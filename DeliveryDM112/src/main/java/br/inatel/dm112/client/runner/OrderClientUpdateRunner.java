package br.inatel.dm112.client.runner;

import java.util.Date;

import br.inatel.dm112.client.OrderClient;
import br.inatel.dm112.model.Order;

public class OrderClientUpdateRunner {

	public static void main(String[] args) {
		OrderClient client = new OrderClient();
		client.setRestURL(ClientUtil.getOrderRestURL());

		int orderNumber = 3;

		Order orderToUpdate = client.retrieveOrder(orderNumber);
		if (orderToUpdate == null) {
			System.out.println("Order not found: " + 1);
			return;
		}

		// update the values for the order
		//orderToUpdate.setAssociatedDeliveryPerson("Entregador1");;
		orderToUpdate.setStatus(1);
		System.out.println(orderToUpdate.toString());
		
		client.updateOrder(orderToUpdate);
	}
}
