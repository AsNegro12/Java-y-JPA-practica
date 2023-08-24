package com.mexico.uriel.tienda.modelo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class CategoriID implements Serializable
{
	private String nombre;
	private String contrasenha;
	
	public CategoriID() {}
	
	public CategoriID(String nombre, String contrasenha)
	{
		this.nombre = nombre;
	    this.contrasenha = contrasenha;
	}
	
	// Getter para el nombre
	public String getNombre()
	{
	    return nombre;
	}
	
	// Setter para el nombre
	public void setNombre(String nombre)
	{
	    this.nombre = nombre;
	}
	
	// Getter para la contrasenha
	public String getContrasenha()
	{
	    return contrasenha;
	}
	
	// Setter para la contrasenha
	public void setContrasenha(String contrasenha)
	{
	    this.contrasenha = contrasenha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contrasenha, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoriID other = (CategoriID) obj;
		return Objects.equals(contrasenha, other.contrasenha) && Objects.equals(nombre, other.nombre);
	}
	
	
}
