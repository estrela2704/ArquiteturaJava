package br.edu.infnet.felipe.controller.request;

import java.math.BigDecimal;

public class CriarProdutoDTO {

	private String nome;
	private String descricao;
	private int codigo;
	private BigDecimal preco;
	private boolean estoque;
	private Integer idVendedor;
	private String nomeCategoria;
	private String descricaoCategoria;

	public CriarProdutoDTO(String nome, String descricao, int codigo,
			BigDecimal preco, boolean estoque, Integer idVendedor,	
			String nomeCategoria, String descricaoCategoria) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.codigo = codigo;
		this.preco = preco;
		this.estoque = estoque;
		this.idVendedor = idVendedor;
		this.nomeCategoria = nomeCategoria;
		this.descricaoCategoria = descricaoCategoria;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public boolean isEstoque() {
		return estoque;
	}

	public Integer getIdVendedor() {
		return idVendedor;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}

}
