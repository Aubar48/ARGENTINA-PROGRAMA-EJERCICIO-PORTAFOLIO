/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.nahuel.dto;

import javax.validation.constraints.NotBlank;




/**
 *
 * @author Nnahu
 */
public class PersonaDto {
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    
    private String edad;
    @NotBlank
    private String nacionalidad;
    @NotBlank
    private String provincia;
    @NotBlank
    private String correo;
    
    private String numeroTelefonico;

    public PersonaDto() {
    }

    public PersonaDto(String nombre, String apellido, String edad, String nacionalidad, String provincia, String correo, String numeroTelefonico) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
        this.provincia = provincia;
        this.correo = correo;
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }
    
    
}
