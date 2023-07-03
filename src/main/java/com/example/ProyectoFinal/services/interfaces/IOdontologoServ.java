package com.example.ProyectoFinal.services.interfaces;

import com.example.ProyectoFinal.DTO.VistaOdontologos.OdontologoDTO;
import com.example.ProyectoFinal.exceptions.ElementAlreadyExistsException;
import com.example.ProyectoFinal.exceptions.ResourceNotFoundException;
import com.example.ProyectoFinal.model.Odontologo;

import java.util.List;

public interface IOdontologoServ {

    List<OdontologoDTO> listarOdontologos();

    OdontologoDTO agregarOdontologo(Odontologo odontologo) throws ElementAlreadyExistsException;

    OdontologoDTO buscarOdontologo(Long id) throws ResourceNotFoundException;

    OdontologoDTO modificarOdontologo(Odontologo odontologo) throws ResourceNotFoundException;

    Boolean eliminarOdontologo(Long id) throws ResourceNotFoundException;
}
