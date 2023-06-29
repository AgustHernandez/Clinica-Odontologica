package com.example.ProyectoFinal.services.interfaces;

import com.example.ProyectoFinal.DTO.TurnoDTO;
import com.example.ProyectoFinal.model.Turno;

import java.util.List;

public interface ITurnoServ {

    List<TurnoDTO> listarTurnos();
    TurnoDTO buscarTurno(Long id);
    TurnoDTO agregarTurno(Turno turno);
    Turno modificarTurno(Turno turno);
    Boolean eliminarTurno(Long id);
}
