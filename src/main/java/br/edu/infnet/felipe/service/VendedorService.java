package br.edu.infnet.felipe.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.felipe.domain.usuario.Vendedor;
import br.edu.infnet.felipe.repository.VendedorRepository;

@Service
public class VendedorService {

	@Autowired
	private VendedorRepository repository;

	public Collection<Vendedor> listar() {
		return repository.findAll();
	}
	
	public Optional<Vendedor> buscarPorID(Integer id) {
		return repository.findById(id);
	}

}
