package com.scotiabank.microservicio.alumno.hexagonal.domain.model;

import com.scotiabank.microservicio.alumno.hexagonal.util.Estado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Alumno {

    private Long id;
    private String nombre;
    private String apellido;
    private Estado estado;
    private int edad;
}

