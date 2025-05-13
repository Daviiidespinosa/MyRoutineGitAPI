    package com.DavidEspinosa.MyRoutineAPI.repositories;

    import com.DavidEspinosa.MyRoutineAPI.models.Serie;
    import org.springframework.data.jpa.repository.JpaRepository;

    import java.util.List;

    public interface SerieRepository extends JpaRepository<Serie, Long> {
        List<Serie> findByEjercicioRutinaId(Long ejercicioRutinaId);
    }
