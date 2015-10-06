package com.hohans.nsome.jungsan.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hohans.nsome.domain.trip.id.TripId;
import com.hohans.nsome.jungsan.domain.ExpenseItem;
import com.hohans.nsome.jungsan.domain.id.ExpenseItemId;

public interface ExpenseItemRepository extends MongoRepository<ExpenseItem, ExpenseItemId>{

	List<ExpenseItem> findByTripId(TripId tripId);
	
	Long deleteByTripId(TripId tripId);
	
//	RegisteredUser findByLoginName(String loginName);
//	
//	RegisteredUser findByEmailAddress(String emailAddress);
	
}
