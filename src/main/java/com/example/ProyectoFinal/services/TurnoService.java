package com.example.ProyectoFinal.services;

import com.example.ProyectoFinal.DTO.TurnoDTO;
import com.example.ProyectoFinal.datos.interfaces.IDao;
import com.example.ProyectoFinal.model.Odontologo;
import com.example.ProyectoFinal.model.Paciente;
import com.example.ProyectoFinal.model.Turno;
import com.example.ProyectoFinal.services.interfaces.ITurnoServ;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService implements ITurnoServ {

    private ObjectMapper mapper;
    private IDao<Turno> turnoDao;
    private IDao<Odontologo> odontologoIDao;
    private IDao<Paciente> pacienteIDao;

    @Autowired
    public TurnoService(IDao<Turno> turnoDao, IDao<Odontologo> odontologoIDao,IDao<Paciente> pacienteIDao) {
        this.turnoDao = turnoDao;
        this.odontologoIDao = odontologoIDao;
        this.pacienteIDao = pacienteIDao;
        this.mapper = new ObjectMapper();
    }

    @Override
    public List<TurnoDTO> listarTurnos() {
        List<Turno> listaTurnos = turnoDao.listar();
        List<TurnoDTO> listaTurnosDTO = mapper.convertValue(listaTurnos, new TypeReference<List<TurnoDTO>>(){});
        return listaTurnosDTO;
    }

    @Override
    public TurnoDTO buscarTurno(Long id) {
        Turno buscarTurno = turnoDao.buscar(id);
        TurnoDTO buscarTurnoDTO = mapper.convertValue(buscarTurno,TurnoDTO.class);
        return buscarTurnoDTO;
    }

    @Override
    public TurnoDTO agregarTurno(Turno turno) {
        turno.setOdontologo(odontologoIDao.buscar(turno.getOdontologo().getId()));
        turno.setPaciente(pacienteIDao.buscar(turno.getPaciente().getId()));
        Turno agregarTurno = turnoDao.agregar(turno);
        TurnoDTO agregarTurnoDTO = mapper.convertValue(agregarTurno,TurnoDTO.class);
        return agregarTurnoDTO;
    }

    @Override
    public Turno modificarTurno(Turno turno) {
        return turnoDao.modificar(turno);
    }

    @Override
    public Boolean eliminarTurno(Long id) {
        return turnoDao.eliminar(id);
    }
}
