package br.edu.infnet.felipe.repository.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;

import br.edu.infnet.felipe.domain.venda.Carrinho;
import br.edu.infnet.felipe.repository.CarrinhoRepository;

@Component
public class CarrinhoRepositoryIMPL implements CarrinhoRepository {

	private Map<UUID, Carrinho> mapCarrinhos = new HashMap<UUID, Carrinho>();

	public void salvar(Carrinho carrinho) {
		mapCarrinhos.put(carrinho.getId(), carrinho);		
	}
	
	public Collection<Carrinho> listar(){
		return mapCarrinhos.values();
	}

	public Carrinho buscarPorID(UUID id) {
		return mapCarrinhos.get(id);
	}

	public List<Carrinho> buscarPorClienteId(UUID id) {
		List<Carrinho> carrinhos = new ArrayList<>();
		
		for(Carrinho carrinho: mapCarrinhos.values()) {
			if(id.equals(carrinho.getComprador().getId())) {
				carrinhos.add(carrinho);
			}
		}
		return carrinhos;
	}
}
