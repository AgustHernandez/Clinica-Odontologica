package com.example.ProyectoFinal.repository;

import com.example.ProyectoFinal.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Long> {
    /*@Modifying
    @Query("update Paciente p set p.apellido = :apellido where p.id = :id")
    void updatePaciente(@Param(value = "id") long id,
                        @Param(value = "apellido") String apellido,
                        @Param(value = "nombre") String nombre,
                        @Param(value = "fechaAlta") Date fechaAlta,
                        @Param(value = "dni") String dni,
                        @Param(value = "apellido") String provincia,
                        @Param(value = "apellido") String apellido,
                        @Param(value = "apellido") String apellido,
                        @Param(value = "apellido") String apellido);*/


}
