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

import br.edu.infnet.felipe.controller.request.CriarUsuarioDTO;
import br.edu.infnet.felipe.domain.usuario.Usuario;
import br.edu.infnet.felipe.service.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/usuario")
	public ResponseEntity<Usuario> criar(@RequestBody CriarUsuarioDTO usuarioDTO){
		Usuario usuarioCriado = usuarioService.criar(usuarioDTO);
		return ResponseEntity.ok(usuarioCriado);	
	}
	
	@GetMapping("/usuarios")
	public ResponseEntity<Collection<Usuario>> listar(){
		Collection<Usuario> usuarios = usuarioService.listar();
		return ResponseEntity.ok(usuarios);
	}

	@GetMapping("/usuario/{id}")
	public ResponseEntity<Usuario> buscarPorID(@PathVariable String id){
		Usuario usuario = usuarioService.buscarPorID(UUID.fromString(id));
		return ResponseEntity.ok(usuario);
	}
	
}
