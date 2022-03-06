package com.customerRewards.CustomerRewardsCalculator;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.customerRewards.CustomerRewardsCalculator.controler.CustomerRewards;
import com.customerRewards.CustomerRewardsCalculator.model.TotalCustomerRewards;
import com.customerRewards.CustomerRewardsCalculator.util.CalculateRewardsPerTransaction;

@SpringBootTest
class CustomerRewardsCalculatorApplicationTests {

	@Test
	void contextLoads() {
		
	}
	
	@Autowired
	public CustomerRewards customerRewardsCalc;
	
	@Autowired
	public CalculateRewardsPerTransaction calculateRewards; //Util to calculate Rewards per transaction

	/**
	 * Test rewards calculation per customer per transaction
	 */
	@Test
	public void rewadsCalculated_perCustomerTransaction() {
		long result = 0;
		
		result  = calculateRewards.calculateRewardsPerTransaction(-100);
		Assert.assertEquals(0,result);
		
		result  = calculateRewards.calculateRewardsPerTransaction(100);
		Assert.assertEquals(50,result);

		result  = calculateRewards.calculateRewardsPerTransaction(750);
		Assert.assertEquals(1350,result);

		result  = calculateRewards.calculateRewardsPerTransaction(20);
		Assert.assertEquals(0,result);
		
		result  = calculateRewards.calculateRewardsPerTransaction(75);
		Assert.assertEquals(25,result);
	}
	
	/**
	 * Test Total and Monthly Reward calculation per customer
	 */
	@Test
	public void totalsCalculated_perCustomer() {
		
		int[] expectedTotalRewards = {22,3396};
		String[] expectedPerMonthRewards = {"{1=22}","{1=1950, 2=1350, 3=96}"};
		
		List<TotalCustomerRewards> result  = customerRewardsCalc.TotalRewardsPerCustomerPerMonth();
		
        for(int i=0; i<result.size();i++) {
        	/**
        	 * Check Total calculated rewards 
        	 */
        	Assert.assertEquals(expectedTotalRewards[i],result.get(i).getTotalRewards());
	        Assert.assertEquals(expectedTotalRewards[i],result.get(i).getRewardsByMonth().values().stream().mapToInt(r -> r.intValue()).sum());
	        /**
	         * Check calculated Monthly Rewards
	         */
	        for(int j=0;j<result.get(i).getRewardsByMonth().size();j++) {
	        	Assert.assertEquals(expectedPerMonthRewards[i],result.get(i).getRewardsByMonth().toString());
	        }
        }
	}

}
