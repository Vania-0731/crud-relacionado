package com.tecsup.examen02.dao;

import com.tecsup.examen02.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlumnoDAO extends JpaRepository<Alumno, Long> {

    // Buscar alumnos por carrera
    List<Alumno> findByCarrera(String carrera);

    // Consulta personalizada con @Query para buscar alumnos mayores de cierta edad
    @Query("SELECT a FROM Alumno a WHERE a.edad > ?1")
    List<Alumno> findAlumnosMayoresQue(int edad);
}