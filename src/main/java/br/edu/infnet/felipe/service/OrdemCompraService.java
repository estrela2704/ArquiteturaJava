package br.edu.infnet.felipe.service;

import java.util.List;
import java.util.Optional;
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
	
	public OrdemCompra checkout(CheckoutDTO checkoutDTO) {
		OrdemCompra ordemCompra = criar(checkoutDTO.getCarrinhoId(), checkoutDTO.getUsuarioId());
		
		Pagamento pagamento = new Pagamento();
		pagamento.setCliente(ordemCompra.getCarrinho().getComprador());
		pagamento.setValor(ordemCompra.getCarrinho().calcularPrecoCarrinho());
		
		DadosPagamentoDTO dadosPagamento = checkoutDTO.getDadosPagamento();
				
		switch (dadosPagamento.getMetodoPagamento()) {
		    case "CARTAO_CREDITO":
		        pagamento.setMetodoPagamento(MetodoPagamento.CARTAO_CREDITO);
		        break;
		    case "PIX":
		        pagamento.setMetodoPagamento(MetodoPagamento.PIX);
		        break;
	    default:
	        return null;
		}
		
		boolean pagamentoProcessado = pagamentoService.processarPagamento(pagamento, dadosPagamento);
		
		if(pagamentoProcessado) {
			ordemCompra.setStatus(StatusCompra.PAGO);
		}
		
		return repository.save(ordemCompra);	
	}
	
	private OrdemCompra criar(Integer carrinhoId, Integer clienteId) {
		Optional<Carrinho> carrinho = carrinhoService.buscaPorId(carrinhoId);
		
		if(carrinho.isEmpty()) {
			return null;
		}
		
		List<Carrinho> listCarrinhosCliente = carrinhoService.getCarrinhoPorIdCliente(clienteId);
		
		boolean carrinhoPertenceCliente = false;
		
		for(Carrinho carrinhoObjeto: listCarrinhosCliente) {
			if(carrinhoObjeto.getId() == carrinho.get().getId()) {
				carrinhoPertenceCliente = true;
			}
		}
		
		if(!carrinhoPertenceCliente) {
			return null;
		}
		
		OrdemCompra ordemCompra = new OrdemCompra(carrinho.get());
		
		return repository.save(ordemCompra);
	}
	
	private OrdemCompra alterarStatus(Integer ordemCompraId, StatusCompra statusNovo) {
		Optional<OrdemCompra> ordemCompra = repository.findById(ordemCompraId);
		
		if(ordemCompra.isEmpty()) {
			return null;
		}
		
		ordemCompra.get().setStatus(statusNovo);
		
		return repository.save(ordemCompra.get());
	}

}
