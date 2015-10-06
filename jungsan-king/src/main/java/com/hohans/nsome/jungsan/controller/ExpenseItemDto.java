package com.hohans.nsome.jungsan.controller;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.hohans.nsome.domain.trip.id.TripId;
import com.hohans.nsome.jungsan.domain.ExpenseItem;
import com.hohans.nsome.jungsan.domain.id.ExpenseItemId;

@Document(collection="expenseItem")
public class ExpenseItemDto {
	
	@Id
	private String id;
	
	private String name;
	
	private long cost;
	
	private String tripId;
	
	public ExpenseItemDto() {
	}
	
	public ExpenseItemDto(ExpenseItem item){
		this.id = item.getId().getIdString();
		this.name = item.getName();
		this.cost = item.getCost();
		this.tripId = item.getTripId().getIdString();
	}
	
	public ExpenseItem dtoToExpenseItem(){
		ExpenseItem item = new ExpenseItem();
		item.setId(new ExpenseItemId(this.id));
		item.setName(this.name);
		item.setCost(this.cost);
		item.setTripId(new TripId(this.tripId));
		return item;
	}
	
	public ExpenseItemDto(String id, String name, long cost, String tripId) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
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

	public long getCost() {
		return cost;
	}

	public void setCost(long cost) {
		this.cost = cost;
	}

	public String getTripId() {
		return tripId;
	}

	public void setTripId(String tripId) {
		this.tripId = tripId;
	}
	
	
}
