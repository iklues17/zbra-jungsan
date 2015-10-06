package com.hohans.nsome.jungsan.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.hohans.nsome.jungsan.domain.id.MemberItemPaymentId;

@Document(collection="memberItemPayment")
public class MemberItemPayment {

	@Id
	private MemberItemPaymentId id;
	
	private TripMember tripMember;
	
	private long totalAmount;
	
	private List<MemberExpense> memberExpenses;

	public MemberItemPayment() {
	}

	public MemberItemPayment(MemberItemPaymentId id, TripMember tripMember,
			long totalAmount, List<MemberExpense> memberExpenses) {
		super();
		this.id = id;
		this.tripMember = tripMember;
		this.totalAmount = totalAmount;
		this.memberExpenses = memberExpenses;
	}

	public MemberItemPaymentId getId() {
		return id;
	}

	public void setId(MemberItemPaymentId id) {
		this.id = id;
	}

	public TripMember getTripMember() {
		return tripMember;
	}

	public void setTripMember(TripMember tripMember) {
		this.tripMember = tripMember;
	}

	public long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<MemberExpense> getMemberExpenses() {
		return memberExpenses;
	}

	public void setMemberExpenses(List<MemberExpense> memberExpenses) {
		this.memberExpenses = memberExpenses;
	}
	
	
}
