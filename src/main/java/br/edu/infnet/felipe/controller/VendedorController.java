package br.edu.infnet.felipe.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.felipe.model.domain.usuario.Vendedor;
import br.edu.infnet.felipe.model.service.VendedorService;

@RestController
public class VendedorController {

	@Autowired
	private VendedorService vendedorService;
	
	@GetMapping("/vendedores")
	public Collection<Vendedor> listar(){
	    System.out.println("Listando vendedores: " + vendedorService.listar() + " Tamanho: " + vendedorService.listar().size());
		return vendedorService.listar();
	}
	
}
