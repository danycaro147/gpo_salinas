/**
 * 
 */
package com.salinas.miniblog.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salinas.miniblog.service.PersonaService;
import com.salinas.miniblog.service.domain.Persona;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/api/personas")
public class PersonaController {
    
    @Autowired
    private PersonaService personaService;

    @PostMapping
    public Persona createPersona(@RequestBody Persona persona) {
    	return personaService.crearPersonaConUsuario(persona);
    }
    
    @GetMapping
    public List<Persona> getAllPersonas() {
        return personaService.getAllPersonas();
    }

    @GetMapping("/{id}")
    public Persona getPersonaById(@PathVariable Long id) {
        return personaService.getPersonaById(id);
    }

    @PutMapping("/{id}")
    public Persona updatePersona(@PathVariable Long id, @RequestBody Persona personaDetails) {
        return personaService.updatePersona(id, personaDetails);
    }

    @DeleteMapping("/{id}")
    public void deletePersona(@PathVariable Long id) {
        personaService.deletePersona(id);
    }
}