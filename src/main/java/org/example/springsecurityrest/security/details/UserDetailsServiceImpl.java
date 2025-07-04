package org.example.springsecurityrest.security.details;

import lombok.RequiredArgsConstructor;
import org.example.springsecurityrest.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return new UserDetailsImpl(userRepository
                .findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User " + email + " not found")));
    }

}
