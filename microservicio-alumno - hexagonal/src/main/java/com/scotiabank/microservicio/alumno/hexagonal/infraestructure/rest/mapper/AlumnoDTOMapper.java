package com.scotiabank.microservicio.alumno.hexagonal.infraestructure.rest.mapper;

import com.scotiabank.microservicio.alumno.hexagonal.domain.model.Alumno;
import com.scotiabank.microservicio.alumno.hexagonal.common.AlumnoDTO;
import com.scotiabank.microservicio.alumno.hexagonal.util.Estado;

public class AlumnoDTOMapper {

    public static AlumnoDTO fromAlumnoToDTO(Alumno alumno){
        return new AlumnoDTO(
            alumno.getId(),
            alumno.getNombre(),
            alumno.getApellido(),
            alumno.getEstado().toString(),
            alumno.getEdad()
        );
    }
    public static Alumno fromDTOToAlumno(AlumnoDTO alumnoDTO){
        return new Alumno(
            alumnoDTO.id(),
            alumnoDTO.nombre(),
            alumnoDTO.apellido(),
            Estado.valueOf(alumnoDTO.estado()),
            alumnoDTO.edad()

        );
    }

}
