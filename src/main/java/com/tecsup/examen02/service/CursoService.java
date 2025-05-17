package com.tecsup.examen02.service;

import com.tecsup.examen02.model.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {
    List<Curso> findAll();
    Optional<Curso> findById(Long id);
    Curso save(Curso curso);
    void deleteById(Long id);

    List<Curso> findByCreditosGreaterThan(int creditos);
    List<Curso> findCursosPorNombre(String texto);
}

