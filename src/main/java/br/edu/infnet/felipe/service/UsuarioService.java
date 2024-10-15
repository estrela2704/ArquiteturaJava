package br.edu.infnet.felipe.service;

import java.util.Collection;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.felipe.controller.request.CriarUsuarioDTO;
import br.edu.infnet.felipe.domain.usuario.Admin;
import br.edu.infnet.felipe.domain.usuario.Cliente;
import br.edu.infnet.felipe.domain.usuario.Endereco;
import br.edu.infnet.felipe.domain.usuario.Usuario;
import br.edu.infnet.felipe.domain.usuario.Vendedor;
import br.edu.infnet.felipe.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;

	public Usuario criar(CriarUsuarioDTO usuarioDTO) {

		Endereco endereco = new Endereco(usuarioDTO.getCep(),
				usuarioDTO.getLogradouro(), usuarioDTO.getComplemento(),
				usuarioDTO.getBairro(), usuarioDTO.getLocalidade(),
				usuarioDTO.getUf());

		Usuario usuario = null;
		
		switch(usuarioDTO.getRole()) {
		
		case ADMIN : 
			usuario = new Admin(usuarioDTO.getCpf(),
					usuarioDTO.getNome(), usuarioDTO.getSobrenome(),
					usuarioDTO.getEmail(), usuarioDTO.getDataNascimento(),
					usuarioDTO.getTelefone(), endereco, usuarioDTO.getSenha(),
					usuarioDTO.getRole());
			break;
		
		case VENDEDOR:
			usuario = new Vendedor(usuarioDTO.getCpf(),
					usuarioDTO.getNome(), usuarioDTO.getSobrenome(),
					usuarioDTO.getEmail(), usuarioDTO.getDataNascimento(),
					usuarioDTO.getTelefone(), endereco, usuarioDTO.getSenha(),
					usuarioDTO.getRole());
			break;
		
		case CLIENTE:
			usuario = new Cliente(usuarioDTO.getCpf(),
					usuarioDTO.getNome(), usuarioDTO.getSobrenome(),
					usuarioDTO.getEmail(), usuarioDTO.getDataNascimento(),
					usuarioDTO.getTelefone(), endereco, usuarioDTO.getSenha(),
					usuarioDTO.getRole());
			break;
		
		default:
			
			break;
			
		}

		if(usuario != null) {
			repository.salvar(usuario);
		}
		
		return usuario;
	}
	
	public void salvar(Usuario usuario) {
		repository.salvar(usuario);
	}

	public Collection<Usuario> listar() {
		return repository.listar();
	}

	public Usuario buscarPorID(UUID id) {
		return repository.buscarPorID(id);
	}
	
}
