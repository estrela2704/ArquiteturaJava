package br.edu.infnet.felipe.controller.request;

import java.time.LocalDate;

import br.edu.infnet.felipe.domain.enums.UsuarioRole;

public class CriarUsuarioDTO {

	private String nome;
	private String sobrenome;
	private String email;
	private LocalDate dataNascimento;
	private String telefone;
	private String cpf;
	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String localidade;
	private String uf;
	private UsuarioRole role;
	private String senha;
	
	public CriarUsuarioDTO(String nome, String sobrenome, String email,
			LocalDate dataNascimento, String telefone, String cpf, String cep,
			String logradouro, String complemento, String bairro,
			String localidade, String uf, UsuarioRole role, String senha) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.cpf = cpf;
		this.cep = cep;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.localidade = localidade;
		this.uf = uf;
		this.role = role;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public String getCep() {
		return cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public String getUf() {
		return uf;
	}
	
	public UsuarioRole getRole() {
		return role;
	}

	public String getSenha() {
		return senha;
	}
	
	
}
