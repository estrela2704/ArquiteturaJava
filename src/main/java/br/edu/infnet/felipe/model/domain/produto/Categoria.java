package br.edu.infnet.felipe.model.domain.produto;

public abstract class Categoria {

	private String nome;
	private String descricao;
	
	public Categoria(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
	
}


