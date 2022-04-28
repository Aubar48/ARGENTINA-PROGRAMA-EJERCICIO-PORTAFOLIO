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
public class ProyectosDto {
    @NotBlank
    private String nombre;
    
    private String fechaProyecto;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String link;

    public ProyectosDto() {
    }

    public ProyectosDto(String nombre, String fechaProyecto, String descripcion, String link) {
        this.nombre = nombre;
        this.fechaProyecto = fechaProyecto;
        this.descripcion = descripcion;
        this.link = link;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaProyecto() {
        return fechaProyecto;
    }

    public void setFechaProyecto(String fechaProyecto) {
        this.fechaProyecto = fechaProyecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
}
