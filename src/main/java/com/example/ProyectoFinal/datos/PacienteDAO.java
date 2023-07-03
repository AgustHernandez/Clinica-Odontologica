package com.example.ProyectoFinal.datos;

import com.example.ProyectoFinal.datos.interfaces.IDao;
import com.example.ProyectoFinal.exceptions.ElementAlreadyExistsException;
import com.example.ProyectoFinal.exceptions.ResourceNotFoundException;
import com.example.ProyectoFinal.model.Paciente;
import com.example.ProyectoFinal.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PacienteDAO implements IDao<Paciente> {
    private IPacienteRepository pacienteRepository;

    @Autowired
    public PacienteDAO(IPacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public List<Paciente> listar() {
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente agregar(Paciente paciente) throws ElementAlreadyExistsException {
        if(pacienteRepository.findById(paciente.getId()).isEmpty())
        {
            throw new ElementAlreadyExistsException("El paciente a agregar ya existe en la base de datos.");
        }
        paciente.setFechaAlta();
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente modificar(Paciente paciente) throws ResourceNotFoundException {
        if(pacienteRepository.findById(paciente.getId()).isEmpty())
        {
            throw new ResourceNotFoundException("El paciente a modificar no existe");
        }
        try
        {
            return pacienteRepository.save(paciente);
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }

    @Override
    public Boolean eliminar(Long id) throws ResourceNotFoundException {

        if(pacienteRepository.findById(id).isEmpty())
        {
            throw new ResourceNotFoundException("El paciente a eliminar no existe");
        }
        try
        {
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

        if(pacienteRepository.findById(id).isEmpty())
        {
            throw new ResourceNotFoundException("El paciente buscado no existe");
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
