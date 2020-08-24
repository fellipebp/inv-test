package com.example.test.modifiedsource.firstitem;

import com.example.test.comum.Answer;
import com.example.test.comum.Survey;

public class AlertPriceAboveExpected implements AlertOperation {

	@Override
	public Alert buildAlert(Survey survey, Answer answer) {
		if (isPriceHigherThenExpected(answer, survey)) {
			return buildAlertPriceAboveExpected(survey, answer);
		}
		return null;
	}

	private boolean isPriceHigherThenExpected(Answer answer, Survey survey) {
		return answer.getMonetaryAnswerData().compareTo(survey.getMonetaryExpectedPrice()) > 0;
	}
	
	private Alert buildAlertPriceAboveExpected(Survey survey , Answer answer){
		Alert alert = new Alert();
		alert.setPriceDiff(answer.getMonetaryAnswerData().subtract(survey.getMonetaryExpectedPrice()));
		alert.setDescription(MessageHandler.getInstance().getMessage("msg.precoAcimaEstipulado"));
		alert.setProduct(survey.getProduct());
		alert.setPointOfSale(survey.getPointOfSale());
		alert.setType(AlertTypeEnum.TYPE_2.getId());
		return alert;
	}

}
