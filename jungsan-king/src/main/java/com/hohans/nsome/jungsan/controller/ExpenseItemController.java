package com.hohans.nsome.jungsan.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hohans.nsome.domain.trip.id.TripId;
import com.hohans.nsome.jungsan.domain.ExpenseItem;
import com.hohans.nsome.jungsan.service.ExpenseItemService;

@RestController
@RequestMapping(value="/expense-item")
public class ExpenseItemController {

	@Autowired
	private ExpenseItemService expenseItemService;
	
	@RequestMapping(value="/of/trip/{tripId}", method = RequestMethod.GET)
	public List<ExpenseItemDto> getMemberByTrip(@PathVariable String tripId){
		
		List<ExpenseItemDto> result = new ArrayList<ExpenseItemDto>();
		List<ExpenseItem> items = expenseItemService.getExpenseItemsByTripId(new TripId(tripId));
		
		ExpenseItemDto dto = null;
		for(ExpenseItem item: items){
			dto = new ExpenseItemDto(item);
			result.add(dto);
		}
		return result;
	}
	
	@RequestMapping(value="/of/trip/{tripId}", method = RequestMethod.POST)
	public void saveExpenseItem(@RequestBody List<ExpenseItemDto> dtos, @PathVariable String tripId){
		
		List<ExpenseItem> expenseItems = new ArrayList<ExpenseItem>();
		
		for(ExpenseItemDto dto:dtos){
			expenseItems.add(dto.dtoToExpenseItem());
		}
		expenseItemService.saveExpenseItems(expenseItems, new TripId(tripId));
	}
}
