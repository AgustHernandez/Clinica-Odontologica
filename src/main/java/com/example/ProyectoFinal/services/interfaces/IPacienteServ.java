package com.example.ProyectoFinal.services.interfaces;

import com.example.ProyectoFinal.DTO.VistaPacientes.PacienteDTO;
import com.example.ProyectoFinal.exceptions.DuplicatedElementException;
import com.example.ProyectoFinal.exceptions.ElementAlreadyExistsException;
import com.example.ProyectoFinal.exceptions.ResourceNotFoundException;
import com.example.ProyectoFinal.model.Paciente;

import java.util.List;

public interface IPacienteServ {

    List<PacienteDTO> listarPacientes();
    PacienteDTO buscarPaciente(Long id) throws ResourceNotFoundException;
    PacienteDTO agregarPaciente(Paciente paciente) throws ElementAlreadyExistsException;
    PacienteDTO modificarPaciente(Paciente paciente) throws ResourceNotFoundException, DuplicatedElementException;
    Boolean eliminarPaciente(Long id) throws ResourceNotFoundException;
}
