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
@Table(name="ctconfigvalores")
public class ConfigValores  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public ConfigValores() {}
	
	public ConfigValores(long id, long iditemconfiguracion, String atributo, String valor, String mostrar, String siempreesarreglo) {
		this.Id = id;
		this.IdItemConfiguracion = iditemconfiguracion;
		this.Atributo = atributo;
		this.Valor = valor;
		this.Mostrar = mostrar;
		this.SiempreEsArreglo = siempreesarreglo;
	}

	@Id
	@Column(name="idconfigvalor")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	
	@Column(name="iditemconfiguracion")
	private long IdItemConfiguracion;
	
	@Column(name="atributo")
	private String Atributo;
	
	@Column(name="valor")
	private String Valor;
	
	@Column(name="mostrar")
	private String Mostrar;
	
	@Column(name="siempreesarreglo")
	private String SiempreEsArreglo;

	@Override
	public String toString() {
		return "ConfigValores [Id=" + Id + ", IdItemConfiguracion=" + IdItemConfiguracion + ", Atributo=" + Atributo
				+ ", Valor=" + Valor + ", Mostrar=" + Mostrar + ", SiempreEsArreglo=" + SiempreEsArreglo + "]";
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public long getIdItemConfiguracion() {
		return IdItemConfiguracion;
	}

	public void setIdItemConfiguracion(long idItemConfiguracion) {
		IdItemConfiguracion = idItemConfiguracion;
	}

	public String getAtributo() {
		return Atributo;
	}

	public void setAtributo(String atributo) {
		Atributo = atributo;
	}

	public String getValor() {
		return Valor;
	}

	public void setValor(String valor) {
		Valor = valor;
	}

	public String getMostrar() {
		return Mostrar;
	}

	public void setMostrar(String mostrar) {
		Mostrar = mostrar;
	}

	public String getSiempreEsArreglo() {
		return SiempreEsArreglo;
	}

	public void setSiempreEsArreglo(String siempreEsArreglo) {
		SiempreEsArreglo = siempreEsArreglo;
	}
	
	
}
