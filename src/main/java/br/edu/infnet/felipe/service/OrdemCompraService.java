package br.edu.infnet.felipe.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.felipe.controller.request.CheckoutDTO;
import br.edu.infnet.felipe.controller.request.DadosPagamentoDTO;
import br.edu.infnet.felipe.domain.enums.MetodoPagamento;
import br.edu.infnet.felipe.domain.enums.StatusCompra;
import br.edu.infnet.felipe.domain.pagamento.Pagamento;
import br.edu.infnet.felipe.domain.venda.Carrinho;
import br.edu.infnet.felipe.domain.venda.OrdemCompra;
import br.edu.infnet.felipe.repository.OrdemCompraRepository;

@Service
public class OrdemCompraService {
	
	@Autowired
	private CarrinhoService carrinhoService;
	
	@Autowired
	private PagamentoService pagamentoService;
	
	@Autowired
	private OrdemCompraRepository repository;

	public OrdemCompra criar(String carrinhoId, String clienteId) {
		Carrinho carrinho = carrinhoService.buscaPorId(carrinhoId);
		
		if(carrinho == null) {
			return null;
		}
		
		List<Carrinho> listCarrinhosCliente = carrinhoService.getCarrinhoPorIdCliente(clienteId);
		
		boolean carrinhoPertenceCliente = false;
		
		for(Carrinho carrinhoObjeto: listCarrinhosCliente) {
			if(carrinhoObjeto.getId() == carrinho.getId()) {
				carrinhoPertenceCliente = true;
			}
		}
		
		if(!carrinhoPertenceCliente) {
			return null;
		}
		
		OrdemCompra ordemCompra = new OrdemCompra(carrinho);
		
		repository.salvar(ordemCompra);
		
		return ordemCompra;
	}
	
	public OrdemCompra checkout(CheckoutDTO checkoutDTO) {
		OrdemCompra ordemCompra = criar(checkoutDTO.getCarrinhoId(), checkoutDTO.getUsuarioId());
		
		Pagamento pagamento = new Pagamento();
		pagamento.setCliente(ordemCompra.getCarrinho().getComprador());
		pagamento.setValor(ordemCompra.getCarrinho().calcularPrecoCarrinho());
		
		DadosPagamentoDTO dadosPagamento = checkoutDTO.getDadosPagamento();
		
		System.out.println(dadosPagamento.getMetodoPagamento());
		
		if(dadosPagamento.getMetodoPagamento().equals("CARTAO_CREDITO")) {
			System.out.println("É CREDITO");
			pagamento.setMetodoPagamento(MetodoPagamento.CARTAO_CREDITO);
		}
		
		if(dadosPagamento.getMetodoPagamento().equals("PIX")) {
			System.out.println("É PIX");
			pagamento.setMetodoPagamento(MetodoPagamento.PIX);
		}
		
		boolean pagamentoProcessado = pagamentoService.processarPagamento(pagamento, dadosPagamento);
		
		if(pagamentoProcessado) {
			ordemCompra.setStatus(StatusCompra.PAGO);
		}
		
		repository.salvar(ordemCompra);
		
		return ordemCompra;
		
	}
	
	private OrdemCompra alterarStatus(String ordemCompraId, StatusCompra statusNovo) {
		OrdemCompra ordemCompra = repository.buscarPorID(UUID.fromString(ordemCompraId));
		
		if(ordemCompra == null) {
			return null;
		}
		
		ordemCompra.setStatus(statusNovo);
		
		repository.salvar(ordemCompra);
		
		return ordemCompra;
	}

}
