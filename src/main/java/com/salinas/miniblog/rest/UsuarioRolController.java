/**
 * 
 */
package com.salinas.miniblog.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salinas.miniblog.service.UsuarioRolService;
import com.salinas.miniblog.service.domain.Usuario;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioRolController {

    @Autowired
    private UsuarioRolService usuarioRolService;

    @PostMapping("/{usuarioId}/roles/{rolId}")
    public Usuario asignarRolAUsuario(@PathVariable Long usuarioId, @PathVariable Long rolId) {
        return usuarioRolService.asignarRolAUsuario(usuarioId, rolId);
    }
}