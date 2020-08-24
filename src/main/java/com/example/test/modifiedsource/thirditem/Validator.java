package com.example.test.modifiedsource.thirditem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.example.test.comum.Survey;
import com.example.test.modifiedsource.firstitem.MessageHandler;

@Component
public class Validator {
	
	private MessageHandler messageHandler;

	public List<String> validate(Survey survey) {
		List<String> errors = new ArrayList<>();
		if (survey == null) {
			errors.add(messageHandler.getMessage("msg.surveyNaoPodeSerNulo"));
			return errors;
		}
		if (new Date().before(survey.getDateAnswered())) {
			errors.add(messageHandler.getMessage("msg.surveySoPodeSerRespondidoDataAtual"));
		}
		if (StringUtils.isEmpty(survey.getOwner())) {
			errors.add(messageHandler.getMessage("msg.surveyDeveTerUmDono"));
		}
		return errors;
	}

}
