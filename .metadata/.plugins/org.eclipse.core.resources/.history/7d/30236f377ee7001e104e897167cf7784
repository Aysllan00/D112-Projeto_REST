package br.inatel.dm112.model;

import java.util.Date;

public class Order {

//	@JsonIgnore
	public static enum STATUS { PENDING, DELIVERED }

	private Integer orderCode;

	private String cpfCustomer;

	private int status;

//	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date orderDate;

	private String associatedDeliveryPerson;
	
	public Order() {
	}
	

	public Order(Integer orderCode, String cpfCustomer, int status, String associatedDeliveryPerson) {
		super();
		this.orderCode = orderCode;
		this.cpfCustomer = cpfCustomer;
		this.status = status;
		this.associatedDeliveryPerson = associatedDeliveryPerson;
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

	@Override
	public String toString() {
		return "Order [orderCode=" + orderCode + ", cpfCustomer=" + cpfCustomer + ", status=" + status + ", orderDate="
				+ orderDate + ", associatedDeliveryPerson=" + associatedDeliveryPerson + "]";
	}

	
	
	

}
