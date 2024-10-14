package br.edu.infnet.felipe.domain.usuario;

import java.time.LocalDate;

public class Cliente extends Pessoa {

	public Cliente(String cpf, String nome, String sobrenome, String email, LocalDate dataNascimento, String telefone,
			Endereco endereco) {
		super(cpf, nome, sobrenome, email, dataNascimento, telefone, endereco);

	}

}
