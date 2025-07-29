package com.scotiabank.microservicio.alumno.hexagonal.infraestructure.rest.controller;

import com.scotiabank.microservicio.alumno.hexagonal.common.AlumnoDTO;
import com.scotiabank.microservicio.alumno.hexagonal.infraestructure.rest.mapper.AlumnoDTOMapper;
import com.scotiabank.microservicio.alumno.hexagonal.usecase.IAlumnoUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/alumnos")
@Slf4j
@RequiredArgsConstructor
@Validated
public class AlumnoController {

    private final IAlumnoUseCase alumnoUseCase;


    @GetMapping("/{id}")
    public Mono<ResponseEntity<AlumnoDTO>> obtenerAlumnoPorId(@PathVariable Long id) {
        return alumnoUseCase.findAlumnoById(id)
                .map(AlumnoDTOMapper::fromAlumnoToDTO)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<ResponseEntity<Void>> crearAlumno(@Valid @RequestBody AlumnoDTO alumnoDTO) {
        return alumnoUseCase.saveAlumno(AlumnoDTOMapper.fromDTOToAlumno(alumnoDTO))
                .thenReturn(ResponseEntity.status(HttpStatus.CREATED).<Void>build());
    }

    @GetMapping("/activos")
    public Mono<ResponseEntity<Flux<AlumnoDTO>>> obtenerAlumnosActivos() {
        Flux<AlumnoDTO> alumnosDTO = alumnoUseCase.obtenerAlumnosActivos()
                .map(AlumnoDTOMapper::fromAlumnoToDTO);

        return Mono.just(ResponseEntity.ok(alumnosDTO));
    }

}
