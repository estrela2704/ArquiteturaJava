package br.edu.infnet.felipe.repository.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;

import br.edu.infnet.felipe.domain.usuario.Usuario;
import br.edu.infnet.felipe.repository.UsuarioRepository;

@Component
public class UsuarioRepositoryIMPL implements UsuarioRepository {

	private Map<UUID, Usuario> mapUsuarios = new HashMap<UUID, Usuario>();

	public void salvar(Usuario usuario) {
		System.out.println("Salvando usuario: " + usuario.getNome());
		mapUsuarios.put(usuario.getId(), usuario);		
	}

	public Collection<Usuario> listar() {
		return mapUsuarios.values();
	}

	public Usuario buscarPorID(UUID id) {
		return mapUsuarios.get(id);
	}
	
}
