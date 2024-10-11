package br.edu.infnet.felipe.model.domain.venda;

import br.edu.infnet.felipe.model.enums.StatusCompra;

public class OrdemCompra {
	private Carrinho carrinho;
	private StatusCompra status;
	
	public Carrinho getCarrinho() {
		return carrinho;
	}
	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}
	public StatusCompra getStatus() {
		return status;
	}
	public void setStatus(StatusCompra status) {
		this.status = status;
	}
	
}
