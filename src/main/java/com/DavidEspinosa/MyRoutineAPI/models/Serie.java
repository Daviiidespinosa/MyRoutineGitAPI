package com.DavidEspinosa.MyRoutineAPI.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "series")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "repeticiones")
    private Integer repeticiones;

    @Column(name = "peso_levantado")
    private Float pesoLevantado;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ejercicio_rutina_id", nullable = false)
    private EjercicioRutina ejercicioRutina;
}
