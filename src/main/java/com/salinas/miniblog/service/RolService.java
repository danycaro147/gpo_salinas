package com.salinas.miniblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.salinas.miniblog.repository.RolRepository;
import com.salinas.miniblog.service.domain.Rol;

@Service
public class RolService {
	
	@Autowired
	private RolRepository rolRepository;
	
	public List<Rol> getAllRoles() {
        return rolRepository.findAll();
    }
	
	public Rol createRol(@RequestBody Rol rol) {
        return rolRepository.save(rol);
    }
	
	public Rol getRolById(@PathVariable Long id) {
        return rolRepository.findById(id).orElse(null);
    }
	
	public Rol updateRol(@PathVariable Long id, @RequestBody Rol rolDetails) {
        Rol rol = rolRepository.findById(id).orElse(null);
        if (rol != null) {
            rol.setTipo(rolDetails.getTipo());
            return rolRepository.save(rol);
        }
        return null;
    }
	
	public void deleteRol(@PathVariable Long id) {
        rolRepository.deleteById(id);
    }

}
