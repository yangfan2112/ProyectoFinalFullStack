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

import edu.cesur.fullstackProyecto.dtos.ResenaDto;
import edu.cesur.fullstackProyecto.entities.Resena;
import edu.cesur.fullstackProyecto.services.ResenaService;

@RestController
@RequestMapping("/resenas")
public class ResenaController {
	
	@Autowired
	ResenaService resenaService;
	
	@PostMapping("/publicar")
	ResponseEntity<?> crearResena(@RequestBody ResenaDto resenaDto){
		long id = resenaService.crearResena(resenaDto);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/" + id)
				.buildAndExpand(id)
				.toUri();
		
		return ResponseEntity.created(location).build();
		
		
	}
	
	@GetMapping
	ResponseEntity<?> getResenas(){
		
		List<Resena> resenas = resenaService.getResenas();
		if(resenas.isEmpty()) {
			return ResponseEntity.noContent().build();			
		}
		
		
		return ResponseEntity.ok(resenas);
		
	}
	
	@GetMapping("/filtros")
	ResponseEntity<?> getResenasBy(@RequestParam String campo, @RequestParam Long valor){
		List<Resena> resenas = null;
		try {
			resenas = resenaService.getResenasby(campo, valor);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(resenas);
		
	}

}
