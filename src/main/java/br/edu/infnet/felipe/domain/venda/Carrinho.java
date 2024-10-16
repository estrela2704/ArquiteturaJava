package br.edu.infnet.felipe.domain.venda;

import java.math.BigDecimal;
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
	
	public boolean addProduto(Produto produto, int quantidade) {
        quantidade = Math.max(1, quantidade);

        if(!produto.isEstoque()) {
        	return false;
        }
        
		for(int i = 0; i < quantidade; i++) {
			this.produtos.add(produto);
		}	
    		
    	return true;
	}
	
	public boolean removerProduto(Produto produto, int quantidade) {
        quantidade = Math.max(1, quantidade);
		
		int quantidadeProduto = getQuantidadeProdutoCarrinho(produto);
		
		if(quantidade >= produtos.size() | quantidade >= quantidadeProduto | produtos.size() == 0) {
			return false;
		}
		
		for(int i = 0; i < quantidade; i++) {
			this.produtos.remove(produto);
		}
		
		return true;
	}
	
	public int getQuantidadeProdutoCarrinho(Produto produto) {
		int quantidade = 0;
		for(Produto objProduto: produtos) {
			if(objProduto.getId() == produto.getId()) {
				quantidade++;
			}
		}
		
		return quantidade;
	}
	
	public BigDecimal calcularPrecoCarrinho() {

		BigDecimal preco = new BigDecimal(0);

		for (Produto produto : produtos) {
			preco = preco.add(produto.getPreco());
		}

		return preco;
	}
	
	public Cliente getComprador() {
		return comprador;
	}
	
	
}
