/**
 * 
 */
package com.salinas.miniblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.salinas.miniblog.repository.PublicacionRepository;
import com.salinas.miniblog.service.domain.Publicacion;

/**
 * @author daniel
 *
 */
@Service
public class PublicacionService {
	
	@Autowired
	private PublicacionRepository publicacionRepository;
	
	public Publicacion createPublicacion(@RequestBody Publicacion publicacion) {
        return publicacionRepository.save(publicacion);
    }
    
    public List<Publicacion> getAllPublicaciones() {
        return publicacionRepository.findAll();
    }

    public Publicacion getPublicacionById(@PathVariable Long id) {
        return publicacionRepository.findById(id).orElse(null);
    }
    
    public Publicacion updatePublicacion(@PathVariable Long id, @RequestBody Publicacion publicacionDetails) {
        Publicacion pub = publicacionRepository.findById(id).orElse(null);
        if (pub != null) {
        	pub.setCuerpo(publicacionDetails.getCuerpo());
            return publicacionRepository.save(pub);
        }
        return null;
    }

    public List<Publicacion> getPublicacionesByPersona(@PathVariable Long personaId) {
        return publicacionRepository.findByPersonaId(personaId);
    }

    public void deletePublicacion(@PathVariable Long id) {
        publicacionRepository.deleteById(id);
    }
}
