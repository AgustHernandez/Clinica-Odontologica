package com.example.ProyectoFinal.datos;

import com.example.ProyectoFinal.datos.interfaces.IDao;
import com.example.ProyectoFinal.model.Turno;
import com.example.ProyectoFinal.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TurnoDAO implements IDao<Turno> {
    private ITurnoRepository turnoRepository;

    @Autowired
    public TurnoDAO(ITurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    @Override
    public List<Turno> listar() {
        return turnoRepository.findAll();
    }

    @Override
    public Turno agregar(Turno turno) {
        return turnoRepository.save(turno);
    }

    @Override
    public Turno modificar(Turno elemento) {
        return null;
    }

    @Override
    public Boolean eliminar(Long id) {
        return null;
    }

    @Override
    public Turno buscar(Long id) throws NoSuchElementException {
        return turnoRepository.findById(id).get();
    }
}
