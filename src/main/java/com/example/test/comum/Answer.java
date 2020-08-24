package com.example.test.comum;

import java.math.BigDecimal;

import com.example.test.modifiedsource.firstitem.MessageHandler;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Answer {

	private String question;
	private String answerData;

	public BigDecimal getMonetaryAnswerData() {
		try {
			return new BigDecimal(answerData);
		} catch (NumberFormatException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(MessageHandler.getInstance().getMessage("msg.naoEhPossivelConverterResposta"));
		}
	}
}
