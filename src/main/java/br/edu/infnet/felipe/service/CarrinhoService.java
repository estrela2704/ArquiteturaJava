package br.edu.infnet.felipe.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.felipe.controller.request.CriarCarrinhoDTO;
import br.edu.infnet.felipe.controller.request.RemoverProdutoCarrinhoDTO;
import br.edu.infnet.felipe.domain.produto.Produto;
import br.edu.infnet.felipe.domain.usuario.Cliente;
import br.edu.infnet.felipe.domain.venda.Carrinho;
import br.edu.infnet.felipe.repository.CarrinhoRepository;

@Service
public class CarrinhoService {

	@Autowired
	private CarrinhoRepository repository;
	
	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ProdutoService produtoService;
	
	public Carrinho criar(CriarCarrinhoDTO criarCarrinhoDTO) {
		
		
		Carrinho carrinho = getCarrinhoPorIdCliente(criarCarrinhoDTO.getIdUsuario());
		
		Produto produto = produtoService.buscarPorID(UUID.fromString(criarCarrinhoDTO.getIdProduto()));
		
		if(produto == null) {
			return null;
		}
		
		carrinho.addProduto(produto, criarCarrinhoDTO.getQuantidade());
		
		repository.salvar(carrinho);
		
		return carrinho;
	}
	
	public Carrinho getCarrinhoPorIdCliente(String id) {
		
		Cliente cliente = clienteService.buscarPorID(UUID.fromString(id));	
		
		if(cliente == null) {
			return null;
		}
		
		return retornaOuCriaCarrinhoPorCliente(cliente);	
	}

	public Carrinho removerProduto(RemoverProdutoCarrinhoDTO removerProdutoCarrinhoDTO) {
		
		Produto produto = produtoService.buscarPorID(UUID.fromString(removerProdutoCarrinhoDTO.getIdProduto()));
		
		if(produto == null) {
			return null;
		}
		
		Carrinho carrinho = repository.buscarPorClienteId(UUID.fromString(removerProdutoCarrinhoDTO.getIdUsuario()));

		if(carrinho == null | carrinho.getProdutos().size() <= 0) {
			return null;
		}
		
		carrinho.removerProduto(produto, removerProdutoCarrinhoDTO.getQuantidade());
		
		repository.salvar(carrinho);
		
		return carrinho;
	}

	
	private Carrinho retornaOuCriaCarrinhoPorCliente(Cliente cliente) {
		
		Carrinho carrinho = repository.buscarPorClienteId(cliente.getId());
		
		if(carrinho == null) {
			carrinho = new Carrinho(cliente);
		}
		
		return carrinho;
	}

}
