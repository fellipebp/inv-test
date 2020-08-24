package com.example.test.modifiedsource.firstitem;


import java.math.BigDecimal;

import lombok.Data;

@Data
public class Alert {

	
	private String pointOfSale;
	private String product;
	private BigDecimal priceDiff;
	private Integer type;
	private String description;
}
