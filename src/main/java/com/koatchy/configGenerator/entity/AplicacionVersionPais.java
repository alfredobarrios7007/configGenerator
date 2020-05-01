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
@Table(name="rraplicacionversionpais")
public class AplicacionVersionPais {
	
	public AplicacionVersionPais() {}
	
	public AplicacionVersionPais(long id, long idperfil, long idversion) {
		this.Id = id;
		this.IdPerfil = idperfil;
		this.IdVersion = idversion;
	}

	@Id
	@Column(name="IdRelAppPais")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	
	@Column(name="idperfil")
	private long IdPerfil;
	
	@Column(name="idversion")
	private long IdVersion;

	@Override
	public String toString() {
		return "AplicacionVersionPais [Id=" + Id + ", IdPerfil=" + IdPerfil + ", IdVersion=" + IdVersion + "]";
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public long getIdPerfil() {
		return IdPerfil;
	}

	public void setIdPerfil(long idPerfil) {
		IdPerfil = idPerfil;
	}

	public long getIdVersion() {
		return IdVersion;
	}

	public void setIdVersion(long idVersion) {
		IdVersion = idVersion;
	}

}
