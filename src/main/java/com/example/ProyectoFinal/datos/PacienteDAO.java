package com.example.ProyectoFinal.datos;

import com.example.ProyectoFinal.datos.interfaces.IDao;
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
    public Paciente agregar(Paciente paciente) {
        paciente.setFechaAlta();
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente modificar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public Boolean eliminar(Long id) {
        pacienteRepository.deleteById(id);
        return true;
    }

    @Override
    public Paciente buscar(Long id) throws NoSuchElementException {
        return pacienteRepository.findById(id).get();
    }
}
