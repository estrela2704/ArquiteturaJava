package br.edu.infnet.felipe.domain.venda;

import java.math.BigDecimal;
import java.util.UUID;

import br.edu.infnet.felipe.domain.enums.StatusCompra;

public class OrdemCompra {
	
	private UUID id;
	private Carrinho carrinho;
	private BigDecimal valor;
	private StatusCompra status;
	
	public OrdemCompra(Carrinho carrinho) {
		this.id = UUID.randomUUID();
		this.carrinho = carrinho;
		this.valor = this.carrinho.calcularPrecoCarrinho();
		status = StatusCompra.PENDENTE;
	}

	public UUID getId() {
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
	
	public BigDecimal getValor() {
		return valor;
	}

	
}
