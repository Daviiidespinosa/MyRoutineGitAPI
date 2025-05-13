    package com.DavidEspinosa.MyRoutineAPI.repositories;

    import com.DavidEspinosa.MyRoutineAPI.models.Rutina;
    import org.springframework.data.jpa.repository.JpaRepository;

    import java.util.List;

    public interface RutinaRepository extends JpaRepository<Rutina, Long> {
        List<Rutina> findByUsuarioId(Long usuarioId);

    }

