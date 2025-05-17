package com.tecsup.examen02.dao;

import com.tecsup.examen02.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoDAO extends JpaRepository<Curso, Long> {

    // Buscar cursos con créditos mayores a un valor
    List<Curso> findByCreditosGreaterThan(int creditos);

    // Consulta JPQL personalizada: cursos cuyo nombre contenga un texto
    @Query("SELECT c FROM Curso c WHERE c.nombre LIKE %?1%")
    List<Curso> findCursosPorNombre(String texto);
}