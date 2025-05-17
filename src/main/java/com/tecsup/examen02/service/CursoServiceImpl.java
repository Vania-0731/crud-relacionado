package com.tecsup.examen02.service;

import com.tecsup.examen02.dao.CursoDAO;
import com.tecsup.examen02.model.Curso;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

    private final CursoDAO cursoDAO;

    public CursoServiceImpl(CursoDAO cursoDAO) {
        this.cursoDAO = cursoDAO;
    }

    @Override
    public List<Curso> findAll() {
        return cursoDAO.findAll();
    }

    @Override
    public Optional<Curso> findById(Long id) {
        return cursoDAO.findById(id);
    }

    @Override
    public Curso save(Curso curso) {
        return cursoDAO.save(curso);
    }

    @Override
    public void deleteById(Long id) {
        cursoDAO.deleteById(id);
    }

    @Override
    public List<Curso> findByCreditosGreaterThan(int creditos) {
        return cursoDAO.findByCreditosGreaterThan(creditos);
    }

    @Override
    public List<Curso> findCursosPorNombre(String texto) {
        return cursoDAO.findCursosPorNombre(texto);
    }
}
