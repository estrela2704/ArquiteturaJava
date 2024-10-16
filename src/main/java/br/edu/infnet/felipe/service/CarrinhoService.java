package br.edu.infnet.felipe.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.felipe.controller.request.AdicionarProdutoCarrinhoDTO;
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
		
		Cliente cliente = clienteService.buscarPorID(criarCarrinhoDTO.getIdUsuario());	
		
		if(cliente == null) {
			return null;
		}
		
		Carrinho carrinho = new Carrinho(cliente);
		
		Produto produto = produtoService.buscarPorID(criarCarrinhoDTO.getIdProduto());
		
		if(produto == null) {
			System.out.println("Produto");
			return null;
		}
		
		carrinho.addProduto(produto, criarCarrinhoDTO.getQuantidade());
		
		repository.salvar(carrinho);
		
		return carrinho;
	}
	
	public List<Carrinho> getCarrinhoPorIdCliente(String id) {
		
		Cliente cliente = clienteService.buscarPorID(id);	
		
		if(cliente == null) {
			return null;
		}
		
		return repository.buscarPorClienteId(cliente.getId());	
	}
	
	public Carrinho adicionarProduto(AdicionarProdutoCarrinhoDTO adicionarProdutoCarrinhoDTO) {
		
		Produto produto = produtoService.buscarPorID(adicionarProdutoCarrinhoDTO.getIdProduto());
		
		if(produto == null) {
			return null;
		}
		
		Carrinho carrinho = repository.buscarPorID(UUID.fromString(adicionarProdutoCarrinhoDTO.getIdCarrinho()));
		
		if(carrinho == null) {
			return null;
		}
		
		carrinho.addProduto(produto, adicionarProdutoCarrinhoDTO.getQuantidade());
		
		repository.salvar(carrinho);
		
		return carrinho;
	}

	public Carrinho removerProduto(RemoverProdutoCarrinhoDTO removerProdutoCarrinhoDTO) {
		
		Produto produto = produtoService.buscarPorID(removerProdutoCarrinhoDTO.getIdProduto());
		
		if(produto == null) {
			return null;
		}
		
		Carrinho carrinho = repository.buscarPorID(UUID.fromString(removerProdutoCarrinhoDTO.getIdCarrinho()));

		if(carrinho == null | carrinho.getProdutos().size() <= 0) {
			return null;
		}
		
		carrinho.removerProduto(produto, removerProdutoCarrinhoDTO.getQuantidade());
		
		repository.salvar(carrinho);
		
		return carrinho;
	}
	
	public Carrinho buscaPorId(String id) {
		return repository.buscarPorID(UUID.fromString(id));
	}

}
