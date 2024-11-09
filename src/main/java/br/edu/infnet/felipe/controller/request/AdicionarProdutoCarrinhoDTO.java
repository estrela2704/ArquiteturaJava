package br.edu.infnet.felipe.controller.request;


public class AdicionarProdutoCarrinhoDTO {

	private Integer idCarrinho;
	private Integer idProduto;
	private int quantidade = 0;
	
	public Integer getIdCarrinho() {
		return idCarrinho;
	}
	public void setIdCarrinho(Integer idCarrinho) {
		this.idCarrinho = idCarrinho;
	}
	
	public Integer getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
}
