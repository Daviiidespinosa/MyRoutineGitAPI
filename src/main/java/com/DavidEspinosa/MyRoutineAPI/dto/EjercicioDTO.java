package com.DavidEspinosa.MyRoutineAPI.dto;

public class EjercicioDTO {
    private String nombreEs;
    private String nombreEn;
    private String nombreCa;
    private Long grupoMuscularId;

    public String getNombreEs() { return nombreEs; }
    public void setNombreEs(String nombreEs) { this.nombreEs = nombreEs; }

    public String getNombreEn() { return nombreEn; }
    public void setNombreEn(String nombreEn) { this.nombreEn = nombreEn; }

    public String getNombreCa() { return nombreCa; }
    public void setNombreCa(String nombreCa) { this.nombreCa = nombreCa; }

    public Long getGrupoMuscularId() { return grupoMuscularId; }
    public void setGrupoMuscularId(Long grupoMuscularId) { this.grupoMuscularId = grupoMuscularId; }
}
