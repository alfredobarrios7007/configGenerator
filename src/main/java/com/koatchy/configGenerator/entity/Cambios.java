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
@Table(name="ctcambios")
public class Cambios {
	
	public Cambios() {}
	
	public Cambios(long id, long idrelapppais_base, String fechahora) {
		this.Id = id;
		this.IdRelAppPais_base = idrelapppais_base;
		this.FechaHora = fechahora;
	}

	@Id
	@Column(name="idcambio")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	
	@Column(name="idrelapppais_base")
	private long IdRelAppPais_base;
	
	@Column(name="fechahora")
	private String FechaHora;

	@Override
	public String toString() {
		return "Cambios [Id=" + Id + ", IdRelAppPais_base=" + IdRelAppPais_base + ", FechaHora=" + FechaHora + "]";
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public long getIdRelAppPais_base() {
		return IdRelAppPais_base;
	}

	public void setIdRelAppPais_base(long idRelAppPais_base) {
		IdRelAppPais_base = idRelAppPais_base;
	}

	public String getFechaHora() {
		return FechaHora;
	}

	public void setFechaHora(String fechaHora) {
		FechaHora = fechaHora;
	}

	
}
