package br.edu.infnet.felipe.repository;

import java.util.Collection;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.edu.infnet.felipe.domain.venda.OrdemCompra;

@Repository
public interface OrdemCompraRepository {
	void salvar(OrdemCompra ordemCompra);
	Collection<OrdemCompra> listar();
	OrdemCompra buscarPorID(UUID id);
}
