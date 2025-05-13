// src/main/java/com/DavidEspinosa/MyRoutineAPI/dto/UsuarioDTO.java
package com.DavidEspinosa.MyRoutineAPI.dto;

public class UsuarioDTO {
    private String nombre;
    private String contrasena;
    private Boolean administrador;
    private Integer altura;
    private Integer pesoActual;
    // getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
    public Boolean getAdministrador() { return administrador; }
    public void setAdministrador(Boolean administrador) { this.administrador = administrador; }
    public Integer getAltura() { return altura; }
    public void setAltura(Integer altura) { this.altura = altura; }
    public Integer getPesoActual() { return pesoActual; }
    public void setPesoActual(Integer pesoActual) { this.pesoActual = pesoActual; }
}
