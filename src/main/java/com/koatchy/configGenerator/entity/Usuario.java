package com.koatchy.configGenerator.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="ctusuarios")
public class Usuario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Usuario() {}
	
	public Usuario(long id, long idusuarioarea, String contrasena, String eliminar, String nombre, String email, String superusuario) {
		this.Id = id;
		this.IdUsuarioArea = idusuarioarea;
		this.Contrasena = contrasena;
		this.Eliminar = eliminar;
		this.Nombre = nombre;
		this.Email = email;
		this.Superusuario = superusuario;
	}

	@Id
	@Column(name="idusuario")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	
	@Column(name="idusuarioarea")
	private long IdUsuarioArea;
	
	@Column(name="contrasena")
	private String Contrasena;
	
	@Column(name="eliminar")
	private String Eliminar;
	
	@Column(name="nombre")
	private String Nombre;
	
	@Column(name="email")
	private String Email;
	
	@Column(name="superusuario")
	private String Superusuario;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public long getIdUsuarioArea() {
		return IdUsuarioArea;
	}

	public void setIdUsuarioArea(long idUsuarioArea) {
		IdUsuarioArea = idUsuarioArea;
	}

	public String getContrasena() {
		return Contrasena;
	}

	public void setContrasena(String contrasena) {
		Contrasena = contrasena;
	}

	public String getEliminar() {
		return Eliminar;
	}

	public void setEliminar(String eliminar) {
		Eliminar = eliminar;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getSuperusuario() {
		return Superusuario;
	}

	public void setSuperusuario(String superusuario) {
		Superusuario = superusuario;
	}

	@Override
	public String toString() {
		return "Usuario [Id=" + Id + ", IdUsuarioArea=" + IdUsuarioArea + ", Contrasena=" + Contrasena + ", Eliminar="
				+ Eliminar + ", Nombre=" + Nombre + ", Email=" + Email + ", Superusuario=" + Superusuario + "]";
	}	
	
}
