package br.edu.infnet.felipe.model.domain.categoria;

import br.edu.infnet.felipe.model.enums.Classificacao;

public abstract class Categoria {

	private String nome;
	private String descricao;
	private Classificacao classificacao;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getClassificacao() {
		return classificacao.name();
	}
	public void setClassificacao(Classificacao classificacao) {
		this.classificacao = classificacao;
	}
	
}


