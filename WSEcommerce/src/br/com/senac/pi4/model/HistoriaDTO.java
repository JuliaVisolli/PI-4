package br.com.senac.pi4.model;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Historia", description = "Classe que modela um objeto do tipo historia")
public class HistoriaDTO {

	private Long id;
	private UsuarioDTO usuario;
	private String texto;
	private byte[] foto;
	private Date data;
	private Integer totalComentarios;
	private Integer totalCurtidas;

	public HistoriaDTO() {
		super();
	}

	public HistoriaDTO(Long id) {
		this();
		this.id = id;
	}

	public HistoriaDTO(Long id, String texto, byte[] foto, Date data, int totalComentarios, int totalCurtidas) {
		this();
		this.id = id;
		this.texto = texto;
		this.foto = foto;
		this.data = data;
		this.totalComentarios = totalComentarios;
		this.totalCurtidas = totalCurtidas;
	}

	@ApiModelProperty(value = "id da historia", required = true)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ApiModelProperty(value = "id do usuario associado a historia", required = true)
	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	@ApiModelProperty(value = "texto", required = true)
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@ApiModelProperty(value = "foto da historia", required = false)
	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	@ApiModelProperty(value = "data de postagem da historia", required = true)
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	@ApiModelProperty(value = "total de comentarios da historia", required = false)
	public Integer getTotalComentarios() {
		return totalComentarios;
	}

	public void setTotalComentarios(Integer totalComentarios) {
		this.totalComentarios = totalComentarios;
	}
	@ApiModelProperty(value = "total de curtidas da historia", required = false)
	public Integer getTotalCurtidas() {
		return totalCurtidas;
	}
	
	public void setTotalCurtidas(Integer totalCurtidas) {
		this.totalCurtidas = totalCurtidas;
	}

}
