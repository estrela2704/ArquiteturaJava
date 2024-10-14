package br.edu.infnet.felipe.domain.pagamento;

import java.time.LocalDate;

import br.edu.infnet.felipe.domain.enums.MetodoPagamento;
import br.edu.infnet.felipe.domain.enums.StatusPagamento;
import br.edu.infnet.felipe.domain.usuario.Cliente;

public class Pagamento {
	
	private Cliente cliente;
	private float valor;
	private LocalDate dataPagamento;
	private MetodoPagamento metodoPagamento;
	private StatusPagamento status;
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public LocalDate getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	public MetodoPagamento getMetodoPagamento() {
		return metodoPagamento;
	}
	public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}
	public StatusPagamento getStatus() {
		return status;
	}
	public void setStatus(StatusPagamento status) {
		this.status = status;
	}
	
}
