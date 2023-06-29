package com.example.ProyectoFinal.services.interfaces;

import com.example.ProyectoFinal.DTO.PacienteDTO;
import com.example.ProyectoFinal.model.Paciente;

import java.util.List;

public interface IPacienteServ {

    List<PacienteDTO> listarPacientes();
    PacienteDTO buscarPaciente(Long id);
    PacienteDTO agregarPaciente(Paciente paciente);
    Paciente modificarPaciente(Paciente paciente);
    Boolean eliminarPaciente(Long id);
}
