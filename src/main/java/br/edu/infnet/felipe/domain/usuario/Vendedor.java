package br.edu.infnet.felipe.domain.usuario;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.felipe.domain.enums.UsuarioRole;
import br.edu.infnet.felipe.domain.produto.Produto;

public class Vendedor extends Usuario {

	private List<Produto> produtos = new ArrayList<Produto>();

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
