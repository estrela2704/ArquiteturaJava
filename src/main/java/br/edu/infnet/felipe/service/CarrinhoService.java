package br.edu.infnet.felipe.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.felipe.controller.request.CriarCarrinhoDTO;
import br.edu.infnet.felipe.domain.produto.Produto;
import br.edu.infnet.felipe.domain.usuario.Cliente;
import br.edu.infnet.felipe.domain.venda.Carrinho;

@Service
public class CarrinhoService {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ProdutoService produtoService;
	
	public Carrinho criar(CriarCarrinhoDTO criarCarrinhoDTO) {
		
		Cliente cliente = clienteService.buscarPorID(UUID.fromString(criarCarrinhoDTO.getIdUsuario()));
		Produto produto = produtoService.buscarPorID(UUID.fromString(criarCarrinhoDTO.getIdProduto()));
		
		Carrinho carrinho = null;
		
		if(cliente != null && produto != null) {
			carrinho = new Carrinho(cliente);
			adicionarProduto(carrinho, produto, criarCarrinhoDTO.getQuantidade());
			
		}
		
		return carrinho;
	}

	public void adicionarProduto(Carrinho carrinho, Produto produto,
			int quantidade) {
		if (produto.isEstoque()) {
			quantidade = Math.max(1, quantidade);
			carrinho.addProduto(produto, quantidade);
		}
	}

	public void removerProduto(Carrinho carrinho, Produto produto, int quantidade) {
		carrinho.removerProduto(produto, quantidade);
	}

	public BigDecimal calcularPrecoCarrinho(Carrinho carrinho) {
		List<Produto> produtos = carrinho.getProdutos();

		BigDecimal preco = new BigDecimal(0);

		for (Produto produto : produtos) {
			preco = preco.add(produto.getPreco());
		}

		return preco;
	}

}
