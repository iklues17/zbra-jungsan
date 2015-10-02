package com.hohans.zbra.king.jungsan.domain;

import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import com.hohans.zbra.king.jungsan.domain.id.TripMemberId;

@Document(collection="tripMember")
public class TripMember {
	
	@Id
	private TripMemberId id;
	
	private String name;
	
	private long payment;
	
	@CreatedBy 
	private String createdBy;
	
	@CreatedDate
	private DateTime createdDate;
	
	@LastModifiedBy 
	private String lastModifiedBy;
	
	@LastModifiedDate
	private DateTime lastModifiedDate;

	public TripMember() {
	}

	public TripMember(TripMemberId id, String name, long payment) {
		this.id = id;
		this.name = name;
		this.payment = payment;
	}

	public TripMemberId getId() {
		return id;
	}

	public void setId(TripMemberId id) {
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

	public void setPayment(long payment) {
		this.payment = payment;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public DateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public DateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(DateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	
}
