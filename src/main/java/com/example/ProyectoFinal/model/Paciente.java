package com.example.ProyectoFinal.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Paciente {
    public void setId(Long id) {
        Id = id;
    }

    @Id
        @SequenceGenerator(name="paciente_sequence", sequenceName = "paciente_sequence")
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente_sequence")
        private Long Id;
        private String apellido;
        private String nombre;
        @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        @JoinColumn(name="direccionId", referencedColumnName = "Id")
        private Direccion direccion;
        private String dni;
        private Date fechaAlta;

    public Paciente(String apellido, String nombre, Direccion direccion, String dni) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.direccion = direccion;
        this.dni = dni;
        this.fechaAlta = new Date();
    }

    public Paciente() {
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

    public Direccion getDireccion() {

        return direccion;
    }

    public void setDireccion(Direccion direccion) {

        this.direccion = direccion;
    }

    public String getDNI() {

        return dni;
    }

    public void setDNI(String DNI) {

        this.dni = DNI;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta() {

        this.fechaAlta = new Date();
    }
}
