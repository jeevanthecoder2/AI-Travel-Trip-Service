package com.ai_travel.tripservice.Dao;

import com.ai_travel.tripservice.Entities.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Reviews,Integer> {


}
