package com.scotiabank.microservicio.alumno.hexagonal.usecase;

import com.scotiabank.microservicio.alumno.hexagonal.exception.errors.IdExistException;
import com.scotiabank.microservicio.alumno.hexagonal.domain.model.Alumno;
import com.scotiabank.microservicio.alumno.hexagonal.domain.repository.AlumnoRepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Component
@RequiredArgsConstructor
@Slf4j
public class AlumnoUseCaseImpl implements IAlumnoUseCase {

    private final AlumnoRepositoryPort alumnoRepository;

    @Override
    public Mono<Alumno>  findAlumnoById(Long id) {

        return alumnoRepository.findAlumnoById(id);
    }

    @Override
    public Mono<Void> saveAlumno(Alumno alumno) {

        return alumnoRepository.existsById(alumno.getId())
                .flatMap(existe -> {
                    if (existe) {
                        return Mono.error(new IdExistException());
                    }

                    return alumnoRepository.saveAlumno(alumno);
                });

    }

    @Override
    public Mono<Boolean> existsById(Long id) {
        return alumnoRepository.existsById(id);
    }

    @Override
    public Flux<Alumno> obtenerAlumnosActivos() {
        return alumnoRepository.findAlumnosByEstado();
    }

    @Override
    public Flux<Alumno> findAllAlumnos() {
        return null;
    }
}
