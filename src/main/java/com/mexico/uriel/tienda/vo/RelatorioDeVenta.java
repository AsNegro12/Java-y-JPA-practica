package com.mexico.uriel.tienda.vo;

import java.time.LocalDate;

public class RelatorioDeVenta
{
	private String nombreProducto;
	private long CantidadProducto;
	private LocalDate fechaDeUltimaVenta;
	

	public RelatorioDeVenta
	(String nombreProducto, long cantidadProducto, LocalDate fechaDeUltimaVenta)
	{
		this.nombreProducto = nombreProducto;
		CantidadProducto = cantidadProducto;
		this.fechaDeUltimaVenta = fechaDeUltimaVenta;
	}

	@Override
	public String toString()
	{
		return "RelatoroDeVenta [nombreProducto=" + nombreProducto 
				+ ", CantidadProducto=" + CantidadProducto
				+ ", fechaDeUltimaVenta=" + fechaDeUltimaVenta + "]";
	}

	public String getNombreProducto() {
		return nombreProducto;
	}


	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}


	public long getCantidadProducto() {
		return CantidadProducto;
	}


	public void setCantidadProducto(long cantidadProducto) {
		CantidadProducto = cantidadProducto;
	}


	public LocalDate getFechaDeUltimaVenta() {
		return fechaDeUltimaVenta;
	}


	public void setFechaDeUltimaVenta(LocalDate fechaDeUltimaVenta) {
		this.fechaDeUltimaVenta = fechaDeUltimaVenta;
	}
}
