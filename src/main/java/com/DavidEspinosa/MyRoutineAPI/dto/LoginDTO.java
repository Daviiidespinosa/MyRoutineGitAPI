package com.DavidEspinosa.MyRoutineAPI.dto;

public class LoginDTO {
    private String correo;
    private String contrasena;

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
}
