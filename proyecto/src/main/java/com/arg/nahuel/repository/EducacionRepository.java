/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.nahuel.repository;

import com.arg.nahuel.entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nnahu
 */
@Repository
public interface EducacionRepository extends JpaRepository<Educacion, Integer> {
    Optional<Educacion> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
    
     Optional<Educacion> findByDesde(String desde);
    boolean existsByDesde(String desde);
    
    Optional<Educacion> findByHasta(String hasta);
    boolean existsByHasta(String hasta);
    
     Optional<Educacion> findByDescripcion(String descripcion);
    boolean existsByDescripcion(String descripcion);
    
}
