package br.edu.infnet.felipe.domain.venda;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.edu.infnet.felipe.domain.produto.Produto;
import br.edu.infnet.felipe.domain.usuario.Cliente;

public class Carrinho {
	
	private UUID id;
	private List<Produto> produtos = new ArrayList<Produto>();
	private Cliente comprador;
	
	public Carrinho(Cliente comprador) {
		this.id = UUID.randomUUID();
		this.comprador = comprador;
	}
	
	public UUID getId() {
		return id;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}
	
	public void addProduto(Produto produto) {
		this.produtos.add(produto);
	}
	
	public Cliente getComprador() {
		return comprador;
	}
	
}
