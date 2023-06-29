package com.example.ProyectoFinal.controller;

import com.example.ProyectoFinal.DTO.PacienteDTO;
import com.example.ProyectoFinal.model.Paciente;
import com.example.ProyectoFinal.services.interfaces.IPacienteServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class PacienteController {

    private IPacienteServ pacienteService;

    @Autowired
    public PacienteController(IPacienteServ pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/pacientes")
    public ResponseEntity<List<PacienteDTO>> listarPacientes() {
        return new ResponseEntity<>(pacienteService.listarPacientes(), HttpStatus.OK);
    }

    @GetMapping("/pacientes/{id}")
    public ResponseEntity<PacienteDTO> buscarPaciente(@PathVariable Long id) {
        if (id == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(pacienteService.buscarPaciente(id), HttpStatus.OK);
    }

    @PostMapping("/pacientes")
    public PacienteDTO agregarPaciente(@RequestBody Paciente paciente) {
        return pacienteService.agregarPaciente(paciente);
    }

    @PutMapping("/pacientes")
    public Paciente modificarPaciente(@RequestBody Paciente paciente) {
        return pacienteService.modificarPaciente(paciente);
    }

    @DeleteMapping("/pacientes/{id}")
    public Boolean eliminarPaciente(@PathVariable Long id) {
        return pacienteService.eliminarPaciente(id);
    }
}
