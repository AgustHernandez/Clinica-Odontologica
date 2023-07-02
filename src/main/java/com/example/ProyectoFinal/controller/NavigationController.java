package com.example.ProyectoFinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {
    @GetMapping("/index")
    public String index() {
        return "index";
    }
    @GetMapping("/odontologos")
    public String odontologos() {
        return "odontologos";
    }

    @GetMapping("/odontologos/alta")
    public String odontologoAlta() {
        return "altaOdontologo";
    }

    @GetMapping("/pacientes")
    public String pacientes() {
        return "pacientes";
    }

    @GetMapping("/pacientes/alta")
    public String pacienteAlta() {
        return "altaPaciente";
    }

    @GetMapping("/turnos")
    public String turnos() {
        return "turnos";
    }

    @GetMapping("/turnos/alta")
    public String turnoAlta() {
        return "altaTurno";
    }
}
