package com.example.ProyectoFinal.model;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

@Entity
@Table
public class Odontologo {
    public void setId(Long id) {
        Id = id;
    }

    @Id
    @SequenceGenerator(name="odontologo_sequence", sequenceName = "odontologo_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "odontologo_sequence")
    private Long Id;
    private String apellido;
    private String nombre;
    private String matricula;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "odontologo_id")
    private Set<Turno> turnos;

    public Odontologo(String apellido, String nombre, String matricula) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.matricula = matricula;
        crearAgenda(LocalDateTime.now(), LocalDateTime.now().plusDays(1));
    }

    public Odontologo() {
        crearAgenda(LocalDateTime.now(), LocalDateTime.now().plusDays(1));
    }

    private void crearAgenda(LocalDateTime fechaDesde, LocalDateTime fechaHasta) {
        this.turnos = new HashSet<Turno>();
        ZoneId zoneId = ZoneId.systemDefault();

        ZonedDateTime dateTimeDesde = fechaDesde.atZone(zoneId);
        ZonedDateTime dateTimeHasta = fechaHasta.atZone(zoneId);

        List<Date> fechas = new ArrayList<>();
        ZonedDateTime dateTimeActual = dateTimeDesde;
        while (!dateTimeActual.isAfter(dateTimeHasta)) {
            ZonedDateTime roundedDateTime = dateTimeActual.withMinute(0).withSecond(0).withNano(0).plusHours(4);
            Date date = Date.from(roundedDateTime.toInstant());
            fechas.add(date);
            dateTimeActual = dateTimeActual.plusHours(1);
        }

        for (Date fecha : fechas) {
            Turno turno = new Turno(fecha, null);
            turnos.add(turno);
        }
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
    public Set<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
    }
    public Long getId() {
        return Id;
    }

    public String getMatricula() {

        return matricula;
    }

    public void setMatricula(String matricula) {

        this.matricula = matricula;
    }


}
