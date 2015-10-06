package com.hohans.nsome.jungsan.service;

import java.util.List;

import com.hohans.nsome.domain.trip.id.TripId;
import com.hohans.nsome.jungsan.domain.ExpenseItem;
import com.hohans.nsome.jungsan.domain.id.ExpenseItemId;



/**
 * Cargo Tracker Management Portal's User Management service
 * @author Hahn
 */
public interface ExpenseItemService {
	
	void saveExpenseItems(List<ExpenseItem> expenseItems, TripId tripId);
	
	void saveExpenseItem(ExpenseItem expenseItem);

	ExpenseItem getExpenseItemById(ExpenseItemId id);

	List<ExpenseItem> getExpenseItemsByTripId(TripId tripId);
	
	void removeExpenseItem(ExpenseItemId id);

}
