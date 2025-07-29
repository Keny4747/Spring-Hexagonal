package com.scotiabank.microservicio.alumno.hexagonal.domain.repository;

import com.scotiabank.microservicio.alumno.hexagonal.domain.model.Alumno;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AlumnoRepositoryPort {
    Mono<Alumno> findAlumnoById(Long id);
    Mono<Void> saveAlumno(Alumno alumno);
    Mono<Boolean> existsById(Long id);
    Flux<Alumno> findAllAlumnos();
    Flux<Alumno> findAlumnosByEstado();

}
