package com.example.ProyectoFinal.datos.interfaces;

import com.example.ProyectoFinal.exceptions.DuplicatedElementException;
import com.example.ProyectoFinal.exceptions.ElementAlreadyExistsException;
import com.example.ProyectoFinal.exceptions.ResourceNotFoundException;
import com.example.ProyectoFinal.model.Paciente;

import java.util.List;

public interface IDao <T> {
    List<T> listar();
    T agregar(T elemento) throws ElementAlreadyExistsException;
    T modificar(T elemento, Boolean saltearValidacionDuplicado) throws ResourceNotFoundException, DuplicatedElementException;
    Boolean eliminar(Long id) throws ResourceNotFoundException;
    T buscar(Long id) throws ResourceNotFoundException;
}
