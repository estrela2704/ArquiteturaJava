package br.edu.infnet.felipe.model.domain.produto;

public class Eletronico extends Categoria {

	private String marca;
	private String modelo;
	
	public Eletronico(String marca, String modelo) {
		super("Eletrônico", "Produtos Eletrônicos");
		this.marca = marca;
		this.modelo = modelo;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
}
