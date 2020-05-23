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
@Table(name="rpbitacora")
public class Bitacora  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public Bitacora() {}
	
	public Bitacora(long id, long evento, String fechahora, String aplicacion, String version, String pais, String perfil, String nuevocambio, String versionversion, String usuario, String nodo, String requerimiento, String release) {
		this.Id = id;
		this.Evento = evento;
		this.Fechahora = fechahora;
		this.Aplicacion = aplicacion;
		this.Version = version;
		this.Pais = pais;
		this.Perfil = perfil;
		this.NuevoCambio = nuevocambio;
		this.VersionVersion = versionversion;
		this.Usuario = usuario;
		this.Nodo = nodo;
		this.Requerimiento = requerimiento;
		this.Release = release;
	}

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	
	@Column(name="evento")
	private long Evento;
	
	@Column(name="fechahora")
	private String Fechahora;
	
	@Column(name="Aplicacion")
	private String Aplicacion;
	
	@Column(name="version")
	private String Version;
	
	@Column(name="pais")
	private String Pais;
	
	@Column(name="perfil")
	private String Perfil;
	
	@Column(name="nuevocambio")
	private String NuevoCambio;
	
	@Column(name="versionversion")
	private String VersionVersion;
	
	@Column(name="usuario")
	private String Usuario;
	
	@Column(name="nodo")
	private String Nodo;
	
	@Column(name="requerimiento")
	private String Requerimiento;
	
	@Column(name="release")
	private String Release;

	@Override
	public String toString() {
		return "Bitacora [Id=" + Id + ", Evento=" + Evento + ", Fechahora=" + Fechahora + ", Aplicacion=" + Aplicacion
				+ ", Version=" + Version + ", Pais=" + Pais + ", Perfil=" + Perfil + ", NuevoCambio=" + NuevoCambio
				+ ", VersionVersion=" + VersionVersion + ", Usuario=" + Usuario + ", Nodo=" + Nodo + ", Requerimiento="
				+ Requerimiento + ", Release=" + Release + "]";
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public long getEvento() {
		return Evento;
	}

	public void setEvento(long evento) {
		Evento = evento;
	}

	public String getFechahora() {
		return Fechahora;
	}

	public void setFechahora(String fechahora) {
		Fechahora = fechahora;
	}

	public String getAplicacion() {
		return Aplicacion;
	}

	public void setAplicacion(String aplicacion) {
		Aplicacion = aplicacion;
	}

	public String getVersion() {
		return Version;
	}

	public void setVersion(String version) {
		Version = version;
	}

	public String getPais() {
		return Pais;
	}

	public void setPais(String pais) {
		Pais = pais;
	}

	public String getPerfil() {
		return Perfil;
	}

	public void setPerfil(String perfil) {
		Perfil = perfil;
	}

	public String getNuevoCambio() {
		return NuevoCambio;
	}

	public void setNuevoCambio(String nuevoCambio) {
		NuevoCambio = nuevoCambio;
	}

	public String getVersionVersion() {
		return VersionVersion;
	}

	public void setVersionVersion(String versionVersion) {
		VersionVersion = versionVersion;
	}

	public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String usuario) {
		Usuario = usuario;
	}

	public String getNodo() {
		return Nodo;
	}

	public void setNodo(String nodo) {
		Nodo = nodo;
	}

	public String getRequerimiento() {
		return Requerimiento;
	}

	public void setRequerimiento(String requerimiento) {
		Requerimiento = requerimiento;
	}

	public String getRelease() {
		return Release;
	}

	public void setRelease(String release) {
		Release = release;
	}
	
}
