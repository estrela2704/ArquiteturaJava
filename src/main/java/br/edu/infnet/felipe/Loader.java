package br.edu.infnet.felipe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.felipe.model.domain.produto.Eletronico;
import br.edu.infnet.felipe.model.domain.produto.Produto;
import br.edu.infnet.felipe.model.domain.usuario.Endereco;
import br.edu.infnet.felipe.model.domain.usuario.Vendedor;
import br.edu.infnet.felipe.model.service.VendedorService;

@Component
public class Loader implements ApplicationRunner {

	@Autowired
	private VendedorService vendedorService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		FileReader file = new FileReader("files/java.txt");

		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();
		
		Vendedor vendedor = null;

		while(linha != null) {
			String[] campos = linha.split(";");

			switch(campos[0].toUpperCase()) {
			
			case("V"):
				Endereco endereco = new Endereco();
				endereco.setCep(campos[7]);
				String cpf = campos[1];
				String nome = campos[2];
				String sobrenome = campos[3];
				String email = campos[4];
				LocalDate dataNascimento = LocalDate.parse(campos[5]);
				String telefone = campos[6];
				
				vendedor = new Vendedor(cpf, nome, sobrenome, email, dataNascimento, telefone, endereco);
				
				this.vendedorService.adicionar(vendedor);
				
				break;
			case("P"):
				String marca = campos[6];
				String modelo = campos[7];
				Eletronico categoria = new Eletronico(marca, modelo);
				
				String cpfVendedor = campos[8];
				Vendedor vendedorProduto = this.vendedorService.retornarPorCPF(cpfVendedor);
				
				String nomeProduto = campos[1];
				String descricaoProduto = campos[2];
				int codigo = Integer.parseInt(campos[3]);
				BigDecimal preco = new BigDecimal(campos[4]);
				boolean estoque = Boolean.parseBoolean(campos[5]);
				
				
				Produto produto = new Produto(nomeProduto, descricaoProduto, codigo, preco, estoque, vendedorProduto, categoria);
				
				this.vendedorService.adicionarProduto(vendedorProduto, produto);
				
				break;
			 default: 
				break;
			}
			
			linha = leitura.readLine();
		}
		
		leitura.close();
		
		for(Vendedor vendedorI: this.vendedorService.listar()) {
			System.out.println("Nome do vendedor: " + vendedorI.getNome() + " " + vendedorI.getSobrenome());
			System.out.println("CPF do vendedor: " + vendedorI.getCpf());
			System.out.println("Email do vendedor: " + vendedorI.getEmail());
			System.out.println("Data de nascimento do vendedor: " + vendedorI.getDataNascimento());
			System.out.println("telefone do vendedor: " + vendedorI.getTelefone());
			
			System.out.println("Produtos do vendedor: ");
			
			for(Produto produto: this.vendedorService.listarProdutosVendedor(vendedor)) {
				System.out.println("Nome do produto: " + produto.getNome());
				System.out.println("Descrição do produto: " + produto.getDescricao());
				System.out.println("Codigo do produto: " + produto.getCodigo());
				System.out.println("Codigo do produto: " + produto.getCodigo());
				System.out.println("Preço do produto: R$" + produto.getPreco());
				System.out.println("Categoria do produto: " + produto.getCategoria().getNome());

			}
			
		}
		
	}


}
