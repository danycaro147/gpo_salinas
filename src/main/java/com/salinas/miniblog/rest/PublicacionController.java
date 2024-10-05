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

import com.salinas.miniblog.service.PublicacionService;
import com.salinas.miniblog.service.domain.Publicacion;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/api/publicaciones")
public class PublicacionController {

    @Autowired
    private PublicacionService publicacionService;

    @PostMapping
    public Publicacion createPublicacion(@RequestBody Publicacion publicacion) {
        return publicacionService.createPublicacion(publicacion);
    }
    
    @GetMapping
    public List<Publicacion> getAllPublicaciones() {
        return publicacionService.getAllPublicaciones();
    }

    @GetMapping("/{id}")
    public Publicacion getPublicacionById(@PathVariable Long id) {
        return publicacionService.getPublicacionById(id);
    }
    
    @PutMapping("/{id}")
    public Publicacion updatePublicacion(@PathVariable Long id, @RequestBody Publicacion publicacionDetails) {
        return publicacionService.updatePublicacion(id, publicacionDetails);
    }

    @GetMapping("/persona/{personaId}")
    public List<Publicacion> getPublicacionesByPersona(@PathVariable Long personaId) {
        return publicacionService.getPublicacionesByPersona(personaId);
    }

    @DeleteMapping("/{id}")
    public void deletePublicacion(@PathVariable Long id) {
    	publicacionService.deletePublicacion(id);
    }
}