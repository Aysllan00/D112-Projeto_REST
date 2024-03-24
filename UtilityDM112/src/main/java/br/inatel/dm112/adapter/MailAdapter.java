package br.inatel.dm112.adapter;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import br.inatel.dm112.adapter.model.OrderData;
import br.inatel.dm112.model.MailRequestData;

public abstract class MailAdapter {

	public void sendMail(MailRequestData mailData) {

		System.out.println("Enviando email do pedido " + mailData.getOrderNumber() + " para: " + mailData.getTo());

		Properties props = getEmailHostProperties();

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(mailData.getFrom(), mailData.getPassword());
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(mailData.getFrom()));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailData.getTo()));
			message.setSubject("Pedido " + mailData.getOrderNumber() + ": Entrega confirmada");

			Multipart multipart = new MimeMultipart();
			// Cria o corpo da mensagem HTML
			BodyPart messageBodyPartHtml = new MimeBodyPart();
			//messageBodyPartHtml.setContent("text/html");
			String htmlContent = "<h1> O pedido <i>" + mailData.getOrderNumber() + "</i> foi confirmado como recebido.</h1><br>"
					+ mailData.getBody() +
					" <br><br> <b>Gerado pelo Correios-DM112.</b>" ;
			messageBodyPartHtml.setContent(htmlContent, "text/html; charset=utf-8");
			multipart.addBodyPart(messageBodyPartHtml);

			message.setContent(multipart);

			Transport.send(message);
			System.out.println("Email sent successfully....");
		} catch (MessagingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	protected abstract Properties getEmailHostProperties();
}
