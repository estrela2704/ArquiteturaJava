package br.edu.infnet.felipe.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.felipe.domain.produto.Produto;
import br.edu.infnet.felipe.domain.usuario.Cliente;
import br.edu.infnet.felipe.domain.usuario.Usuario;
import br.edu.infnet.felipe.domain.usuario.Vendedor;

@Service
public class ClienteService {

	@Autowired
	private UsuarioService service;

	public Collection<Cliente> listar() {
		Collection<Usuario> listaUsuarios = service.listar();
		
		Map<UUID, Cliente> listaClientes = new HashMap<>();
	
		for(Usuario usuario: listaUsuarios) {
			if(usuario instanceof Cliente) {
				listaClientes.put(usuario.getId(), (Cliente) usuario);
			}
		}
		
		return listaClientes.values();
	}
	
	public Cliente buscarPorID(String id) {
		Usuario usuario = service.buscarPorID(UUID.fromString(id));
		
		return usuario instanceof Cliente ? (Cliente) usuario : null;
	}
}
