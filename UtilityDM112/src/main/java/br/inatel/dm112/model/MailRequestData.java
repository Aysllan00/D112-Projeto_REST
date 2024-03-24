package br.inatel.dm112.model;

public class MailRequestData {

	private int orderNumber;
	private String from;
	private String password;
	private String to;
	private String body;

	public MailRequestData() {
	}

	public MailRequestData(int orderNumber, String from, String password, String to, String body) {
		this.orderNumber = orderNumber;
		this.from = from;
		this.password = password;
		this.to = to;
		this.body = body;
	}

	public int getOrderNumber() {
		return orderNumber;
	}
	
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "MailRequestData [from=" + from + ", password=" + password + ", to=" + to + "]";
	}

}
