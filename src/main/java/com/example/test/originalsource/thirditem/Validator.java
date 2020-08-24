package com.example.test.originalsource.thirditem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.test.comum.Survey;

@Component
public class Validator {

	public List<String> validate(Survey survey) {
		List<String> errors = new ArrayList<>();
		if (survey == null) {
			throw new BusinessException("Survey cannot be null.");
		}
		if (currentDate().before(survey.getDateAnswered())) {
			errors.add("Survey can only be answered for current date.");
		}
		if (survey.getOwner() == null || survey.getOwner().isEmpty()) {
			errors.add("Survey must have an owner.");
		}
		return errors;
	}

	private Date currentDate() {
		return new Date();
	}
}
