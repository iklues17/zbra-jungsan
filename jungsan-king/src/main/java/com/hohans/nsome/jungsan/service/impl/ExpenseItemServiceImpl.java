package com.hohans.nsome.jungsan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hohans.nsome.domain.trip.id.TripId;
import com.hohans.nsome.jungsan.domain.ExpenseItem;
import com.hohans.nsome.jungsan.domain.id.ExpenseItemId;
import com.hohans.nsome.jungsan.repository.ExpenseItemRepository;
import com.hohans.nsome.jungsan.service.ExpenseItemService;

@Service
public class ExpenseItemServiceImpl implements ExpenseItemService {

	@Autowired
	private ExpenseItemRepository expenseItemRepository;

	public ExpenseItemServiceImpl(){}
	
	public ExpenseItemServiceImpl(ExpenseItemRepository expenseItemRepository) {
		this.expenseItemRepository = expenseItemRepository;
	}

	@Override
	public void saveExpenseItems(List<ExpenseItem> expenseItems, TripId tripId) {

		expenseItemRepository.deleteByTripId(tripId);
		
		expenseItemRepository.save(expenseItems);
	}

	@Override
	public void saveExpenseItem(ExpenseItem expenseItem) {
		
		expenseItemRepository.save(expenseItem);
	}

	@Override
	public ExpenseItem getExpenseItemById(ExpenseItemId id) {
		return expenseItemRepository.findOne(id);
	}

	@Override
	public List<ExpenseItem> getExpenseItemsByTripId(TripId tripId) {
		return expenseItemRepository.findByTripId(tripId);
	}

	@Override
	public void removeExpenseItem(ExpenseItemId id) {
		expenseItemRepository.delete(id);
	}

}
