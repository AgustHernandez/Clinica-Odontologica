package com.example.ProyectoFinal.services;

import com.example.ProyectoFinal.DTO.VistaPacientes.PacienteDTO;
import com.example.ProyectoFinal.datos.interfaces.IDao;
import com.example.ProyectoFinal.model.Paciente;
import com.example.ProyectoFinal.services.interfaces.IPacienteServ;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PacienteService implements IPacienteServ {

    private ObjectMapper mapper;
    private IDao<Paciente> pacienteDao;

    @Autowired
    public PacienteService(IDao<Paciente> pacienteDao) {
        this.pacienteDao = pacienteDao;
        this.mapper = new ObjectMapper();
    }

    @Override
    public List<PacienteDTO> listarPacientes() {
        List<Paciente> listaPacientes = pacienteDao.listar();
        List<PacienteDTO> listaPacientesDTO = mapper.convertValue(listaPacientes, new TypeReference<List<PacienteDTO>>(){});
        return listaPacientesDTO;
    }

    @Override
    public PacienteDTO agregarPaciente(Paciente paciente) {
        Paciente agregarPaciente = pacienteDao.agregar(paciente);
        PacienteDTO agregarPacienteDTODTO = mapper.convertValue(agregarPaciente, PacienteDTO.class);
        return agregarPacienteDTODTO;
    }

    @Override
    public PacienteDTO buscarPaciente(Long id) {
        Paciente buscarPaciente = pacienteDao.buscar(id);
        PacienteDTO buscarPacienteDTODTO = mapper.convertValue(buscarPaciente, PacienteDTO.class);
        return buscarPacienteDTODTO;
    }

    @Override
    public Paciente modificarPaciente(Paciente paciente) {
        return pacienteDao.modificar(paciente);
    }

    @Override
    public Boolean eliminarPaciente(Long id) {
        return pacienteDao.eliminar(id);
    }
}
