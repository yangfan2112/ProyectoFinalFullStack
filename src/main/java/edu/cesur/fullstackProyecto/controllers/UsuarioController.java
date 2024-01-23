package edu.cesur.fullstackProyecto.controllers;

import java.net.URI;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.cesur.fullstackProyecto.Specifications.Specifications;
import edu.cesur.fullstackProyecto.entities.Usuario;
import edu.cesur.fullstackProyecto.services.GlobalService;
import edu.cesur.fullstackProyecto.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	@Autowired
	GlobalService globalService;
	
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
	ResponseEntity<?> getUsuariosBy(@RequestBody Map<String, String> filtros){

        Specification<Usuario> especificacion = Specifications.filtrar(filtros);
        List<Usuario> resultados = globalService.buscarUsuario(especificacion);
        
		return ResponseEntity.ok(resultados);
		
	}

}
