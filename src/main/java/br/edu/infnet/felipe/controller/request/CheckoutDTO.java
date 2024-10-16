package br.edu.infnet.felipe.controller.request;

import java.math.BigDecimal;


public class CheckoutDTO {
    
    private String usuarioId;
    private String carrinhoId;
    private DadosPagamentoDTO dadosPagamento;

    public CheckoutDTO(String usuarioId, String carrinhoId, DadosPagamentoDTO dadosPagamento, BigDecimal valorTotal) {
        this.usuarioId = usuarioId;
        this.carrinhoId = carrinhoId;
        this.dadosPagamento = dadosPagamento;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getCarrinhoId() {
		return carrinhoId;
	}

	public void setCarrinhoId(String ordemCompraId) {
		this.carrinhoId = ordemCompraId;
	}

	public DadosPagamentoDTO getDadosPagamento() {
        return dadosPagamento;
    }

    public void setDadosPagamento(DadosPagamentoDTO dadosPagamento) {
        this.dadosPagamento = dadosPagamento;
    }
}


