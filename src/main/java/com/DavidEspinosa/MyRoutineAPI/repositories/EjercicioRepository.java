package com.DavidEspinosa.MyRoutineAPI.repositories;

import com.DavidEspinosa.MyRoutineAPI.models.Ejercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EjercicioRepository extends JpaRepository<Ejercicio, Long> {
    List<Ejercicio> findByGrupoMuscularId(Long grupoMuscularId);
}

