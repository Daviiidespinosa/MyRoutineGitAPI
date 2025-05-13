package com.DavidEspinosa.MyRoutineAPI.dto;

public class EjercicioDTO {
    private String nombre;
    private Long grupoMuscularId;
    // getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Long getGrupoMuscularId() { return grupoMuscularId; }
    public void setGrupoMuscularId(Long grupoMuscularId) { this.grupoMuscularId = grupoMuscularId; }
}
