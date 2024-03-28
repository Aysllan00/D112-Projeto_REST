package br.inatel.dm112.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.inatel.dm112.model.Order;
import br.inatel.dm112.model.dao.OrderRepository;
import br.inatel.dm112.model.entities.OrderEntity;
import br.inatel.dm112.rest.support.InvalidOrderOperationException;
import br.inatel.dm112.rest.support.OrderNotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repo;

	public OrderEntity getOrder(int orderNumber) {

		Optional<OrderEntity> obj = repo.findById(orderNumber);
		return obj.orElseThrow(() -> new OrderNotFoundException("Order " + orderNumber + " not found."));
	}

//	public List<OrderEntity> searchOrdersByCPF(String cpf) {
//
//		List<OrderEntity> list = repo.findByCPF(cpf);
//		return list;
//	}

	public void updateOrder(Order order, Integer orderNumber) {

		OrderEntity entity = getOrder(orderNumber);
		updateOrderData(order, entity); // don't change PK
		repo.save(entity);
		System.out.println("OrderImpl updateOrder - atualizou o pedido com número: " + order.getOrderCode());
	}

	public void associateOrderWithDeliveryPerson(Integer orderNumber, String deliveryPerson) {
		// TODO Auto-generated method stub
		OrderEntity entity = getOrder(orderNumber);
		associateOrder(entity, deliveryPerson); // don't change PK
		repo.save(entity);
	}
	
	public OrderEntity createOrder(Order order) {

		OrderEntity entity = convertToEntity(order);
		repo.save(entity);
		System.out.println("OrderImpl createOrder - pedido criado com número: " + entity.getOrderCode());
		return entity;
	}

	public List<Order> getAllOrders() {
		List<OrderEntity> entities = repo.findAll();
		List<Order> orders = new ArrayList<>();

		for (OrderEntity entity : entities) {
			Order order = convertToOrder(entity);
			orders.add(order);
		}
		return orders;
	}

	private void updateOrderData(Order order, OrderEntity entity) {
		entity.setCpfCustomer(order.getCpfCustomer());
		entity.setStatus(order.getStatus());
		entity.setOrderDate(order.getOrderDate());
		entity.setAssociatedDeliveryPerson(order.getAssociatedDeliveryPerson());
	}
	
	private void associateOrder(OrderEntity entity, String deliveryPerson) {
		entity.setAssociatedDeliveryPerson(deliveryPerson);
	}

	public static Order convertToOrder(OrderEntity entity) {
		Order order = new Order(entity.getOrderCode(), entity.getCpfCustomer(), entity.getStatus(),
				entity.getAssociatedDeliveryPerson());
		return order;
	}

	public static OrderEntity convertToEntity(Order order) {
		OrderEntity entity = new OrderEntity();
		entity.setCpfCustomer(order.getCpfCustomer());
		entity.setStatus(order.getStatus());
		entity.setOrderDate(order.getOrderDate());
		entity.setAssociatedDeliveryPerson(order.getAssociatedDeliveryPerson());
		return entity;
	}

	

}