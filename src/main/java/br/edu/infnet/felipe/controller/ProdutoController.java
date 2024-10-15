package br.edu.infnet.felipe.controller;

import java.util.Collection;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.felipe.controller.request.CriarProdutoDTO;
import br.edu.infnet.felipe.domain.produto.Produto;
import br.edu.infnet.felipe.service.ProdutoService;

@RestController
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@PostMapping("/produto")
	public ResponseEntity<Produto> criarProduto(
			@RequestBody CriarProdutoDTO criarProdutoDTO) {
		Produto produtoCriado = produtoService.criar(criarProdutoDTO);
		return ResponseEntity.ok(produtoCriado);
	}

	@GetMapping("/produtos")
	public ResponseEntity<Collection<Produto>> listar() {
		Collection<Produto> listaProdutos = produtoService.listar();
		return ResponseEntity.ok(listaProdutos);
	}

	@GetMapping("/produto/{id}")
	public ResponseEntity<Produto> buscarPorID(@PathVariable String id) {
		Produto produto = produtoService.buscarPorID(UUID.fromString(id));
		return ResponseEntity.ok(produto);
	}

}
