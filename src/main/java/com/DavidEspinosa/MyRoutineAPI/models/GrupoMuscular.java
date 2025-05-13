package com.DavidEspinosa.MyRoutineAPI.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "grupos_musculares")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class GrupoMuscular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_grupo", length = 50, unique = true)
    private String nombreGrupo;
}
