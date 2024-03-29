package br.inatel.dm112.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.inatel.dm112.model.MailRequestData;
import reactor.core.publisher.Mono;

@Service
public class EmailClient {

	@Value("${utility.rest.email.url}")
	private String restURL;

	@Value("send_from_addr@gmail.com")
	private String sendFromAddress;

	@Value("send_to_addr@gmail.com")
	private String sendToAddress;
	
	@Value("change_it")
	private String sendPassAddress;
	private String mailEndpoint = "/mail";
	
	public void callSendMailService(int orderNumber, String body) {

		String url = restURL + mailEndpoint ;
		System.out.println("URL: " + url);
		
		MailRequestData mrd = new MailRequestData(orderNumber, sendFromAddress, sendPassAddress, sendToAddress, body);
		
		WebClient
				.create(url)
		        .post()
		        .contentType(MediaType.APPLICATION_JSON)
		        .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
		        .body(Mono.just(mrd), MailRequestData.class)
		        .accept(MediaType.APPLICATION_JSON)
		        .retrieve()
		        .bodyToMono(String.class).defaultIfEmpty("")
		        .log()
		        .block();
	}
	
	public void setRestURL(String restURL) {
		this.restURL = restURL;
	}
	
	public void setSendFromAddress(String sendFromAddress) {
		this.sendFromAddress = sendFromAddress;
	}
	
	public void setSendToAddress(String sendToAddress) {
		this.sendToAddress = sendToAddress;
	}

	public void setSendPassAddress(String sendPassAddress) {
		this.sendPassAddress = sendPassAddress;
	}

}
