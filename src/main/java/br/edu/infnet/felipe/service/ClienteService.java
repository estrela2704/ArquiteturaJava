package br.edu.infnet.felipe.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.felipe.domain.usuario.Cliente;
import br.edu.infnet.felipe.domain.usuario.Usuario;
import br.edu.infnet.felipe.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	public Collection<Cliente> listar() {
		return repository.findAll();
	}
	
	public Optional<Cliente> buscarPorID(Integer id) {
		return repository.findById(id);
	}
}
