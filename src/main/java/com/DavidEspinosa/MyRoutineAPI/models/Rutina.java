package com.DavidEspinosa.MyRoutineAPI.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "rutinas")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Rutina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 256)
    private String nombre;

    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
}
