package com.example.test.modifiedsource.firstitem;

import com.example.test.comum.Answer;
import com.example.test.comum.Survey;

public class AlertBreakageDetected implements AlertOperation{

	@Override
	public Alert buildAlert(Survey survey, Answer answer) {
		if (MessageHandler.getInstance().getMessage("msg.produtoAusenteGondola").equals(answer.getAnswerData())) {
			return buildAlertBeakageDetected(survey);
		}
		return null;
	}
	
	private Alert buildAlertBeakageDetected(Survey survey){
		Alert alert = new Alert();
		alert.setPointOfSale(survey.getPointOfSale());
		alert.setDescription(MessageHandler.getInstance().getMessage("msg.rupturaDetectada"));
		alert.setProduct(survey.getProduct());
		alert.setType(AlertTypeEnum.TYPE_1.getId());
		return alert;
	}

}
