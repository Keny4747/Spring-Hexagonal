package com.scotiabank.microservicio.alumno.hexagonal.common;

import javax.validation.constraints.*;

public record AlumnoDTO (

    @NotNull(message = "El ID no puede ser nulo")
    @Min(value = 1, message = "El ID debe ser mayor a 0")
    Long id,

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "El nombre solo puede contener letras")
    String nombre,

    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(min = 2, max = 100, message = "El apellido debe tener entre 2 y 100 caracteres")
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "El apellido solo puede contener letras")
    String apellido,

    @NotBlank(message = "El estado no puede estar vacío")
    @Pattern(regexp = "^(ACTIVO|INACTIVO)$", message = "El estado debe ser ACTIVO o INACTIVO")
    String estado,

    @NotNull(message = "La edad no puede ser nula")
    @Min(value = 1, message = "La edad debe ser mayor a 0")
    int edad
)
{}