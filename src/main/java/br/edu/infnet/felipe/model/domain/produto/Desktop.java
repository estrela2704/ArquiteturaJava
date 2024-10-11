package br.edu.infnet.felipe.model.domain.produto;

import br.edu.infnet.felipe.model.enums.TipoCooler;

public class Desktop extends Computador {

	private String gabinete;
	private String fonte;
	private TipoCooler tipoCooler;
	private boolean possuiWifi;
	
	public String getGabinete() {
		return gabinete;
	}
	public void setGabinete(String gabinete) {
		this.gabinete = gabinete;
	}
	public String getFonte() {
		return fonte;
	}
	public void setFonte(String fonte) {
		this.fonte = fonte;
	}
	public TipoCooler getTipoCooler() {
		return tipoCooler;
	}
	public void setTipoCooler(TipoCooler tipoCooler) {
		this.tipoCooler = tipoCooler;
	}
	public boolean isPossuiWifi() {
		return possuiWifi;
	}
	public void setPossuiWifi(boolean possuiWifi) {
		this.possuiWifi = possuiWifi;
	}
	
	
	
}
