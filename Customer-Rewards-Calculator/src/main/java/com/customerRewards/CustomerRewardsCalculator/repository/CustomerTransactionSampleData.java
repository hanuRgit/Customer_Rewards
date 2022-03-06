package com.customerRewards.CustomerRewardsCalculator.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.customerRewards.CustomerRewardsCalculator.model.CustomerTransaction;

@Component
public class CustomerTransactionSampleData {
	
	/**
	 * Dummy method to populate Data. In real world scenario, a service will return
	 * list of Objects
	 * Given Data is expected to have only last three months transactions
	 * @return
	 */

	public List<CustomerTransaction> returnCustomerTransactionData() {
		List<CustomerTransaction> customerTransactions = new ArrayList<>();
		CustomerTransaction trans1 = new CustomerTransaction(100, 10, 1);
		customerTransactions.add(trans1);
		CustomerTransaction trans2 = new CustomerTransaction(101, 750, 2);
		customerTransactions.add(trans2);

		CustomerTransaction trans3 = new CustomerTransaction(101, 123, 3);
		customerTransactions.add(trans3);
		CustomerTransaction trans4 = new CustomerTransaction(100, 72, 1);
		customerTransactions.add(trans4);
		CustomerTransaction trans5 = new CustomerTransaction(101, 1050, 1);
		customerTransactions.add(trans5);
		return customerTransactions;
	}

}
