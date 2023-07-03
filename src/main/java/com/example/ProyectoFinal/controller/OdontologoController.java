package com.example.ProyectoFinal.controller;

import com.example.ProyectoFinal.DTO.VistaOdontologos.OdontologoDTO;
import com.example.ProyectoFinal.DTO.VistaTurnos.TurnoDTO;
import com.example.ProyectoFinal.exceptions.InvalidRequestException;
import com.example.ProyectoFinal.exceptions.ResourceNotFoundException;
import com.example.ProyectoFinal.model.Odontologo;
import com.example.ProyectoFinal.model.Turno;
import com.example.ProyectoFinal.repository.IPacienteRepository;
import com.example.ProyectoFinal.services.interfaces.IOdontologoServ;
import com.example.ProyectoFinal.services.interfaces.IPacienteServ;
import com.example.ProyectoFinal.services.interfaces.ITurnoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OdontologoController {

    private IOdontologoServ odontologoService;
    private ITurnoServ turnoService;
    private IPacienteServ pacienteServ;

    @Autowired
    public OdontologoController(IOdontologoServ odontologoService, ITurnoServ turnoService,IPacienteServ pacienteServ) {
        this.odontologoService = odontologoService;
        this.turnoService = turnoService;
        this.pacienteServ = pacienteServ;
    }

    @GetMapping("/odontologos")
    public ResponseEntity<List<OdontologoDTO>> listarOdontologos() {
        List<OdontologoDTO> result = odontologoService.listarOdontologos();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/odontologos/{idOdontologo}")
    public ResponseEntity<OdontologoDTO> buscarOdontologos(@PathVariable Long idOdontologo) throws ResourceNotFoundException, NumberFormatException {
        return new ResponseEntity<>(odontologoService.buscarOdontologo(idOdontologo), HttpStatus.OK);
    }

    @PostMapping("/odontologos")
    public OdontologoDTO agregarOdontologos(@RequestBody Odontologo odontologo) {
        return odontologoService.agregarOdontologo(odontologo);
    }

    @PutMapping("/odontologos")
    public OdontologoDTO modificarOdontologo(@RequestBody Odontologo odontologo) {
        return odontologoService.modificarOdontologo(odontologo);
    }

    @DeleteMapping("/odontologos/{idOdontologo}")
    public Boolean eliminarOdontologo(@PathVariable Long idOdontologo) throws ResourceNotFoundException, NumberFormatException {
        return odontologoService.eliminarOdontologo(idOdontologo);
    }

    @GetMapping("/odontologo/{idOdontologo}/turnos")
    public ResponseEntity<List<TurnoDTO>> buscarTurnos(@PathVariable Long idOdontologo) throws ResourceNotFoundException {
        return new ResponseEntity<>(turnoService.listarTurnos(idOdontologo), HttpStatus.OK);
    }

    @GetMapping("/odontologo/{idOdontologo}/turno/{idTurno}")
    public ResponseEntity<TurnoDTO> buscarTurno(@PathVariable Long idOdontologo, @PathVariable Long idTurno) throws ResourceNotFoundException {
        return new ResponseEntity<>(turnoService.buscarTurno(idOdontologo, idTurno), HttpStatus.OK);
    }

    @PutMapping("/odontologo/{idOdontologo}/turnos")
    public ResponseEntity<TurnoDTO> modificarTurno(@PathVariable Long idOdontologo, @RequestBody Turno turno) throws ResourceNotFoundException {
        TurnoDTO result = turnoService.modificarTurno(idOdontologo,turno);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @PostMapping("/odontologo/{idOdontologo}/turnos")
    public ResponseEntity<TurnoDTO> agregarTurno(@PathVariable Long idOdontologo, @RequestBody Turno turno) throws ResourceNotFoundException, InvalidRequestException {
        TurnoDTO result = turnoService.agregarTurno(idOdontologo, turno);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
    @DeleteMapping("/odontologo/{idOdontologo}/turnos")
    public ResponseEntity<Boolean> eliminarTurno(@PathVariable Long idOdontologo,@RequestBody Turno turno) throws ResourceNotFoundException {
        return new ResponseEntity<>(turnoService.eliminarTurno(idOdontologo, turno), HttpStatus.OK);
    }
}
