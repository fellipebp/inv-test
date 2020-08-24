package com.example.test.modifiedsource.firstitem;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class AppProperties {
	
	@Value("${mail.alert.recipient}")
	private String mailAlertRecipient;

}
