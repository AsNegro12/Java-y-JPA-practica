package com.mexico.uriel.tienda.modelo;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Embedded
	private DatosPersonales datospersonales;

	public Cliente()
	{
		
	}
	
	public Cliente(String nombre, String dni)
	{
		this.datospersonales = new DatosPersonales(nombre,dni);
	}

	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return datospersonales.getNombre();
	}

	public void setNombre(String nombre) {
		this.datospersonales.setNombre(nombre);;
	}

	public String getDni() {
		return datospersonales.getDni();
	}

	public void setDni(String dni) {
		this.datospersonales.setDni(dni);
	}
	
	
}
