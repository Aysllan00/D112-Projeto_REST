package br.inatel.dm112.adapter.model;

import java.util.Calendar;
import java.util.Date;

public class OrderData {

	public static enum STATUS { PENDING, DELIVERED }
	private Integer orderCode;
	private String cpfCustomer;
	private int status;
	private Date orderDate;
	private String associatedDeliveryPerson;
	Calendar cal = Calendar.getInstance();
	public OrderData() {

		this.setOrderCode(1234);
		this.setCpfCustomer("111.111.111-11");
		this.setOrderDate(cal.getTime());
		cal.add(Calendar.DAY_OF_MONTH, 10);
		this.setAssociatedDeliveryPerson("Entregador1");
		this.setStatus(1);

	}

	public Integer getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(Integer orderCode) {
		this.orderCode = orderCode;
	}

	public String getCpfCustomer() {
		return cpfCustomer;
	}

	public void setCpfCustomer(String cpfCustomer) {
		this.cpfCustomer = cpfCustomer;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getAssociatedDeliveryPerson() {
		return associatedDeliveryPerson;
	}

	public void setAssociatedDeliveryPerson(String associatedDeliveryPerson) {
		this.associatedDeliveryPerson = associatedDeliveryPerson;
	}
}
