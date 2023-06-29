package com.example.ProyectoFinal.datos.interfaces;

import java.util.List;

public interface IDao <T> {
    List<T> listar();
    T agregar(T elemento);
    T modificar(T elemento);
    Boolean eliminar(Long id);
    T buscar(Long id);
}
