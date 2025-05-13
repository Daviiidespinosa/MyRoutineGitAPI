// src/main/java/com/DavidEspinosa/MyRoutineAPI/dto/SerieDTO.java
package com.DavidEspinosa.MyRoutineAPI.dto;

public class SerieDTO {
    private Long ejercicioRutinaId;
    private Integer repeticiones;
    private Float pesoLevantado;
    // getters y setters
    public Long getEjercicioRutinaId() { return ejercicioRutinaId; }
    public void setEjercicioRutinaId(Long ejercicioRutinaId) { this.ejercicioRutinaId = ejercicioRutinaId; }
    public Integer getRepeticiones() { return repeticiones; }
    public void setRepeticiones(Integer repeticiones) { this.repeticiones = repeticiones; }
    public Float getPesoLevantado() { return pesoLevantado; }
    public void setPesoLevantado(Float pesoLevantado) { this.pesoLevantado = pesoLevantado; }
}
