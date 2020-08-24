package com.example.test.comum;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.example.test.modifiedsource.firstitem.MessageHandler;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Survey {
	
	private List<Answer> answers;
	private String pointOfSale;
	private String product;
	private String expectedPrice;
	private String owner;
	private Date dateAnswered;

	
	public BigDecimal getMonetaryExpectedPrice() {
		try {
			return new BigDecimal(expectedPrice);
		} catch (NumberFormatException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(MessageHandler.getInstance().getMessage("msg.naoEhPossivelConverterPreco"));
		}
	}
}
