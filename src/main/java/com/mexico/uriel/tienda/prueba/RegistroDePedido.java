package com.mexico.uriel.tienda.prueba;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.mexico.uriel.tienda.DAO.CategoriaDao;
import com.mexico.uriel.tienda.DAO.ClienteDao;
import com.mexico.uriel.tienda.DAO.PedidoDao;
import com.mexico.uriel.tienda.DAO.ProductoDao;
import com.mexico.uriel.tienda.modelo.Categoria;
import com.mexico.uriel.tienda.modelo.Cliente;
import com.mexico.uriel.tienda.modelo.ItemsPedido;
import com.mexico.uriel.tienda.modelo.Pedido;
import com.mexico.uriel.tienda.modelo.Producto;
import com.mexico.uriel.tienda.utils.JPAUtils;
import com.mexico.uriel.tienda.vo.RelatorioDeVenta;

public class RegistroDePedido {

	public static void main(String[] args)
	{
		registrarProducto();
		
		EntityManager em = JPAUtils.getEntityManager();
		
		ProductoDao productoDao = new ProductoDao(em);
		PedidoDao pedidoDao = new PedidoDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
		
		Producto producto = productoDao.ConsultaPorId(1);
		Cliente cliente = new Cliente("Juan","u23fs1d2d");
		Pedido pedido = new Pedido(cliente);
		
		pedido.agregarItems(new ItemsPedido(5,producto,pedido));
		
		em.getTransaction().begin();
		
		clienteDao.guardar(cliente);
		pedidoDao.guardar(pedido);
		
		em.getTransaction().commit();
		
		BigDecimal valorTotalVendido = pedidoDao.valorTotalVendido();
		System.out.println("Valor total: "+valorTotalVendido);
		
		List<RelatorioDeVenta> relatorio = pedidoDao.relatorioDeVentasVO();

		relatorio.forEach(System.out::println);
		
		em.close();
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
