package com.koatchy.configGenerator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CascadeType;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Setter;
import lombok.Getter;

@Entity
@Table(name="ctpaises")
public class Paises {
	
	public Paises() {}
	
	public Paises(long id, String codigo, String eliminar, String nombre) {
		this.Id = id;
		this.Codigo = codigo;
		this.Eliminar = eliminar;
		this.Nombre = nombre;
	}

	@Id
	@Column(name="idpais")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	
	@Column(name="codigo")
	private String Codigo;
	
	@Column(name="eliminar")
	private String Eliminar;
	
	@Column(name="nombre")
	private String Nombre;

	@Override
	public String toString() {
		return "Paises [Id=" + Id + ", Codigo=" + Codigo + ", Eliminar=" + Eliminar + ", Nombre=" + Nombre + "]";
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getCodigo() {
		return Codigo;
	}

	public void setCodigo(String codigo) {
		Codigo = codigo;
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
	
}
