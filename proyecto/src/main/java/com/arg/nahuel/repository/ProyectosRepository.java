/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.nahuel.repository;

import com.arg.nahuel.entity.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nnahu
 */
@Repository
public interface ProyectosRepository extends JpaRepository<Proyectos, Integer> {
    Optional<Proyectos> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
    
     Optional<Proyectos> findByFechaProyecto(String fechaProyecto);
    boolean existsByFechaProyecto(String fechaProyecto);
    
    Optional<Proyectos> findByDescripcion(String descripcion);
    boolean existsByDescripcion(String descripcion);
    
     Optional<Proyectos> findByLink(String link);
    boolean existsByLink(String link);
}
