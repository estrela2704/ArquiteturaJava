package br.edu.infnet.felipe.model.domain.produto;

import br.edu.infnet.felipe.model.enums.TipoTeclado;

public class Notebook extends Computador {
	
	private String SistemaOperacional;
	private String tamanhoTela;
	private String webcam;
	private String capacidadeBateria;
	private TipoTeclado tipoTeclado;
	
	public String getSistemaOperacional() {
		return SistemaOperacional;
	}
	public void setSistemaOperacional(String sistemaOperacional) {
		SistemaOperacional = sistemaOperacional;
	}
	public String getTamanhoTela() {
		return tamanhoTela;
	}
	public void setTamanhoTela(String tamanhoTela) {
		this.tamanhoTela = tamanhoTela;
	}
	public String getWebcam() {
		return webcam;
	}
	public void setWebcam(String webcam) {
		this.webcam = webcam;
	}
	public String getCapacidadeBateria() {
		return capacidadeBateria;
	}
	public void setCapacidadeBateria(String capacidadeBateria) {
		this.capacidadeBateria = capacidadeBateria;
	}
	public TipoTeclado getTipoTeclado() {
		return tipoTeclado;
	}
	public void setTipoTeclado(TipoTeclado tipoTeclado) {
		this.tipoTeclado = tipoTeclado;
	}

}
