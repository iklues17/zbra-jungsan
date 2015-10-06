package com.hohans.nsome.jungsan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hohans.nsome.jungsan.domain.MemberItemPayment;
import com.hohans.nsome.jungsan.domain.TripCalculate;
import com.hohans.nsome.jungsan.domain.id.MemberItemPaymentId;
import com.hohans.nsome.jungsan.domain.id.TripCalculateId;
import com.hohans.nsome.jungsan.repository.CalculateRepository;
import com.hohans.nsome.jungsan.service.CalculateService;
import com.hohans.nsome.util.IdGenerator;

@Service
public class CalculateServiceImpl implements CalculateService {

	@Autowired
	private CalculateRepository tripCalculateRepository;

	public CalculateServiceImpl(){}
	
	public CalculateServiceImpl(CalculateRepository tripCalculateRepository) {
		this.tripCalculateRepository = tripCalculateRepository;
	}

//	@Override
//	public void removeTripCalculate(TripCalculateId id) {
//		tripCalculateRepository.delete(id);
//	}
//
//	@Override
//	public TripMember getTripCalculateById(TripCalculateId id) {
//		return tripCalculateRepository.findOne(id);
//	}
//
	@Override
	public void saveTripCalculate(TripCalculate tripCalculate) {
		
		if(tripCalculate.getId() == null || "".equals(tripCalculate.getId()) ){
			tripCalculate.setId(new TripCalculateId("1"));
			
		}
		
		for(MemberItemPayment itemPayment: tripCalculate.getJungsanMetrix()){
			itemPayment.setId(new MemberItemPaymentId(new IdGenerator().generateId()));
		}
		tripCalculateRepository.save(tripCalculate);
		
	}

}
