package com.example.ProyectoFinal.services;

import com.example.ProyectoFinal.DTO.VistaOdontologos.OdontologoDTO;
import com.example.ProyectoFinal.datos.OdontologoDAO;
import com.example.ProyectoFinal.datos.interfaces.IDao;
import com.example.ProyectoFinal.exceptions.DuplicatedElementException;
import com.example.ProyectoFinal.exceptions.ElementAlreadyExistsException;
import com.example.ProyectoFinal.exceptions.ResourceNotFoundException;
import com.example.ProyectoFinal.model.Odontologo;
import com.example.ProyectoFinal.services.interfaces.IOdontologoServ;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService implements IOdontologoServ {

    private ObjectMapper mapper;
    private static final Logger logger = Logger.getLogger(OdontologoService.class);
    IDao<Odontologo> odontologoDao;

    @Autowired
    public OdontologoService(IDao<Odontologo> odontologoDao) {
        this.odontologoDao = odontologoDao;
        this.mapper = new ObjectMapper();
    }

    @Override
    public List<OdontologoDTO> listarOdontologos() {
        logger.info("Listado de odontologos solicitado");
        List<Odontologo> listaOdontologos = odontologoDao.listar();
        List<OdontologoDTO> listaOdontologosDTO = mapper.convertValue(listaOdontologos,new TypeReference<List<OdontologoDTO>>(){});
        return listaOdontologosDTO;
    }

    @Override
    public OdontologoDTO agregarOdontologo(Odontologo odontologo) throws ElementAlreadyExistsException {
        logger.info("Inserción de odontologo solicitada");
        Odontologo agregarOdontologo = odontologoDao.agregar(odontologo);
        OdontologoDTO agregarOdontologoDTO = mapper.convertValue(agregarOdontologo,OdontologoDTO.class);
        return agregarOdontologoDTO;
    }

    @Override
    public OdontologoDTO buscarOdontologo(Long id) throws ResourceNotFoundException {
        logger.info("Busqueda de odontologo solicitada");
        Odontologo buscarOdontologo = odontologoDao.buscar(id);
        OdontologoDTO buscarOdontologoDTO = mapper.convertValue(buscarOdontologo,OdontologoDTO.class);
        return buscarOdontologoDTO;
    }

    @Override
    public OdontologoDTO modificarOdontologo(Odontologo odontologo) throws ResourceNotFoundException, DuplicatedElementException {
        logger.info("Modificación de odontologo solicitada");
        Odontologo odontologoModificado = odontologoDao.modificar(odontologo,false);
        OdontologoDTO odontologoDTO = mapper.convertValue(odontologoModificado,OdontologoDTO.class);
        return odontologoDTO;
    }

    @Override
    public Boolean eliminarOdontologo(Long id) throws ResourceNotFoundException {
        logger.info("Eliminación de odontologo solicitada");
        return odontologoDao.eliminar(id);
    }
}
