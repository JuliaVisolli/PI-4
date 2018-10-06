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
    
    public UsuarioDTO() {
    	super();
    }
    
	public UsuarioDTO(String nome, String email, String senha) {
		this();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
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
    
}
