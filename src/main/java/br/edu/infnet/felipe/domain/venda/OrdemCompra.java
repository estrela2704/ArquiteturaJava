package br.edu.infnet.felipe.domain.venda;

import java.math.BigDecimal;

import br.edu.infnet.felipe.domain.enums.StatusCompra;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrdemCompra {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
    
    @ManyToOne 
    @JoinColumn(name = "carrinho_id", nullable = false) 
	private Carrinho carrinho;
    
	private BigDecimal valor;
	
    @Enumerated(EnumType.STRING)
	private StatusCompra status;
	
    public OrdemCompra() {
    	
    }
    
	public OrdemCompra(Carrinho carrinho) {
		this.carrinho = carrinho;
		this.valor = this.carrinho.calcularPrecoCarrinho();
		status = StatusCompra.PENDENTE;
	}

	public Integer getId() {
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
