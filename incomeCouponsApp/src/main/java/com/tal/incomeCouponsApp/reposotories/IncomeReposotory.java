package com.tal.incomeCouponsApp.reposotories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tal.incomeCouponsApp.entities.Income;

public interface IncomeReposotory extends JpaRepository<Income, Long> {
	public List<Income> findByCustomerId(Long customerId);
	public List<Income> findByCompanyId(Long companyId);
	
	

}
