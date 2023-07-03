package com.example.ProyectoFinal.DTO.VistaTurnos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TurnoDTO {
    private Long Id;
    private Date fecha;

    private PacienteDTO pacienteDTO;

    public TurnoDTO(Long Id, Date fecha, PacienteDTO pacienteDTO) {
        this.Id = Id;
        this.fecha = fecha;
        this.pacienteDTO = pacienteDTO;
    }

    public TurnoDTO() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public PacienteDTO getPaciente() {
        return pacienteDTO;
    }

    public void setPaciente(PacienteDTO pacienteDTO) {
        this.pacienteDTO = pacienteDTO;
    }
}
