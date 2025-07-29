package com.scotiabank.microservicio.alumno.hexagonal.infraestructure.database.h2.mapper;

import com.scotiabank.microservicio.alumno.hexagonal.domain.model.Alumno;
import com.scotiabank.microservicio.alumno.hexagonal.infraestructure.database.h2.entity.AlumnoEntity;

public class AlumnoEntityMapper {

    public static Alumno fromEntityToDomain(AlumnoEntity entity) {
        return new Alumno(
            entity.getId(),
            entity.getNombre(),
            entity.getApellido(),
            entity.getEstado(),
            entity.getEdad()
        );
    }
}
