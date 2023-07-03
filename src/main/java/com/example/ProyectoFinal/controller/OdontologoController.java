package com.example.ProyectoFinal.controller;

import com.example.ProyectoFinal.DTO.VistaOdontologos.OdontologoDTO;
import com.example.ProyectoFinal.DTO.VistaTurnos.TurnoDTO;
import com.example.ProyectoFinal.exceptions.ResourceNotFoundException;
import com.example.ProyectoFinal.model.Odontologo;
import com.example.ProyectoFinal.services.interfaces.IOdontologoServ;
import com.example.ProyectoFinal.services.interfaces.ITurnoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OdontologoController {

    private IOdontologoServ odontologoService;
    private ITurnoServ turnoService;

    @Autowired
    public OdontologoController(IOdontologoServ odontologoService, ITurnoServ turnoService) {
        this.odontologoService = odontologoService;
        this.turnoService = turnoService;
    }

    @GetMapping("/odontologos")
    public ResponseEntity<List<OdontologoDTO>> listarOdontologos() {
        List<OdontologoDTO> result = odontologoService.listarOdontologos();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/odontologos/{id}")
    public ResponseEntity<OdontologoDTO> buscarOdontologos(@PathVariable Long id) throws ResourceNotFoundException, NumberFormatException {
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
    public Boolean eliminarOdontologo(@PathVariable Long id) throws ResourceNotFoundException, NumberFormatException {
        return odontologoService.eliminarOdontologo(id);
    }

    /*@GetMapping("/odontologos/{id}/turnos")
    public ResponseEntity<TurnoDTO> buscarTurno(@PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(turnoService.buscarTurno(id), HttpStatus.OK);
    }

    @PostMapping("/odontologos/{id}/turnos")
    public ResponseEntity<TurnoDTO> agregarTurno(@PathVariable Long idOdontologo, @RequestBody Date fechaTurno) throws ResourceNotFoundException {
        TurnoDTO result = turnoService.agregarTurno(turno);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @PutMapping("/odontologos/{id}/turnos")
    public ResponseEntity<TurnoDTO> agregarTurno(@PathVariable Long idOdontologo, @RequestBody Date fechaTurno) throws ResourceNotFoundException {
        TurnoDTO result = turnoService.agregarTurno(turno);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @DeleteMapping("/turnos/{id}")
    public Boolean eliminarTurno(@PathVariable Long id) throws ResourceNotFoundException {
        return turnoService.eliminarTurno(id);
    }*/
}
