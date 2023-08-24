package com.mexico.uriel.tienda.prueba;

import java.io.FileNotFoundException;
import javax.persistence.EntityManager;

import com.mexico.uriel.tienda.DAO.PedidoDao;
import com.mexico.uriel.tienda.modelo.Pedido;
import com.mexico.uriel.tienda.utils.JPAUtils;

public class PruebaDeDesempeño
{
	public static void main(String[] args) throws FileNotFoundException
	{
		LoadRecords.cargarRegistros();
		
		EntityManager em = JPAUtils.getEntityManager();
		
		Pedido pedido = em.find(Pedido.class, 3);
		PedidoDao pedidoDao = new PedidoDao(em);
		
		Pedido pedidoConCliente = pedidoDao.consultarPedidoConCliente(2);	
		em.close();
		
//		System.out.println(pedido.getFecha());
//		System.out.println(pedido.getItems().size());
//		System.out.println(pedidoConCliente.getCliente().getNombre());
	}
}
