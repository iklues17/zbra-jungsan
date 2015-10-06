//package com.hohans.nsome.jungsan.service;
//
//import static org.junit.Assert.assertNotNull;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import com.hohans.nsome.domain.trip.id.TripId;
//import com.hohans.nsome.jungsan.domain.TripMember;
//import com.hohans.nsome.jungsan.domain.id.TripMemberId;
//import com.hohans.nsome.jungsan.repository.mongo.TripMemberMongoDbRepository;
//import com.hohans.nsome.jungsan.service.impl.TripMemberServiceImpl;
//import com.hohans.nsome.jungsan.util.MockRepositoryTestUtil;
//
//public class TripMemberServiceTest {
//
//	private TripMemberService tripMemberService;
//	private TripMemberMongoDbRepository tripMemberRepository;
//	
//	@Before
//	public void seUp() throws Exception{
//		tripMemberRepository = mock(TripMemberMongoDbRepository.class);
//		tripMemberService = new TripMemberServiceImpl(tripMemberRepository);
//	}
//	
//	@Test
//	public void shouldCreateTripMember(){
//		
//		MockRepositoryTestUtil.stubRespositoryAdd(tripMemberRepository, TripMember.class);
//		
//		TripMemberId id = new TripMemberId("1");
//		TripId tripId = new TripId("1");
//		String name = "test";
//		long payment = 123456l;
//		TripMember tripMember = tripMemberService.createTripMember(id, name, payment, tripId);
//		
//		assertNotNull(tripMember);
//		
//		verify(tripMemberRepository).insert(tripMember);
//		
//	}
//	
//	@Test
//	public void shouldRemoveTripMember(){
//		
//		MockRepositoryTestUtil.stubRespositoryAdd(tripMemberRepository, TripMember.class);
//		
//		TripMemberId id = new TripMemberId("1");
//		tripMemberService.removeTripMember(id);
//		
//		verify(tripMemberRepository).delete(id);
//		
//	}
//	
//	@Test
//	public void shouldGetTripMemberById(){
//		
//		TripMemberId inputId = new TripMemberId("1");
//		TripMember outputTripMembers = new TripMember(inputId, "test", 10000, new TripId("1"));
//		
//		when(tripMemberRepository.findOne(inputId)).thenReturn(outputTripMembers);
//		
//		MockRepositoryTestUtil.stubRespositoryAdd(tripMemberRepository, TripMember.class);
//		
//		TripMemberId id = new TripMemberId("1");
//		TripMember tripMember = tripMemberService.getTripMemberById(id);
//		
//		assertNotNull(tripMember);
//		
//		verify(tripMemberRepository).findOne(id);
//		
//	}
//	
//	@Test
//	public void shouldGetTripMembers(){
//		
//		TripId tripId = new TripId("1");
//		List<TripMember> outputTripMembers = new ArrayList<TripMember>();
//		
//		when(tripMemberRepository.findByTripId(tripId)).thenReturn(outputTripMembers);
//		
//		MockRepositoryTestUtil.stubRespositoryAdd(tripMemberRepository, TripMember.class);
//		
//		List<TripMember> tripMembers = tripMemberService.getTripMembersByTripId(tripId);
//		
//		assertNotNull(tripMembers);
//		
//		verify(tripMemberRepository).findByTripId(tripId);
//		
//	}
//}
