package com.tal.incomeCouponsApp.services;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tal.couponsdemo.entities.Coupon;
import com.tal.incomeCouponsApp.entities.Income;
import com.tal.incomeCouponsApp.entities.IncomeType;
import com.tal.incomeCouponsApp.reposotories.IncomeReposotory;



@Service
public class IncomeServiceImpl {
	private final IncomeReposotory incomeReposotory;
	private final Double NEW_COUPON_AMOUNT = 100.0;
	private final Double UPDATE_COUPON_AMPUNT = 10.0;
	

	public IncomeServiceImpl(IncomeReposotory incomeReposotory) {
		this.incomeReposotory = incomeReposotory;
	}
	
	private Income createIncome(String name) {
		Income newIncome = new Income();
		Calendar cal = Calendar.getInstance();
		newIncome.setName(name);
		newIncome.setDate(cal.getTime());
		return newIncome;
	}
	
	public Income storeCustomerPruchaseIncome(Coupon couponPruchase, Long id,String name) {
		Income newIncome = createIncome(name);
		newIncome.setAmount(couponPruchase.getPrice());
		newIncome.setIncomeType(IncomeType.CUSTOMER_PURCHASE);
		newIncome.setCustomerId(id);
		return incomeReposotory.save(newIncome);
	}
	
	public Income storeCompanyNewCouponIncome(Long id , String name) {
		Income newIncome = createIncome(name);
		newIncome.setAmount(NEW_COUPON_AMOUNT);
		newIncome.setIncomeType(IncomeType.COMPANY_NEW_COUPON);
		newIncome.setCompanyId(id);
		return incomeReposotory.save(newIncome);	
	}
	
	public Income storeCompanyUpdateCuoponIncome(Long id , String name) {
		Income newIncome = createIncome(name);
		newIncome.setAmount(UPDATE_COUPON_AMPUNT);
		newIncome.setIncomeType(IncomeType.COMPANY_UPDATE_COUPON);
		newIncome.setCompanyId(id);
		return incomeReposotory.save(newIncome);
	}
	
	
	
	
	
	
	public List<Income> findAllIncome(){
		return incomeReposotory.findAll();
	}
	public List<Income> findAllIncomeByCustomer(long customerId){
		return incomeReposotory.findByCustomerId(customerId);
	}
	public List<Income> findAllIncomeByCompany(long companyId){
		return incomeReposotory.findByCompanyId(companyId);
	}
	
	

}
