package br.edu.infnet.felipe.controller.request;

import java.math.BigDecimal;


public class CheckoutDTO {
    
    private Integer usuarioId;
    private Integer carrinhoId;
    private DadosPagamentoDTO dadosPagamento;

    public CheckoutDTO(Integer usuarioId, Integer carrinhoId, DadosPagamentoDTO dadosPagamento, BigDecimal valorTotal) {
        this.usuarioId = usuarioId;
        this.carrinhoId = carrinhoId;
        this.dadosPagamento = dadosPagamento;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getCarrinhoId() {
		return carrinhoId;
	}

	public void setCarrinhoId(Integer ordemCompraId) {
		this.carrinhoId = ordemCompraId;
	}

	public DadosPagamentoDTO getDadosPagamento() {
        return dadosPagamento;
    }

    public void setDadosPagamento(DadosPagamentoDTO dadosPagamento) {
        this.dadosPagamento = dadosPagamento;
    }
}


