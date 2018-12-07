package com.tal.incomeCouponsApp.entities;

public enum IncomeType {
	CUSTOMER_PURCHASE("Customer purschase a coupon"),
	COMPANY_NEW_COUPON("Company create a new coupon"),
	COMPANY_UPDATE_COUPON("Company update a coupon");

	private String decription;

	private IncomeType (String decription) {
			this.decription = decription;
		}

	public String getDecription() {
		return decription;
	}

}
