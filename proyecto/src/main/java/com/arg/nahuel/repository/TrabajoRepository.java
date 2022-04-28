/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.nahuel.repository;

import com.arg.nahuel.entity.Trabajo;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nnahu
 */
@Repository
public interface TrabajoRepository extends JpaRepository<Trabajo, Integer> {
    Optional<Trabajo> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
    
     Optional<Trabajo> findByDesde(Integer desde);
    boolean existsByDesde(Integer desde);
    
    Optional<Trabajo> findByHasta(Integer hasta);
    boolean existsByHasta(Integer hasta);
    
     Optional<Trabajo> findByDescripcion(String descripcion);
    boolean existsByDescripcion(String descripcion);
}
