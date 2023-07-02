package com.example.ProyectoFinal.DTO.VistaPacientes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DireccionDTO {
    private String Calle;
    private String Altura;
    private String Localidad;
    private String Provincia;

    public DireccionDTO(String calle, String altura, String localidad, String provincia) {
        Calle = calle;
        Altura = altura;
        Localidad = localidad;
        Provincia = provincia;
    }

    public DireccionDTO() {
    }

    public String getLocalidad() {
        return Localidad;
    }

    public void setLocalidad(String localidad) {
        Localidad = localidad;
    }

    public String getProvincia() {
        return Provincia;
    }

    public void setProvincia(String provincia) {
        Provincia = provincia;
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
