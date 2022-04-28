/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.nahuel.controller;
import com.arg.nahuel.dto.Mensaje;
import com.arg.nahuel.dto.ProyectosDto;
import com.arg.nahuel.entity.Proyectos;
import com.arg.nahuel.service.ProyectosService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author Nnahu
 */
@RestController
@RequestMapping("/proyectos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProyectosController {
    @Autowired
    ProyectosService proyectosService;

    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list(){
        List<Proyectos> list = proyectosService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id){
        if(!proyectosService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyectos proyectos = proyectosService.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }

    @GetMapping("/detailname/{nombre}")
    public ResponseEntity<Proyectos> getByNombre(@PathVariable("nombre") String nombre){
        if(!proyectosService.existsByNombre(nombre))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyectos proyectos = proyectosService.getByNombre(nombre).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProyectosDto proyectosDto){
        if(StringUtils.isBlank(proyectosDto.getNombre()))
            return new ResponseEntity(new Mensaje("El campo nombre es obligatorio"), HttpStatus.BAD_REQUEST);     
        if(StringUtils.isBlank(proyectosDto.getDescripcion()))
            return new ResponseEntity(new Mensaje("El campo descripcion es obligatorio"), HttpStatus.BAD_REQUEST);           
        if(proyectosService.existsByNombre(proyectosDto.getNombre()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);  
        if(proyectosService.existsByDescripcion(proyectosDto.getDescripcion()))
            return new ResponseEntity(new Mensaje("El campo descripcion ya existe"), HttpStatus.BAD_REQUEST);        
        Proyectos proyectos = new Proyectos(proyectosDto.getNombre(), proyectosDto.getFechaProyecto(), proyectosDto.getDescripcion(), proyectosDto.getLink());
        proyectosService.save(proyectos);
        return new ResponseEntity(new Mensaje("proyecto creado"), HttpStatus.OK);
    }
 
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody ProyectosDto proyectosDto){
        if(!proyectosService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(proyectosService.existsByNombre(proyectosDto.getNombre()) && proyectosService.getByNombre(proyectosDto.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(proyectosDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);        

        Proyectos proyectos = proyectosService.getOne(id).get();
        proyectos.setNombre(proyectosDto.getNombre());
        proyectos.setFechaProyecto(proyectosDto.getFechaProyecto());
        proyectos.setDescripcion(proyectosDto.getDescripcion());
        proyectos.setLink(proyectosDto.getLink());
        
       proyectosService.save(proyectos);
        return new ResponseEntity(new Mensaje("proyecto actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!proyectosService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        proyectosService.delete(id);
        return new ResponseEntity(new Mensaje("proyecto eliminado"), HttpStatus.OK);
    }
}
