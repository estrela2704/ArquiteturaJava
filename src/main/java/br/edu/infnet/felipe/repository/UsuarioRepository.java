package br.edu.infnet.felipe.repository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.edu.infnet.felipe.domain.produto.Produto;
import br.edu.infnet.felipe.domain.usuario.Usuario;
import br.edu.infnet.felipe.domain.usuario.Vendedor;

@Repository
public interface UsuarioRepository {
	void salvar(Usuario usuario);
	Collection<Usuario> listar();
	Usuario buscarPorID(UUID id);
}
