package com.mexico.uriel.tienda.DAO;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.mexico.uriel.tienda.modelo.Cliente;

public class ClienteDao
{
	private EntityManager em;
	
	public ClienteDao(EntityManager em)
	{
		this.em = em;	
	}
	
	public void guardar(Cliente cliente)
	{
		this.em.persist(cliente);
	}
	
	public Cliente ConsultaPorId(Integer id)
	{
		return em.find(Cliente.class, id);
	}
	
	public List<Cliente> consultarTodos()
	{
		String JPQL = "SELECT P FROM Cliente AS P";
		return em.createQuery(JPQL,Cliente.class).getResultList();
	}
	
	public List<Cliente> consultaPorNombre(String nombre)
	{
		String JPQL = "SELECT P FROM Producto AS P WHERE P.nombre =: nombre ";
		return em.createQuery(JPQL,Cliente.class).setParameter("nombre", nombre).getResultList();
	}
	
	public List<Cliente> ConsultaPorCategoria(String nombre)
	{
		String JPQL = "SELECT P FROM Producto AS P WHERE P.categoria.nombre =: nombre ";
		return em.createQuery(JPQL,Cliente.class).setParameter("nombre", nombre).getResultList();
	}
	
	public BigDecimal ConsultaPorPrecio(String nombre)
	{
		String JPQL = "SELECT P.precio FROM Producto AS P WHERE P.nombre =: nombre";
		return em.createQuery(JPQL,BigDecimal.class).setParameter("nombre", nombre).getSingleResult();
	}
}
