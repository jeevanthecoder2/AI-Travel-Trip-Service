package com.ai_travel.tripservice.Dao;
import com.ai_travel.tripservice.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;

@EnableJpaRepositories
public interface UserRepository extends JpaRepository<Users,Integer> {
    public Users findUserByUserName(final String userName);

    Optional<Users> findUserByUserEmail(final String userEmail);

}
