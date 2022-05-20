package com.smartservice.adapter.http.adapters.pedido;

import com.smartservice.adapter.datastore.entities.Pedido;
import com.smartservice.adapter.datastore.entities.Produto;
import com.smartservice.adapter.datastore.entities.Usuario;
import com.smartservice.adapter.datastore.repositories.PedidoRepository;
import com.smartservice.adapter.datastore.repositories.UsuarioRepository;
import com.smartservice.adapter.http.spring.dto.saida.pedido.ConsultaPedidoResponse;
import com.smartservice.adapter.http.spring.dto.saida.pedido.EnderecoResponse;
import com.smartservice.adapter.http.spring.dto.saida.pedido.ProdutoResponse;
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

    private static String datePattern = "d/M/y";

    @Override
    public ConsultaPedidoResponse consultaPedidoPorId(String idPedido) {
        Pedido pedido = pedidoRepository.findById(idPedido).orElseThrow(() -> new PedidoNaoExistenteException("Pedido não existe na nossa base de dados."));
        if(null == pedido.getUsuario()) {
            pedido.setUsuario(new Usuario());
            pedido.setFormaPagamento(TipoPagamento.PRESENCIAL);
        }
        EnderecoResponse endereco = new EnderecoResponse(pedido.getUsuario().getLogradouro(), pedido.getUsuario().getNumero(), pedido.getUsuario().getBairro(), pedido.getUsuario().getComplemento(), pedido.getUsuario().getCidade(), pedido.getUsuario().getEstado(), pedido.getUsuario().getCep());
        List<ProdutoResponse> produtos = new ArrayList<>();
        List<Produto> produtosDB = pedido.getProdutos();
        for (Produto produto : produtosDB
        ) {
            ProdutoResponse produtoResponse = new ProdutoResponse(produto.getNome(), "1");
            produtos.add(produtoResponse);
        }
        return new ConsultaPedidoResponse(pedido.getCodigoPedido(), pedido.getUsuario().getNome(), pedido.getUsuario().getEmail(), endereco, produtos, pedido.getObs(), pedido.getFormaPagamento().toString(), pedido.getValorTotal().toString(), pedido.getDataCriacaoPedido().format(DateTimeFormatter.ofPattern(datePattern)));
    }

    @Override
    public List<ConsultaPedidoResponse> consultaPedidosPorStatus(String status) {
        StatusPedido statusPedido = StatusPedido.valueOf(status);
        List<Pedido> pedidos = pedidoRepository.findByStatusPedido(statusPedido).orElseThrow(()-> new StatusPedidoNaoExistenteException("Status pedido inexistente"));
        List<ConsultaPedidoResponse> pedidosResponse = new ArrayList<>();
        List<ProdutoResponse> produtos = new ArrayList<>();
        for (Pedido pedido : pedidos
        ) {
            for (Produto produto : pedido.getProdutos()
            ) {
                ProdutoResponse produtoResponse = new ProdutoResponse(produto.getNome(), "1");
                produtos.add(produtoResponse);
            }
            if(null == pedido.getUsuario()) {
                pedido.setUsuario(new Usuario());
                pedido.setFormaPagamento(TipoPagamento.PRESENCIAL);
            }
            EnderecoResponse endereco = new EnderecoResponse(pedido.getUsuario().getLogradouro(), pedido.getUsuario().getNumero(), pedido.getUsuario().getBairro(), pedido.getUsuario().getComplemento(), pedido.getUsuario().getCidade(), pedido.getUsuario().getEstado(), pedido.getUsuario().getCep());
            pedidosResponse.add(new ConsultaPedidoResponse(pedido.getCodigoPedido(), pedido.getUsuario().getNome(), pedido.getUsuario().getEmail(), endereco, produtos, pedido.getObs(), pedido.getFormaPagamento().toString(), pedido.getValorTotal().toString(), pedido.getDataCriacaoPedido().format(DateTimeFormatter.ofPattern(datePattern))));
            produtos = new ArrayList<>();
        }
        return pedidosResponse;
    }

    @Override
    public List<ConsultaPedidoResponse> consultaPedidosPorUsuario(String idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow(() -> new UsuarioNaoExistenteException("Usuario não encontrado na nossa base de dados."));
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
            pedidosResponse.add(new ConsultaPedidoResponse(pedido.getCodigoPedido(), pedido.getUsuario().getNome(), pedido.getUsuario().getEmail(), endereco, produtos, pedido.getObs(), pedido.getFormaPagamento().toString(), pedido.getValorTotal().toString(), pedido.getDataCriacaoPedido().format(DateTimeFormatter.ofPattern(datePattern))));
            produtos = new ArrayList<>();
        }
        return pedidosResponse;
    }
}
