package com.example.ProyectoFinal.services;

import com.example.ProyectoFinal.DTO.VistaTurnos.TurnoDTO;
import com.example.ProyectoFinal.datos.interfaces.IDao;
import com.example.ProyectoFinal.exceptions.InvalidRequestException;
import com.example.ProyectoFinal.exceptions.ResourceNotFoundException;
import com.example.ProyectoFinal.model.Odontologo;
import com.example.ProyectoFinal.model.Paciente;
import com.example.ProyectoFinal.model.Turno;
import com.example.ProyectoFinal.services.interfaces.ITurnoServ;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TurnoService implements ITurnoServ {

    private ObjectMapper mapper;
    private IDao<Turno> turnoDao;
    private IDao<Odontologo> odontologoIDao;
    private IDao<Paciente> pacienteIDao;

    @Autowired
    public TurnoService(IDao<Turno> turnoDao, IDao<Odontologo> odontologoIDao, IDao<Paciente> pacienteIDao) {
        this.turnoDao = turnoDao;
        this.odontologoIDao = odontologoIDao;
        this.pacienteIDao = pacienteIDao;
        this.mapper = new ObjectMapper();
    }

    @Override
    public List<TurnoDTO> listarTurnos(Long odontologoId) throws ResourceNotFoundException {
        List<Turno> listaTurnos = odontologoIDao.buscar(odontologoId).getTurnos().stream().toList();
        List<TurnoDTO> listaTurnosDTO = mapper.convertValue(listaTurnos, new TypeReference<List<TurnoDTO>>(){});
        return listaTurnosDTO;
    }

    @Override
    public TurnoDTO buscarTurno(Long odontologoId,Long idTurno) throws ResourceNotFoundException {
        Turno turnoObtenido = odontologoIDao.buscar(odontologoId).getTurnos().stream().filter(t ->
                t.getId().equals(idTurno)
        ).findFirst().get();
        TurnoDTO turnoDTO = mapper.convertValue(turnoObtenido, TurnoDTO.class);
        return turnoDTO;
    }

    @Override
    public TurnoDTO agregarTurno(Long odontologoId,Turno turno) throws ResourceNotFoundException, InvalidRequestException {
        if(turno.getFecha() == null  || turno.getPaciente() == null)
        {
            throw new InvalidRequestException("Parametros insuficientes para crear un nuevo turno.");
        }
        turno.setPaciente(pacienteIDao.buscar(turno.getPaciente().getId()));
        Odontologo odontologo = odontologoIDao.buscar(odontologoId);
        odontologo.getTurnos().add(turno);
        odontologoIDao.modificar(odontologo);
        TurnoDTO turnoDTO = mapper.convertValue(odontologo.getTurnos().stream().filter(t -> t.getFecha().equals(turno.getFecha())).findFirst().get()
                , TurnoDTO.class);
        return turnoDTO;
    }

    @Override
    public TurnoDTO modificarTurno(Long odontologoId,Turno turno) throws ResourceNotFoundException {
        Odontologo odontologo = odontologoIDao.buscar(odontologoId);
        odontologo.getTurnos().stream().filter(t ->
                t.getFecha().toInstant().equals(turno.getFecha().toInstant())
        ).findFirst().get().setPaciente(pacienteIDao.buscar(turno.getPaciente().getId()));
        odontologoIDao.modificar(odontologo);

        return mapper.convertValue(odontologo.getTurnos().stream().filter(t ->
                t.getFecha().toInstant().equals(turno.getFecha().toInstant())
        ).findFirst().get(), TurnoDTO.class);
    }

    @Override
    public Boolean eliminarTurno(Long odontologoId,Turno turno) throws ResourceNotFoundException {
        Odontologo odontologo = odontologoIDao.buscar(odontologoId);
        odontologo.getTurnos().stream().filter(t ->
                t.getFecha().toInstant().equals(turno.getFecha().toInstant())
        ).findFirst().get().setPaciente(null);
        odontologoIDao.modificar(odontologo);
        return true;
    }
}
