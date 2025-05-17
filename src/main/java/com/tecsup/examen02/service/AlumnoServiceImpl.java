package com.tecsup.examen02.service;

import com.tecsup.examen02.dao.AlumnoDAO;
import com.tecsup.examen02.dao.CursoDAO;
import com.tecsup.examen02.model.Alumno;
import com.tecsup.examen02.model.Curso;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoDAO alumnoDAO;
    private final CursoDAO cursoDAO;

    // Inyectamos ambos DAO en el constructor
    public AlumnoServiceImpl(AlumnoDAO alumnoDAO, CursoDAO cursoDAO) {
        this.alumnoDAO = alumnoDAO;
        this.cursoDAO = cursoDAO;
    }

    @Override
    public List<Alumno> findAll() {
        return alumnoDAO.findAll();
    }

    @Override
    public Optional<Alumno> findById(Long id) {
        return alumnoDAO.findById(id);
    }

    @Override
    public Alumno save(Alumno alumno) {
        // Cargar cursos completos para evitar solo ID con datos nulos
        if (alumno.getCursos() != null && !alumno.getCursos().isEmpty()) {
            Set<Curso> cursosCompletos = alumno.getCursos().stream()
                    .map(curso -> cursoDAO.findById(curso.getId())
                            .orElseThrow(() -> new RuntimeException("Curso no encontrado con ID: " + curso.getId())))
                    .collect(Collectors.toSet());
            alumno.setCursos(cursosCompletos);
        }
        return alumnoDAO.save(alumno);
    }

    @Override
    public void deleteById(Long id) {
        alumnoDAO.deleteById(id);
    }

    @Override
    public List<Alumno> findByCarrera(String carrera) {
        return alumnoDAO.findByCarrera(carrera);
    }

    @Override
    public List<Alumno> findAlumnosMayoresQue(int edad) {
        return alumnoDAO.findAlumnosMayoresQue(edad);
    }
}
