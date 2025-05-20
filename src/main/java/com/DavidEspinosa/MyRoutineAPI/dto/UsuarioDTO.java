// src/main/java/com/DavidEspinosa/MyRoutineAPI/dto/UsuarioDTO.java
package com.DavidEspinosa.MyRoutineAPI.dto;

import com.DavidEspinosa.MyRoutineAPI.models.Usuario.NivelActividad;
import com.DavidEspinosa.MyRoutineAPI.models.Usuario.Objetivo;
import com.DavidEspinosa.MyRoutineAPI.models.Usuario.Sexo;

public class UsuarioDTO {
    private String nombre;
    private String contrasena;
    private Boolean administrador;
    private Integer altura;
    private Integer pesoActual;
    private Integer edad;
    private NivelActividad nivelActividad;
    private Objetivo objetivo;
    private Sexo sexo;


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

    public Integer getEdad() { return edad; }

    public void setEdad(Integer edad) { this.edad = edad; }

    public NivelActividad getNivelActividad() { return nivelActividad; }

    public void setNivelActividad(NivelActividad nivelActividad) { this.nivelActividad = nivelActividad; }

    public Objetivo getObjetivo() { return objetivo; }

    public void setObjetivo(Objetivo objetivo) { this.objetivo = objetivo; }

    public Sexo getSexo() { return sexo; }

    public void setSexo(Sexo sexo) { this.sexo = sexo; }
}
