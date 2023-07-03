package com.example.ProyectoFinal.datos;

import com.example.ProyectoFinal.datos.interfaces.IDao;
import com.example.ProyectoFinal.exceptions.ElementAlreadyExistsException;
import com.example.ProyectoFinal.exceptions.ResourceNotFoundException;
import com.example.ProyectoFinal.model.Odontologo;
import com.example.ProyectoFinal.repository.IOdontologoRepository;
import org.hibernate.tool.schema.ast.SqlScriptParserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OdontologoDAO implements IDao<Odontologo> {

    private IOdontologoRepository odontologoRepository;

    @Autowired
    public OdontologoDAO(IOdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    @Override
    public List<Odontologo> listar()
    {
        return odontologoRepository.findAll();
    }

    @Override
    public Odontologo agregar(Odontologo odontologo) throws ElementAlreadyExistsException {
        if(odontologoRepository.findById(odontologo.getId()).isEmpty())
        {
            throw new ElementAlreadyExistsException("El odontologo a agregar ya existe en la base de datos.");
        }
        return odontologoRepository.save(odontologo);
    }

    @Override
    public Odontologo modificar(Odontologo odontologo) throws ResourceNotFoundException {
        if(odontologoRepository.findById(odontologo.getId()).isEmpty())
        {
            throw new ResourceNotFoundException("El odontologo a modificar no existe");
        }
        try
        {
            return odontologoRepository.save(odontologo);
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }

    @Override
    public Boolean eliminar(Long id) throws ResourceNotFoundException {
        if(odontologoRepository.findById(id).isEmpty())
        {
            throw new ResourceNotFoundException("El odontologo a eliminar no existe");
        }
        try
        {
            odontologoRepository.delete(buscar(id));
        }
        catch (Exception ex)
        {
            throw ex;
        }
        return true;
    }

    @Override
    public Odontologo buscar(Long id) throws ResourceNotFoundException {
        if(odontologoRepository.findById(id).isEmpty())
        {
            throw new ResourceNotFoundException("El odontologo buscado no existe");
        }
        try
        {
            return odontologoRepository.findById(id).get();
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }
}
