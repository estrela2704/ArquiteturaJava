package br.edu.infnet.felipe.domain.venda;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.edu.infnet.felipe.domain.produto.Produto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ItemCarrinho {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @ManyToOne
    private Produto produto;

    private int quantidade;
    
    @ManyToOne
    @JsonBackReference
    private Carrinho carrinho;  // Adicionando a associação com o Carrinho
    


    public ItemCarrinho() {
    }

    public ItemCarrinho(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public void adicionarQuantidade(int quantidade) {
        this.quantidade += quantidade;
    }

    public void removerQuantidade(int quantidade) {
        this.quantidade = Math.max(0, this.quantidade - quantidade);
    }
}
