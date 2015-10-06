package com.hohans.nsome.jungsan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hohans.nsome.jungsan.domain.TripCalculate;
import com.hohans.nsome.jungsan.service.CalculateService;

@RestController
@RequestMapping(value="/calculate")
public class TripCalculateController {

	@Autowired
	private CalculateService calculateService;
	
	@RequestMapping(value="/trip/{tripId}", method = RequestMethod.POST)
	public void saveTripCalculate(@RequestBody TripCalculate tripCalculate, @PathVariable String tripId){
		calculateService.saveTripCalculate(tripCalculate);
	}
}
