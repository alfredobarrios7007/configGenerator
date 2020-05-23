package com.koatchy.configGenerator.entity;

import java.io.Serializable;

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
@Table(name="ftintemsconfiguracion")
public class ItemsConfiguracion  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public ItemsConfiguracion() {}
	
	public ItemsConfiguracion(long id, long idrelapppais, String llaveprivada, String mostrar, String mostrarllaveprivadaenjson) {
		this.Id = id;
		this.IdRelAppPais = idrelapppais;
		this.LlavePrivada = llaveprivada;
		this.Mostrar = mostrar;
		this.MostrarLlavePrivadaEnJSON = mostrarllaveprivadaenjson;
	}

	@Id
	@Column(name="idusuario")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	
	@Column(name="idrelapppais")
	private long IdRelAppPais;
	
	@Column(name="llaveprivada")
	private String LlavePrivada;
	
	@Column(name="mostrar")
	private String Mostrar;
	
	@Column(name="mostrarllaveprivadaenjson")
	private String MostrarLlavePrivadaEnJSON;

	@Override
	public String toString() {
		return "ItemsConfiguracion [Id=" + Id + ", IdRelAppPais=" + IdRelAppPais + ", LlavePrivada=" + LlavePrivada
				+ ", Mostrar=" + Mostrar + ", MostrarLlavePrivadaEnJSON=" + MostrarLlavePrivadaEnJSON + "]";
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public long getIdRelAppPais() {
		return IdRelAppPais;
	}

	public void setIdRelAppPais(long idRelAppPais) {
		IdRelAppPais = idRelAppPais;
	}

	public String getLlavePrivada() {
		return LlavePrivada;
	}

	public void setLlavePrivada(String llavePrivada) {
		LlavePrivada = llavePrivada;
	}

	public String getMostrar() {
		return Mostrar;
	}

	public void setMostrar(String mostrar) {
		Mostrar = mostrar;
	}

	public String getMostrarLlavePrivadaEnJSON() {
		return MostrarLlavePrivadaEnJSON;
	}

	public void setMostrarLlavePrivadaEnJSON(String mostrarLlavePrivadaEnJSON) {
		MostrarLlavePrivadaEnJSON = mostrarLlavePrivadaEnJSON;
	}
	
}
