package com.customerRewards.CustomerRewardsCalculator.model;

/**
 * Class Customer Transaction Holds CustId,Amount paid per transaction, Month of
 * the Year
 * 
 * @author 19088
 *
 */
public class CustomerTransaction {

	private int custId;
	private double amountPaid;
	private Integer monthOfYear;

	public int getCustId() {
		return custId;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public Integer getMonthOfYear() {
		return monthOfYear;
	}

/**
 * Constructor for CustomerTransaction, this makes this Object Immutable(no Setters for any Attribute)
 * @param custId
 * @param amountPaid
 * @param monthOfYear
 */
	public CustomerTransaction(int custId, double amountPaid, int monthOfYear) {
		super();
		this.custId = custId;
		this.amountPaid = amountPaid;
		this.monthOfYear = monthOfYear;
	}
}
