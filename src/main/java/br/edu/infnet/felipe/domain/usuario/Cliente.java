package br.edu.infnet.felipe.domain.usuario;

import java.time.LocalDate;

import br.edu.infnet.felipe.domain.enums.UsuarioRole;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CLIENTE")
public class Cliente extends Usuario {

	public Cliente() {
		super();
	}
	
	public Cliente(String cpf, String nome, String sobrenome, String email,
			LocalDate dataNascimento, String telefone, Endereco endereco, String senha, UsuarioRole role) {
		super(cpf, nome, sobrenome, email, dataNascimento, telefone, endereco, senha, role);
	}

}
