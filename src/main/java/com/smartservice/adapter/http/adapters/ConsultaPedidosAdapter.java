package com.smartservice.adapter.http.adapters;

import com.smartservice.adapter.datastore.entities.Pedido;
import com.smartservice.adapter.datastore.entities.Produto;
import com.smartservice.adapter.datastore.repositories.PedidoRepository;
import com.smartservice.adapter.http.dto.saida.pedido.ConsultaPedidoResponse;
import com.smartservice.adapter.http.dto.saida.pedido.EnderecoResponse;
import com.smartservice.adapter.http.dto.saida.pedido.ProdutoResponse;
import com.smartservice.core.exceptions.PedidoNaoExistenteException;
import com.smartservice.core.model.enums.StatusPedido;
import com.smartservice.core.port.saida.ConsultaPedidosPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class ConsultaPedidosAdapter implements ConsultaPedidosPort {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public ConsultaPedidoResponse consultaPedidoPorId(String idPedido) {
        Pedido pedido = pedidoRepository.findById(idPedido).orElseThrow(()->new PedidoNaoExistenteException("Pedido não existe na nossa base de dados."));
        EnderecoResponse endereco = new EnderecoResponse(pedido.getUsuario().getLogradouro(),pedido.getUsuario().getNumero(),pedido.getUsuario().getBairro(),pedido.getUsuario().getComplemento(),pedido.getUsuario().getCidade(),pedido.getUsuario().getEstado(),pedido.getUsuario().getCep());
        List<ProdutoResponse> produtos = new ArrayList<>();
        List<Produto> produtosDB = pedido.getProdutos();
        for (Produto produto:produtosDB
             ) {
            ProdutoResponse produtoResponse = new ProdutoResponse(produto.getNome(),"1");
            produtos.add(produtoResponse);
        }
        return new ConsultaPedidoResponse(pedido.getCodigoPedido(),pedido.getUsuario().getNome(),pedido.getUsuario().getEmail(),endereco,produtos,pedido.getObs(),pedido.getFormaPagamento().toString(),pedido.getValorTotal().toString(),pedido.getDataCriacaoPedido().format(DateTimeFormatter.ofPattern("d/M/y")));
    }

    @Override
    public List<ConsultaPedidoResponse> consultaPedidosPorStatus(String status) {
        StatusPedido statusPedido = StatusPedido.valueOf(status);
        List<Pedido> pedidos = pedidoRepository.findByStatusPedido(statusPedido);
        List<ConsultaPedidoResponse> pedidosResponse = new ArrayList<>();
        List<ProdutoResponse> produtos = new ArrayList<>();
        for (Pedido pedido:pedidos
             ) {
            for (Produto produto:pedido.getProdutos()
                 ) {
                ProdutoResponse produtoResponse = new ProdutoResponse(produto.getNome(),"1");
                produtos.add(produtoResponse);
            }
            EnderecoResponse endereco = new EnderecoResponse(pedido.getUsuario().getLogradouro(),pedido.getUsuario().getNumero(),pedido.getUsuario().getBairro(),pedido.getUsuario().getComplemento(),pedido.getUsuario().getCidade(),pedido.getUsuario().getEstado(),pedido.getUsuario().getCep());
            pedidosResponse.add(new ConsultaPedidoResponse(pedido.getCodigoPedido(),pedido.getUsuario().getNome(),pedido.getUsuario().getEmail(),endereco,produtos,pedido.getObs(),pedido.getFormaPagamento().toString(),pedido.getValorTotal().toString(),pedido.getDataCriacaoPedido().format(DateTimeFormatter.ofPattern("d/M/y"))));
            produtos = new ArrayList<>();
        }
        return pedidosResponse;
    }
}
