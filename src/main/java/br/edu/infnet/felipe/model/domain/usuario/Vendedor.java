package br.edu.infnet.felipe.model.domain.usuario;

import br.edu.infnet.felipe.model.domain.produto.Produto;

public class Vendedor extends Pessoa {
	
	private Produto[] produtos;
	
	public Produto[] getProdutos() {
		return produtos;
	}
	
	public void setProdutos(Produto[] produtos) {
		this.produtos = produtos;
	}
}
