package br.edu.infnet.felipe.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.felipe.domain.produto.Produto;
import br.edu.infnet.felipe.domain.usuario.Usuario;
import br.edu.infnet.felipe.domain.usuario.Vendedor;

@Service
public class VendedorService {

	@Autowired
	private UsuarioService service;

	public Collection<Vendedor> listar() {
		Collection<Usuario> listaUsuarios = service.listar();
		
		Map<UUID, Vendedor> listaVendedores = new HashMap<>();
	
		for(Usuario usuario: listaUsuarios) {
			if(usuario instanceof Vendedor) {
				listaVendedores.put(usuario.getId(), (Vendedor) usuario);
			}
		}
		
		return listaVendedores.values();
	}
	
	public Vendedor buscarPorID(UUID id) {
		Usuario usuario = service.buscarPorID(id);
		
		return usuario instanceof Vendedor ? (Vendedor) usuario : null;
	}
	
	public Produto adicionarProduto(Vendedor vendedor, Produto produto) {
		vendedor.addProduto(produto);

		service.salvar(vendedor);

		return produto;
	}

	public List<Produto> listarProdutosVendedor(Vendedor vendedor) {
		Vendedor vendedorEncontrado = (Vendedor) service.buscarPorID(vendedor.getId());
		
		return vendedorEncontrado.getProdutos();
	}
}
