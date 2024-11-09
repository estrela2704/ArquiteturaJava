package br.edu.infnet.felipe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.felipe.controller.request.AdicionarProdutoCarrinhoDTO;
import br.edu.infnet.felipe.controller.request.CriarCarrinhoDTO;
import br.edu.infnet.felipe.controller.request.RemoverProdutoCarrinhoDTO;
import br.edu.infnet.felipe.domain.venda.Carrinho;
import br.edu.infnet.felipe.service.CarrinhoService;

@RestController
public class CarrinhoController {

	@Autowired
	private CarrinhoService carrinhoService;

	@PostMapping("/carrinho")
	public ResponseEntity<Carrinho> criar(@RequestBody CriarCarrinhoDTO criarCarrinhoDTO){
		Carrinho carrinho = carrinhoService.criar(criarCarrinhoDTO);
		
		return ResponseEntity.ok(carrinho);
	}
	
	@PutMapping("/carrinho/produto")
	public ResponseEntity<Carrinho> adicionarProduto(@RequestBody AdicionarProdutoCarrinhoDTO adicionarProdutoCarrinhoDTO){
		Carrinho carrinho = carrinhoService.adicionarProduto(adicionarProdutoCarrinhoDTO);
		
		return ResponseEntity.ok(carrinho);
	}
	
	@DeleteMapping("/carrinho/produto")
	public ResponseEntity<Carrinho> removerProduto(@RequestBody RemoverProdutoCarrinhoDTO removerProdutoCarrinhoDTO){
		Carrinho carrinho = carrinhoService.removerProduto(removerProdutoCarrinhoDTO);
		
		return ResponseEntity.ok(carrinho);
	}
	
	@GetMapping("/carrinho/{idCliente}")
	public ResponseEntity<List<Carrinho>> retornarCarrinhoCliente(@PathVariable Integer idCliente){
		List<Carrinho> carrinho = carrinhoService.getCarrinhoPorIdCliente(idCliente);
		
		return ResponseEntity.ok(carrinho);
	}
	
	

}
