// src/main/java/com/DavidEspinosa/MyRoutineAPI/models/Usuario.java
package com.DavidEspinosa.MyRoutineAPI.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 256)
    private String nombre;

    @Column(name = "contrasena", length = 256)
    private String contrasena;

    @Column(name = "administrador")
    private Boolean administrador;

    @Column(name = "altura")
    private Integer altura;

    @Column(name = "peso_actual")
    private Integer pesoActual;

    @Column(name = "edad")
    private Integer edad;

    public enum NivelActividad { BAJO, MEDIO, ALTO }
    @Enumerated(EnumType.STRING)
    @Column(name = "nivel_actividad", length = 20)
    private NivelActividad nivelActividad;

    public enum Objetivo { VOLUMEN, MANTENIMIENTO, DEFINICION }
    @Enumerated(EnumType.STRING)
    @Column(name = "objetivo", length = 20)
    private Objetivo objetivo;

    public enum Sexo { MASCULINO, FEMENINO }
    @Enumerated(EnumType.STRING)
    @Column(name = "sexo", length = 10)
    private Sexo sexo;
}
