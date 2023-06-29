package com.example.ProyectoFinal.security;

import com.example.ProyectoFinal.model.AppUser;
import com.example.ProyectoFinal.model.AppUserRole;
import com.example.ProyectoFinal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner  {
    private UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void run(ApplicationArguments args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("sa");
        BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
        String password2 = passwordEncoder2.encode("sa");
        userRepository.save(new AppUser("Agustina", "agustina", "agustina@digital.com", password, AppUserRole.ROLE_ADMIN));
        userRepository.save(new AppUser("Emiliano", "emiliano", "emiliano@digital.com", password2, AppUserRole.ROLE_USER));
    }

}
