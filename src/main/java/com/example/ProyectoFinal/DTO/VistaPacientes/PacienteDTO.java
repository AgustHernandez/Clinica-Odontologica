package com.example.ProyectoFinal.DTO.VistaPacientes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PacienteDTO {

    private Long Id;
    private String apellido;
    private String nombre;
    private String DNI;
    private Date fechaAlta;
    private DireccionDTO direccionDTO;

    public PacienteDTO(Long Id, String apellido, String nombre, String DNI, Date fechaAlta, DireccionDTO direccionDTO) {
        this.Id = Id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.DNI = DNI;
        this.fechaAlta = fechaAlta;
        this.direccionDTO = direccionDTO;
    }

    public PacienteDTO() {
    }
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }


    public DireccionDTO getDireccion() {
        return direccionDTO;
    }

    public void setDireccion(DireccionDTO direccionDTO) {
        this.direccionDTO = direccionDTO;
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

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
}
