package com.DavidEspinosa.MyRoutineAPI.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ejercicios")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Ejercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 256)
    private String nombre;

    @ManyToOne(optional = false)
    @JoinColumn(name = "grupo_muscular_id", nullable = false)
    private GrupoMuscular grupoMuscular;
}