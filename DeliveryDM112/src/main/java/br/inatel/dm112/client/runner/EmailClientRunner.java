package br.inatel.dm112.client.runner;

import java.io.FileInputStream;
import java.io.IOException;

import br.inatel.dm112.client.EmailClient;

public class EmailClientRunner {

	public static void main(String[] args) {
		//Altere os endereços de envio de e-mail nas properties dentro da pasta resources
		EmailClient client = new EmailClient();
		client.setRestURL(ClientUtil.getUtilityRestEmailURL());
		client.setSendFromAddress(ClientUtil.getEmailFromAddress());
		client.setSendToAddress(ClientUtil.getEmailSendToAddress());
		client.setSendPassAddress(ClientUtil.getEmailPassword());

		int orderNumber = 5555; //any test order number
		String body = "Pedido teste num " + orderNumber + " entregue.";
		client.callSendMailService(orderNumber, body);
		System.out.println("Sucesso na chamada para envio do email.");
	}
}
