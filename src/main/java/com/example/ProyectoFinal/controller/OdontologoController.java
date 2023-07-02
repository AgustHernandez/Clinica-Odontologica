package com.example.ProyectoFinal.controller;

import com.example.ProyectoFinal.DTO.VistaOdontologos.OdontologoDTO;
import com.example.ProyectoFinal.model.Odontologo;
import com.example.ProyectoFinal.services.interfaces.IOdontologoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OdontologoController {

    private IOdontologoServ odontologoService;

    @Autowired
    public OdontologoController(IOdontologoServ odontologoService) {
        this.odontologoService = odontologoService;
    }

    @GetMapping("/odontologos")
    public ResponseEntity<List<OdontologoDTO>> listarOdontologos() {
        List<OdontologoDTO> result = odontologoService.listarOdontologos();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/odontologos/{id}")
    public ResponseEntity<OdontologoDTO> buscarOdontologos(@PathVariable Long id) {
        if (id == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(odontologoService.buscarOdontologo(id), HttpStatus.OK);
    }

    @PostMapping("/odontologos")
    public OdontologoDTO agregarOdontologos(@RequestBody Odontologo odontologo) {
        return odontologoService.agregarOdontologo(odontologo);
    }

    @PutMapping("/odontologos")
    public Odontologo modificarOdontologo(@RequestBody Odontologo odontologo) {
        return odontologoService.modificarOdontologo(odontologo);
    }

    @DeleteMapping("/odontologos/{id}")
    public Boolean eliminarOdontologo(@PathVariable Long id) {
        return odontologoService.eliminarOdontologo(id);
    }
}
