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
public class TrabajoDto {
    @NotBlank
    private String nombre;
    
    private Integer desde;
    
    private Integer hasta;
    @NotBlank
    private String descripcion;

    public TrabajoDto() {
    }

    public TrabajoDto(String nombre, Integer desde, Integer hasta, String descripcion) {
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

    public Integer getDesde() {
        return desde;
    }

    public void setDesde(Integer desde) {
        this.desde = desde;
    }

    public Integer getHasta() {
        return hasta;
    }

    public void setHasta(Integer hasta) {
        this.hasta = hasta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
   
}
