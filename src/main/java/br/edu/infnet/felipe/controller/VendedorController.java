package br.edu.infnet.felipe.controller;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.felipe.controller.request.CriarUsuarioDTO;
import br.edu.infnet.felipe.domain.produto.Produto;
import br.edu.infnet.felipe.domain.usuario.Vendedor;
import br.edu.infnet.felipe.service.VendedorService;

@RestController
public class VendedorController {

	@Autowired
	private VendedorService vendedorService;
	
	@GetMapping("/vendedores")
	public ResponseEntity<Collection<Vendedor>> listar(){
		Collection<Vendedor> listaVendedores = vendedorService.listar();
		return ResponseEntity.ok(listaVendedores);
	}
	
	@GetMapping("/vendedor/{id}")
	public ResponseEntity<Vendedor> buscarPorID(@PathVariable String id){
		Vendedor vendedor = vendedorService.buscarPorID(UUID.fromString(id));
		return ResponseEntity.ok(vendedor);
	}
	
	@GetMapping("/vendedor/{id}/produtos")
	public ResponseEntity<List<Produto>> listarProdutosVendedor(@PathVariable String id){
		Vendedor vendedor = vendedorService.buscarPorID(UUID.fromString(id));
		List<Produto> produtos = vendedorService.listarProdutosVendedor(vendedor);
		return ResponseEntity.ok(produtos);
	}
	
	
}
