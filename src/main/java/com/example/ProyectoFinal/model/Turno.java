package com.example.ProyectoFinal.model;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
public class Turno {

    @Id
    @SequenceGenerator(name="turno_sequence", sequenceName = "turno_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turno_sequence")
    private Long Id;

    private Date fecha;
    @ManyToOne
    @JoinColumn(name="pacienteId")
    private Paciente paciente;

    public Turno(Date fecha, Paciente paciente) {
        this.fecha = fecha;
        this.paciente = paciente;
    }

    public Turno() {
    }

    public Long getId() {
        return Id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
