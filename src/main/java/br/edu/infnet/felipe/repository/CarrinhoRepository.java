package br.edu.infnet.felipe.repository;

import java.util.Collection;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.edu.infnet.felipe.domain.venda.Carrinho;

@Repository
public interface CarrinhoRepository {
	void salvar(Carrinho carrinho);
	Collection<Carrinho> listar();
	Carrinho buscarPorID(UUID id);
	Carrinho buscarPorClienteId(UUID id);
}
