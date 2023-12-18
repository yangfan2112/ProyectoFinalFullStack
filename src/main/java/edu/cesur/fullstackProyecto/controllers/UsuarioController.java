package edu.cesur.fullstackProyecto.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.cesur.fullstackProyecto.model.UsuarioDTO;
import edu.cesur.fullstackProyecto.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@PostMapping("/registrar")
	ResponseEntity<?> crearUsuario(@RequestBody UsuarioDTO usuarioDTO){
		UsuarioDTO usuario = usuarioService.crearUsuario(usuarioDTO);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/" + usuario.getId())
				.buildAndExpand(usuario.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
		
		
	}
	
	@GetMapping
	ResponseEntity<?> getUsuarios(){
		
		List<UsuarioDTO> usuarios = usuarioService.getUsuarios();
		if(usuarios.isEmpty()) {
			return ResponseEntity.noContent().build();			
		}
		
		return ResponseEntity.ok(usuarios);
		
	}

}
