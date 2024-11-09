package br.edu.infnet.felipe.domain.venda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.edu.infnet.felipe.domain.produto.Produto;
import br.edu.infnet.felipe.domain.usuario.Cliente;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ItemCarrinho> itens = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    public Carrinho() {
    }

    public Carrinho(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public List<ItemCarrinho> getItens() {
        return itens;
    }

    public boolean addProduto(Produto produto, int quantidade) {
        quantidade = Math.max(1, quantidade);

        if (!produto.isEstoque()) {
            return false;
        }

        // Verificar se o produto já está no carrinho
        for (ItemCarrinho item : itens) {
            if (item.getProduto().getId().equals(produto.getId())) {
                item.adicionarQuantidade(quantidade); // Apenas adicionar a quantidade ao item existente
                return true;
            }
        }

        // Criar um novo item no carrinho se o produto não existir
        ItemCarrinho novoItem = new ItemCarrinho(produto, quantidade);
        novoItem.setCarrinho(this);  // Associar o item ao carrinho
        itens.add(novoItem);

        return true;
    }


    public boolean removerProduto(Produto produto, int quantidade) {
        quantidade = Math.max(1, quantidade);

        for (ItemCarrinho item : itens) {
            if (item.getProduto().getId().equals(produto.getId())) {
                if (item.getQuantidade() < quantidade) {
                    return false; // Não tem quantidade suficiente no carrinho
                }
                item.removerQuantidade(quantidade); // Remove a quantidade
                return true;
            }
        }

        return false; // Produto não encontrado no carrinho
    }

    public int getQuantidadeProdutoCarrinho(Produto produto) {
        for (ItemCarrinho item : itens) {
            if (item.getProduto().getId().equals(produto.getId())) {
                return item.getQuantidade(); // Retorna a quantidade do item no carrinho
            }
        }
        return 0; // Produto não encontrado
    }

    public BigDecimal calcularPrecoCarrinho() {
        BigDecimal preco = BigDecimal.ZERO;

        for (ItemCarrinho item : itens) {
            // Multiplica o preço do produto pela quantidade no carrinho
            preco = preco.add(item.getProduto().getPreco().multiply(new BigDecimal(item.getQuantidade())));
        }

        return preco;
    }

    public Cliente getComprador() {
        return cliente;
    }
}
