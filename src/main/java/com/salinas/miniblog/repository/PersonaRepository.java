/**
 * 
 */
package com.salinas.miniblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salinas.miniblog.service.domain.Persona;

/**
 * @author daniel
 *
 */
public interface PersonaRepository extends JpaRepository<Persona, Long> {
	
}