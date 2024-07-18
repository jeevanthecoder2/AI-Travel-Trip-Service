package com.ai_travel.tripservice.Dao;

import com.ai_travel.tripservice.Entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface BookingRepository extends JpaRepository<Booking,Integer> {

}
