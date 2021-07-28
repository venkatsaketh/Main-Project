package com.cts.security.service;

import com.cts.security.SecurityMicroserviceApplication;
import com.cts.security.model.MyUserDetails;
import com.cts.security.model.User;
import com.cts.security.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {
	private static final Logger log= LoggerFactory.getLogger(SecurityMicroserviceApplication.class);
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findById(Long.parseLong(s)).orElse(null);
        if (user == null)
            throw new UsernameNotFoundException("User not found with ID: " + s);
        log.info("User with ID " + s + " found");
        return new MyUserDetails(user);
    }

}
