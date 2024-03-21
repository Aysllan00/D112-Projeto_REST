package br.inatel.dm112.model.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.inatel.dm112.model.Order.STATUS;

@Entity
@Table(name = "Pedido")
public class OrderEntity {
	
	@Id
	@Column(name = "numero")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderCode;

	@Column(name = "CPF")
	private String cpfCustomer;

	private String associatedDeliveryPerson;

	@Column(name = "status")
	private int status;

	@Column(name = "dataPedido", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date orderDate;


	public OrderEntity() {
		this.status = STATUS.PENDING.ordinal();
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


	public String getAssociatedDeliveryPerson() {
		return associatedDeliveryPerson;
	}


	public void setAssociatedDeliveryPerson(String associatedDeliveryPerson) {
		this.associatedDeliveryPerson = associatedDeliveryPerson;
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


	@Override
	public String toString() {
		return "OrderEntity [orderCode=" + orderCode + ", cpfCustomer=" + cpfCustomer + ", associatedDeliveryPerson="
				+ associatedDeliveryPerson + ", status=" + status + ", orderDate=" + orderDate + "]";
	}

}