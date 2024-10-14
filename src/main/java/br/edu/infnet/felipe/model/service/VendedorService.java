package br.edu.infnet.felipe.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.felipe.model.domain.produto.Produto;
import br.edu.infnet.felipe.model.domain.usuario.Vendedor;

@Service
public class VendedorService {

	Map<String, Vendedor> mapVendedores = new HashMap<String, Vendedor>();
	
	public void adicionar(Vendedor vendedor) {
		mapVendedores.put(vendedor.getCpf(), vendedor);
	}
	
	public Collection<Vendedor> listar(){
		return mapVendedores.values();
	}
	
	public Vendedor retornarPorCPF(String cpf) {
		return mapVendedores.get(cpf);
	}
	
	public void adicionarProduto(Vendedor vendedor, Produto produto) {
		vendedor.addProduto(produto);
	}
	
	public List<Produto> listarProdutosVendedor(Vendedor vendedor){
		return vendedor.getProdutos();
	}
}
