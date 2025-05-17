package com.tecsup.examen02.controller;

import com.tecsup.examen02.model.Alumno;
import com.tecsup.examen02.service.AlumnoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    private final AlumnoService alumnoService;
    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;}

    @GetMapping
    public List<Alumno> getAll() {
        return alumnoService.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> getById(@PathVariable Long id) {
        return alumnoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build()); }

    @PostMapping
    public Alumno create(@RequestBody Alumno alumno) {
        return alumnoService.save(alumno); }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> update(@PathVariable Long id, @RequestBody Alumno alumno) {
        return alumnoService.findById(id)
                .map(existing -> {
                    existing.setNombre(alumno.getNombre());
                    existing.setEdad(alumno.getEdad());
                    existing.setCarrera(alumno.getCarrera());
                    existing.setCursos(alumno.getCursos());
                    Alumno updated = alumnoService.save(existing);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (alumnoService.findById(id).isPresent()) {
            alumnoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}