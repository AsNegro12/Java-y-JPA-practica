package com.mexico.uriel.tienda.modelo;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Categoria")
public class Categoria
{
	@EmbeddedId
	private CategoriID categoriaId;
	
	public Categoria()
	{
		
	}

	public Categoria(String nombre) {
		this.categoriaId = new CategoriID(nombre,"456");
	}
	
	public String getNombre() {
		return categoriaId.getNombre();
	}
	public void setNombre(String nombre) {
		this.categoriaId.setNombre(nombre);
	}
	
	
}
