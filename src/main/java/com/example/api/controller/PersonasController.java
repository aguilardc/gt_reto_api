package com.example.api.controller;

import com.example.api.dto.PersonaDTO;
import com.example.api.entity.Persona;
import com.example.api.services.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/personas")
public class PersonasController {

    @Autowired
    private PersonaServiceImpl personaService;


    @PostMapping
    public ResponseEntity<PersonaDTO> create(@RequestBody Persona persona) {
        try {
            PersonaDTO objPersona = personaService.create(persona);
            return ResponseEntity.created(new URI("/api/personas/" + objPersona.getId())).body(objPersona);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<PersonaDTO>> read() {
        return ResponseEntity.ok(personaService.read());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> readById(@PathVariable Long id) {
        PersonaDTO persona = personaService.readById(id);
        if (persona == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(persona);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Persona persona) {
        var persona1 = this.personaService.readById(id);
        if (persona1 == null) return ResponseEntity.notFound().build();
        persona.setId(persona1.getId());
        PersonaDTO objPersona = personaService.update(persona);
        return ResponseEntity.ok(objPersona);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        var persona = personaService.readById(id);
        if (persona == null) return ResponseEntity.notFound().build();
        if (personaService.delete(persona.getId())) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
