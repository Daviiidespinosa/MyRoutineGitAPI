package com.DavidEspinosa.MyRoutineAPI.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ejercicios_rutina")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class EjercicioRutina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "series_planeadas")
    private Integer seriesPlaneadas;


    @ManyToOne(optional = false)
    @JoinColumn(name = "rutina_id", nullable = false)
    private Rutina rutina;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ejercicio_id", nullable = false)
    private Ejercicio ejercicio;
}
