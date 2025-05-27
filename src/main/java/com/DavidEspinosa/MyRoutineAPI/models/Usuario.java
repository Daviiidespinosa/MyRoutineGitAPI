package com.DavidEspinosa.MyRoutineAPI.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "correo", length = 256, nullable = false, unique = true)
    private String correo;

    @Column(name = "nombre", length = 128, nullable = false)
    private String nombre;

    @Column(name = "contrasena", length = 128, nullable = false)
    private String contrasena;

    @Column(name = "administrador", nullable = false)
    private Boolean administrador;

    @Column(name = "altura")
    private Integer altura;

    @Column(name = "peso_actual")
    private Integer pesoActual;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Enumerated(EnumType.STRING)
    @Column(name = "nivel_actividad")
    private NivelActividad nivelActividad;

    @Enumerated(EnumType.STRING)
    @Column(name = "objetivo")
    private Objetivo objetivo;

    @Enumerated(EnumType.STRING)
    @Column(name = "sexo")
    private Sexo sexo;

    public enum NivelActividad { BAJO, MEDIO, ALTO }
    public enum Objetivo         { DEFINICION, MANTENIMIENTO, VOLUMEN }
    public enum Sexo             { MASCULINO, FEMENINO }
}
