package com.example.ProyectoFinal.datos;

import com.example.ProyectoFinal.datos.interfaces.IDao;
import com.example.ProyectoFinal.exceptions.DuplicatedElementException;
import com.example.ProyectoFinal.exceptions.ElementAlreadyExistsException;
import com.example.ProyectoFinal.exceptions.ResourceNotFoundException;
import com.example.ProyectoFinal.model.Odontologo;
import com.example.ProyectoFinal.repository.IOdontologoRepository;
import org.apache.log4j.Logger;
import org.hibernate.tool.schema.ast.SqlScriptParserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OdontologoDAO implements IDao<Odontologo> {
    private static final Logger logger = Logger.getLogger(OdontologoDAO.class);
    private IOdontologoRepository odontologoRepository;

    @Autowired
    public OdontologoDAO(IOdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    @Override
    public List<Odontologo> listar()
    {
        logger.debug("Solicitando lista completa de odontologos");
        return odontologoRepository.findAll();
    }

    @Override
    public Odontologo agregar(Odontologo odontologo) throws ElementAlreadyExistsException {
        logger.debug("Agregar odontologo");
        if(!odontologoRepository.findByMatricula(odontologo.getMatricula()).isEmpty())
        {
            ElementAlreadyExistsException ex = new ElementAlreadyExistsException("El odontologo a agregar ya existe en la base de datos.");
            logger.error(ex.getMessage(),ex);
            throw ex;
        }
        logger.debug("El odontologo no existe en la base de datos. Se procede con la inserción");
        return odontologoRepository.save(odontologo);
    }

    @Override
    public Odontologo modificar(Odontologo odontologo, Boolean saltearValidacionDuplicado) throws ResourceNotFoundException, DuplicatedElementException {
        logger.debug("Modificar odontologo");
        if(odontologoRepository.findById(odontologo.getId()).isEmpty())
        {
            ResourceNotFoundException ex = new ResourceNotFoundException("El odontologo a modificar no existe");
            logger.error(ex.getMessage(),ex);
            throw ex;
        }
        if(!saltearValidacionDuplicado && !odontologoRepository.findByMatricula(odontologo.getMatricula()).isEmpty())
        {
            DuplicatedElementException ex = new DuplicatedElementException("Ya existe un odontologo con la misma matricula.");
            logger.error(ex.getMessage(),ex);
            throw ex;
        }
        try
        {
            logger.debug("El odontologo existe en la base de datos. Se procede con la modificación");
            return odontologoRepository.save(odontologo);
        }
        catch (Exception ex)
        {
            logger.error(ex.getMessage(),ex);
            throw ex;
        }
    }

    @Override
    public Boolean eliminar(Long id) throws ResourceNotFoundException {
        logger.debug("Eliminar odontologo");
        if(odontologoRepository.findById(id).isEmpty())
        {
            ResourceNotFoundException ex = new ResourceNotFoundException("El odontologo a eliminar no existe");
            logger.error(ex.getMessage(),ex);
            throw ex;
        }
        try
        {
            logger.debug("El odontologo existe en la base de datos. Se procede con la eliminación");
            odontologoRepository.delete(buscar(id));
        }
        catch (Exception ex)
        {
            logger.error(ex.getMessage(),ex);
            throw ex;
        }
        return true;
    }

    @Override
    public Odontologo buscar(Long id) throws ResourceNotFoundException {
        logger.debug("Busqueda de odontologo con id: "+id);
        if(odontologoRepository.findById(id).isEmpty())
        {
            ResourceNotFoundException ex = new ResourceNotFoundException("El odontologo buscado no existe");
            logger.error(ex.getMessage(),ex);
            throw ex;
        }
        try
        {
            return odontologoRepository.findById(id).get();
        }
        catch (Exception ex)
        {
            logger.error(ex.getMessage(),ex);
            throw ex;
        }
    }
}
