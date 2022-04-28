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
public class EducacionDto {
   @NotBlank
    private String nombre;
    
    private String desde;
    
    private String hasta;
    @NotBlank
    private String descripcion;

    public EducacionDto() {
    }

    public EducacionDto(String nombre, String desde, String hasta, String descripcion) {
        this.nombre = nombre;
        this.desde = desde;
        this.hasta = hasta;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesde() {
        return desde;
    }

    public void setDesde(String desde) {
        this.desde = desde;
    }

    public String getHasta() {
        return hasta;
    }

    public void setHasta(String hasta) {
        this.hasta = hasta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
