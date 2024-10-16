package br.edu.infnet.felipe.controller.request;


public class AdicionarProdutoCarrinhoDTO {

	private String idCarrinho;
	private String idProduto;
	private int quantidade = 0;
	
	public String getIdCarrinho() {
		return idCarrinho;
	}
	public void setIdCarrinho(String idCarrinho) {
		this.idCarrinho = idCarrinho;
	}
	
	public String getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
}
