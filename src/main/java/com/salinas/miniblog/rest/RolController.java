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

import com.salinas.miniblog.service.RolService;
import com.salinas.miniblog.service.domain.Rol;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/api/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @PostMapping
    public Rol createRol(@RequestBody Rol rol) {
        return rolService.createRol(rol);
    }
    
    @GetMapping()
    public List<Rol> getAllRoles() {
        return rolService.getAllRoles();
    }

    @GetMapping("/{id}")
    public Rol getRolById(@PathVariable Long id) {
        return rolService.getRolById(id);
    }

    @PutMapping("/{id}")
    public Rol updateRol(@PathVariable Long id, @RequestBody Rol rolDetails) {
        return rolService.updateRol(id, rolDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteRol(@PathVariable Long id) {
        rolService.deleteRol(id);
    }
}