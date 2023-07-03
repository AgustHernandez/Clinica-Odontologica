package com.example.ProyectoFinal.datos;

import com.example.ProyectoFinal.datos.interfaces.IDao;
import com.example.ProyectoFinal.exceptions.ResourceNotFoundException;
import com.example.ProyectoFinal.model.Odontologo;
import com.example.ProyectoFinal.repository.IOdontologoRepository;
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
    public List<Odontologo> listar() {
        return odontologoRepository.findAll();
    }

    @Override
    public Odontologo agregar(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }

    @Override
    public Odontologo modificar(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }

    @Override
    public Boolean eliminar(Long id) throws ResourceNotFoundException {
        odontologoRepository.delete(buscar(id));
        return true;
    }

    @Override
    public Odontologo buscar(Long id) throws ResourceNotFoundException {
        return odontologoRepository.findById(id).get();
    }
}
