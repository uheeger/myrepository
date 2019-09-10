package com.uhe.app.budget.obj;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum PaymentType {
	
	EINZAHLUNG, AUSZAHLUNG;
	
	@JsonCreator
	public static PaymentType forValue(String value) {
		for (PaymentType paymentType : PaymentType.values()) {
			if (paymentType.toString().equalsIgnoreCase(value)) {
				return paymentType;
			}
		}
		return null;
	}
	
}
