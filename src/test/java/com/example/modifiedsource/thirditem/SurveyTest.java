package com.example.modifiedsource.thirditem;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Date;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.test.comum.Survey;
import com.example.test.comum.SurveyBuilder;
import com.example.test.modifiedsource.firstitem.MessageHandler;
import com.example.test.modifiedsource.thirditem.Validator;


@RunWith(SpringRunner.class)
public class SurveyTest {

	@Autowired
	private Validator validator;
	
	@Autowired
	private MessageHandler messageHandler;
	
	@Test
	public void shouldNotReturnErrorMessage() {
		mockCurrentDate(createDate(23, 9, 2019));
		Survey survey = aSurveyBuilder().answeredAt(createDate(21, 9, 2019)).withOwner("Michael").build();
		List<String> errors = validator.validate(survey);
		assertThat(errors.size(), equalTo(0));
	}

	@Test
	public void shouldReturnMessageSurveyMustHaveAnOwner() {
		mockCurrentDate(createDate(23, 9, 2019));
		Survey survey = aSurveyBuilder().answeredAt(createDate(23, 9, 2019)).withOwner("").build();
		List<String> errors = validator.validate(survey);
		Assertions.assertThat(errors).hasSize(1)
        							.containsExactly(messageHandler.getMessage("msg.surveyDeveTerUmDono")); 
	}
	
	@Test
	public void shouldReturnMessageSurveyCannotBeNull() {
		List<String> errors = validator.validate(null);
		Assertions.assertThat(errors).hasSize(1)
        							 .containsExactly(messageHandler.getMessage("msg.surveyNaoPodeSerNulo")); 
	}
	
	@Test
	public void shouldReturnMessageSurveyCanOnlyBeAnsweredCurrentDate() {
		mockCurrentDate(createDate(23, 9, 2019));
		Survey survey = aSurveyBuilder().answeredAt(createDate(24, 9, 2019)).withOwner("Michael").build();
		List<String> errors = validator.validate(survey);
		Assertions.assertThat(errors).hasSize(1)
        							 .containsExactly(messageHandler.getMessage("msg.surveySoPodeSerRespondidoDataAtual")); 
	}

	
	
	private Date createDate(int i, int j, int k) {
		return null;
	}

	private SurveyBuilder aSurveyBuilder() {
		return new SurveyBuilder();
	}
	
	private void mockCurrentDate(Date createDate) {
		// TODO Auto-generated method stub
	}


	

}
