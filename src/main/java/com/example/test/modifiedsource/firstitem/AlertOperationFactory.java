package com.example.test.modifiedsource.firstitem;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AlertOperationFactory {

	  static Map<String, AlertOperation> operationMap = new HashMap<>();
	    static {
	    	MessageHandler messageHandler = MessageHandler.getInstance();
	        operationMap.put(messageHandler.getMessage("msg.qualSituacaoProduto"), new AlertBreakageDetected());
	        operationMap.put(messageHandler.getMessage("msg.qualPrecoProduto"), new AlertPriceAboveExpected());
	    }
	 
	    public static Optional<AlertOperation> getOperation(String operator) {
	        return Optional.ofNullable(operationMap.get(operator));
	    }
}


