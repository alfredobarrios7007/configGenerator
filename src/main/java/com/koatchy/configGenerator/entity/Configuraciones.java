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
@Table(name="ctconfiguraciones")
public class Configuraciones {
	
	public Configuraciones() {}
	
	public Configuraciones(long id, String clave, String valor) {
		this.Id = id;
		this.Clave = clave;
		this.Valor = valor;
	}

	@Id
	@Column(name="idconfiguracion")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	
	@Column(name="clave")
	private String Clave;
	
	@Column(name="valor")
	private String Valor;

	@Override
	public String toString() {
		return "Configuraciones [Id=" + Id + ", Clave=" + Clave + ", Valor=" + Valor + "]";
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getClave() {
		return Clave;
	}

	public void setClave(String clave) {
		Clave = clave;
	}

	public String getValor() {
		return Valor;
	}

	public void setValor(String valor) {
		Valor = valor;
	}
	
	
}
