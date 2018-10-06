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
	
	@ApiModelProperty(value = "id do usuario associado a uma curtida", required = true)
	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	
	@ApiModelProperty(value = "id da historia associada a uma curtida", required = true)
	public HistoriaDTO getHistoria() {
		return historia;
	}

	public void setHistoria(HistoriaDTO historia) {
		this.historia = historia;
	}
	
	

}
