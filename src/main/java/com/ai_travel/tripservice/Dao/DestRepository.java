package com.ai_travel.tripservice.Dao;

import com.ai_travel.tripservice.Entities.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestRepository extends JpaRepository<Destination,Integer> {
    public Destination findDestinationByName(String name);
}
