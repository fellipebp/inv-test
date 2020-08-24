package com.example.test.modifiedsource.firstitem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.comum.AlertGateway;
import com.example.test.comum.Answer;
import com.example.test.comum.MailService;
import com.example.test.comum.Survey;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AlertProcessor {

	private final SurveyGateway surveyGateway;
	private final AlertGateway alertGateway;
	private final MailService mailService;

	@Autowired
	public AlertProcessor(SurveyGateway surveyGateway, AlertGateway alertGateway, MailService mailService,
			MessageHandler messageHandler) {
		this.surveyGateway = surveyGateway;
		this.alertGateway = alertGateway;
		this.mailService = mailService;
	}

	public void processAlerts() {
		List<Alert> alerts = new ArrayList<>();
		
		log.debug("Processing answers...");
		for (Survey survey : surveyGateway.findSurveys()) {
			processAnswersData(alerts, survey);
		}
		
		log.debug("Saving alerts...");
		alertGateway.saveAll(alerts);
		
		log.debug("Sending mails...");
		mailService.sendAlertsMail(alerts);
	}

	private void processAnswersData(List<Alert> alerts, Survey survey) {
		for (Answer answer : survey.getAnswers()) {
			Optional<AlertOperation> alertOperation = AlertOperationFactory.getOperation(answer.getQuestion());
			if (alertOperation.isPresent()) {
				alerts.add(alertOperation.get().buildAlert(survey, answer));
			}
		}
	}

}