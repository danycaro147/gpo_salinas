/**
 * 
 */
package com.salinas.miniblog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salinas.miniblog.service.domain.Publicacion;

/**
 * @author daniel
 *
 */
public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {
    List<Publicacion> findByPersonaId(Long personaId);
}