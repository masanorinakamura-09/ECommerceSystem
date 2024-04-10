package com.ec.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ec.entity.Authentication;
import com.ec.repository.AuthenticationRepository;

@Service
public class CustomerDetailService implements UserDetailsService {

    private final AuthenticationRepository authenticationrepository;
    public CustomerDetailService(AuthenticationRepository authenticationrepository) {
        this.authenticationrepository = authenticationrepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Authentication> authentication=authenticationrepository.findById(username);

        if(!authentication.isPresent()) {
            throw new UsernameNotFoundException("Exception:Username Not Found");
        }
        return new CustomerDetail(authentication.get().getCustomer());
    }

}
