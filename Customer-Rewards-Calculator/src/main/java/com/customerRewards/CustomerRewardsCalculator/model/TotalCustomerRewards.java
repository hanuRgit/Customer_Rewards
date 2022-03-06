package com.customerRewards.CustomerRewardsCalculator.model;

import java.util.Map;

public class TotalCustomerRewards {
	private int custId;
	private  long totalRewards;
	private Map<Integer,Long> rewardsByMonth;
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public long getTotalRewards() {
		return totalRewards;
	}
	public void setTotalRewards(long totalRewards) {
		this.totalRewards = totalRewards;
	}
	public Map<Integer, Long> getRewardsByMonth() {
		return rewardsByMonth;
	}
	public void setRewardsByMonth(Map<Integer, Long> rewardsByMonth) {
		this.rewardsByMonth = rewardsByMonth;
	}
	public TotalCustomerRewards(int custId, long totalRewards, Map<Integer, Long> rewardsByMonth) {
		super();
		this.custId = custId;
		this.totalRewards = totalRewards;
		this.rewardsByMonth = rewardsByMonth;
	}
	
}
