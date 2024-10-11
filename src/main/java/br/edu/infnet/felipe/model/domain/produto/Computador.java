package br.edu.infnet.felipe.model.domain.produto;

import br.edu.infnet.felipe.model.enums.TipoArmazenamento;

public class Computador extends Produto {
	
	private int memoriaRam;
	private int armazenamento;
	private String processador;
	private String placaDeVideo;
	private String placaMae;
	private TipoArmazenamento tipoArmazenamento;
	
	public int getMemoriaRam() {
		return memoriaRam;
	}
	public void setMemoriaRam(int memoriaRam) {
		this.memoriaRam = memoriaRam;
	}
	public int getArmazenamento() {
		return armazenamento;
	}
	public void setArmazenamento(int armazenamento) {
		this.armazenamento = armazenamento;
	}
	public String getProcessador() {
		return processador;
	}
	public void setProcessador(String processador) {
		this.processador = processador;
	}
	public String getPlacaDeVideo() {
		return placaDeVideo;
	}
	public void setPlacaDeVideo(String placaDeVideo) {
		this.placaDeVideo = placaDeVideo;
	}
	public String getPlacaMae() {
		return placaMae;
	}
	public void setPlacaMae(String placaMae) {
		this.placaMae = placaMae;
	}
	public TipoArmazenamento getTipoArmazenamento() {
		return tipoArmazenamento;
	}
	public void setTipoArmazenamento(TipoArmazenamento tipoArmazenamento) {
		this.tipoArmazenamento = tipoArmazenamento;
	}
	
	
	
}
