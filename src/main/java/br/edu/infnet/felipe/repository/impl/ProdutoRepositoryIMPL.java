package br.edu.infnet.felipe.repository.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;

import br.edu.infnet.felipe.domain.produto.Produto;
import br.edu.infnet.felipe.domain.usuario.Vendedor;
import br.edu.infnet.felipe.repository.ProdutoRepository;

@Component
public class ProdutoRepositoryIMPL implements ProdutoRepository {

	private Map<UUID, Produto> mapProdutos = new HashMap<UUID, Produto>();

	public void salvar(Produto produto) {
		mapProdutos.put(produto.getId(), produto);		
	}

	public Collection<Produto> listar() {
		return mapProdutos.values();
	}

	public Produto buscarPorID(UUID id) {
		return mapProdutos.get(id);
	}	
}
