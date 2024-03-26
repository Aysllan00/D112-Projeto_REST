package br.inatel.dm112.interfaces;

import java.util.List;

import br.inatel.dm112.model.Entregador;
import br.inatel.dm112.model.Order;

public interface IEntregador {

	List<Order> listOrders(String delivetyPerson);

	Entregador confirmDelivery(String cpf, int orderNumber);

}