package com.tal.incomeCouponsApp.Converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.tal.incomeCouponsApp.entities.IncomeType;

@Converter(autoApply = true)
public class IncomeTypeConverter implements AttributeConverter<IncomeType, String> {
	@Override
	public String convertToDatabaseColumn(IncomeType method) {
		switch (method) {
		case CUSTOMER_PURCHASE:
			return "CP";
		case COMPANY_NEW_COUPON:
			return "CNP";
		case COMPANY_UPDATE_COUPON:
			return "CUC";

		default:
			throw new IllegalArgumentException("Unknown method: " + method);
		}
	}

	@Override
	public IncomeType convertToEntityAttribute(String dbData) {
		switch (dbData) {
		case "CP":
			return IncomeType.CUSTOMER_PURCHASE;
		case "CNP":
			return IncomeType.COMPANY_NEW_COUPON;
		case "CUC":
			return IncomeType.COMPANY_UPDATE_COUPON;

		default:
			throw new IllegalArgumentException("Unknown value: " + dbData);
		}
	}

}
