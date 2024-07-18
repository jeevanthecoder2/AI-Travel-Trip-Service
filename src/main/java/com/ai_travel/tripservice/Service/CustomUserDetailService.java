package com.ai_travel.tripservice.Service;

import com.ai_travel.tripservice.Dao.UserRepository;
import com.ai_travel.tripservice.Entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Users user = this.userRepository.findUserByUserName(userName);
        if(user==null){
            new RuntimeException("User not Found");

        }
        return user;
    }
}
