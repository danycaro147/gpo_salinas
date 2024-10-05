/**
 * 
 */
package com.salinas.miniblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salinas.miniblog.repository.RolRepository;
import com.salinas.miniblog.repository.UsuarioRepository;
import com.salinas.miniblog.repository.UsuarioRolRepository;
import com.salinas.miniblog.service.domain.Rol;
import com.salinas.miniblog.service.domain.Usuario;
import com.salinas.miniblog.service.domain.UsuarioRol;

import jakarta.transaction.Transactional;

/**
 * @author daniel
 *
 */
@Service
public class UsuarioRolService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private UsuarioRolRepository usuarioRolRepository;

    @Transactional
    public Usuario asignarRolAUsuario(Long usuarioId, Long rolId) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Rol rol = rolRepository.findById(rolId).orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(usuario);
        usuarioRol.setRol(rol);

        usuario.getUsuarioRoles().add(usuarioRol);
        rol.getUsuarioRoles().add(usuarioRol);

        usuarioRolRepository.save(usuarioRol);

        return usuario;
    }
}