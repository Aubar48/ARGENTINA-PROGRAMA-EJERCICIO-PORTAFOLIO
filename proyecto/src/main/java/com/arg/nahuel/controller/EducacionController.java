/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.nahuel.controller;
import com.arg.nahuel.dto.EducacionDto;
import com.arg.nahuel.dto.Mensaje;
import com.arg.nahuel.entity.Educacion;
import com.arg.nahuel.service.EducacionService;
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
@RequestMapping("/educacion")
@CrossOrigin(origins = "http://localhost:4200")
public class EducacionController {
    @Autowired
    EducacionService educacionService;

    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = educacionService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!educacionService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Educacion educacion = educacionService.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    @GetMapping("/detailname/{nombre}")
    public ResponseEntity<Educacion> getByNombre(@PathVariable("nombre") String nombre){
        if(!educacionService.existsByNombre(nombre))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Educacion educacion = educacionService.getByNombre(nombre).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody EducacionDto educacionDto){
        if(StringUtils.isBlank(educacionDto.getNombre()))
            return new ResponseEntity(new Mensaje("El campo nombre es obligatorio"), HttpStatus.BAD_REQUEST);     
        if(StringUtils.isBlank(educacionDto.getDescripcion()))
            return new ResponseEntity(new Mensaje("El campo descripcion es obligatorio"), HttpStatus.BAD_REQUEST);           
        if(educacionService.existsByNombre(educacionDto.getNombre()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);  
        if(educacionService.existsByDescripcion(educacionDto.getDescripcion()))
            return new ResponseEntity(new Mensaje("El campo descripcion ya existe"), HttpStatus.BAD_REQUEST);        
        Educacion educacion = new Educacion(educacionDto.getNombre(), educacionDto.getDesde(), educacionDto.getHasta(), educacionDto.getDescripcion());
        educacionService.save(educacion);
        return new ResponseEntity(new Mensaje("educacion creada"), HttpStatus.OK);
    }
 
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody EducacionDto educacionDto){
        if(!educacionService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(educacionService.existsByNombre(educacionDto.getNombre()) && educacionService.getByNombre(educacionDto.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(educacionDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);        

        Educacion educacion = educacionService.getOne(id).get();
        educacion.setNombre(educacionDto.getNombre());
        educacion.setDesde(educacionDto.getDesde());
        educacion.setHasta(educacionDto.getHasta());
        educacion.setDescripcion(educacionDto.getDescripcion());
        
        educacionService.save(educacion);
        return new ResponseEntity(new Mensaje("trabajo actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!educacionService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        educacionService.delete(id);
        return new ResponseEntity(new Mensaje("educacion eliminada"), HttpStatus.OK);
    }
}
