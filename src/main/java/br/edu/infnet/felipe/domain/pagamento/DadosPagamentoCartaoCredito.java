package br.edu.infnet.felipe.domain.pagamento;

import java.math.BigDecimal;

public class DadosPagamentoCartaoCredito extends DadosPagamento {
	
	private String numeroCartao;
	private String dataVencimento;
	private String codigoSeguranca;
	private String nomeTitular;

	public DadosPagamentoCartaoCredito(BigDecimal valor, String numeroCartao,
			String dataVencimento, String codigoSeguranca, String nomeTitular) {
		super(valor);
		this.numeroCartao = numeroCartao;
		this.dataVencimento = dataVencimento;
		this.codigoSeguranca = codigoSeguranca;
		this.nomeTitular = nomeTitular;
	}

	@Override
	public boolean validar() {
		if (numeroCartao == null || dataVencimento == null
				|| codigoSeguranca == null || nomeTitular == null) {
			return false;
		}
		
		return true;
	}
}
