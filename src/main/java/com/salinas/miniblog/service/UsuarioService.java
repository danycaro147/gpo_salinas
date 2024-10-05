/**
 * 
 */
package com.salinas.miniblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.salinas.miniblog.repository.UsuarioRepository;
import com.salinas.miniblog.service.domain.Usuario;

/**
 * @author daniel
 *
 */
@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario getUsuarioById(@PathVariable Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario updateUsuario(@PathVariable Long id, @RequestBody Usuario usuarioDetails) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario != null) {
            usuario.setUsuario(usuarioDetails.getUsuario());
            usuario.setContrasena(usuarioDetails.getContrasena());
            usuario.setEstado(usuarioDetails.getEstado());
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    public void deleteUsuario(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
    }

}
