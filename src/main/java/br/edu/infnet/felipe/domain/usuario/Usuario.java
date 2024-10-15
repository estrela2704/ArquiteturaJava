package br.edu.infnet.felipe.domain.usuario;

import java.time.LocalDate;
import java.util.UUID;

import br.edu.infnet.felipe.domain.enums.UsuarioRole;

public abstract class Usuario extends Pessoa {

	private UUID id;
	private String email;
	private String password;
	private UsuarioRole role;
	
	public Usuario(String cpf, String nome, String sobrenome, String email,
			LocalDate dataNascimento, String telefone, Endereco endereco, String password, UsuarioRole role) {
		super(cpf, nome, sobrenome, dataNascimento, telefone, endereco);
		this.id = UUID.randomUUID();
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	public UUID getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UsuarioRole getRole() {
		return role;
	}

	public void setRole(UsuarioRole role) {
		this.role = role;
	}

}
