package com.example.ProyectoFinal.services.interfaces;

import com.example.ProyectoFinal.DTO.VistaOdontologos.OdontologoDTO;
import com.example.ProyectoFinal.model.Odontologo;

import java.util.List;

public interface IOdontologoServ {

    List<OdontologoDTO> listarOdontologos();

    OdontologoDTO agregarOdontologo(Odontologo odontologo);

    OdontologoDTO buscarOdontologo(Long id);

    Odontologo modificarOdontologo(Odontologo odontologo);

    Boolean eliminarOdontologo(Long id);
}
