/**
 * 
 */
package com.salinas.miniblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salinas.miniblog.service.domain.Rol;

/**
 * @author daniel
 *
 */
public interface RolRepository extends JpaRepository<Rol, Long> {
}