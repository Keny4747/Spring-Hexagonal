package com.scotiabank.microservicio.alumno.test;

import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@AutoConfigureWebTestClient
@TestPropertySource(properties = {
        "spring.r2dbc.url=r2dbc:h2:mem:///testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE",
        "spring.r2dbc.username=sa",
        "spring.r2dbc.password="
})
public class AlumnoEntityControllerTest {
/*

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private AlumnoService alumnoService;

    @Test
    void crearAlumno_debeRetornar201SiSeGuardaCorrectamente() {
        AlumnoDTO alumnoDTO = new AlumnoDTO(1L, "Juan", "Pérez", "ACTIVO", 20);

        when(alumnoService.guardarAlumno(Mockito.any())).thenReturn(Mono.empty());

        webTestClient.post()
                .uri("/api/alumnos")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(alumnoDTO)
                .exchange()
                .expectStatus().isCreated();
    }

    @Test
    void obtenerAlumnosActivos_debeRetornarListaDeAlumnos() {
        AlumnoDTO alumno1 = new AlumnoDTO(1L, "Ana", "Lopez", "ACTIVO", 22);
        AlumnoDTO alumno2 = new AlumnoDTO(2L, "Luis", "Vega", "ACTIVO", 24);

        when(alumnoService.obtenerAlumnosActivos())
                .thenReturn(Flux.just(alumno1, alumno2));

        webTestClient.get()
                .uri("/api/alumnos/activos")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(AlumnoDTO.class)
                .hasSize(2);
    }

    @Test
    void listarAlumnos_debeRetornarListaCompleta() {
        AlumnoEntity alumnoEntity1 = new AlumnoEntity(1L, "Juan", "Pérez", Estado.ACTIVO, 20);
        AlumnoEntity alumno2 = new AlumnoEntity(2L, "María", "Gómez", Estado.INACTIVO, 21);

        when(alumnoService.findAll()).thenReturn(Flux.just(alumnoEntity1, alumno2));

        webTestClient.get()
                .uri("/api/alumnos")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(AlumnoEntity.class)
                .hasSize(2);
    }
*/
}
