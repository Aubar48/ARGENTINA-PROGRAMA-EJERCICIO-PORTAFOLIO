/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.nahuel.controller;

import com.arg.nahuel.dto.Mensaje;
import com.arg.nahuel.dto.TrabajoDto;
import com.arg.nahuel.entity.Trabajo;
import com.arg.nahuel.service.TrabajoService;
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
@RequestMapping("/trabajo")
@CrossOrigin(origins = "http://localhost:4200")
public class TrabajoController {
    @Autowired
    TrabajoService trabajoService;

    @GetMapping("/lista")
    public ResponseEntity<List<Trabajo>> list(){
        List<Trabajo> list = trabajoService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Trabajo> getById(@PathVariable("id") int id){
        if(!trabajoService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Trabajo trabajo = trabajoService.getOne(id).get();
        return new ResponseEntity(trabajo, HttpStatus.OK);
    }

    @GetMapping("/detailname/{nombre}")
    public ResponseEntity<Trabajo> getByNombre(@PathVariable("nombre") String nombre){
        if(!trabajoService.existsByNombre(nombre))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Trabajo trabajo = trabajoService.getByNombre(nombre).get();
        return new ResponseEntity(trabajo, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody TrabajoDto trabajoDto){
        if(StringUtils.isBlank(trabajoDto.getNombre()))
            return new ResponseEntity(new Mensaje("El campo nombre es obligatorio"), HttpStatus.BAD_REQUEST);     
        if(StringUtils.isBlank(trabajoDto.getDescripcion()))
            return new ResponseEntity(new Mensaje("El campo descripcion es obligatorio"), HttpStatus.BAD_REQUEST);           
        if(trabajoService.existsByNombre(trabajoDto.getNombre()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);  
        if(trabajoService.existsByDescripcion(trabajoDto.getDescripcion()))
            return new ResponseEntity(new Mensaje("El campo descripcion ya existe"), HttpStatus.BAD_REQUEST);        
        Trabajo trabajo = new Trabajo(trabajoDto.getNombre(), trabajoDto.getDesde(), trabajoDto.getHasta(), trabajoDto.getDescripcion());
        trabajoService.save(trabajo);
        return new ResponseEntity(new Mensaje("trabajo creado"), HttpStatus.OK);
    }
 
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody TrabajoDto trabajoDto){
        if(!trabajoService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(trabajoService.existsByNombre(trabajoDto.getNombre()) && trabajoService.getByNombre(trabajoDto.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(trabajoDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);        

        Trabajo trabajo = trabajoService.getOne(id).get();
        trabajo.setNombre(trabajoDto.getNombre());
        trabajo.setDesde(trabajoDto.getDesde());
        trabajo.setHasta(trabajoDto.getHasta());
        trabajo.setDescripcion(trabajoDto.getDescripcion());
        
        trabajoService.save(trabajo);
        return new ResponseEntity(new Mensaje("trabajo actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!trabajoService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        trabajoService.delete(id);
        return new ResponseEntity(new Mensaje("trabajo eliminado"), HttpStatus.OK);
    }
}
