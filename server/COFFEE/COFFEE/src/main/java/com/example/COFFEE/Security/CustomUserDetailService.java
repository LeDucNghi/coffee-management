package com.example.COFFEE.Security;

import com.example.COFFEE.Entity.UserAccount;
import com.example.COFFEE.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount userAccount= userRepository.findByUserName(username);
        if (userAccount==null){
            throw new UsernameNotFoundException("User not found");
        }
        return CustomUserDetail.mapUserToUserDetail(userAccount);
    }
}
