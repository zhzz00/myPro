package com.bear.dao;

import java.util.List;
import java.util.Map;

import com.bear.entity.Income;

public interface IncomeDao {
	int insert(Income income);
	
	List<Income> queryIncome(Map<String, Object> qm);
	
	
	int queryIncomeCount(Map<String, Object> qm);
	
	String queryIncomeSum(Map<String, Object> qm);
}
