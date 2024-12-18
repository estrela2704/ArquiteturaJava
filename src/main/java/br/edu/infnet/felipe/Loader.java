package br.edu.infnet.felipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.edu.infnet.felipe.controller.request.CriarCarrinhoDTO;
import br.edu.infnet.felipe.controller.request.CriarProdutoDTO;
import br.edu.infnet.felipe.controller.request.CriarUsuarioDTO;
import br.edu.infnet.felipe.domain.enums.UsuarioRole;
import br.edu.infnet.felipe.domain.produto.Produto;
import br.edu.infnet.felipe.domain.usuario.Cliente;
import br.edu.infnet.felipe.domain.usuario.Vendedor;
import br.edu.infnet.felipe.service.CarrinhoService;
import br.edu.infnet.felipe.service.ClienteService;
import br.edu.infnet.felipe.service.ProdutoService;
import br.edu.infnet.felipe.service.UsuarioService;
import br.edu.infnet.felipe.service.VendedorService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class Loader implements ApplicationRunner {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ClienteService clienteService;
    
    @Autowired
    private ProdutoService produtoService;
    
    @Autowired
    private VendedorService vendedorService;

    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        loadData("files/java.txt");
    }
    
	Map<String, Vendedor> vendedoresMapCPF = new HashMap<>();
	Map<String, Produto> produtosMapCodigo = new HashMap<>();
	Map<String, Cliente> clienteMapCPF = new HashMap<>();

	public Map<String, Vendedor> loadVendedoresMap() {
        Collection<Vendedor> vendedoresCollection = vendedorService.listar();

    	for(Vendedor vendedor: vendedoresCollection) {
    		vendedoresMapCPF.put(vendedor.getCpf(), vendedor);
    	}
    	
    	return vendedoresMapCPF;
	}
	
	public Map<String, Cliente> loadClientesMap() {
        Collection<Cliente> usuarioCollection = clienteService.listar();

    	for(Cliente usuario: usuarioCollection) {
    		System.out.println(usuario.getCpf());
    		clienteMapCPF.put(usuario.getCpf(), usuario);
    	}
    	
    	return clienteMapCPF;
	}
	
	public Map<String, Produto> loadProdutoMap() {
        Collection<Produto> produtoCollection = produtoService.listar();

    	for(Produto produto: produtoCollection) {
    		produtosMapCodigo.put(Integer.toString(produto.getCodigo()), produto);
    	}
    	
    	return produtosMapCodigo;
	}
	
    public void loadData(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                    	
        	String line;
            while ((line = br.readLine()) != null) {
                String[] dados = line.split(";");
                if (dados.length < 1) continue;

                if ("U".equals(dados[0])) {
                    criarUsuario(dados);
                } else if ("P".equals(dados[0])) {
                    criarProduto(dados);
                } 
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void criarUsuario(String[] dados) {
    	System.out.println(dados.length);

        CriarUsuarioDTO usuarioDTO = new CriarUsuarioDTO(
                dados[1], // nome
                dados[2], // sobrenome
                dados[3], // email
                LocalDate.parse(dados[4]), // dataNascimento
                dados[5], // telefone
                dados[6], // cpf
                dados[7], // cep
                dados[8], // logradouro
                dados[9], // complemento
                dados[10], // bairro
                dados[11], // localidade
                dados[12], // uf
                mapRole(dados[13]), // role
                dados[14]  // senha
        );
        usuarioService.criar(usuarioDTO);
    }

    @Transactional
    private void criarProduto(String[] dados) {
        Map<String, Vendedor> mapVendedores = loadVendedoresMap();
        Vendedor vendedor = mapVendedores.get(dados[6]);
        
        if(vendedor != null) {
            CriarProdutoDTO produtoDTO = new CriarProdutoDTO(
                    dados[1], // nome
                    dados[2], // descricao
                    Integer.parseInt(dados[3]), // codigo
                    new BigDecimal(dados[4]), // preco
                    Boolean.parseBoolean(dados[5]), // estoque
                    vendedor.getId(), // idVendedor
                    dados[7], // nomeCategoria
                    dados[8]  // descricaoCategoria
            );
            produtoService.criar(produtoDTO);
        }
    }

    private UsuarioRole mapRole(String role) {
        switch (role) {
            case "ADMIN":
                return UsuarioRole.ADMIN;
            case "CLIENTE":
                return UsuarioRole.CLIENTE;
            case "VENDEDOR":
                return UsuarioRole.VENDEDOR;
            default:
                throw new IllegalArgumentException("Role inválida: " + role);
        }
    }
}
