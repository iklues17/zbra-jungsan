package com.hohans.nsome.jungsan.service;

import java.util.List;

import com.hohans.nsome.domain.trip.id.TripId;
import com.hohans.nsome.jungsan.domain.TripCalculate;
import com.hohans.nsome.jungsan.domain.TripMember;
import com.hohans.nsome.jungsan.domain.id.TripMemberId;


public interface TripMemberService {

	void saveTripMembers(List<TripMember> tripMembers, TripId tripId);
	
	TripMember getTripMemberById(TripMemberId id);

	List<TripMember> getTripMembersByTripId(TripId tripId);

	void removeTripMember(TripMemberId id);

}
