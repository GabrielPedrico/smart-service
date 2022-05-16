package com.smartservice.adapter.http.adapters;

import com.smartservice.adapter.datastore.entities.Pedido;
import com.smartservice.adapter.datastore.entities.Produto;
import com.smartservice.adapter.datastore.entities.Usuario;
import com.smartservice.adapter.datastore.repositories.PedidoRepository;
import com.smartservice.adapter.datastore.repositories.ProdutoRepository;
import com.smartservice.adapter.datastore.repositories.UsuarioRepository;
import com.smartservice.adapter.http.dto.saida.pedido.CadastraPedidoResponse;
import com.smartservice.config.properties.WppProperties;
import com.smartservice.core.exceptions.FormaPagamentoInvalidaException;
import com.smartservice.core.exceptions.ProdutoNaoExistenteException;
import com.smartservice.core.exceptions.ProdutoSemEstoqueException;
import com.smartservice.core.exceptions.UsuarioNaoExistenteException;
import com.smartservice.core.model.enums.StatusPedido;
import com.smartservice.core.model.enums.TipoPagamento;
import com.smartservice.core.model.pedido.PedidoModel;
import com.smartservice.core.model.pedido.ProdutoModel;
import com.smartservice.core.port.saida.CadastraPedidoPort;
import com.smartservice.core.port.saida.EmailSendPort;
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

    @Override
    public CadastraPedidoResponse cadastraPedidoDB(PedidoModel pedidoModel) throws MessagingException, URISyntaxException, UnsupportedEncodingException {
        Pedido pedido = new Pedido();
        List<Produto> produtos = new ArrayList<Produto>();
        String listaDeProdutos = "";
        pedido.setProdutos(produtos);
        Usuario usuario = usuarioRepository.findById(pedidoModel.getIdUsuario()).orElseThrow(()-> new UsuarioNaoExistenteException("Falha ao registrar pedido, usuario inexistente"));
        pedido.setUsuario(usuario);
        pedido.setFormaPagamento(TipoPagamento.valueOf(pedidoModel.getFormaPagamento()));
        if(pedido.getFormaPagamento().equals(null)) throw new FormaPagamentoInvalidaException("Falha ao registrar pedido, forma de pagamento invalida");

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
        pedido.setValorTotal(BigDecimal.valueOf(valorTotal));
        pedido.setStatusPedido(StatusPedido.AGUARDANDO_CONFIRMACAO);
        pedidoRepository.save(pedido);
        pedido.setCodigoPedido(pedido.getId().substring(0,4).toUpperCase());
        pedidoRepository.save(pedido);
        String urlWpp = wppProperties.getApi();
        double valorTotalComEntrega = pedido.getValorTotal().doubleValue()+5.0;
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
        emailSendPort.sendPedidoRegistradoEmail(pedido,urlFinalPedidoWpp);
        return new CadastraPedidoResponse(pedido.getId(),pedido.getStatusPedido().toString(),urlFinalPedidoWpp);
    }
}
