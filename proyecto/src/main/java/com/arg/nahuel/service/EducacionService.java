/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.nahuel.service;

import com.arg.nahuel.entity.Educacion;
import com.arg.nahuel.repository.EducacionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nnahu
 */
@Service
@Transactional
public class EducacionService {
    
    @Autowired
    EducacionRepository educacionRepository;

    public List<Educacion> list(){
        return educacionRepository.findAll();
    }

    public Optional<Educacion> getOne(int id){
        return educacionRepository.findById(id);
    }

    public Optional<Educacion> getByNombre(String nombre){
        return educacionRepository.findByNombre(nombre);
    }
     public Optional<Educacion> getByDesde(String desde){
        return educacionRepository.findByDesde(desde);
    }
      public Optional<Educacion> getByHasta(String hasta){
        return educacionRepository.findByHasta(hasta);
    }
       public Optional<Educacion> getByDescripcion(String descripcion){
        return educacionRepository.findByDescripcion(descripcion);
    }
     
    

    public void  save(Educacion educacion){
        educacionRepository.save(educacion);
    }

    public void delete(int id){
        educacionRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return educacionRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre){
        return educacionRepository.existsByNombre(nombre);
    }
    public boolean existsByDesde(String desde){
        return educacionRepository.existsByDesde(desde);
    }
    public boolean existsByHasta(String hasta){
        return educacionRepository.existsByHasta(hasta);
    }
    public boolean existsByDescripcion(String descripcion){
        return educacionRepository.existsByDescripcion(descripcion);
    }
  
}
