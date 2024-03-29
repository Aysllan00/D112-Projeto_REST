package br.inatel.dm112.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.inatel.dm112.interfaces.IEntregador;
import br.inatel.dm112.model.Entregador;
import br.inatel.dm112.model.Order;
import br.inatel.dm112.services.DeliveryService;

@RestController
@RequestMapping("/api")
public class DeliveryRest implements IEntregador {

	@Autowired
	private DeliveryService service;

	@Override
	@GetMapping("/confirmDelivery/{deliveryPerson}/{orderNumber}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Entregador confirmDelivery(
			@PathVariable("deliveryPerson")String deliveryPerson, 
			@PathVariable("orderNumber") int orderNumber) {
		
		System.out.println("ConfirmDeliveryRest - "+ deliveryPerson);
		return service.confirmDelivery(deliveryPerson, orderNumber);
	}

	@Override
	@GetMapping("/listOrders/{deliveryPerson}")
	public List<Order> listOrders(@PathVariable("deliveryPerson")String deliveryPerson) {
		
		System.out.println("Pedidos - "+ deliveryPerson);
		return service.listOrders(deliveryPerson);
	}

}