package br.edu.infnet.felipe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.infnet.felipe.domain.produto.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    List<Produto> findByVendedorId(Integer vendedorId);
    List<Produto> findByCategoriaId(Integer categoriaId);
}
