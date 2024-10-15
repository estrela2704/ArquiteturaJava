package br.edu.infnet.felipe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.edu.infnet.felipe.controller.request.CriarCarrinhoDTO;
import br.edu.infnet.felipe.domain.produto.Produto;
import br.edu.infnet.felipe.domain.usuario.Cliente;
import br.edu.infnet.felipe.domain.venda.Carrinho;
import br.edu.infnet.felipe.repository.ProdutoRepository;
import br.edu.infnet.felipe.repository.UsuarioRepository;
import br.edu.infnet.felipe.service.CarrinhoService;
import br.edu.infnet.felipe.service.ClienteService;
import br.edu.infnet.felipe.service.ProdutoService;
import br.edu.infnet.felipe.service.UsuarioService;

public class CarrinhoServiceTests {

	@InjectMocks
	private CarrinhoService carrinhoService;

   @Mock
    private UsuarioService usuarioService;

    @Mock
    private ProdutoService produtoService;

    @Mock
    private Cliente cliente;

    @Mock
    private Produto produto;

    @Mock
    private ClienteService clienteService;

    @Mock
    private ProdutoRepository produtoRepository;

    @Mock
    private UsuarioRepository usuarioRepository;



	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testCriar() {
		when(produto.getPreco()).thenReturn(new BigDecimal("10.00"));
		when(produto.isEstoque()).thenReturn(true);
		when(produto.getId()).thenReturn(
				UUID.fromString("d4afb3bb-e484-4ce9-9177-d8bffa5e3afd"));
		when(cliente.getId()).thenReturn(
				UUID.fromString("141bc070-4ad4-443e-8256-7148a9a2db29"));
		when(produtoService.buscarPorID(produto.getId())).thenReturn(produto);
		when(clienteService.buscarPorID(cliente.getId())).thenReturn(cliente);

		CriarCarrinhoDTO dto = new CriarCarrinhoDTO();
		dto.setIdUsuario(cliente.getId().toString());
		dto.setIdProduto(produto.getId().toString());
		dto.setQuantidade(0);

		usuarioService.salvar(cliente);
		produtoService.salvar(produto);

		Carrinho carrinho = carrinhoService.criar(dto);

		assertNotNull(carrinho);
		assertEquals(1, carrinho.getProdutos().size());
	}

	@Test
	public void testAdicionarProduto() {
		Carrinho carrinho = new Carrinho(cliente);
		when(produto.isEstoque()).thenReturn(true);

		carrinhoService.adicionarProduto(carrinho, produto, 3);

		assertEquals(3, carrinho.getProdutos().size());
	}

	@Test
	public void testRemoverProduto() {
		Carrinho carrinho = new Carrinho(cliente);
		carrinho.addProduto(produto, 1);

		carrinhoService.removerProduto(carrinho, produto, 1);

		assertEquals(0, carrinho.getProdutos().size());
	}

	@Test
	public void testCalcularPrecoCarrinho() {
		Carrinho carrinho = new Carrinho(cliente);

		Produto produto1 = mock(Produto.class);
		Produto produto2 = mock(Produto.class);

		when(produto1.getPreco()).thenReturn(new BigDecimal("10.00"));
		when(produto2.getPreco()).thenReturn(new BigDecimal("15.00"));

		carrinho.addProduto(produto1, 1);
		carrinho.addProduto(produto2, 1);

		BigDecimal precoTotal = carrinhoService.calcularPrecoCarrinho(carrinho);

		assertEquals(new BigDecimal("25.00"), precoTotal);
	}
}