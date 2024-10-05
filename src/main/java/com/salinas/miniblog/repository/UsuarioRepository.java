/**
 * 
 */
package com.salinas.miniblog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salinas.miniblog.service.domain.Usuario;

/**
 * @author daniel
 *
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	@Query(value="DELETE FROM usuario u where u.id not in(select ur.usuario_id from usuariorol ur where ur.usuario_id = :id)", nativeQuery = true)
	Optional<Usuario> deleteUsuarioWithPersona(@Param("id") Long id);

}