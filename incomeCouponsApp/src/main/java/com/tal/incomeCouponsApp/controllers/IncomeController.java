package com.tal.incomeCouponsApp.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tal.couponsdemo.entities.Coupon;
import com.tal.incomeCouponsApp.entities.Income;
import com.tal.incomeCouponsApp.services.IncomeServiceImpl;

@RestController
@RequestMapping("rest/api/income")

public class IncomeController {
	private final IncomeServiceImpl incomeService;

	public IncomeController(IncomeServiceImpl incomeService) {
		this.incomeService = incomeService;
	}
	@PostMapping("/customer/{id}/{customerName}")
	public Income StoreCustomerPruchaseIncome(@RequestBody Coupon couponPruchase,@PathVariable("id") long id, @PathVariable("customerName") String name) {
		return incomeService.storeCustomerPruchaseIncome(couponPruchase, id , name);
	}
	@PostMapping("/company/{id}/{companyName}/update")
	public Income StoreCompanyUpdateCouponIncome(@PathVariable("id") long id, @PathVariable("companyName") String compName) {
		return incomeService.storeCompanyUpdateCuoponIncome(id, compName);
	}
	@PostMapping("/company/{id}/{companyName}/new")
	public Income StoreCompanynewCouponIncome(@PathVariable("id") long id, @PathVariable("companyName") String compName) {
		return incomeService.storeCompanyNewCouponIncome(id, compName);
	}
	@GetMapping()
	public List<Income> findAllIncome(){
		return incomeService.findAllIncome();
	}
	@GetMapping("/customer/{id}")
	public List<Income> findIncomeByCustomer(@PathVariable("id") long id){
		return incomeService.findAllIncomeByCustomer(id);
	}
	@GetMapping("/company/{id}")
	public List<Income> findIncomeByCompany(@PathVariable("id") long id){
		return incomeService.findAllIncomeByCompany(id);
	}
	

}
