package com.hohans.king.jungsan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hohans.zbra.king.jungsan.domain.TripMember;
import com.hohans.zbra.king.jungsan.domain.id.TripMemberId;
import com.hohans.zbra.king.jungsan.repository.TripMemberRepository;
import com.hohans.zbra.king.jungsan.service.TripMemberService;

@Service
public class TripMemberServiceImpl implements TripMemberService {

	@Autowired
	private TripMemberRepository tripMemberRepository;

	public TripMemberServiceImpl(TripMemberRepository tripMemberRepository) {
		this.tripMemberRepository = tripMemberRepository;
	}

	@Override
	public TripMember createTripMember(TripMemberId id, String name, long payment) {

		return tripMemberRepository.insert(new TripMember(id, name, payment));
	}

}
