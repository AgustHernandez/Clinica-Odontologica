package com.example.ProyectoFinal.services;

import com.example.ProyectoFinal.datos.OdontologoDAO;
import com.example.ProyectoFinal.model.AppUser;
import com.example.ProyectoFinal.model.AppUserRole;
import com.example.ProyectoFinal.repository.UserRepository;
import org.apache.log4j.Logger;
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
    private static final Logger logger = Logger.getLogger(AppUserService.class);

    @Autowired
    public AppUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        logger.debug("Cargando detalles del usuario");
        AppUser appUser = userRepository.findByEmail(email).get();
        logger.debug("Detalles de usuario "+appUser.getUsername()+" encontrados");
        Set<GrantedAuthority> grantList = new HashSet<GrantedAuthority>();
        logger.debug("Cargando privilegios para "+appUser.getUsername());
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(appUser.getAppUserRole().toString());
        grantList.add(grantedAuthority);
        logger.debug("Privilegios cargados para "+appUser.getUsername());
        UserDetails user = (UserDetails) new User(email, appUser.getPassword(),grantList);

        return user;
    }
}
