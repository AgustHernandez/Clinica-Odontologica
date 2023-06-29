package com.example.ProyectoFinal.model;

import javax.persistence.*;

@Entity
@Table
public class Direccion implements Comparable<Direccion> {
    @Id
    @SequenceGenerator(name="direccion_sequence", sequenceName = "direccion_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "direccion_sequence")
    private Long Id;
    private String Calle;
    private String Altura;
    private String Localidad;
    private String Provincia;

    public Direccion(String calle, String altura, String localidad, String provincia) {
        Calle = calle;
        Altura = altura;
        Localidad = localidad;
        Provincia = provincia;
    }

    public Direccion() {
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

    public Long getId() {
        return Id;
    }

    @Override
    public int compareTo(Direccion o) {
        if(this.Calle == o.Calle && this.Altura == o.Altura && this.Localidad == o.Localidad && this.Provincia == o.Provincia){
            return 0;
        }
        return 1;
    }
}
