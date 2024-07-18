package com.ai_travel.tripservice.Dao;

import com.ai_travel.tripservice.Entities.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface TripRepository extends JpaRepository<Trip,Integer> {

    public Trip findTripByTripName(String tripName);
}
