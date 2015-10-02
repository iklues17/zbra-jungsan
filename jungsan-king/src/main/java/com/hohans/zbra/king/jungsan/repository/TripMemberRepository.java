package com.hohans.zbra.king.jungsan.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hohans.zbra.king.jungsan.domain.TripMember;
import com.hohans.zbra.king.jungsan.domain.id.TripMemberId;

public interface TripMemberRepository extends MongoRepository<TripMember, TripMemberId>{
	
//	RegisteredUser findByLoginName(String loginName);
//	
//	RegisteredUser findByEmailAddress(String emailAddress);
	
}
