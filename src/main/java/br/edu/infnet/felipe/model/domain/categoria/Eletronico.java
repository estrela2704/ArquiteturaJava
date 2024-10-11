package br.edu.infnet.felipe.model.domain.categoria;

import java.util.List;

public class Eletronico extends Categoria {

	private String marca;
	private String modelo;
	
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
