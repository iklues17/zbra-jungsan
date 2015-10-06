package com.hohans.nsome.jungsan.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hohans.nsome.domain.trip.id.TripId;
import com.hohans.nsome.jungsan.domain.TripMember;
import com.hohans.nsome.jungsan.domain.id.TripMemberId;

public interface TripMemberRepository extends MongoRepository<TripMember, TripMemberId>{

	List<TripMember> findByTripId(TripId tripId);
	
	Long deleteByTripId(TripId tripId);
	
//	RegisteredUser findByLoginName(String loginName);
//	
//	RegisteredUser findByEmailAddress(String emailAddress);
	
}
