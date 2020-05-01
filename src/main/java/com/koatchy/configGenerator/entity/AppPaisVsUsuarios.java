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
@Table(name="rrapppaisvsusuarios")
public class AppPaisVsUsuarios {
	
	public AppPaisVsUsuarios() {}
	
	public AppPaisVsUsuarios(long id, long idrelapppais, long idusuario) {
		this.Id = id;
		this.IdRelAppPais = idrelapppais;
		this.IdUsuario = idusuario;
	}

	@Id
	@Column(name="idapppaisvsusuarios")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	
	@Column(name="idrelapppais")
	private long IdRelAppPais;
	
	@Column(name="idusuario")
	private long IdUsuario;

	@Override
	public String toString() {
		return "AppPaisVsUsuarios [Id=" + Id + ", IdRelAppPais=" + IdRelAppPais + ", IdUsuario=" + IdUsuario + "]";
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

	public long getIdUsuario() {
		return IdUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		IdUsuario = idUsuario;
	}

}
