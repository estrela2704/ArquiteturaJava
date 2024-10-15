package br.edu.infnet.felipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.felipe.controller.request.CriarCarrinhoDTO;
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

}
