/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.nahuel.repository;

import com.arg.nahuel.entity.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nnahu
 */
@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    Optional<Persona> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
    
     Optional<Persona> findByApellido(String apellido);
    boolean existsByApellido(String apellido);
    
    Optional<Persona> findByEdad(String edad);
    boolean existsByEdad(String edad);
    
     Optional<Persona> findByNacionalidad(String nacionalidad);
    boolean existsByNacionalidad(String nacionalidad);
    
     Optional<Persona> findByProvincia(String provincia);
    boolean existsByProvincia(String provincia);
    
    Optional<Persona> findByCorreo(String correo);
    boolean existsByCorreo(String correo);
    
    Optional<Persona> findByNumeroTelefonico(String numeroTelefonico);
    boolean existsByNumeroTelefonico(String numeroTelefonico);
}
