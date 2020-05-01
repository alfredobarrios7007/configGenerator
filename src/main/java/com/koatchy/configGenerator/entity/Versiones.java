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
@Table(name="ctversiones")
public class Versiones {
	
	public Versiones() {}
	
	public Versiones(long id, long idaplicacion, String versionBase, String eliminar, String mostrar, String nombre) {
		this.Id = id;
		this.IdAplicacion = idaplicacion;
		this.VersionBase = versionBase;
		this.Eliminar = eliminar;
		this.Mostrar = mostrar;
		this.Nombre = nombre;
	}

	@Id
	@Column(name="idusuario")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	
	@Column(name="idaplicacion")
	private long IdAplicacion;
	
	@Column(name="versionBase")
	private String VersionBase;
	
	@Column(name="eliminar")
	private String Eliminar;
	
	@Column(name="mostrar")
	private String Mostrar;
	
	@Column(name="nombre")
	private String Nombre;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public long getIdAplicacion() {
		return IdAplicacion;
	}

	public void setIdAplicacion(long idAplicacion) {
		IdAplicacion = idAplicacion;
	}

	public String getVersionBase() {
		return VersionBase;
	}

	public void setVersionBase(String versionBase) {
		VersionBase = versionBase;
	}

	public String getEliminar() {
		return Eliminar;
	}

	public void setEliminar(String eliminar) {
		Eliminar = eliminar;
	}

	public String getMostrar() {
		return Mostrar;
	}

	public void setMostrar(String mostrar) {
		Mostrar = mostrar;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	@Override
	public String toString() {
		return "Versiones [Id=" + Id + ", IdAplicacion=" + IdAplicacion + ", VersionBase=" + VersionBase + ", Eliminar="
				+ Eliminar + ", Mostrar=" + Mostrar + ", Nombre=" + Nombre + "]";
	}
	
}
