package br.edu.infnet.felipe.model.domain.usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.felipe.model.domain.produto.Produto;

public class Vendedor extends Pessoa {
	
	private List<Produto> produtos = new ArrayList<Produto>();
	
	public Vendedor(String cpf, String nome, String sobrenome, String email, LocalDate dataNascimento, String telefone,
			Endereco endereco) {
		super(cpf, nome, sobrenome, email, dataNascimento, telefone, endereco);
	}

	public List<Produto> getProdutos() {
		return produtos;
	}
	
	public void addProduto(Produto produto) {
		this.produtos.add(produto);
	}

}
