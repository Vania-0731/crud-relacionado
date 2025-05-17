package com.tecsup.examen02.controller;

import com.tecsup.examen02.model.Curso;
import com.tecsup.examen02.service.CursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    private final CursoService cursoService;
    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }
    // Obtener todos los cursos
    @GetMapping
    public List<Curso> getAllCursos() {
        return cursoService.findAll();
    }
    // Obtener curso por ID
    @GetMapping("/{id}")
    public ResponseEntity<Curso> getCursoById(@PathVariable Long id) {
        return cursoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());    }
    // Crear un nuevo curso
    @PostMapping
    public Curso createCurso(@RequestBody Curso curso) {
        return cursoService.save(curso);    }
    // Actualizar curso existente
    @PutMapping("/{id}")
    public ResponseEntity<Curso> updateCurso(@PathVariable Long id, @RequestBody Curso curso) {
        return cursoService.findById(id)
                .map(existingCurso -> {
                    existingCurso.setNombre(curso.getNombre());
                    existingCurso.setCreditos(curso.getCreditos());
                    cursoService.save(existingCurso);
                    return ResponseEntity.ok(existingCurso);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar curso por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurso(@PathVariable Long id) {
        if (cursoService.findById(id).isPresent()) {
            cursoService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Consultas personalizadas - ejemplo: buscar cursos por créditos mínimos
    @GetMapping("/creditos-mayores/{creditos}")
    public List<Curso> getCursosPorCreditos(@PathVariable int creditos) {
        return cursoService.findByCreditosGreaterThan(creditos);
    }

    // Buscar cursos por nombre (contiene texto)
    @GetMapping("/buscar")
    public List<Curso> buscarCursosPorNombre(@RequestParam String texto) {
        return cursoService.findCursosPorNombre(texto);
    }
}