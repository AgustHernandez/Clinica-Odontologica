package com.example.ProyectoFinal.datos;

import com.example.ProyectoFinal.datos.interfaces.IDao;
import com.example.ProyectoFinal.exceptions.DuplicatedElementException;
import com.example.ProyectoFinal.exceptions.ElementAlreadyExistsException;
import com.example.ProyectoFinal.exceptions.ResourceNotFoundException;
import com.example.ProyectoFinal.model.Paciente;
import com.example.ProyectoFinal.repository.IPacienteRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteDAO implements IDao<Paciente> {
    private IPacienteRepository pacienteRepository;
    private static final Logger logger = Logger.getLogger(PacienteDAO.class);

    @Autowired
    public PacienteDAO(IPacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public List<Paciente> listar() {
        logger.debug("Solicitando lista completa de pacientes");
        return pacienteRepository.findAll();
    }
    @Override
    public Paciente agregar(Paciente paciente) throws ElementAlreadyExistsException {
        logger.debug("Agregar paciente");
        if(!pacienteRepository.findByDni(paciente.getDNI()).isEmpty())
        {
            ElementAlreadyExistsException ex = new ElementAlreadyExistsException("El paciente a agregar ya existe en la base de datos.");
            logger.error(ex.getMessage(),ex);
            throw ex;
        }
        logger.debug("El paciente no existe en la base de datos. Se procede con la inserción");
        paciente.setFechaAlta();
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente modificar(Paciente paciente, Boolean saltearValidacionDuplicado) throws ResourceNotFoundException, DuplicatedElementException {
        logger.debug("Modificar paciente");
        if(pacienteRepository.findById(paciente.getId()).isEmpty())
        {
            ResourceNotFoundException ex = new ResourceNotFoundException("El paciente a modificar no existe");
            logger.error(ex.getMessage(),ex);
            throw ex;
        }
        if(!pacienteRepository.findByDni(paciente.getDNI()).isEmpty())
        {
            DuplicatedElementException ex = new DuplicatedElementException("Ya existe un paciente con el mismo DNI");
            logger.error(ex.getMessage(),ex);
            throw ex;
        }
        try
        {
            logger.debug("El paciente existe en la base de datos. Se procede con la modificación");
            return pacienteRepository.save(paciente);
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }

    @Override
    public Boolean eliminar(Long id) throws ResourceNotFoundException {
        logger.debug("Eliminar paciente");
        if(pacienteRepository.findById(id).isEmpty())
        {
            ResourceNotFoundException ex = new ResourceNotFoundException("El paciente a eliminar no existe");
            logger.error(ex.getMessage(),ex);
            throw ex;
        }
        try
        {
            logger.debug("El paciente existe en la base de datos. Se procede con la eliminación");
            pacienteRepository.deleteById(id);
        }
        catch (Exception ex)
        {
            throw ex;
        }
        return true;
    }

    @Override
    public Paciente buscar(Long id) throws ResourceNotFoundException {
        logger.debug("Busqueda de paciente con id: "+id);
        if(pacienteRepository.findById(id).isEmpty())
        {
            ResourceNotFoundException ex = new ResourceNotFoundException("El paciente buscado no existe");
            logger.error(ex.getMessage(),ex);
            throw ex;
        }
        try
        {
            return pacienteRepository.findById(id).get();
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }
}
