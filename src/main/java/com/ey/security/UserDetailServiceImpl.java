package com.ey.security;

import com.ey.model.entities.User;
import com.ey.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {

        User user = userRepository.findOneByUserMail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException("Email not found: " + userEmail));

        return new UserDetailsImpl(user);
    }
}
