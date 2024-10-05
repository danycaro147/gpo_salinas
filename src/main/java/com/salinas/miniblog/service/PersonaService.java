/**
 * 
 */
package com.salinas.miniblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.salinas.miniblog.repository.PersonaRepository;
import com.salinas.miniblog.service.domain.Persona;

import jakarta.transaction.Transactional;

/**
 * @author daniel
 *
 */
@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Transactional
    public Persona crearPersonaConUsuario(Persona persona) {
        return personaRepository.save(persona);
    }
    
    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }
    
    public Persona getPersonaById(@PathVariable Long id) {
        return personaRepository.findById(id).orElse(null);
    }
    
    public Persona updatePersona(@PathVariable Long id, @RequestBody Persona personaDetails) {
        Persona persona = personaRepository.findById(id).orElse(null);
        if (persona != null) {
            persona.setNombres(personaDetails.getNombres());
            persona.setApellidos(personaDetails.getApellidos());
            persona.setSexo(personaDetails.getSexo());
            persona.setPais(personaDetails.getPais());
            persona.setDireccion(personaDetails.getDireccion());
            return personaRepository.save(persona);
        }
        return null;
    }
    
    public void deletePersona(@PathVariable Long id) {
        personaRepository.deleteById(id);
    }
}
