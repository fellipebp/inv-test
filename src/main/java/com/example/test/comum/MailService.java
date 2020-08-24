package com.example.test.comum;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.test.modifiedsource.firstitem.Alert;
import com.example.test.modifiedsource.firstitem.AppProperties;
import com.example.test.modifiedsource.firstitem.MessageHandler;

@Component
public class MailService {

	@Autowired
	private AppProperties appProperties;
	
	@Autowired
	private MessageHandler messageHandler;
	
	public void sendAlertsMail(List<Alert> alerts) {
		for (Alert alert : alerts) {
			Email email = new Email();
			email.addRecipient(appProperties.getMailAlertRecipient());
			email.setSubject(messageHandler.getMessage("msg.alertaPesquisa", alert.getDescription()));
			email.setBody(messageHandler.getMessage("msg.pontoVenda", " %s\nProduto: %s\n", alert.getPointOfSale(), alert.getProduct()));
			send(email);
		}
	}

	public void send(Email email) {
	}
}
