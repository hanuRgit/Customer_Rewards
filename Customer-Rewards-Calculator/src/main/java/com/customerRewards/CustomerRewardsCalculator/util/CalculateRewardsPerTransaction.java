package com.customerRewards.CustomerRewardsCalculator.util;

import org.springframework.stereotype.Component;

@Component
public class CalculateRewardsPerTransaction {
	
	public long calculateRewardsPerTransaction(double amountPaid) {
		//In real world scenario amountPaid should be BigDecimal
		long rewards = 0;
		double tempAmount = amountPaid - 50;
		if (tempAmount <= 0) {
			return 0;
		}
		if (tempAmount > 0)		// Check for amount between 50 and 100
		{
			rewards = tempAmount > 50 ? 50 : (long) tempAmount;
			tempAmount = tempAmount - 50;
		}
		if (tempAmount > 0)		// Check for amount greater than 100
		{
			rewards = rewards + ((long) tempAmount * 2);
		}

		return rewards;
	}
}
