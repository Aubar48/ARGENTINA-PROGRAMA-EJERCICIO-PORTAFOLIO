/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.nahuel.service;

import com.arg.nahuel.entity.Proyectos;
import com.arg.nahuel.repository.ProyectosRepository;
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
public class ProyectosService {
    
    @Autowired
    ProyectosRepository proyectosRepository;

    public List<Proyectos> list(){
        return proyectosRepository.findAll();
    }

    public Optional<Proyectos> getOne(int id){
        return proyectosRepository.findById(id);
    }

    public Optional<Proyectos> getByNombre(String nombre){
        return proyectosRepository.findByNombre(nombre);
    }
     public Optional<Proyectos> getByFechaProyecto(String fechaProyecto){
        return proyectosRepository.findByFechaProyecto(fechaProyecto);
    }
      
       public Optional<Proyectos> getByDescripcion(String descripcion){
        return proyectosRepository.findByDescripcion(descripcion);
    }
       public Optional<Proyectos> getByLink(String link){
        return proyectosRepository.findByLink(link);
    }
     
    

    public void  save(Proyectos proyectos){
       proyectosRepository.save(proyectos);
    }

    public void delete(int id){
        proyectosRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return proyectosRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre){
        return proyectosRepository.existsByNombre(nombre);
    }
    public boolean existsByFechaProyecto(String fechaProyecto){
        return proyectosRepository.existsByFechaProyecto(fechaProyecto);
    }
   
    public boolean existsByDescripcion(String descripcion){
        return proyectosRepository.existsByDescripcion(descripcion);
    }
     public boolean existsByLink(String link){
        return proyectosRepository.existsByLink(link);
    }
}
