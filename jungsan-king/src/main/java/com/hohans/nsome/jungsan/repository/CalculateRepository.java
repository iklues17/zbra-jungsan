package com.hohans.nsome.jungsan.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hohans.nsome.jungsan.domain.TripCalculate;
import com.hohans.nsome.jungsan.domain.id.TripCalculateId;

public interface CalculateRepository extends MongoRepository<TripCalculate, TripCalculateId> {

}
