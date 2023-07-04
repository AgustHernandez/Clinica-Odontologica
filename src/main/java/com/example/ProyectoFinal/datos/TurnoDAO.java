package com.example.ProyectoFinal.datos;

import com.example.ProyectoFinal.datos.interfaces.IDao;
import com.example.ProyectoFinal.exceptions.ElementAlreadyExistsException;
import com.example.ProyectoFinal.exceptions.ResourceNotFoundException;
import com.example.ProyectoFinal.model.Turno;
import com.example.ProyectoFinal.repository.ITurnoRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class TurnoDAO implements IDao<Turno> {
    private ITurnoRepository turnoRepository;
    private static final Logger logger = Logger.getLogger(TurnoDAO.class);

    @Autowired
    public TurnoDAO(ITurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    @Override
    public List<Turno> listar() {
        logger.debug("Solicitando lista completa de turnos");
        return turnoRepository.findAll();
    }

    @Override
    public Turno agregar(Turno turno) throws ElementAlreadyExistsException {

        logger.debug("Agregar turno");
        return turnoRepository.save(turno);
    }

    @Override
    public Turno modificar(Turno turno, Boolean saltearValidacionDuplicado) throws ResourceNotFoundException {
        logger.debug("Modificar turno");
        if(turnoRepository.findById(turno.getId()).isEmpty())
        {
            ResourceNotFoundException ex = new ResourceNotFoundException("El turno a modificar no existe");
            logger.error(ex.getMessage(),ex);
            throw ex;
        }
        try
        {
            logger.debug("El turno existe en la base de datos. Se procede con la modificación");
            return turnoRepository.save(turno);
        }
        catch (Exception ex)
        {
            logger.error(ex.getMessage(),ex);
            throw ex;
        }
    }

    @Override
    public Boolean eliminar(Long id) throws ResourceNotFoundException {
        logger.debug("Eliminar turno");
        if(turnoRepository.findById(id).isEmpty())
        {
            ResourceNotFoundException ex = new ResourceNotFoundException("El turno a eliminar no existe");
            logger.error(ex.getMessage(),ex);
            throw ex;
        }
        try
        {
            logger.debug("El turno existe en la base de datos. Se procede con la eliminación");
            turnoRepository.delete(buscar(id));
        }
        catch (Exception ex)
        {
            logger.error(ex.getMessage(),ex);
            throw ex;
        }
        return true;
    }

    @Override
    public Turno buscar(Long id) throws ResourceNotFoundException {
        logger.debug("Busqueda de turno con id: "+id);
        if(turnoRepository.findById(id).isEmpty())
        {
            ResourceNotFoundException ex = new ResourceNotFoundException("El turno buscado no existe");
            logger.error(ex.getMessage(),ex);
            throw ex;
        }
        try
        {
            return turnoRepository.findById(id).get();
        }
        catch (Exception ex)
        {
            logger.error(ex.getMessage(),ex);
            throw ex;
        }
    }
}
