/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.pi4.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 * @author Francini
 */

@ApiModel(
   value = "Usuario",
   description = "Classe que modela um objeto do tipo usuario"
)
public class UsuarioDTO {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private byte[] foto;
    private HistoriaDTO historia;
    
    public UsuarioDTO() {
    	super();
    }
    
	public UsuarioDTO(String nome, byte[] foto) {
		this();
		this.nome = nome;
		this.foto = foto;
	}
	
	public UsuarioDTO(Long id) {
		super();
		this.id = id;
	}

	@ApiModelProperty(value = "id do usuario", required = true)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@ApiModelProperty(value = "nome do usuario", required = true)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@ApiModelProperty(value = "email do usuario", required = true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@ApiModelProperty(value = "senha do usuario", required = true)
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@ApiModelProperty(value = "foto do usuario", required = false)
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
	@ApiModelProperty(value = "historia do usuario", required = false)
	public HistoriaDTO getHistoria() {
		return historia;
	}

	public void setHistoria(HistoriaDTO historia) {
		this.historia = historia;
	}  
	
	
    
}
