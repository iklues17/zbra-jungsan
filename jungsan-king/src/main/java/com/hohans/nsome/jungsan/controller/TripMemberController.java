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
import com.hohans.nsome.jungsan.domain.TripMember;
import com.hohans.nsome.jungsan.service.TripMemberService;

@RestController
@RequestMapping(value="/member")
public class TripMemberController {

	@Autowired
	private TripMemberService tripMemberService;
	
	@RequestMapping(value="/of/trip/{tripId}", method = RequestMethod.GET)
	public List<TripMemberDto> getMemberByTrip(@PathVariable String tripId){
		
		List<TripMemberDto> result = new ArrayList<TripMemberDto>();
		List<TripMember> members = tripMemberService.getTripMembersByTripId(new TripId(tripId));

		TripMemberDto dto = null;
		for(TripMember member: members){
			dto = new TripMemberDto(member);
			result.add(dto);
		}
		return result;
	}
	
	@RequestMapping(value="/of/trip/{tripId}", method = RequestMethod.POST)
	public void saveTripMember(@RequestBody List<TripMemberDto> dtos, @PathVariable String tripId){

		List<TripMember> tripMembers = new ArrayList<TripMember>();
		
		for(TripMemberDto dto:dtos){
			tripMembers.add(dto.dtoToTripMember());
		}
		tripMemberService.saveTripMembers(tripMembers, new TripId(tripId));
	}
	
}
