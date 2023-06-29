package com.example.ProyectoFinal.services;

import com.example.ProyectoFinal.model.AppUser;
import com.example.ProyectoFinal.model.AppUserRole;
import com.example.ProyectoFinal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class AppUserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public AppUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        AppUser appUser = userRepository.findByEmail(email).get();

        Set<GrantedAuthority> grantList = new HashSet<GrantedAuthority>();

        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(appUser.getAppUserRole().toString());
        grantList.add(grantedAuthority);

        UserDetails user = (UserDetails) new User(email, appUser.getPassword(),grantList);

        return user;
    }
}
