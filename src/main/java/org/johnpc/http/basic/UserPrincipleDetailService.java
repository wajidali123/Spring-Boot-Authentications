package org.johnpc.http.basic;


import org.johnpc.http.basic.model.User;
import org.johnpc.http.basic.repo.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipleDetailService implements UserDetailsService {

    private UserRepository userRepository;
    public UserPrincipleDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(s);
        UserPrinciple userPrinciple = new UserPrinciple(user);
        return userPrinciple;
    }
}
