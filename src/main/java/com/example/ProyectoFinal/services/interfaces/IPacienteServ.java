package com.example.ProyectoFinal.services.interfaces;

import com.example.ProyectoFinal.DTO.VistaPacientes.PacienteDTO;

import java.util.List;

public interface IPacienteServ {

    List<PacienteDTO> listarPacientes();
    PacienteDTO buscarPaciente(Long id);
    PacienteDTO agregarPaciente(com.example.ProyectoFinal.model.Paciente paciente);
    com.example.ProyectoFinal.model.Paciente modificarPaciente(com.example.ProyectoFinal.model.Paciente paciente);
    Boolean eliminarPaciente(Long id);
}
