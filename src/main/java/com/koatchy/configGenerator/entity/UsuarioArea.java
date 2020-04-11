package com.koatchy.configGenerator.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Setter;
import lombok.Getter;

@Entity
@Table(name="ctusuarioareas")
public class UsuarioArea {

	public UsuarioArea() {}
	
	public UsuarioArea(long id, String nombre, String notifica) {
		this.Id=id;
		this.Nombre=nombre;
		this.Notifica=notifica;
	}
	
	@Id
	@Column(name="idusuarioarea")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	
	@Column(name="nombre")
	private String Nombre;

	@Column(name="notifica")
	private String Notifica;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getNotifica() {
		return Notifica;
	}

	public void setNotifica(String notifica) {
		Notifica = notifica;
	}

	@Override
	public String toString() {
		return "UsuarioArea [Id=" + Id + ", Nombre=" + Nombre + ", Notifica=" + Notifica + "]";
	}
	
	
}
