package br.edu.infnet.felipe.service;

import java.util.List;
import java.util.Optional;

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
		
		Optional<Cliente> cliente = clienteService.buscarPorID(criarCarrinhoDTO.getIdUsuario());	
		
		if(cliente.isEmpty()) {
			System.out.println("é null");
			return null;
		}
		
		Carrinho carrinho = new Carrinho(cliente.get());
		
		Optional<Produto> produto = produtoService.buscarPorID(criarCarrinhoDTO.getIdProduto());
		
		if(produto.isEmpty()) {
			System.out.println("é null2");
			return null;
		}
		
		carrinho.addProduto(produto.get(), criarCarrinhoDTO.getQuantidade());
		
		repository.save(carrinho);
		
		return carrinho;
	}
	
	public List<Carrinho> getCarrinhoPorIdCliente(Integer id) {
		
		Optional<Cliente> cliente = clienteService.buscarPorID(id);	
		
		if(cliente.isEmpty()) {
			return null;
		}
		
		return repository.findByClienteId(cliente.get().getId());	
	}
	
	public Carrinho adicionarProduto(AdicionarProdutoCarrinhoDTO adicionarProdutoCarrinhoDTO) {
		
		Optional<Produto> produto = produtoService.buscarPorID(adicionarProdutoCarrinhoDTO.getIdProduto());
		
		if(produto.isEmpty()) {
			return null;
		}
		
		Optional<Carrinho> carrinho = repository.findById(adicionarProdutoCarrinhoDTO.getIdCarrinho());
		
		if(carrinho.isEmpty()) {
			return null;
		}
		
		
		carrinho.get().addProduto(produto.get(), adicionarProdutoCarrinhoDTO.getQuantidade());
		
		return repository.save(carrinho.get());
	}

	public Carrinho removerProduto(RemoverProdutoCarrinhoDTO removerProdutoCarrinhoDTO) {
		
		Optional<Produto> produto = produtoService.buscarPorID(removerProdutoCarrinhoDTO.getIdProduto());
		
		if(produto.isEmpty()) {
			return null;
		}
		
		Optional<Carrinho> carrinho = repository.findById(removerProdutoCarrinhoDTO.getIdCarrinho());
		
		if(carrinho.isEmpty() | carrinho.get().getItens().size() <= 0) {
			return null;
		}

		carrinho.get().removerProduto(produto.get(), removerProdutoCarrinhoDTO.getQuantidade());
		
		return repository.save(carrinho.get());
	}
	
	public Optional<Carrinho> buscaPorId(Integer id) {
		return repository.findById(id);
	}

}
