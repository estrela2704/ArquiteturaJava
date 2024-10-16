package br.edu.infnet.felipe.repository;

import java.util.Collection;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.edu.infnet.felipe.domain.usuario.Usuario;

@Repository
public interface UsuarioRepository {
	void salvar(Usuario usuario);
	Collection<Usuario> listar();
	Usuario buscarPorID(UUID id);
}
