package com.mexico.uriel.tienda.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="electronico")
public class Electronico extends Producto
{
	private String marca;
	private String modelo;
	
	public Electronico(){}

	public Electronico(String marca, String modelo)
	{
		this.marca = marca;
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
}