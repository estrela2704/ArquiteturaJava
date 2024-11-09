package br.edu.infnet.felipe.repository;

import br.edu.infnet.felipe.domain.venda.ItemCarrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCarrinhoRepository extends JpaRepository<ItemCarrinho, Long> {
    // Métodos de consulta personalizados, caso necessário, podem ser adicionados aqui
}

