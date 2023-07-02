package com.example.ProyectoFinal.DTO.VistaOdontologos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OdontologoDTO {
    private Long Id;
    private String apellido;
    private String nombre;
    private String matricula;

    public OdontologoDTO(Long Id,String apellido, String nombre, String matricula) {
        this.Id = Id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.matricula = matricula;
    }

    public OdontologoDTO() {

    }
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
