package com.hohans.nsome.jungsan.domain;

import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 * 특정 멤버의 Trip 소비 항목 별 지출 액 
 * @author Hahn
 */
public class MemberExpense {

	private ExpenseItem expenseItem;
	
	private boolean isPay;
	
	private boolean isUserInput;
	
	private long amount;

	public MemberExpense() {
	}

	public MemberExpense(ExpenseItem expenseItem, boolean isPay,
			boolean isUserInput, long amount) {
		super();
		this.expenseItem = expenseItem;
		this.isPay = isPay;
		this.isUserInput = isUserInput;
		this.amount = amount;
	}

	public ExpenseItem getExpenseItem() {
		return expenseItem;
	}

	public void setExpenseItem(ExpenseItem expenseItem) {
		this.expenseItem = expenseItem;
	}

	public boolean isPay() {
		return isPay;
	}

	public void setPay(boolean isPay) {
		this.isPay = isPay;
	}

	public boolean isUserInput() {
		return isUserInput;
	}

	public void setUserInput(boolean isUserInput) {
		this.isUserInput = isUserInput;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}
	
	
}
