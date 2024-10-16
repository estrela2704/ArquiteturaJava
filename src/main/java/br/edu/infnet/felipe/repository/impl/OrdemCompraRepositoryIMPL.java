package br.edu.infnet.felipe.repository.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;

import br.edu.infnet.felipe.domain.venda.OrdemCompra;
import br.edu.infnet.felipe.repository.OrdemCompraRepository;

@Component
public class OrdemCompraRepositoryIMPL implements OrdemCompraRepository {

	private Map<UUID, OrdemCompra> mapOrdemCompra = new HashMap<UUID, OrdemCompra>();

	public void salvar(OrdemCompra ordemCompra) {
		mapOrdemCompra.put(ordemCompra.getId(), ordemCompra);		
	}

	public Collection<OrdemCompra> listar() {
		return mapOrdemCompra.values();
	}

	public OrdemCompra buscarPorID(UUID id) {
		return mapOrdemCompra.get(id);
	}
	
}
