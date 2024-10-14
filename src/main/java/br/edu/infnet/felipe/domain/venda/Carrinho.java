package br.edu.infnet.felipe.domain.venda;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.felipe.domain.produto.Produto;
import br.edu.infnet.felipe.domain.usuario.Cliente;

public class Carrinho {
	
	private List<Produto> produtos = new ArrayList<Produto>();
	private Cliente comprador;
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	
	public void addProduto(Produto produto) {
		this.produtos.add(produto);
	}
	
	public Cliente getComprador() {
		return comprador;
	}
	public void setComprador(Cliente comprador) {
		this.comprador = comprador;
	}
	
	
}
