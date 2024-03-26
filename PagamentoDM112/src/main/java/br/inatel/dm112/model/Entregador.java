package br.inatel.dm112.model;

import br.inatel.dm112.rest.support.PaymentException;

public class Entregador {

	
	public enum PAY_STATUS {
		OK, NULL_VALUES, ORDER_NOT_FOUND, WRONG_ORDER_STATUS, ORDER_ERROR, BILLET_ERROR, EMAIL_ERROR
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
	
	public static PaymentException createErrorStatus(String msg, String cpf, int orderNumber, PAY_STATUS errorStatus) {
		System.out.println(msg);
		return new PaymentException(msg + " Details: error status " + errorStatus.name()
				+ " CPF: " + cpf + " Order: " + orderNumber);
	}


}
