package com.mexico.uriel.tienda.prueba;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.mexico.uriel.tienda.DAO.CategoriaDao;
import com.mexico.uriel.tienda.DAO.ProductoDao;
import com.mexico.uriel.tienda.modelo.CategoriID;
import com.mexico.uriel.tienda.modelo.Categoria;
import com.mexico.uriel.tienda.modelo.Producto;
import com.mexico.uriel.tienda.utils.JPAUtils;

public class RegistroDeProductos {

	public static void main(String[] args)
	{
		registrarProducto();
		
		EntityManager em = JPAUtils.getEntityManager();
		ProductoDao productoDao = new ProductoDao(em);
		
		//List<Producto> consultaPorCategoria = productoDao.ConsultaPorCategoria("Celulares");
		//System.out.println(consultaPorCategoria);
		
		BigDecimal precio = productoDao.ConsultaPorPrecio("Xiaomi Redmi note 10");
		System.out.println(precio);
		
		Categoria find = em.find(Categoria.class, new CategoriID("CELULARES","456"));
		
		System.out.println(find.getNombre());
	}

	private static void registrarProducto()
	{
		Categoria categoria = new Categoria("Celulares");
		Producto producto = new Producto("Xiaomi Redmi note 10","Usado", new BigDecimal("800"),categoria);
		
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
