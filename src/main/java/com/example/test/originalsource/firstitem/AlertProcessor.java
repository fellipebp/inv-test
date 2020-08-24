package com.example.test.originalsource.firstitem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.comum.AlertGateway;
import com.example.test.comum.Answer;
import com.example.test.comum.Email;
import com.example.test.comum.MailService;
import com.example.test.comum.Survey;
import com.example.test.modifiedsource.firstitem.SurveyGateway;

@Service
public class AlertProcessor {
	private final SurveyGateway surveyGateway;
	private final AlertGateway alertGateway;
	private final MailService mailService;

	@Autowired
	public AlertProcessor(SurveyGateway surveyGateway, AlertGateway alertGateway, MailService mailService) {
		this.surveyGateway = surveyGateway;
		this.alertGateway = alertGateway;
		this.mailService = mailService;
	}

	public void process() {
		Survey[] sList = surveyGateway.findSurveys();
		List<Alert> aList = new ArrayList<>();
		for (int i = 0; i < sList.length; i++) {
			for (int j = 0; j < sList[i].getAnswers().size(); j++) {
				Answer answer = sList[i].getAnswers().get(j);
				if (answer.getQuestion().equals("Qual a situação do produto?")) {
					if (answer.getAnswerData().equals("Produto ausente na gondola")) {
						Alert a = new Alert();
						a.setPointOfSale(sList[i].getPointOfSale());
						a.setDescription("Ruptura detectada!");
						a.setProduct(sList[i].getProduct());
						a.setType(1);
						aList.add(a);
					}
				} else if (answer.getQuestion().equals("Qual o preço do produto?")) {
					int collectedPrice = Integer.parseInt(answer.getAnswerData());
					int expectedPrice = Integer.parseInt(sList[i].getExpectedPrice());
					if (collectedPrice > expectedPrice) {
						Alert a = new Alert();
						a.setPriceDiff(expectedPrice - Integer.parseInt(answer.getAnswerData()));
						a.setDescription("Preço acima do estipulado!");
						a.setProduct(sList[i].getProduct());
						a.setPointOfSale(sList[i].getPointOfSale());
						a.setType(2);
						aList.add(a);
					}
				}
			}
		}
		for (Alert a : aList) {
			alertGateway.save(a);
			Email email = new Email();
			email.addRecipient("supervisor@empresa.com.br");
			email.setSubject("Alerta de Pesquisa:" + a.getDescription());
			email.setBody(String.format("Ponto de venda: %s\nProduto: %s\n", a.getPointOfSale(), a.getProduct()));
			mailService.send(email);
		}
	}
}