package com.example.ProyectoFinal.controller;

import com.example.ProyectoFinal.DTO.VistaPacientes.PacienteDTO;
import com.example.ProyectoFinal.exceptions.DuplicatedElementException;
import com.example.ProyectoFinal.exceptions.ElementAlreadyExistsException;
import com.example.ProyectoFinal.exceptions.ResourceNotFoundException;
import com.example.ProyectoFinal.model.Paciente;
import com.example.ProyectoFinal.services.interfaces.IPacienteServ;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class PacienteController {

    private IPacienteServ pacienteService;
    private static final Logger logger = Logger.getLogger(PacienteController.class);

    @Autowired
    public PacienteController(IPacienteServ pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/pacientes")
    public ResponseEntity<List<PacienteDTO>> listarPacientes() {
        logger.info("GET /pacientes");
        return new ResponseEntity<>(pacienteService.listarPacientes(), HttpStatus.OK);
    }

    @GetMapping("/pacientes/{id}")
    public ResponseEntity<PacienteDTO> buscarPaciente(@PathVariable Long id) throws ResourceNotFoundException {
        logger.info("GET /pacientes/"+id);
        return new ResponseEntity<>(pacienteService.buscarPaciente(id), HttpStatus.OK);
    }

    @PostMapping("/pacientes")
    public PacienteDTO agregarPaciente(@RequestBody Paciente paciente) throws ElementAlreadyExistsException {
        logger.info("POST /pacientes");
        return pacienteService.agregarPaciente(paciente);
    }

    @PutMapping("/pacientes")
    public PacienteDTO modificarPaciente(@RequestBody Paciente paciente) throws ResourceNotFoundException, DuplicatedElementException {
        logger.info("PUT /pacientes");
        return pacienteService.modificarPaciente(paciente);
    }

    @DeleteMapping("/pacientes/{id}")
    public Boolean eliminarPaciente(@PathVariable Long id) throws ResourceNotFoundException {
        logger.info("DELETE /pacientes/"+id);
        return pacienteService.eliminarPaciente(id);
    }
}
