package com.example.test.originalsource.firstitem;


import java.math.BigDecimal;

import lombok.Data;

@Data
public class Alert {

	
	private String pointOfSale;
	private String product;
	private Integer priceDiff;
	private Integer type;
	private String description;
}
