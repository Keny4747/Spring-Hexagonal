package com.scotiabank.microservicio.alumno.hexagonal.infraestructure.database.h2.repository;

import com.scotiabank.microservicio.alumno.hexagonal.infraestructure.database.h2.entity.AlumnoEntity;
import com.scotiabank.microservicio.alumno.hexagonal.util.Estado;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository("HexagonalAlumnoRepositoryH2")
public interface AlumnoRepositoryH2  extends ReactiveCrudRepository<AlumnoEntity, Long> {
    @Query("INSERT INTO alumno (id, nombre, apellido, estado, edad) VALUES (:id, :nombre, :apellido, :estado, :edad)")
    Mono<Void> insertAlumno(@Param("id") Long id,
                            @Param("nombre") String nombre,
                            @Param("apellido") String apellido,
                            @Param("estado") String estado,
                            @Param("edad") int edad);


    Flux<AlumnoEntity> findAlumnosByEstado(Estado estado);
}
