package edu.cesur.fullstackProyecto.controllers;

import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.cesur.fullstackProyecto.dtos.FiltroDTO;
import edu.cesur.fullstackProyecto.entities.Usuario;
import edu.cesur.fullstackProyecto.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@PostMapping("/registrar")
	ResponseEntity<?> crearUsuario(@RequestBody Usuario usuarioEntity){
		long id = usuarioService.crearUsuario(usuarioEntity);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/" + id)
				.buildAndExpand(id)
				.toUri();	
		
		return ResponseEntity.created(location).build();
		
		
	}
	
	@GetMapping
	ResponseEntity<?> getUsuarios(){
		
		List<Usuario> usuarios = usuarioService.getUsuarios();
		if(usuarios.isEmpty()) {
			return ResponseEntity.noContent().build();			
		}
		
		
		return ResponseEntity.ok(usuarios);
		
	}
	
	@GetMapping("/filtro")
	ResponseEntity<?> getUsuariosBy(@RequestBody List<FiltroDTO> filtroDTO){

		return ResponseEntity.ok(usuarioService.getUsuariosby(filtroDTO));
		
	}

}
