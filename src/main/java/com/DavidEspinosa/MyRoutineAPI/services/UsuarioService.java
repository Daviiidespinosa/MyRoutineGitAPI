package com.DavidEspinosa.MyRoutineAPI.services;

import com.DavidEspinosa.MyRoutineAPI.models.Usuario;
import java.util.List;

public interface UsuarioService {
    List<Usuario> findAll();
    Usuario findById(Long id);
    Usuario create(Usuario u);
    Usuario update(Long id, Usuario u);
    void delete(Long id);
    Usuario loginByEmail(String correo, String contrasena);
}
