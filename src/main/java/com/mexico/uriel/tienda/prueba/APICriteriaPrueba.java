package com.mexico.uriel.tienda.prueba;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.mexico.uriel.tienda.DAO.CategoriaDao;
import com.mexico.uriel.tienda.DAO.ProductoDao;
import com.mexico.uriel.tienda.modelo.Categoria;
import com.mexico.uriel.tienda.modelo.Producto;
import com.mexico.uriel.tienda.utils.JPAUtils;

public class APICriteriaPrueba
{
	public static void main(String[] args) {
		registrarProducto();
		
		EntityManager em = JPAUtils.getEntityManager();
		ProductoDao productoDao = new ProductoDao(em);
		
		List<Producto> resultado = productoDao.ConsultaPorParametros("Xiaomi", null, null);
		System.out.println(resultado.get(0).getDescripcion());
	}
	
	private static void registrarProducto()
	{
		Categoria categoria = new Categoria("Celulares");
		Producto producto = new Producto("Xiaomi","Usado", new BigDecimal("800"),categoria);
		
		EntityManager em = JPAUtils.getEntityManager();
		ProductoDao productoDao = new ProductoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		em.getTransaction().begin();
		
		categoriaDao.guardar(categoria);
		productoDao.guardar(producto);
		
		em.getTransaction().commit();
		em.close();
	}
}
