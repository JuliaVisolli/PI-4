package br.com.senac.pi4.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(
   value = "Amizade",
   description = "Classe que modela um objeto do tipo amizade"
)
public class Amizade {
	
	private Usuario usuario1;
	private Usuario usuario2;
	private boolean aprovada;
	
	public Amizade() {
		super();
	}
	
	public Amizade(Usuario usuario1, Usuario usuario2, boolean aprovada) {
		this();
		this.usuario1 = usuario1;
		this.usuario2 = usuario2;
		this.aprovada = aprovada;
	}
	
	@ApiModelProperty(value = "usuario que solicita a amizade", required = true)
	public Usuario getUsuario1() {
		return usuario1;
	}

	public void setUsuario1(Usuario usuario1) {
		this.usuario1 = usuario1;
	}
	
	@ApiModelProperty(value = "usuario que foi solicitado a amizade", required = true)
	public Usuario getUsuario2() {
		return usuario2;
	}

	public void setUsuario2(Usuario usuario2) {
		this.usuario2 = usuario2;
	}
	
	@ApiModelProperty(value = "aprovada", required = true)
	public boolean isAprovada() {
		return aprovada;
	}

	public void setAprovada(boolean aprovada) {
		this.aprovada = aprovada;
	}
	
}
