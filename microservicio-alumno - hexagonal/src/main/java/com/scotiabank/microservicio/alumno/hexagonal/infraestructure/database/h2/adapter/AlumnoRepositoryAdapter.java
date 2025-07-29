package com.scotiabank.microservicio.alumno.hexagonal.infraestructure.database.h2.adapter;

import com.scotiabank.microservicio.alumno.hexagonal.domain.model.Alumno;
import com.scotiabank.microservicio.alumno.hexagonal.domain.repository.AlumnoRepositoryPort;
import com.scotiabank.microservicio.alumno.hexagonal.infraestructure.database.h2.mapper.AlumnoEntityMapper;
import com.scotiabank.microservicio.alumno.hexagonal.infraestructure.database.h2.repository.AlumnoRepositoryH2;
import com.scotiabank.microservicio.alumno.hexagonal.util.Estado;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
@Slf4j
public class AlumnoRepositoryAdapter implements AlumnoRepositoryPort {

    private final AlumnoRepositoryH2 alumnoRepositoryH2;
    private final ModelMapper modelMapper;

    @Override
    public Mono<Alumno> findAlumnoById(Long id) {

        return alumnoRepositoryH2.findById(id)
                .map(AlumnoEntityMapper::fromEntityToDomain)
                .switchIfEmpty(Mono.empty());

    }

    @Override
    public Mono<Void> saveAlumno(Alumno alumno) {
        return alumnoRepositoryH2
                .insertAlumno
                        (alumno.getId(),
                        alumno.getNombre(),
                        alumno.getApellido(),
                        alumno.getEstado().name(),
                        alumno.getEdad()
                        ).then();
    }

    @Override
    public Flux<Alumno> findAlumnosByEstado() {
        return alumnoRepositoryH2.findAlumnosByEstado(Estado.ACTIVO)
                .map(AlumnoEntityMapper::fromEntityToDomain);
    }

    @Override
    public Mono<Boolean> existsById(Long id) {
        return alumnoRepositoryH2.existsById(id);
    }

    @Override
    public Flux<Alumno> findAllAlumnos() {
        return null;
    }



}

