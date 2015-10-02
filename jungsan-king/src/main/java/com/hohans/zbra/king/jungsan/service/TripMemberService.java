package com.hohans.zbra.king.jungsan.service;

import com.hohans.zbra.king.jungsan.domain.TripMember;
import com.hohans.zbra.king.jungsan.domain.id.TripMemberId;


public interface TripMemberService {

	TripMember createTripMember(TripMemberId id, String name, long payment);

}
