package com.smartservice.adapter.http.adapters.pedido;

import com.smartservice.adapter.datastore.entities.Mesa;
import com.smartservice.adapter.datastore.entities.Pedido;
import com.smartservice.adapter.datastore.entities.Produto;
import com.smartservice.adapter.datastore.entities.Usuario;
import com.smartservice.adapter.datastore.repositories.MesaRepository;
import com.smartservice.adapter.datastore.repositories.PedidoRepository;
import com.smartservice.adapter.datastore.repositories.ProdutoRepository;
import com.smartservice.adapter.datastore.repositories.UsuarioRepository;
import com.smartservice.adapter.http.spring.dto.saida.pedido.CadastraPedidoResponse;
import com.smartservice.config.general.Log4jConfig;
import com.smartservice.config.properties.WppProperties;
import com.smartservice.core.exceptions.*;
import com.smartservice.core.model.enums.StatusMesa;
import com.smartservice.core.model.enums.StatusPedido;
import com.smartservice.core.model.enums.TipoPagamento;
import com.smartservice.core.model.pedido.PedidoModel;
import com.smartservice.core.model.pedido.ProdutoModel;
import com.smartservice.core.port.saida.pedido.CadastraPedidoPort;
import com.smartservice.core.port.saida.external.EmailSendPort;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class CadastraPedidoAdapter implements CadastraPedidoPort {

    @Autowired
    ProdutoRepository produtoRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    PedidoRepository pedidoRepository;
    @Autowired
    EmailSendPort emailSendPort;
    @Autowired
    WppProperties wppProperties;
    @Autowired
    MesaRepository mesaRepository;
    @Autowired
    Log4jConfig log;

    @Override
    public CadastraPedidoResponse cadastraPedidoDeliveryDB(PedidoModel pedidoModel) throws MessagingException, URISyntaxException, UnsupportedEncodingException {
        log.getLogger().info("[ADAPTER] INICIANDO CADASTRO PEDIDO DELIVERY...[ADAPTER]");
        Pedido pedido = new Pedido();
        List<Produto> produtos = new ArrayList<>();
        String listaDeProdutos = "";
        pedido.setProdutos(produtos);
        pedido.setObs(pedidoModel.getObs());
        log.getLogger().info("[ADAPTER] VERIFICANDO SE USUARIO "+pedidoModel.getIdUsuario()+" EXISTE...[ADAPTER]");
        Usuario usuario = usuarioRepository.findById(pedidoModel.getIdUsuario()).orElseThrow(()-> new UsuarioNaoExistenteException("Falha ao registrar pedido, usuario inexistente"));
        pedido.setUsuario(usuario);
        log.getLogger().info("[ADAPTER] VERIFICANDO FORMA DE PAGAMENTO...[ADAPTER]");
        try {
            pedido.setFormaPagamento(TipoPagamento.valueOf(pedidoModel.getFormaPagamento()));
        }catch (Exception e){
            log.getLogger().info("[ADAPTER] FORMA DE PAGAMENTO INVALIDA [ADAPTER]");
            throw new FormaPagamentoInvalidaException("Forma de pagamento "+pedidoModel.getFormaPagamento()+" não existe");
        }
        log.getLogger().info("[ADAPTER] REGISTRANDO PRODUTOS AO PEDIDO... [ADAPTER]");
        double valorTotal = 0;
        for (ProdutoModel produtoModel:pedidoModel.getProdutos()
             ) {
                Produto possivelProduto = produtoRepository.findById(produtoModel.getIdProduto())
                        .orElseThrow(()-> new ProdutoNaoExistenteException("Falha ao registrar pedido, o produto com ID:"+produtoModel.getIdProduto()+" não existe na nossa base de dados."));
                int numeroEmEstoque = possivelProduto.getEstoque();
                if(numeroEmEstoque <= 0 || numeroEmEstoque < produtoModel.getQuantidade()) throw new ProdutoSemEstoqueException("O produto de ID:"+produtoModel.getIdProduto()+" não tem a quantidade em estoque solicitada pelo usuario");
                numeroEmEstoque = numeroEmEstoque-produtoModel.getQuantidade();
                possivelProduto.setEstoque(numeroEmEstoque);
                pedido.getProdutos().add(possivelProduto);
                valorTotal += possivelProduto.getPreco().doubleValue() * produtoModel.getQuantidade().doubleValue();
                produtoRepository.save(possivelProduto);
                String produtoDaLista = "*"+produtoModel.getQuantidade().toString()+"x "+possivelProduto.getNome()+" - "+"R$ "+possivelProduto.getPreco().doubleValue()*produtoModel.getQuantidade().doubleValue()+"*"+"\n";
                listaDeProdutos = listaDeProdutos.concat(produtoDaLista);

        }
        log.getLogger().info("[ADAPTER] PRODUTOS: "+listaDeProdutos+" [ADAPTER]");
        log.getLogger().info("[ADAPTER] PRODUTOS REGISTRADOS PARA PEDIDO! [ADAPTER]");
        pedido.setValorTotal(BigDecimal.valueOf(valorTotal));
        log.getLogger().info("[ADAPTER] VALOR TOTAL CALCULADO & REGISTRADO COM SUCESSO P/ PEDIDO [ADAPTER] Valor Total: R$"+valorTotal);
        pedido.setStatusPedido(StatusPedido.AGUARDANDO_CONFIRMACAO);
        log.getLogger().info("[ADAPTER] STATUS DE PEDIDO REGISTRADO COM SUCESSO, STATUS:"+pedido.getStatusPedido().name()+" [ADAPTER]");

        pedidoRepository.save(pedido);
        log.getLogger().info("[ADAPTER] PEDIDO REGISTRADO COM SUCESSO, ID_GERADO:"+pedido.getId()+" [ADAPTER]");
        pedido.setCodigoPedido(pedido.getId().substring(0,4).toUpperCase());
        pedidoRepository.save(pedido);
        String urlWpp = wppProperties.getApi();
        double valorTotalComEntrega = pedido.getValorTotal().doubleValue()+5;
        String pedidoMsg = "*GOSTOU DE PEDIR NO NOSSO APP?*\n" +
                "Não precisa baixar nada, adicione o nosso restaurante na tela inicial do seu celular e peça com mais agilidade na próxima vez através do link abaixo:\n" +
                "https://nomeseurestaurante.smartservice.app/\n" +
                "---------------------------------------\n" +
                "Confira o pedido abaixo:\n" +
                "*Pedido Smart-Service Delivery* - _Nome do seu restaurante aqui_\n" +
                "---------------------------------------\n" +
                "\n" +
                listaDeProdutos+
                "\n" +
                "*Subtotal:* R$ "+pedido.getValorTotal().toString()+"\n" +
                "*Taxa de entrega*: +R$ 5,00\n" +
                "*Total: R$ "+valorTotalComEntrega+"*\n" +
                "\n" +
                "---------------------------------------\n" +
                "\n" +
                "*Tempo de entrega:* de 30 minutos à 80 minutos\n" +
                "\n" +
                "*"+usuario.getNome()+"*\n" +
                ""+usuario.getTelefone()+"\n" +
                "\n" +
                ""+usuario.getLogradouro()+", "+usuario.getNumero()+" - "+usuario.getComplemento()+"\n" +
                ""+usuario.getBairro()+", "+usuario.getCidade()+"/"+usuario.getEstado()+"\n" +
                ""+usuario.getCep()+"\n" +
                "\n" +
                "*Pagamento:* "+pedido.getFormaPagamento().toString()+" \n" +
                "\n" +
                "_Pedido gerado por Smart Service Delivery às "+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("h:m"))+" ";
        String uri = URLEncoder.encode(pedidoMsg,"UTF-8");
        String urlFinalPedidoWpp = urlWpp.concat("send?phone="+wppProperties.getTelefone()+"&text="+uri);
        log.getLogger().info("[ADAPTER] ENVIANDO EMAIL PARA NOTIFICAR CLIENTE DO PEDIDO... [ADAPTER]");
        emailSendPort.sendPedidoRegistradoEmail(pedido,urlFinalPedidoWpp);
        log.getLogger().info("[ADAPTER] EMAIL ENVIADO COM SUCESSO! [ADAPTER]");
        log.getLogger().info("[ADAPTER] PEDIDO REGISTRADO COM SUCESSO! [ADAPTER]");
        return new CadastraPedidoResponse(pedido.getId(),pedido.getStatusPedido().toString(),urlFinalPedidoWpp);
    }

    @Override
    public CadastraPedidoResponse cadastraPedidoPresencialDB(PedidoModel pedidoModel,String qrCode) throws MessagingException, URISyntaxException, UnsupportedEncodingException {
        log.getLogger().info("[ADAPTER] INICIANDO CADASTRO PEDIDO PRESENCIAL...[ADAPTER]");
        log.getLogger().info("[ADAPTER] VERIFICANDO SE MESA EXISTE...[ADAPTER]");
        Mesa mesa = mesaRepository.findById(Integer.valueOf(qrCode)).orElseThrow(()-> new MesaNaoExistenteException("Numero mesa invalido"));
        log.getLogger().info("[ADAPTER] MESA "+mesa.getId()+" ENCONTRADA![ADAPTER]");
        log.getLogger().info("[ADAPTER] VERIFICANDO SE MESA ESTA LIVRE...[ADAPTER]");
        if(mesa.getStatusMesa().equals(StatusMesa.LIVRE)) throw new MesaLivreException("Não é possível cadastrar pedidos para mesas com status LIVRE, apenas mesas com Status OCUPADO podem registrar pedidos");
        log.getLogger().info("[ADAPTER] MESA ELEGIVEL PARA PEDIDO![ADAPTER]");
        log.getLogger().info("[ADAPTER] CADASTRANDO PEDIDO PARA MESA "+mesa.getId()+"...[ADAPTER]");
        Pedido pedido = new Pedido();
        List<Produto> produtos = new ArrayList<>();
        double valorTotal = 0;
        for (ProdutoModel produtoModel:pedidoModel.getProdutos()
        ) {
            Produto possivelProduto = produtoRepository.findById(produtoModel.getIdProduto())
                    .orElseThrow(()-> new ProdutoNaoExistenteException("Falha ao registrar pedido, o produto com ID:"+produtoModel.getIdProduto()+" não existe na nossa base de dados."));
            int numeroEmEstoque = possivelProduto.getEstoque();
            if(numeroEmEstoque <= 0 || numeroEmEstoque < produtoModel.getQuantidade()) throw new ProdutoSemEstoqueException("O produto de ID:"+produtoModel.getIdProduto()+" não tem a quantidade em estoque solicitada pelo usuario");
            numeroEmEstoque = numeroEmEstoque-produtoModel.getQuantidade();
            possivelProduto.setEstoque(numeroEmEstoque);
            for(int i = 0; i<produtoModel.getQuantidade(); i++){
                produtos.add(possivelProduto);
            }
            valorTotal += possivelProduto.getPreco().doubleValue() * produtoModel.getQuantidade().doubleValue();
            produtoRepository.save(possivelProduto);
        }
        pedido.setValorTotal(BigDecimal.valueOf(valorTotal));
        log.getLogger().info("[ADAPTER] PEDIDO CADASTRADO COM SUCESSO P/ MESA "+mesa.getId()+"![ADAPTER]");
        pedido.setStatusPedido(StatusPedido.AGUARDANDO_CONFIRMACAO);
        pedido.setProdutos(produtos);
        pedidoRepository.save(pedido);
        mesa.getPedidos().add(pedido);
        mesa.getProdutos().addAll(produtos);
        double valorTotalMesa= pedido.getValorTotal().doubleValue()+mesa.getValorTotal().doubleValue();
        mesa.setValorTotal(BigDecimal.valueOf(valorTotalMesa));
        mesaRepository.save(mesa);


        return new CadastraPedidoResponse(pedido.getId(),pedido.getStatusPedido().name(),"Pedido registrado para mesa "+mesa.getId());
    }
}
