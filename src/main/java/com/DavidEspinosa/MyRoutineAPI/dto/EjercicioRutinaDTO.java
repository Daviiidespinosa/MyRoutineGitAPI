// src/main/java/com/DavidEspinosa/MyRoutineAPI/dto/EjercicioRutinaDTO.java
package com.DavidEspinosa.MyRoutineAPI.dto;

public class EjercicioRutinaDTO {
    private Long rutinaId;
    private Long ejercicioId;
    private Integer seriesPlaneadas;

    public Long getRutinaId() { return rutinaId; }

    public void setRutinaId(Long rutinaId) { this.rutinaId = rutinaId; }

    public Long getEjercicioId() { return ejercicioId; }

    public void setEjercicioId(Long ejercicioId) { this.ejercicioId = ejercicioId; }

    public Integer getSeriesPlaneadas() { return seriesPlaneadas; }

    public void setSeriesPlaneadas(Integer seriesPlaneadas) { this.seriesPlaneadas = seriesPlaneadas; }
}
    