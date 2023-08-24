package com.mexico.uriel.tienda.DAO;

import javax.persistence.EntityManager;

import com.mexico.uriel.tienda.modelo.Categoria;
import com.mexico.uriel.tienda.modelo.Producto;

public class CategoriaDao
{
	private EntityManager em;

	public CategoriaDao(EntityManager em)
	{
		this.em = em;	
	}
	
	public void guardar(Categoria categoria)
	{
		this.em.persist(categoria);
	}
	
	public void Actializar(Categoria categoria)
	{
		this.em.merge(categoria);
	}
	
	public void Remover(Categoria categoria)
	{
		categoria = this.em.merge(categoria);
		this.em.remove(categoria);
	}

	public Categoria consultaPorNombre(String nombre)
	{
		String JPQL = "SELECT C FROM Categoria AS C WHERE C.nombre =: nombre ";
		return em.createQuery(JPQL,Categoria.class).setParameter("nombre", nombre).getSingleResult();
	}
}
