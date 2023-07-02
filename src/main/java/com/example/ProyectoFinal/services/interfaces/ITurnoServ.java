package com.example.ProyectoFinal.services.interfaces;

import com.example.ProyectoFinal.DTO.VistaTurnos.TurnoDTO;

import java.util.List;

public interface ITurnoServ {

    List<TurnoDTO> listarTurnos();
    TurnoDTO buscarTurno(Long id);
    TurnoDTO agregarTurno(com.example.ProyectoFinal.model.Turno turno);
    com.example.ProyectoFinal.model.Turno modificarTurno(com.example.ProyectoFinal.model.Turno turno);
    Boolean eliminarTurno(Long id);
}
