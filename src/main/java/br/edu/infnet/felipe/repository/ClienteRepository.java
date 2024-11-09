package br.edu.infnet.felipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.felipe.domain.usuario.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
}
