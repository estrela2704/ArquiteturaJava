package br.edu.infnet.felipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
	
	@GetMapping("/carrinho/{idCliente}")
	public ResponseEntity<Carrinho> retornarCarrinhoCliente(@PathVariable String idCliente){
		Carrinho carrinho = carrinhoService.getCarrinhoPorIdCliente(idCliente);
		
		return ResponseEntity.ok(carrinho);
	}
	
	@PostMapping("/carrinho/produto/remover")
	public ResponseEntity<Carrinho> removerProduto(@RequestBody RemoverProdutoCarrinhoDTO removerProdutoCarrinhoDTO){
		Carrinho carrinho = carrinhoService.removerProduto(removerProdutoCarrinhoDTO);
		
		return ResponseEntity.ok(carrinho);
	}

}
