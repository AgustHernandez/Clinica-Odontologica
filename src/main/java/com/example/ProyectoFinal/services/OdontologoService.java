package com.example.ProyectoFinal.services;

import com.example.ProyectoFinal.DTO.VistaOdontologos.OdontologoDTO;
import com.example.ProyectoFinal.datos.interfaces.IDao;
import com.example.ProyectoFinal.model.Odontologo;
import com.example.ProyectoFinal.services.interfaces.IOdontologoServ;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService implements IOdontologoServ {

    private ObjectMapper mapper;
    IDao<Odontologo> odontologoDao;

    @Autowired
    public OdontologoService(IDao<Odontologo> odontologoDao) {
        this.odontologoDao = odontologoDao;
        this.mapper = new ObjectMapper();
    }

    @Override
    public List<OdontologoDTO> listarOdontologos() {
        List<Odontologo> listaOdontologos = odontologoDao.listar();
        List<OdontologoDTO> listaOdontologosDTO = mapper.convertValue(listaOdontologos,new TypeReference<List<OdontologoDTO>>(){});
        return listaOdontologosDTO;
    }

    @Override
    public OdontologoDTO agregarOdontologo(Odontologo odontologo) {
        Odontologo agregarOdontologo = odontologoDao.agregar(odontologo);
        OdontologoDTO agregarOdontologoDTO = mapper.convertValue(agregarOdontologo,OdontologoDTO.class);
        return agregarOdontologoDTO;
    }

    @Override
    public OdontologoDTO buscarOdontologo(Long id) {
        Odontologo buscarOdontologo = odontologoDao.buscar(id);
        OdontologoDTO buscarOdontologoDTO = mapper.convertValue(buscarOdontologo,OdontologoDTO.class);
        return buscarOdontologoDTO;
    }

    @Override
    public Odontologo modificarOdontologo(Odontologo odontologo) {
        return odontologoDao.modificar(odontologo);
    }

    @Override
    public Boolean eliminarOdontologo(Long id) {
        return odontologoDao.eliminar(id);
    }
}
