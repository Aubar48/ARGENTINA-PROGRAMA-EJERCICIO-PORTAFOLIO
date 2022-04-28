/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.nahuel.service;

import com.arg.nahuel.entity.Trabajo;
import com.arg.nahuel.repository.TrabajoRepository;
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
public class TrabajoService {
    
    @Autowired
    TrabajoRepository trabajoRepository;

    public List<Trabajo> list(){
        return trabajoRepository.findAll();
    }

    public Optional<Trabajo> getOne(int id){
        return trabajoRepository.findById(id);
    }

    public Optional<Trabajo> getByNombre(String nombre){
        return trabajoRepository.findByNombre(nombre);
    }
     public Optional<Trabajo> getByDesde(Integer desde){
        return trabajoRepository.findByDesde(desde);
    }
      public Optional<Trabajo> getByHasta(Integer hasta){
        return trabajoRepository.findByHasta(hasta);
    }
       public Optional<Trabajo> getByDescripcion(String descripcion){
        return trabajoRepository.findByDescripcion(descripcion);
    }
     
    

    public void  save(Trabajo trabajo){
        trabajoRepository.save(trabajo);
    }

    public void delete(int id){
        trabajoRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return trabajoRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre){
        return trabajoRepository.existsByNombre(nombre);
    }
    public boolean existsByDesde(Integer desde){
        return trabajoRepository.existsByDesde(desde);
    }
    public boolean existsByHasta(Integer hasta){
        return trabajoRepository.existsByHasta(hasta);
    }
    public boolean existsByDescripcion(String descripcion){
        return trabajoRepository.existsByDescripcion(descripcion);
    }
}
