package br.edu.infnet.felipe.repository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.edu.infnet.felipe.domain.produto.Produto;
import br.edu.infnet.felipe.domain.usuario.Vendedor;

@Repository
public interface ProdutoRepository {
	void salvar(Produto produto);
	Collection<Produto> listar();
	Produto buscarPorID(UUID id);
}
