package br.edu.infnet.felipe.service;

import java.util.Collection;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.felipe.controller.request.CriarProdutoDTO;
import br.edu.infnet.felipe.domain.produto.Categoria;
import br.edu.infnet.felipe.domain.produto.Produto;
import br.edu.infnet.felipe.domain.usuario.Vendedor;
import br.edu.infnet.felipe.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	@Autowired
	private VendedorService vendedorService;

	public Produto criar(CriarProdutoDTO criarProdutoDTO) {

		Vendedor vendedor = vendedorService
				.buscarPorID(UUID.fromString(criarProdutoDTO.getIdVendedor()));
		
		if(vendedor != null) {
			Categoria categoria = new Categoria(criarProdutoDTO.getNomeCategoria(),
					criarProdutoDTO.getDescricaoCategoria());
			
			Produto produto = new Produto(criarProdutoDTO.getNome(),
					criarProdutoDTO.getDescricao(), criarProdutoDTO.getCodigo(),
					criarProdutoDTO.getPreco(), criarProdutoDTO.isEstoque(),
					vendedor, categoria);
			
			vendedorService.adicionarProduto(vendedor, produto);

			salvar(produto);
			
			return produto;
		}
		
		return null;

	}
	
	public void salvar(Produto produto) {
		repository.salvar(produto);
	}

	public Collection<Produto> listar() {
		return repository.listar();
	}

	public Produto buscarPorID(String id) {
		return repository.buscarPorID(UUID.fromString(id));
	}

}
