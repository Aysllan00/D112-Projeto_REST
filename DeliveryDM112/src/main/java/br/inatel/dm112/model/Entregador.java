package br.inatel.dm112.model;

import br.inatel.dm112.rest.support.DeliveryException;

public class Entregador {

	
	public enum PAY_STATUS {
		OK, NULL_VALUES, ORDER_NOT_FOUND, WRONG_ORDER_STATUS, ORDER_ERROR, EMAIL_ERROR
	}

	
	private int id;
	
	public Entregador() {
	}

	public Entregador(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Entregador [id=" + id + "]";
	}
	
	public static DeliveryException createErrorStatus(String msg, String deliveryPerson, int orderNumber, PAY_STATUS errorStatus) {
		System.out.println(msg);
		return new DeliveryException(msg + " Details: error status " + errorStatus.name()
				+ " deliveryPerson: " + deliveryPerson + " Order: " + orderNumber);
	}


}
