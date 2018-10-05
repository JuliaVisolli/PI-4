package br.com.senac.pi4.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(
   value = "Curtida",
   description = "Classe que modela um objeto do tipo curtida"
)
public class Curtida {
	
	private Usuario usuario;
	private Historia historia;
	
	public Curtida() {
		super();
	}

	public Curtida(Usuario usuario, Historia historia) {
		this();
		this.usuario = usuario;
		this.historia = historia;
	}
	
	@ApiModelProperty(value = "usuario", required = true)
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@ApiModelProperty(value = "historia", required = true)
	public Historia getHistoria() {
		return historia;
	}

	public void setHistoria(Historia historia) {
		this.historia = historia;
	}
	
	

}
