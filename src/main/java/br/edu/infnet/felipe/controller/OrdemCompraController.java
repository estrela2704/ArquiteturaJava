package br.edu.infnet.felipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.felipe.controller.request.CheckoutDTO;
import br.edu.infnet.felipe.domain.venda.OrdemCompra;
import br.edu.infnet.felipe.service.OrdemCompraService;

@RestController
public class OrdemCompraController {

	@Autowired
	private OrdemCompraService ordemCompraService;
	
	@PostMapping("/checkout")
	public ResponseEntity<OrdemCompra> criar(@RequestBody CheckoutDTO dto){
		OrdemCompra ordemCompra = ordemCompraService.checkout(dto);
		
		return ResponseEntity.ok(ordemCompra);
	}
	
}
