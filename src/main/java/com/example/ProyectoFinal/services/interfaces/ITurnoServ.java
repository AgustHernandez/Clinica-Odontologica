package com.example.ProyectoFinal.services.interfaces;

import com.example.ProyectoFinal.DTO.VistaTurnos.TurnoDTO;
import com.example.ProyectoFinal.exceptions.ResourceNotFoundException;

import java.util.List;

public interface ITurnoServ {

    List<TurnoDTO> listarTurnos();
    TurnoDTO buscarTurno(Long id) throws ResourceNotFoundException;
    TurnoDTO agregarTurno(com.example.ProyectoFinal.model.Turno turno) throws ResourceNotFoundException;
    com.example.ProyectoFinal.model.Turno modificarTurno(com.example.ProyectoFinal.model.Turno turno);
    Boolean eliminarTurno(Long id) throws ResourceNotFoundException;
}
