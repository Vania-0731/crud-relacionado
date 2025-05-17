package com.tecsup.examen02.service;

import com.tecsup.examen02.model.Alumno;

import java.util.List;
import java.util.Optional;

public interface AlumnoService {
    List<Alumno> findAll();
    Optional<Alumno> findById(Long id);
    Alumno save(Alumno alumno);
    void deleteById(Long id);
    List<Alumno> findByCarrera(String carrera);
    List<Alumno> findAlumnosMayoresQue(int edad);
}

