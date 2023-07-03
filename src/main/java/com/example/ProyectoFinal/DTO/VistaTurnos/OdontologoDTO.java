package com.example.ProyectoFinal.DTO.VistaTurnos;

import com.example.ProyectoFinal.model.Turno;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OdontologoDTO {
    private Long Id;
    private String apellido;
    private String nombre;
    private Set<Turno> turnos;

    public OdontologoDTO() {
    }

    public OdontologoDTO(Long id, String apellido, String nombre, Set<Turno> turnos) {
        Id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.turnos = turnos;
    }
    public Set<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
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
