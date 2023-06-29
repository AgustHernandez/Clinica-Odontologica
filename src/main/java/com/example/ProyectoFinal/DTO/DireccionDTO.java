package com.example.ProyectoFinal.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DireccionDTO {
    private String Calle;
    private String Altura;

    public DireccionDTO(String calle, String altura) {
        Calle = calle;
        Altura = altura;
    }

    public DireccionDTO() {
    }

    public String getCalle() {
        return Calle;
    }

    public void setCalle(String calle) {
        Calle = calle;
    }

    public String getAltura() {
        return Altura;
    }

    public void setAltura(String altura) {
        Altura = altura;
    }
}
