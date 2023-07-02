package com.example.ProyectoFinal.DTO.VistaTurnos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PacienteDTO
{
    private Long Id;
    private String apellido;
    private String nombre;

    public PacienteDTO(Long id, String apellido, String nombre) {
        Id = id;
        this.apellido = apellido;
        this.nombre = nombre;
    }

    public PacienteDTO() {
    }

    public Long getId() {
        return Id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
