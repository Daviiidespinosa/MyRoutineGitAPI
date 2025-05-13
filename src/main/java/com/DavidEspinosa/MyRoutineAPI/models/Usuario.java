    package com.DavidEspinosa.MyRoutineAPI.models;

    import jakarta.persistence.*;
    import lombok.*;

    @Entity
    @Table(name = "usuarios")
    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
    public class Usuario {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
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

        public enum NivelActividad { BAJO, MEDIO, ALTO }
        @Enumerated(EnumType.STRING)
        @Column(name = "nivel_actividad", length = 10)
        private NivelActividad nivelActividad;

        public enum Objetivo { VOLUMEN, DEFINICION, MANTENIMIENTO }
        @Enumerated(EnumType.STRING)
        @Column(name = "objetivo", length = 15)
        private Objetivo objetivo;
    }
