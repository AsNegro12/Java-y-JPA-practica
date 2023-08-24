package com.mexico.uriel.tienda.DAO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.mexico.uriel.tienda.modelo.Producto;

public class ProductoDao
{
	private EntityManager em;

	public ProductoDao(EntityManager em)
	{
		this.em = em;	
	}
	
	public void guardar(Producto producto)
	{
		this.em.persist(producto);
	}
	
	public Producto ConsultaPorId(Integer id)
	{
		return em.find(Producto.class, id);
	}
	
	public List<Producto> consultarTodos()
	{
		String JPQL = "SELECT P FROM Producto AS P";
		return em.createQuery(JPQL,Producto.class).getResultList();
	}
	
	public List<Producto> consultaPorNombre(String nombre)
	{
		String JPQL = "SELECT P FROM Producto AS P WHERE P.nombre =: nombre ";
		return em.createQuery(JPQL,Producto.class).setParameter("nombre", nombre).getResultList();
	}
	
	public List<Producto> ConsultaPorCategoria(String nombre)
	{
		String JPQL = "SELECT P FROM Producto AS P WHERE P.categoria.nombre =: nombre ";
		return em.createQuery(JPQL,Producto.class).setParameter("nombre", nombre).getResultList();
	}
	
	public BigDecimal ConsultaPorPrecio(String nombre)
	{

		return em.createNamedQuery("Producto.ConsultaDePrecio",BigDecimal.class)
				.setParameter("nombre", nombre).getSingleResult();
	}
	
	public List<Producto> ConsultaPorParametros(String nombre, BigDecimal precio, LocalDate fecha)
	{
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Producto> query = builder.createQuery(Producto.class);
		
		Root<Producto> from = query.from(Producto.class);
		
		Predicate filtro = builder.and();
		
		if(nombre != null && !nombre.trim().isEmpty())
		{
			filtro = builder.and(filtro, builder.equal(from.get("nombre"), nombre));
		}
		if(precio != null && !precio.equals(new BigDecimal(0)))
		{
			filtro = builder.and(filtro, builder.equal(from.get("precio"), precio));
		}
		if(fecha != null )
		{
			filtro = builder.and(filtro, builder.equal(from.get("fechaDeRegistro"), fecha));
		}
		
		query = query.where(filtro);
		
		return em.createQuery(query).getResultList();
	}
}
