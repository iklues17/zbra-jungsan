package com.hohans.king.jungsan.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.hohans.king.jungsan.util.MockRepositoryTestUtil;
import com.hohans.zbra.king.jungsan.domain.TripMember;
import com.hohans.zbra.king.jungsan.domain.id.TripMemberId;
import com.hohans.zbra.king.jungsan.repository.TripMemberRepository;
import com.hohans.zbra.king.jungsan.service.TripMemberService;

public class TripMemberServiceTest {

	private TripMemberService tripMemberService;
	private TripMemberRepository tripMemberRepository;
	
	@Before
	public void seUp() throws Exception{
		tripMemberRepository = mock(TripMemberRepository.class);
		tripMemberService = new TripMemberServiceImpl(tripMemberRepository);
	}
	
	@Test
	public void shouldCreateTripMember(){
		
		MockRepositoryTestUtil.stubRespositoryAdd(tripMemberRepository, TripMember.class);
		
		TripMemberId id = new TripMemberId("1");
		String name = "test";
		long payment = 123456l;
		TripMember tripMember = tripMemberService.createTripMember(id, name, payment);
		
		assertNotNull(tripMember);
		
		verify(tripMemberRepository).insert(tripMember);
		
	}
	
	@Test
	public void shouldRemoveTripMember(){
		
		MockRepositoryTestUtil.stubRespositoryAdd(tripMemberRepository, TripMember.class);
		
		TripMemberId id = new TripMemberId("1");
		tripMemberService.removeTripMember(id);
		
		verify(tripMemberRepository).delete(id);
		
	}
	
	@Test
	public void shouldGetTripMemberById(){
		
		MockRepositoryTestUtil.stubRespositoryAdd(tripMemberRepository, TripMember.class);
		
		TripMemberId id = new TripMemberId("1");
		TripMember tripMember = tripMemberService.getTripMemberById(id);
		
		assertNotNull(tripMember);
		
		verify(tripMemberRepository).findOne(id);
		
	}
	
	@Test
	public void shouldGetTripMembers(){
		
		TripId tripId = new TripId("1");
		List<TripMember> resultTripMembers = new ArrayList<TripMember>();
		
		when(tripMemberRepository.findByTripId(tripId)).thenReturn(resultTripMembers);
		
		MockRepositoryTestUtil.stubRespositoryAdd(tripMemberRepository, TripMember.class);
		
		List<TripMember> tripMembers = tripMemberService.getTripMembersByTripId(tripId);
		
		assertNotNull(tripMembers);
		
		verify(tripMemberRepository).findByTripId(tripId);
		
	}
}
