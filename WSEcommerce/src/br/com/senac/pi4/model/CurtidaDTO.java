package br.com.senac.pi4.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(
   value = "Curtida",
   description = "Classe que modela um objeto do tipo curtida"
)
public class CurtidaDTO {
	
	private UsuarioDTO usuario;
	private HistoriaDTO historia;
	
	public CurtidaDTO() {
		super();
	}

	public CurtidaDTO(UsuarioDTO usuario, HistoriaDTO historia) {
		this();
		this.usuario = usuario;
		this.historia = historia;
	}
	
	@ApiModelProperty(value = "usuario", required = true)
	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	
	@ApiModelProperty(value = "historia", required = true)
	public HistoriaDTO getHistoria() {
		return historia;
	}

	public void setHistoria(HistoriaDTO historia) {
		this.historia = historia;
	}
	
	

}
