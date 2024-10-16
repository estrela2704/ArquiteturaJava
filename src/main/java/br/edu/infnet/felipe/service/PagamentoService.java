package br.edu.infnet.felipe.service;

import org.springframework.stereotype.Service;

import br.edu.infnet.felipe.controller.request.DadosPagamentoDTO;
import br.edu.infnet.felipe.domain.enums.MetodoPagamento;
import br.edu.infnet.felipe.domain.pagamento.DadosPagamento;
import br.edu.infnet.felipe.domain.pagamento.DadosPagamentoCartaoCredito;
import br.edu.infnet.felipe.domain.pagamento.DadosPagamentoPix;
import br.edu.infnet.felipe.domain.pagamento.Pagamento;

@Service
public class PagamentoService {

	public boolean processarPagamento(Pagamento pagamento, DadosPagamentoDTO dadosPagamento) {
		System.out.println("É" + pagamento.getMetodoPagamento());

		MetodoPagamento metodo = pagamento.getMetodoPagamento();
			
		DadosPagamento dados;
		
		switch(metodo) {
		
		case PIX:
			dados = new DadosPagamentoPix(pagamento.getValor(), dadosPagamento.getChavePix());
			return processarPagamentoPix((DadosPagamentoPix) dados);		
		case CARTAO_CREDITO:
			dados = new DadosPagamentoCartaoCredito(pagamento.getValor(), dadosPagamento.getNumeroCartao(),
					dadosPagamento.getDataVencimento(), dadosPagamento.getCodigoSeguranca(), dadosPagamento.getNomeTitular());
			return processarPagamentoCredito((DadosPagamentoCartaoCredito) dados);
		default: 
			return false;
		
		}

	}

	private boolean processarPagamentoPix(DadosPagamentoPix dados) {
		return true;
	}

	private boolean processarPagamentoCredito(
			DadosPagamentoCartaoCredito dados) {
		return true;
	}

}
