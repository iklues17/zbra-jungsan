package com.hohans.nsome.jungsan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hohans.nsome.domain.trip.id.TripId;
import com.hohans.nsome.jungsan.domain.TripMember;
import com.hohans.nsome.jungsan.domain.id.TripMemberId;
import com.hohans.nsome.jungsan.repository.TripMemberRepository;
import com.hohans.nsome.jungsan.service.TripMemberService;

@Service
public class TripMemberServiceImpl implements TripMemberService {

	@Autowired
	private TripMemberRepository tripMemberRepository;

	public TripMemberServiceImpl(){}
	
	public TripMemberServiceImpl(TripMemberRepository tripMemberRepository) {
		this.tripMemberRepository = tripMemberRepository;
	}

	@Override
	public void saveTripMembers(List<TripMember> tripMembers, TripId tripId) {
		
		tripMemberRepository.deleteByTripId(tripId);
		
		tripMemberRepository.save(tripMembers);
	}

	@Override
	public TripMember getTripMemberById(TripMemberId id) {
		return tripMemberRepository.findOne(id);
	}

	@Override
	public List<TripMember> getTripMembersByTripId(TripId tripId) {
		return tripMemberRepository.findByTripId(tripId);
	}

	@Override
	public void removeTripMember(TripMemberId id) {
		tripMemberRepository.delete(id);
	}

}
