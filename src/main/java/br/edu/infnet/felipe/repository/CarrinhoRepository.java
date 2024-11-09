package br.edu.infnet.felipe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.felipe.domain.venda.Carrinho;

@Repository
public interface CarrinhoRepository extends  JpaRepository<Carrinho, Integer>  {
	List<Carrinho> findByClienteId(Integer id);
}
