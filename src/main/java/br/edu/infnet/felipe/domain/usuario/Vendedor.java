package br.edu.infnet.felipe.domain.usuario;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.felipe.domain.enums.UsuarioRole;
import br.edu.infnet.felipe.domain.produto.Produto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorValue("VENDEDOR")
public class Vendedor extends Usuario {

    @OneToMany(mappedBy = "vendedor", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Produto> produtos = new ArrayList<Produto>();

    public Vendedor() {
    	super();
    }
    
	public Vendedor(String cpf, String nome, String sobrenome, String email,
			LocalDate dataNascimento, String telefone, Endereco endereco, String password, UsuarioRole role) {
		super(cpf, nome, sobrenome, email, dataNascimento, telefone, endereco, password, role);
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void addProduto(Produto produto) {
		this.produtos.add(produto);
	}
	

}
