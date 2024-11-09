package br.edu.infnet.felipe.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.felipe.controller.request.CriarProdutoDTO;
import br.edu.infnet.felipe.domain.produto.Categoria;
import br.edu.infnet.felipe.domain.produto.Produto;
import br.edu.infnet.felipe.domain.usuario.Vendedor;
import br.edu.infnet.felipe.repository.CategoriaRepository;
import br.edu.infnet.felipe.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private VendedorService vendedorService;

	public Produto criar(CriarProdutoDTO criarProdutoDTO) {

		Optional<Vendedor> vendedorOPT = vendedorService
				.buscarPorID(criarProdutoDTO.getIdVendedor());
		
		if(vendedorOPT.isPresent()) {
			Vendedor vendedor = vendedorOPT.get();
			
			Categoria categoria = new Categoria(criarProdutoDTO.getNomeCategoria(),
					criarProdutoDTO.getDescricaoCategoria());
			
			categoriaRepository.save(categoria);
			
			Produto produto = new Produto(criarProdutoDTO.getNome(),
					criarProdutoDTO.getDescricao(), criarProdutoDTO.getCodigo(),
					criarProdutoDTO.getPreco(), criarProdutoDTO.isEstoque(),
					vendedor, categoria);
			
			salvar(produto);
			
			return produto;
		}
		
		return null;

	}
	
	public void salvar(Produto produto) {
		repository.save(produto);
	}

	public Collection<Produto> listar() {
		return repository.findAll();
	}

	public Collection<Produto> listarPorVendedor(Integer id) {
		return repository.findByVendedorId(id);
	}
	
	public Optional<Produto> buscarPorID(Integer id) {
		return repository.findById(id);
	}

}
