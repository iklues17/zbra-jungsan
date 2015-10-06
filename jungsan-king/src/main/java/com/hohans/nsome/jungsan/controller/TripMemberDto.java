package com.hohans.nsome.jungsan.controller;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.hohans.nsome.domain.trip.id.TripId;
import com.hohans.nsome.jungsan.domain.TripMember;
import com.hohans.nsome.jungsan.domain.id.TripMemberId;

@Document(collection="expenseItem")
public class TripMemberDto {
	
	@Id
	private String id;
	
	private String name;
	
	private long payment;
	
	private String tripId;
	
	public TripMemberDto() {
	}
	
	public TripMemberDto(TripMember item){
		this.id = item.getId().getIdString();
		this.name = item.getName();
		this.payment = item.getPayment();
		this.tripId = item.getTripId().getIdString();
	}
	
	public TripMember dtoToTripMember(){
		TripMember item = new TripMember();
		item.setId(new TripMemberId(this.id));
		item.setName(this.name);
		item.setPayment(this.payment);
		item.setTripId(new TripId(this.tripId));
		return item;
	}
	
	public TripMemberDto(String id, String name, long cost, String tripId) {
		super();
		this.id = id;
		this.name = name;
		this.payment = cost;
		this.tripId = tripId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPayment() {
		return payment;
	}

	public void setPayment(long cost) {
		this.payment = cost;
	}

	public String getTripId() {
		return tripId;
	}

	public void setTripId(String tripId) {
		this.tripId = tripId;
	}
	
	
}
