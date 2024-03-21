package br.inatel.dm112.interfaces;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import br.inatel.dm112.model.Order;

public interface OrderInterface {

	public Order getOrder(Integer orderNumber);

	//public List<Order> searchOrders(String cpf);

	public void updateOrder(Order order, Integer orderNumber);
	
	public void associateOrder(Integer orderNumber, String DeliveryPerson);

	public List<Order> getAllOrders();
}
