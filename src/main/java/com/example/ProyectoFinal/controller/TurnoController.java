package com.example.ProyectoFinal.controller;

import com.example.ProyectoFinal.DTO.VistaTurnos.TurnoDTO;
import com.example.ProyectoFinal.services.interfaces.ITurnoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class TurnoController {

    private ITurnoServ turnoService;

    @Autowired
    public TurnoController(ITurnoServ turnoService) {
        this.turnoService = turnoService;
    }

    @GetMapping("/turnos")
    public ResponseEntity<List<TurnoDTO>> listarTurnos() {
        return new ResponseEntity<>(turnoService.listarTurnos(), HttpStatus.OK);
    }

    @GetMapping("/turnos/{id}")
    public ResponseEntity<TurnoDTO> buscarTurno(@PathVariable Long id) {
        if (id == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(turnoService.buscarTurno(id), HttpStatus.OK);
    }

    @PostMapping("/turnos")
    public ResponseEntity<TurnoDTO> agregarTurno(@RequestBody com.example.ProyectoFinal.model.Turno turno) {
        TurnoDTO result = turnoService.agregarTurno(turno);
        if(result == null)
            return ResponseEntity.badRequest().build();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @PutMapping("/turnos")
    public com.example.ProyectoFinal.model.Turno modificarTurno(@RequestBody com.example.ProyectoFinal.model.Turno turno) {
        return turnoService.modificarTurno(turno);
    }

    @DeleteMapping("/turnos/{id}")
    public Boolean eliminarTurno(@PathVariable Long id) {
        return turnoService.eliminarTurno(id);
    }

}
