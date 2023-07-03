package com.example.ProyectoFinal.datos.interfaces;

import com.example.ProyectoFinal.exceptions.ElementAlreadyExistsException;
import com.example.ProyectoFinal.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IDao <T> {
    List<T> listar();
    T agregar(T elemento) throws ElementAlreadyExistsException;
    T modificar(T elemento) throws ResourceNotFoundException;
    Boolean eliminar(Long id) throws ResourceNotFoundException;
    T buscar(Long id) throws ResourceNotFoundException;
}
