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
	
	public String getFrom() {
		return from;
	}

	public String getPassword() {
		return password;
	}

	public String getTo() {
		return to;
	}

	public String getBody() {
		return body;
	}

	@Override
	public String toString() {
		return "MailRequestData [orderNumber="+ orderNumber +",from=" + from + ", password=" + password + ", to=" + to + ",body="+ body+"]";
	}

}
