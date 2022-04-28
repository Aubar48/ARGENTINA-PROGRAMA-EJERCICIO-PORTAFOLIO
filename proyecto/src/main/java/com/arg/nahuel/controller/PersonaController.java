/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.nahuel.controller;

import com.arg.nahuel.dto.Mensaje;
import com.arg.nahuel.dto.PersonaDto;
import com.arg.nahuel.entity.Persona;
import com.arg.nahuel.service.PersonaService;
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
@RequestMapping("/persona")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    
    @Autowired
    PersonaService personaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }

    @GetMapping("/detailname/{nombre}")
    public ResponseEntity<Persona> getByNombre(@PathVariable("nombre") String nombre){
        if(!personaService.existsByNombre(nombre))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Persona persona = personaService.getByNombre(nombre).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody PersonaDto personaDto){
        if(StringUtils.isBlank(personaDto.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(personaDto.getApellido()))
            return new ResponseEntity(new Mensaje("El apellido es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(personaDto.getNacionalidad()))
            return new ResponseEntity(new Mensaje("La nacionalidad es obligatoria"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(personaDto.getProvincia()))
            return new ResponseEntity(new Mensaje("La provincia es obligatoria"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(personaDto.getCorreo()))
            return new ResponseEntity(new Mensaje("El correo es obligatorio"), HttpStatus.BAD_REQUEST);        
        if(personaService.existsByNombre(personaDto.getNombre()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(personaService.existsByApellido(personaDto.getApellido()))
            return new ResponseEntity(new Mensaje("ese Apellido ya existe"), HttpStatus.BAD_REQUEST);
        if(personaService.existsByNacionalidad(personaDto.getNacionalidad()))
            return new ResponseEntity(new Mensaje("esa nacionalidad ya existe"), HttpStatus.BAD_REQUEST);
        if(personaService.existsByProvincia(personaDto.getProvincia()))
            return new ResponseEntity(new Mensaje("esa provincia ya existe"), HttpStatus.BAD_REQUEST);
        if(personaService.existsByCorreo(personaDto.getCorreo()))
            return new ResponseEntity(new Mensaje("ese correo ya existe"), HttpStatus.BAD_REQUEST);
        if(personaService.existsByNumeroTelefonico(personaDto.getNumeroTelefonico()))
            return new ResponseEntity(new Mensaje("ese NumeroTelefonico ya existe"), HttpStatus.BAD_REQUEST);
        Persona persona = new Persona(personaDto.getNombre(), personaDto.getApellido(), personaDto.getEdad(), personaDto.getNacionalidad(),
        personaDto.getProvincia(), personaDto.getCorreo(), personaDto.getNumeroTelefonico());
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("Persona creada"), HttpStatus.OK);
    }

    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody PersonaDto personaDto){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(personaService.existsByNombre(personaDto.getNombre()) && personaService.getByNombre(personaDto.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(personaDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);        

        Persona persona = personaService.getOne(id).get();
        persona.setNombre(personaDto.getNombre());
        persona.setApellido(personaDto.getApellido());
        persona.setEdad(personaDto.getEdad());
        persona.setNacionalidad(personaDto.getNacionalidad());
        persona.setProvincia(personaDto.getProvincia());
        persona.setCorreo(personaDto.getCorreo());
        persona.setNumeroTelefonico(personaDto.getNumeroTelefonico());
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("persona actualizada"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        personaService.delete(id);
        return new ResponseEntity(new Mensaje("persona eliminada"), HttpStatus.OK);
    }
}
