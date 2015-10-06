package com.hohans.nsome.jungsan.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.hohans.nsome.jungsan.domain.id.TripCalculateId;

@Document(collection="tripCalculate")
public class TripCalculate{

	@Id
	private TripCalculateId id;
	
	@DBRef
	private List<TripMember> tripMembers;

	@DBRef
	private List<ExpenseItem> expenseItems;
	
	private long totalPayment;
	
	private long totalExpense;
	
	@DBRef
	private List<MemberItemPayment> jungsanMetrix;

	public TripCalculate() {
	}

	public TripCalculate(TripCalculateId id, List<TripMember> tripMembers,
			List<ExpenseItem> expenseItems, long totalPayment,
			long totalExpense, List<MemberItemPayment> jungsanMetrix) {
		this.id = id;
		this.tripMembers = tripMembers;
		this.expenseItems = expenseItems;
		this.totalPayment = totalPayment;
		this.totalExpense = totalExpense;
		this.jungsanMetrix = jungsanMetrix;
	}

	public TripCalculateId getId() {
		return id;
	}

	public void setId(TripCalculateId id) {
		this.id = id;
	}

	public List<TripMember> getTripMembers() {
		return tripMembers;
	}

	public long getTotalPayment() {
		return totalPayment;
	}

	public void setTotalPayment(long totalPayment) {
		this.totalPayment = totalPayment;
	}

	public void setTripMembers(List<TripMember> tripMembers) {
		this.tripMembers = tripMembers;
	}

	public List<ExpenseItem> getExpenseItems() {
		return expenseItems;
	}

	public void setExpenseItems(List<ExpenseItem> expenseItems) {
		this.expenseItems = expenseItems;
	}

	public long getTotalExpense() {
		return totalExpense;
	}

	public void setTotalExpense(long totalExpense) {
		this.totalExpense = totalExpense;
	}

	public List<MemberItemPayment> getJungsanMetrix() {
		return jungsanMetrix;
	}

	public void setJungsanMetrix(List<MemberItemPayment> jungsanMetrix) {
		this.jungsanMetrix = jungsanMetrix;
	}
	
}
