package com.smartservice.adapter.http.adapters.pedido;

import com.smartservice.adapter.datastore.entities.Pedido;
import com.smartservice.adapter.datastore.entities.Produto;
import com.smartservice.adapter.datastore.entities.Usuario;
import com.smartservice.adapter.datastore.repositories.PedidoRepository;
import com.smartservice.adapter.datastore.repositories.UsuarioRepository;
import com.smartservice.adapter.http.spring.dto.saida.pedido.ConsultaPedidoResponse;
import com.smartservice.adapter.http.spring.dto.saida.pedido.EnderecoResponse;
import com.smartservice.adapter.http.spring.dto.saida.pedido.ProdutoResponse;
import com.smartservice.config.general.Log4jConfig;
import com.smartservice.core.exceptions.PedidoNaoExistenteException;
import com.smartservice.core.exceptions.StatusPedidoNaoExistenteException;
import com.smartservice.core.exceptions.UsuarioNaoExistenteException;
import com.smartservice.core.model.enums.StatusPedido;
import com.smartservice.core.model.enums.TipoPagamento;
import com.smartservice.core.port.saida.pedido.ConsultaPedidosPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class ConsultaPedidosAdapter implements ConsultaPedidosPort {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private Log4jConfig log;

    private static String datePattern = "d/M/y";

    @Override
    public ConsultaPedidoResponse consultaPedidoPorId(String idPedido) {
        log.getLogger().info("[ADAPTER] INICIANDO CONSULTA PEDIDO BY ID...[ADAPTER]");
        log.getLogger().info("[ADAPTER] VERIFICANDO EXISTENCIA DE PEDIDO...[ADAPTER]");
        Pedido pedido = pedidoRepository.findById(idPedido).orElseThrow(() -> new PedidoNaoExistenteException("Pedido não existe na nossa base de dados."));
        log.getLogger().info("[ADAPTER] PEDIDO ENCONTRADO COM SUCESSO! [ADAPTER]");
        if(null == pedido.getUsuario()) {
            pedido.setUsuario(new Usuario());
            pedido.setFormaPagamento(TipoPagamento.DINHEIRO);
        }
        EnderecoResponse endereco = new EnderecoResponse(pedido.getUsuario().getLogradouro(), pedido.getUsuario().getNumero(), pedido.getUsuario().getBairro(), pedido.getUsuario().getComplemento(), pedido.getUsuario().getCidade(), pedido.getUsuario().getEstado(), pedido.getUsuario().getCep());
        List<ProdutoResponse> produtos = new ArrayList<>();
        List<Produto> produtosDB = pedido.getProdutos();
        for (Produto produto : produtosDB
        ) {
            ProdutoResponse produtoResponse = new ProdutoResponse(produto.getNome(), "1");
            produtos.add(produtoResponse);
        }
        log.getLogger().info("[ADAPTER] CONSULTA REALIZADA COM SUCESSO! [ADAPTER]");
        return new ConsultaPedidoResponse(pedido.getId(),pedido.getCodigoPedido(), pedido.getUsuario().getNome(), pedido.getUsuario().getEmail(), endereco, produtos, pedido.getObs(), pedido.getFormaPagamento().toString(), pedido.getValorTotal().toString(), pedido.getDataCriacaoPedido().format(DateTimeFormatter.ofPattern(datePattern)));
    }

    @Override
    public List<ConsultaPedidoResponse> consultaPedidosPorStatus(String status) {
        log.getLogger().info("[ADAPTER] INICIANDO CONSULTA PEDIDOS BY STATUS...[ADAPTER]");
        StatusPedido statusPedido;
        try {
            statusPedido = StatusPedido.valueOf(status);
            log.getLogger().info("[ADAPTER] VERIFICANDO SE STAUTS PEDIDO EXISTE...[ADAPTER]");
        } catch (Exception e) {
            log.getLogger().info("[ADAPTER] FALHA AO RESGATAR PRODUTOS POR STATUS, STATUS NÃO EXISTE[ADAPTER]");
            throw new StatusPedidoNaoExistenteException("O Status " + status + " não existe");
        }
        log.getLogger().info("[ADAPTER] STATUS VALIDADO![ADAPTER]");
        log.getLogger().info("[ADAPTER] RESGATANDO PEDIDOS PARA CONSULTA[ADAPTER]");
        List<Pedido> pedidos = pedidoRepository.findByStatusPedido(statusPedido).orElseThrow(() -> new StatusPedidoNaoExistenteException("Status pedido inexistente"));
        List<ConsultaPedidoResponse> pedidosResponse = new ArrayList<>();
        List<ProdutoResponse> produtos = new ArrayList<>();
        for (Pedido pedido : pedidos
        ) {
            for (Produto produto : pedido.getProdutos()
            ) {
                ProdutoResponse produtoResponse = new ProdutoResponse(produto.getNome(), "1");
                produtos.add(produtoResponse);
            }
            if (null == pedido.getUsuario()) {
                pedido.setUsuario(new Usuario());
                pedido.setFormaPagamento(TipoPagamento.DINHEIRO);
            }
            EnderecoResponse endereco = new EnderecoResponse(pedido.getUsuario().getLogradouro(), pedido.getUsuario().getNumero(), pedido.getUsuario().getBairro(), pedido.getUsuario().getComplemento(), pedido.getUsuario().getCidade(), pedido.getUsuario().getEstado(), pedido.getUsuario().getCep());
            pedidosResponse.add(new ConsultaPedidoResponse(pedido.getId(), pedido.getCodigoPedido(), pedido.getUsuario().getNome(), pedido.getUsuario().getEmail(), endereco, produtos, pedido.getObs(), pedido.getFormaPagamento().toString(), pedido.getValorTotal().toString(), pedido.getDataCriacaoPedido().format(DateTimeFormatter.ofPattern(datePattern))));
            produtos = new ArrayList<>();
        }
        log.getLogger().info("[ADAPTER] PEDIDOS RESGATADOS COM SUCESSO! [ADAPTER]");
        return pedidosResponse;
    }

    @Override
    public List<ConsultaPedidoResponse> consultaPedidosPorUsuario(String idUsuario) {
        log.getLogger().info("[ADAPTER] INICIANDO CONSULTA PEDIDO BY USUARIO...[ADAPTER]");
        log.getLogger().info("[ADAPTER] VERIFICANDO EXISTENCIA USUARIO...[ADAPTER]");
        Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow(() -> new UsuarioNaoExistenteException("Usuario não encontrado na nossa base de dados."));
        log.getLogger().info("[ADAPTER] USUARIO ENCONTRADO COM SUCESSO! [ADAPTER]");
        log.getLogger().info("[ADAPTER] RESGATANDO PEDIDOS USUARIO ID:"+idUsuario+" [ADAPTER]");
        List<Pedido> pedidos = pedidoRepository.findByUsuario(usuario).orElseThrow();
        List<ConsultaPedidoResponse> pedidosResponse = new ArrayList<>();
        List<ProdutoResponse> produtos = new ArrayList<>();
        for (Pedido pedido : pedidos
        ) {
            for (Produto produto : pedido.getProdutos()
            ) {
                ProdutoResponse produtoResponse = new ProdutoResponse(produto.getNome(), "1");
                produtos.add(produtoResponse);
            }
            EnderecoResponse endereco = new EnderecoResponse(pedido.getUsuario().getLogradouro(), pedido.getUsuario().getNumero(), pedido.getUsuario().getBairro(), pedido.getUsuario().getComplemento(), pedido.getUsuario().getCidade(), pedido.getUsuario().getEstado(), pedido.getUsuario().getCep());
            pedidosResponse.add(new ConsultaPedidoResponse(pedido.getId(),pedido.getCodigoPedido(), pedido.getUsuario().getNome(), pedido.getUsuario().getEmail(), endereco, produtos, pedido.getObs(), pedido.getFormaPagamento().toString(), pedido.getValorTotal().toString(), pedido.getDataCriacaoPedido().format(DateTimeFormatter.ofPattern(datePattern))));
            produtos = new ArrayList<>();
        }
        log.getLogger().info("[ADAPTER] PEDIDOS RESGATADOS COM SUCESSO! [ADAPTER]");
        return pedidosResponse;
    }
}
