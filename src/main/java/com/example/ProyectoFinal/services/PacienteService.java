package com.example.ProyectoFinal.services;

import com.example.ProyectoFinal.DTO.VistaPacientes.PacienteDTO;
import com.example.ProyectoFinal.datos.OdontologoDAO;
import com.example.ProyectoFinal.datos.interfaces.IDao;
import com.example.ProyectoFinal.exceptions.DuplicatedElementException;
import com.example.ProyectoFinal.exceptions.ElementAlreadyExistsException;
import com.example.ProyectoFinal.exceptions.ResourceNotFoundException;
import com.example.ProyectoFinal.model.Paciente;
import com.example.ProyectoFinal.services.interfaces.IPacienteServ;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PacienteService implements IPacienteServ {

    private ObjectMapper mapper;
    private IDao<Paciente> pacienteDao;
    private static final Logger logger = Logger.getLogger(PacienteService.class);

    @Autowired
    public PacienteService(IDao<Paciente> pacienteDao) {
        this.pacienteDao = pacienteDao;
        this.mapper = new ObjectMapper();
    }

    @Override
    public List<PacienteDTO> listarPacientes() {
        logger.info("Listado de pacientes solicitado");
        List<Paciente> listaPacientes = pacienteDao.listar();
        List<PacienteDTO> listaPacientesDTO = mapper.convertValue(listaPacientes, new TypeReference<List<PacienteDTO>>(){});
        return listaPacientesDTO;
    }

    @Override
    public PacienteDTO agregarPaciente(Paciente paciente) throws ElementAlreadyExistsException {
        logger.info("Inserción de paciente solicitada");
        Paciente agregarPaciente = pacienteDao.agregar(paciente);
        PacienteDTO agregarPacienteDTODTO = mapper.convertValue(agregarPaciente, PacienteDTO.class);
        return agregarPacienteDTODTO;
    }

    @Override
    public PacienteDTO buscarPaciente(Long id) throws ResourceNotFoundException {
        logger.info("Busqueda de paciente solicitada");
        Paciente buscarPaciente = pacienteDao.buscar(id);
        PacienteDTO buscarPacienteDTODTO = mapper.convertValue(buscarPaciente, PacienteDTO.class);
        return buscarPacienteDTODTO;
    }

    @Override
    public PacienteDTO modificarPaciente(Paciente paciente) throws ResourceNotFoundException, DuplicatedElementException {
        logger.info("Modificación de paciente solicitada");
        Paciente pacienteModificado = pacienteDao.modificar(paciente,false);
        PacienteDTO pacienteDTO = mapper.convertValue(pacienteModificado, PacienteDTO.class);
        return pacienteDTO;
    }

    @Override
    public Boolean eliminarPaciente(Long id) throws ResourceNotFoundException {
        logger.info("Eliminación de paciente solicitada");
        return pacienteDao.eliminar(id);
    }
}
