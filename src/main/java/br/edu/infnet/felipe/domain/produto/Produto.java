package br.edu.infnet.felipe.domain.produto;

import java.math.BigDecimal;

import br.edu.infnet.felipe.domain.usuario.Vendedor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Produto {
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
    
	private String nome;
	private String descricao;
	private int codigo;
	private BigDecimal preco;
	private boolean estoque;
	
    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private Vendedor vendedor;
	
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
	
    public Produto() {
    	
    }
    
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
	
	public Integer getId() {
		return id;
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
	
	public String getVendedor() {
		return vendedor.getId().toString();
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
