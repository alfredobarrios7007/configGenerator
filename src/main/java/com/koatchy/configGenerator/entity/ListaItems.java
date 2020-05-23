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
@Table(name="rrlistaitems")
public class ListaItems  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public ListaItems() {}
	
	public ListaItems(long id, long idconfigvalor, long iditemconfiguracion) {
		this.Id = id;
		this.IdConfigValor = idconfigvalor;
		this.IdItemConfiguracion = iditemconfiguracion;
	}

	@Id
	@Column(name="iditem")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	
	@Column(name="idconfgvalor")
	private long IdConfigValor;
	
	@Column(name="iditemconfiguracion")
	private long IdItemConfiguracion;

	@Override
	public String toString() {
		return "ListaItems [Id=" + Id + ", IdConfigValor=" + IdConfigValor + ", IdItemConfiguracion="
				+ IdItemConfiguracion + "]";
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public long getIdConfigValor() {
		return IdConfigValor;
	}

	public void setIdConfigValor(long idConfigValor) {
		IdConfigValor = idConfigValor;
	}

	public long getIdItemConfiguracion() {
		return IdItemConfiguracion;
	}

	public void setIdItemConfiguracion(long idItemConfiguracion) {
		IdItemConfiguracion = idItemConfiguracion;
	}
	
}
