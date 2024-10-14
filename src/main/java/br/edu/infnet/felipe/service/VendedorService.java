package br.edu.infnet.felipe.service;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.felipe.controller.request.CriarVendedorDTO;
import br.edu.infnet.felipe.domain.produto.Produto;
import br.edu.infnet.felipe.domain.usuario.Endereco;
import br.edu.infnet.felipe.domain.usuario.Vendedor;
import br.edu.infnet.felipe.repository.VendedorRepository;

@Service
public class VendedorService {

	@Autowired
	private VendedorRepository repository;

	public Vendedor criar(CriarVendedorDTO vendedorDTO) {

		Endereco endereco = new Endereco(vendedorDTO.getCep(),
				vendedorDTO.getLogradouro(), vendedorDTO.getComplemento(),
				vendedorDTO.getBairro(), vendedorDTO.getLocalidade(),
				vendedorDTO.getUf());

		Vendedor vendedor = new Vendedor(vendedorDTO.getCpf(),
				vendedorDTO.getNome(), vendedorDTO.getSobrenome(),
				vendedorDTO.getEmail(), vendedorDTO.getDataNascimento(),
				vendedorDTO.getTelefone(), endereco);

		repository.salvar(vendedor);

		return vendedor;
	}

	public Collection<Vendedor> listar() {
		return repository.listar();
	}

	public Vendedor buscarPorID(String id) {
		return repository.buscarPorID(UUID.fromString(id));
	}

	public Produto adicionarProduto(Vendedor vendedor, Produto produto) {
		vendedor.addProduto(produto);

		repository.salvar(vendedor);

		return produto;
	}

	public List<Produto> listarProdutosVendedor(Vendedor vendedor) {
		return repository.listarProdutosVendedor(vendedor);
	}
}
