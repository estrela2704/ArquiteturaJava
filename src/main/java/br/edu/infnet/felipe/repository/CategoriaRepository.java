package br.edu.infnet.felipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.felipe.domain.produto.Categoria;

@Repository
public interface CategoriaRepository extends  JpaRepository<Categoria, Integer>  {
}
