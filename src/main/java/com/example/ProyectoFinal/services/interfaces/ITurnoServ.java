package com.example.ProyectoFinal.services.interfaces;

import com.example.ProyectoFinal.DTO.VistaTurnos.TurnoDTO;
import com.example.ProyectoFinal.exceptions.InvalidRequestException;
import com.example.ProyectoFinal.exceptions.ResourceNotFoundException;
import com.example.ProyectoFinal.model.Turno;

import java.util.List;

public interface ITurnoServ {

    List<TurnoDTO> listarTurnos(Long odontologoId) throws ResourceNotFoundException;
    TurnoDTO buscarTurno(Long odontologoId,Long idTurno) throws ResourceNotFoundException;
    TurnoDTO agregarTurno(Long odontologoId,Turno turno) throws ResourceNotFoundException, InvalidRequestException;
    TurnoDTO modificarTurno(Long odontologoId,Turno turno) throws ResourceNotFoundException;
    Boolean eliminarTurno(Long odontologoId,Turno turno) throws ResourceNotFoundException;
}
