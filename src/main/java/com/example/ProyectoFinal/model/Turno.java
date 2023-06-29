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
    @ManyToOne
    @JoinColumn(name="odontologoId")
    private Odontologo odontologo;

    public Turno(Date fecha, Paciente paciente, Odontologo odontologo) {
        this.fecha = fecha;
        this.paciente = paciente;
        this.odontologo = odontologo;
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

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }
}
