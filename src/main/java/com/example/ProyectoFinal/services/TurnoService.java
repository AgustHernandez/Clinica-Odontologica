package com.example.ProyectoFinal.services;

import com.example.ProyectoFinal.DTO.VistaTurnos.TurnoDTO;
import com.example.ProyectoFinal.datos.interfaces.IDao;
import com.example.ProyectoFinal.exceptions.ResourceNotFoundException;
import com.example.ProyectoFinal.model.Odontologo;
import com.example.ProyectoFinal.model.Paciente;
import com.example.ProyectoFinal.services.interfaces.ITurnoServ;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService implements ITurnoServ {

    private ObjectMapper mapper;
    private IDao<com.example.ProyectoFinal.model.Turno> turnoDao;
    private IDao<Odontologo> odontologoIDao;
    private IDao<Paciente> pacienteIDao;

    @Autowired
    public TurnoService(IDao<com.example.ProyectoFinal.model.Turno> turnoDao, IDao<Odontologo> odontologoIDao, IDao<Paciente> pacienteIDao) {
        this.turnoDao = turnoDao;
        this.odontologoIDao = odontologoIDao;
        this.pacienteIDao = pacienteIDao;
        this.mapper = new ObjectMapper();
    }

    @Override
    public List<TurnoDTO> listarTurnos() {
        List<com.example.ProyectoFinal.model.Turno> listaTurnos = turnoDao.listar();
        List<TurnoDTO> listaTurnosDTO = mapper.convertValue(listaTurnos, new TypeReference<List<TurnoDTO>>(){});
        return listaTurnosDTO;
    }

    @Override
    public TurnoDTO buscarTurno(Long id) throws ResourceNotFoundException {
        com.example.ProyectoFinal.model.Turno buscarTurno = turnoDao.buscar(id);
        TurnoDTO buscarTurnoDTODTO = mapper.convertValue(buscarTurno, TurnoDTO.class);
        return buscarTurnoDTODTO;
    }

    @Override
    public TurnoDTO agregarTurno(com.example.ProyectoFinal.model.Turno turno) throws ResourceNotFoundException {
        turno.setPaciente(pacienteIDao.buscar(turno.getPaciente().getId()));
        com.example.ProyectoFinal.model.Turno agregarTurno = turnoDao.agregar(turno);
        TurnoDTO agregarTurnoDTODTO = mapper.convertValue(agregarTurno, TurnoDTO.class);
        return agregarTurnoDTODTO;
    }

    @Override
    public com.example.ProyectoFinal.model.Turno modificarTurno(com.example.ProyectoFinal.model.Turno turno) {
        return turnoDao.modificar(turno);
    }

    @Override
    public Boolean eliminarTurno(Long id) throws ResourceNotFoundException {
        return turnoDao.eliminar(id);
    }
}
