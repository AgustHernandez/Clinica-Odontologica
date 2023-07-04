package com.example.ProyectoFinal.security;

import com.example.ProyectoFinal.model.*;
import com.example.ProyectoFinal.repository.IOdontologoRepository;
import com.example.ProyectoFinal.repository.IPacienteRepository;
import com.example.ProyectoFinal.repository.ITurnoRepository;
import com.example.ProyectoFinal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner  {
    private UserRepository userRepository;
    private IOdontologoRepository odontologoRepository;
    private IPacienteRepository pacienteRepository;
    private ITurnoRepository turnoRepository;

    @Value("${custom.initializeData}")
    private Boolean initializeData;

    @Autowired
    public DataLoader(UserRepository userRepository, IOdontologoRepository odontologoRepository, IPacienteRepository pacienteRepository, ITurnoRepository turnoRepository) {
        this.userRepository = userRepository;
        this.odontologoRepository = odontologoRepository;
        this.pacienteRepository = pacienteRepository;
        this.turnoRepository = turnoRepository;
    }

    public void run(ApplicationArguments args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("sa");
        BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
        String password2 = passwordEncoder2.encode("sa");
        userRepository.save(new AppUser("Admin", "Admin", "admin@digital.com", password, AppUserRole.ROLE_ADMIN));
        userRepository.save(new AppUser("User", "User", "user@digital.com", password2, AppUserRole.ROLE_USER));
        if(initializeData) {
            //Creacion de odontologos ejemplo
            odontologoRepository.save(new Odontologo("Hernandez", "Agustina", "879456"));
            odontologoRepository.save(new Odontologo("Lopez", "Javier", "123658"));
            //Creacion de pacientes ejemplo
            pacienteRepository.save(new Paciente("Martinez", "Alberto", new Direccion("Av. Montes de Oca", "459", "CABA","Buenos Aires"),"25478945"));
            pacienteRepository.save(new Paciente("Martinez", "Leandro", new Direccion("Av. Montes de Oca", "459", "CABA","Buenos Aires"),"32124543"));
            pacienteRepository.save(new Paciente("Ramirez", "Juan", new Direccion("Av. Santa Fe", "4217", "CABA","Buenos Aires"),"38784547"));
            pacienteRepository.save(new Paciente("Fernandez", "Agustina", new Direccion("Vicente Lopez", "1354", "CABA","Buenos Aires"),"39874578"));
            pacienteRepository.save(new Paciente("Gonzalez", "Lucia", new Direccion("Av. Pavon", "3654", "Avellaneda","Buenos Aires"),"36457878"));
            pacienteRepository.save(new Paciente("Martinez", "Maria", new Direccion("El Pato", "147", "Cordoba","Cordoba"),"35478745"));
            //Creacion de turnos ejemplo

        }
    }



    }
