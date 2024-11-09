package br.edu.infnet.felipe.domain.usuario;

import java.time.LocalDate;

import br.edu.infnet.felipe.domain.enums.UsuarioRole;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends Usuario {

	public Admin(String cpf, String nome, String sobrenome, String email,
			LocalDate dataNascimento, String telefone, Endereco endereco, String senha, UsuarioRole role) {
		super(cpf, nome, sobrenome, email, dataNascimento, telefone, endereco, senha, role);
	}
	
	public Admin() {}
	

}
