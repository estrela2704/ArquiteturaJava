package br.edu.infnet.felipe.domain.usuario;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.edu.infnet.felipe.domain.produto.Produto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Pessoa {

	private List<Produto> produtos = new ArrayList<Produto>();

	public Vendedor(String cpf, String nome, String sobrenome, String email,
			LocalDate dataNascimento, String telefone, Endereco endereco) {
		super(cpf, nome, sobrenome, email, dataNascimento, telefone, endereco);
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void addProduto(Produto produto) {
		this.produtos.add(produto);
	}
	

}
