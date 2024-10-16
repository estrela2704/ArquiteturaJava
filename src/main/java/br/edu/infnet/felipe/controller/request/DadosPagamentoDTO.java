package br.edu.infnet.felipe.controller.request;

public class DadosPagamentoDTO {

	private String metodoPagamento;
	private String numeroCartao;
	private String dataVencimento;
	private String codigoSeguranca;
	private String nomeTitular;
	private String chavePix;

	public DadosPagamentoDTO(String metodoPagamento, String numeroCartao,
			String dataVencimento, String codigoSeguranca, String nomeTitular,
			String chavePix) {
		this.metodoPagamento = metodoPagamento;
		this.numeroCartao = numeroCartao;
		this.dataVencimento = dataVencimento;
		this.codigoSeguranca = codigoSeguranca;
		this.nomeTitular = nomeTitular;
		this.chavePix = chavePix;
	}

	public String getMetodoPagamento() {
		return metodoPagamento;
	}

	public void setMetodoPagamento(String metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getCodigoSeguranca() {
		return codigoSeguranca;
	}

	public void setCodigoSeguranca(String codigoSeguranca) {
		this.codigoSeguranca = codigoSeguranca;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public String getChavePix() {
		return chavePix;
	}

	public void setChavePix(String chavePix) {
		this.chavePix = chavePix;
	}
}