package com.customerRewards.CustomerRewardsCalculator.controler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customerRewards.CustomerRewardsCalculator.model.TotalCustomerRewards;
import com.customerRewards.CustomerRewardsCalculator.model.CustomerTransaction;
import com.customerRewards.CustomerRewardsCalculator.repository.CustomerTransactionSampleData;
import com.customerRewards.CustomerRewardsCalculator.util.CalculateRewardsPerTransaction;

@RestController
public class CustomerRewards {
	
	@Autowired
	public CalculateRewardsPerTransaction calculateRewards; //Util to calculate Rewards per transaction
	
	@Autowired
	public CustomerTransactionSampleData customerTransactionSampleData;
	
	@GetMapping("/CustomerRewards")
	public List<TotalCustomerRewards> TotalRewardsPerCustomerPerMonth() {

		List<CustomerTransaction> customerTransactionData = customerTransactionSampleData.returnCustomerTransactionData();
		/**
		 * Summing amountPaid per Month
		 */
		Map<Integer, Map<Integer, Long>> custStats = customerTransactionData.stream()
				.collect(Collectors.groupingBy(x -> x.getCustId(), Collectors.groupingBy(x -> x.getMonthOfYear(),
						Collectors.summingLong(t -> calculateRewards.calculateRewardsPerTransaction(t.getAmountPaid())))));
		
		/**
		 * Summing amountPaid for all Months, in this example data is expected to 
		 * have only latest 3 months of data.
		 */
		List<TotalCustomerRewards> rewardsStats = new ArrayList<>();
		custStats.forEach((k, v) -> {
			TotalCustomerRewards stats = new TotalCustomerRewards(k, v.values().stream().reduce(Long::sum).get(), v);
			rewardsStats.add(stats);
		});
		return rewardsStats;
	}
	
}
