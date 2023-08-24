package com.mexico.uriel.tienda.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="pedidos")
public class Pedido
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private LocalDate fecha = LocalDate.now();
	private BigDecimal valor_total = new BigDecimal(0);
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Cliente cliente;
	
	@OneToMany(mappedBy="pedido", cascade= CascadeType.ALL)
	private List<ItemsPedido> items = new ArrayList<>();

	public Pedido() {}
	
	public Pedido(Cliente cliente)
	{
		this.cliente = cliente;
	}
	
	public void agregarItems(ItemsPedido item)
	{
		item.setPedido(this);
		this.items.add(item);
		this.valor_total = this.valor_total.add(item.getValorTotal());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getValor_total() {
		return valor_total;
	}

	public void setValor_total(BigDecimal valor_total) {
		this.valor_total = valor_total;
	}
	
	public List<ItemsPedido> getItems() {
		return items;
	}

	public void setItems(List<ItemsPedido> items) {
		this.items = items;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
