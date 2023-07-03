package com.example.ProyectoFinal.datos.interfaces;

import com.example.ProyectoFinal.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IDao <T> {
    List<T> listar();
    T agregar(T elemento);
    T modificar(T elemento);
    Boolean eliminar(Long id) throws ResourceNotFoundException;
    T buscar(Long id) throws ResourceNotFoundException;
}
