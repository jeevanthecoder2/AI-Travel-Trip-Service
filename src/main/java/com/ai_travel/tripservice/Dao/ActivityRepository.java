package com.ai_travel.tripservice.Dao;

import com.ai_travel.tripservice.Entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity,Integer> {
}
