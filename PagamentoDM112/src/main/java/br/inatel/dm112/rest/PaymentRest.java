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
import br.inatel.dm112.services.PaymentService;

@RestController
@RequestMapping("/api")
public class PaymentRest implements IEntregador {

	@Autowired
	private PaymentService service;

	@Override
	@GetMapping("/confirmDelivery/{delivetyPerson}/{orderNumber}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Entregador confirmDelivery(
			@PathVariable("delivetyPerson")String delivetyPerson, 
			@PathVariable("orderNumber") int orderNumber) {
		
		System.out.println("ConfirmDeliveryRest - "+ delivetyPerson);
		return service.confirmDelivery(delivetyPerson, orderNumber);
	}

	@Override
	@GetMapping("/listOrders/{delivetyPerson}")
	public List<Order> listOrders(@PathVariable("delivetyPerson")String delivetyPerson) {
		
		System.out.println("Pedidos - "+ delivetyPerson);
		return service.listOrders(delivetyPerson);
	}

}