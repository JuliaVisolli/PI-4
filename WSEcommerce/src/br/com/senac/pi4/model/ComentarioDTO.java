package br.com.senac.pi4.model;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(
	       value = "Comentario",
	       description = "Classe que modela um objeto do tipo comentario"
)
public class ComentarioDTO {
	
	private Long id;
	private UsuarioDTO usuario;
	private HistoriaDTO historia;
	private String texto;
	private Date data;
	
	public ComentarioDTO() {
		super();
	}

	public ComentarioDTO(UsuarioDTO usuario, HistoriaDTO historia, String texto, Date data) {
		this();
		this.usuario = usuario;
		this.historia = historia;
		this.texto = texto;
		this.data = data;
	}
	
	@ApiModelProperty(value = "id", required = true)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	@ApiModelProperty(value = "texto", required = true)
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	@ApiModelProperty(value = "data", required = true)
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
}
