package br.edu.infnet.felipe.model.domain.produto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.edu.infnet.felipe.model.domain.usuario.Vendedor;

public class Produto {
	
	private String nome;
	private String descricao;
	private int codigo;
	private BigDecimal preco;
	private boolean estoque;
	
	@JsonBackReference
	private Vendedor vendedor;
	private Categoria categoria;
	
	public Produto(String nome, String descricao, int codigo, BigDecimal preco, boolean estoque, Vendedor vendedor,
			Categoria categoria) {
		this.nome = nome;
		this.descricao = descricao;
		this.codigo = codigo;
		this.preco = preco;
		this.estoque = estoque;
		this.vendedor = vendedor;
		this.categoria = categoria;
	}
	
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
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public boolean isEstoque() {
		return estoque;
	}
	public void setEstoque(boolean estoque) {
		this.estoque = estoque;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
	
}
