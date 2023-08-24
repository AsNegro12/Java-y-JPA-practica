package com.mexico.uriel.tienda.DAO;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.mexico.uriel.tienda.modelo.Pedido;
import com.mexico.uriel.tienda.vo.RelatorioDeVenta;


public class PedidoDao
{
	private EntityManager em;
	
	public PedidoDao(EntityManager em)
	{
		this.em = em;	
	}
	
	public void guardar(Pedido pedido)
	{
		this.em.persist(pedido);
	}
	
	public Pedido ConsultaPorId(Integer id)
	{
		return em.find(Pedido.class, id);
	}
	
	public List<Pedido> consultarTodos()
	{
		String JPQL = "SELECT P FROM Producto AS P";
		return em.createQuery(JPQL,Pedido.class).getResultList();
	}
	
	public BigDecimal valorTotalVendido()
	{
		String JPQL = "SELECT SUM(p.valor_total) FROM Pedido p";
		return em.createQuery(JPQL,BigDecimal.class).getSingleResult();
	}
	
	public List<Pedido> consultaPorNombreCliente(String nombre)
	{
		String JPQL = "SELECT P FROM Pedido AS P WHERE P.cliente.nombre = :nombre ";
		return em.createQuery(JPQL,Pedido.class)
				.setParameter("nombre", nombre)
				.getResultList();
	}
	
	public List<RelatorioDeVenta> relatorioDeVentasVO()
	{
		String JPQL = "SELECT new com.mexico.uriel.tienda.vo.RelatorioDeVenta(producto.nombre, "
				+ "SUM(item.cantidad), "
				+ "MAX(pedido.fecha)) "
				+ "FROM Pedido pedido "
				+ "JOIN pedido.items item "
				+ "JOIN item.producto producto "
				+ "GROUP BY producto.nombre "
				+ "ORDER BY item.cantidad DESC ";
		
		return em.createQuery(JPQL,RelatorioDeVenta.class).getResultList();
	}
	
	public Pedido consultarPedidoConCliente(Integer id)
	{
		String JPQL = "SELECT p FROM Pedido p JOIN FETCH p.cliente WHERE p.id =: id";
		return em.createQuery(JPQL,Pedido.class).setParameter("id", id).getSingleResult();
	}
}
