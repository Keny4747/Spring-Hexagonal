package com.scotiabank.microservicio.alumno.test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AlumnoEntityServiceTest {
/*

    @Mock
    ModelMapper modelMapper;

    @Mock
    AlumnoRepository alumnoRepository;

    @InjectMocks
    AlumnoService alumnoService;



    @Test
    void guardarAlumno_debeLanzarErrorSiExiste() {

        AlumnoDTO alumnoDTO = new AlumnoDTO(1L, "Juan", "Pérez", "ACTIVO", 20);
        when(alumnoRepository.existsById(1L)).thenReturn(Mono.just(true));


        Mono<Void> resultado = alumnoService.guardarAlumno(alumnoDTO);


        StepVerifier.create(resultado)
                .expectError(IdExistException.class)
                .verify();

        verify(alumnoRepository, never()).insertAlumno(any(), any(), any(), any(), anyInt());
    }


    @Test
    void guardarAlumno_debeGuardarSiNoExiste() {

        AlumnoDTO alumnoDTO = new AlumnoDTO(1L, "Juan", "Pérez", "ACTIVO", 20);
        AlumnoEntity alumnoEntity = new AlumnoEntity(1L, "Juan", "Pérez", Estado.ACTIVO, 20);

        when(alumnoRepository.existsById(1L)).thenReturn(Mono.just(false));
        when(modelMapper.map(alumnoDTO, AlumnoEntity.class)).thenReturn(alumnoEntity);
        when(alumnoRepository.insertAlumno(
                eq(1L),
                eq("Juan"),
                eq("Pérez"),
                eq("ACTIVO"),
                eq(20)
        )).thenReturn(Mono.empty());


        Mono<Void> resultado = alumnoService.guardarAlumno(alumnoDTO);


        StepVerifier.create(resultado)
                .verifyComplete();

        verify(alumnoRepository).insertAlumno(1L, "Juan", "Pérez", "ACTIVO", 20);
    }
*/



}
