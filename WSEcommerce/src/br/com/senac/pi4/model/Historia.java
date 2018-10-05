package br.com.senac.pi4.model;

import java.sql.Blob;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(
   value = "Historia",
   description = "Classe que modela um objeto do tipo historia"
)
public class Historia {
	
	private Long id;
	private Usuario usuario;
	private String texto;
    private Blob foto;
    private Date data;
    
    public Historia() {
    	super();
    }
    
	public Historia(Usuario usuario, String texto, Date data) {
		this();
		this.usuario = usuario;
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
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@ApiModelProperty(value = "texto", required = true)
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	@ApiModelProperty(value = "foto", required = false)
	public Blob getFoto() {
		return foto;
	}

	public void setFoto(Blob foto) {
		this.foto = foto;
	}
	
	@ApiModelProperty(value = "data", required = true)
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
