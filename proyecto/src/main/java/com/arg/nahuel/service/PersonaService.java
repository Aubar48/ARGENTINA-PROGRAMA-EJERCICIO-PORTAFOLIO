/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.nahuel.service;

import com.arg.nahuel.entity.Persona;
import com.arg.nahuel.repository.PersonaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nnahu
 */
@Service
public class PersonaService {
    @Autowired
    PersonaRepository personaRepository;
    
    public List<Persona> list(){
        return personaRepository.findAll();
    }

    public Optional<Persona> getOne(int id){
        return personaRepository.findById(id);
    }

    public Optional<Persona> getByNombre(String nombre){
        return personaRepository.findByNombre(nombre);
    }
     public Optional<Persona> getByApellido(String apellido){
        return personaRepository.findByApellido(apellido);
    }
      public Optional<Persona> getByEdad(String edad){
        return personaRepository.findByEdad(edad);
    }
       public Optional<Persona> getByNacionalidad(String nacionalidad){
        return personaRepository.findByNacionalidad(nacionalidad);
    }
        public Optional<Persona> getByProvincia(String provincia){
        return personaRepository.findByProvincia(provincia);
    }
         public Optional<Persona> getByCorreo(String correo){
        return personaRepository.findByCorreo(correo);
    }
          public Optional<Persona> getByNumeroTelefonico(String numeroTelefonico){
        return personaRepository.findByNumeroTelefonico(numeroTelefonico);
    }

    public void  save(Persona persona){
        personaRepository.save(persona);
    }

    public void delete(int id){
        personaRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return personaRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre){
        return personaRepository.existsByNombre(nombre);
    }
    public boolean existsByApellido(String apellido){
        return personaRepository.existsByApellido(apellido);
    }
    public boolean existsByEdad(String edad){
        return personaRepository.existsByEdad(edad);
    }
    public boolean existsByNacionalidad(String nacionalidad){
        return personaRepository.existsByNacionalidad(nacionalidad);
    }
    public boolean existsByProvincia(String provincia){
        return personaRepository.existsByProvincia(provincia);
    }
    public boolean existsByCorreo(String correo){
        return personaRepository.existsByCorreo(correo);
    }
     public boolean existsByNumeroTelefonico(String numeroTelefonico){
        return personaRepository.existsByNumeroTelefonico(numeroTelefonico);
    }
}
