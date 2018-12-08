package br.com.senac.pi4.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(
   value = "Amizade",
   description = "Classe que modela um objeto do tipo amizade"
)
public class AmizadeDTO {
	
	private UsuarioDTO usuario1;
	private UsuarioDTO usuario2;
	private boolean aprovada;
	
	public AmizadeDTO() {
		super();
	}
	
	public AmizadeDTO(UsuarioDTO usuario1, UsuarioDTO usuario2, boolean aprovada) {
		this();
		this.usuario1 = usuario1;
		this.usuario2 = usuario2;
		this.aprovada = aprovada;
	}
	
	@ApiModelProperty(value = "usuario que solicita a amizade", required = true)
	public UsuarioDTO getUsuario1() {
		return usuario1;
	}

	public void setUsuario1(UsuarioDTO usuario1) {
		this.usuario1 = usuario1;
	}
	
	@ApiModelProperty(value = "usuario que foi solicitado a amizade", required = true)
	public UsuarioDTO getUsuario2() {
		return usuario2;
	}

	public void setUsuario2(UsuarioDTO usuario2) {
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