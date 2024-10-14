package br.edu.infnet.felipe.repository.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;

import br.edu.infnet.felipe.domain.produto.Produto;
import br.edu.infnet.felipe.domain.usuario.Vendedor;
import br.edu.infnet.felipe.repository.VendedorRepository;

@Component
public class VendedorRepositoryIMPL implements VendedorRepository {

	private Map<UUID, Vendedor> mapVendedores = new HashMap<UUID, Vendedor>();

	public void salvar(Vendedor vendedor) {
		mapVendedores.put(vendedor.getId(), vendedor);		
	}

	public Collection<Vendedor> listar() {
		return mapVendedores.values();
	}

	public Vendedor buscarPorID(UUID id) {
		return mapVendedores.get(id);
	}

	public List<Produto> listarProdutosVendedor(Vendedor vendedor) {
		return vendedor.getProdutos();
	}
	
}
