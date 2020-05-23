package com.koatchy.configGenerator.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="ctpaises")
public class Paises  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public Paises() {}
/*	
	public Paises(long id, String codigo, String eliminar, String nombre, Set<Perfiles> perfiles) {
		this.Id = id;
		this.Codigo = codigo;
		this.Eliminar = eliminar;
		this.Nombre = nombre;
		this.perfiles = perfiles;
	}
*/	
	
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
	
//	@OneToMany(mappedBy = "pais", cascade = CascadeType.ALL)
//	private Set<Perfiles> perfiles;
	
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

	 /*
    public Set<Perfiles> getPerfiles() {
        return this.perfiles;
    }
	
    public void setPerfiles(Set<Perfiles> perfiles) {
        this.perfiles = perfiles;
    }
    @Override
    public String toString() {
    	String result = String.format(
                "Paises [Id=%i, Codigo='%c', Eliminar='%e', Nombre='%n', Perfiles=%p]\n",
                this.Id, this.Codigo, this.Eliminar, this.Nombre, this.perfiles != null ? this.perfiles.size() : 0 );
        if (this.perfiles != null) {
            for(Perfiles perfil : this.perfiles) {
                result += perfil.toString() + "\n";
            }
        }
        return result;
    }	
*/

    @Override
    public String toString() {
    	return String.format("Paises [Id=%i, Codigo='%c', Eliminar='%e', Nombre='%n']", this.Id, this.Codigo, this.Eliminar, this.Nombre);
    }	

	
}
