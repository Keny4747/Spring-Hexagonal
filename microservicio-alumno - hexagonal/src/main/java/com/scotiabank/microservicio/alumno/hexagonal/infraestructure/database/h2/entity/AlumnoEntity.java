package com.scotiabank.microservicio.alumno.hexagonal.infraestructure.database.h2.entity;

import com.scotiabank.microservicio.alumno.hexagonal.util.Estado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("alumno")
@AllArgsConstructor
@NoArgsConstructor
public class AlumnoEntity {
    @Id
    private Long id;
    private String nombre;
    private String apellido;
    private Estado estado;
    private int edad;
}
