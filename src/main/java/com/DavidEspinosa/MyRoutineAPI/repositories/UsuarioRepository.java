package com.DavidEspinosa.MyRoutineAPI.repositories;

import com.DavidEspinosa.MyRoutineAPI.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> { }
