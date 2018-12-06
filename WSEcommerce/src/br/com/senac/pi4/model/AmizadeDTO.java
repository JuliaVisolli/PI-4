package br.com.senac.pi4.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(
   value = "Amizade",
   description = "Classe que modela um objeto do tipo amizade"
)
public class AmizadeDTO {
	
	private long usuario1;
	private long usuario2;
	private boolean aprovada = false;
	
	public AmizadeDTO() {
		super();
	}
	
	public AmizadeDTO(long usuario1, long usuario2, boolean aprovada) {
		this();
		this.usuario1 = usuario1;
		this.usuario2 = usuario2;
		this.aprovada = aprovada;
	}
	
	@ApiModelProperty(value = "usuario que solicita a amizade", required = true)
	public long getUsuario1() {
		return usuario1;
	}

	public void setUsuario1(long usuario1) {
		this.usuario1 = usuario1;
	}
	
	@ApiModelProperty(value = "usuario que foi solicitado a amizade", required = true)
	public long getUsuario2() {
		return usuario2;
	}

	public void setUsuario2(long usuario2) {
		this.usuario2 = usuario2;
	}
	
	@ApiModelProperty(value = "status da solicitaco de amizade", required = true)
	public boolean isAprovada() {
		return aprovada;
	}

	public void setAprovada(boolean aprovada) {
		this.aprovada = aprovada;
	}
	
}
