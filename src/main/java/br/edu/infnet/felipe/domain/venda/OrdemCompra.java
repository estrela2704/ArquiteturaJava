package br.edu.infnet.felipe.domain.venda;

import java.util.UUID;

import br.edu.infnet.felipe.domain.enums.StatusCompra;

public class OrdemCompra {
	
	private UUID id;
	private Carrinho carrinho;
	private StatusCompra status;
	
	public OrdemCompra(Carrinho carrinho, StatusCompra status) {
		this.id = UUID.randomUUID();
		this.carrinho = carrinho;
		this.status = status;
	}

	public UUID getID() {
		return id;
	}
	
	public Carrinho getCarrinho() {
		return carrinho;
	}
	
	public StatusCompra getStatus() {
		return status;
	}
	public void setStatus(StatusCompra status) {
		this.status = status;
	}
	
}
