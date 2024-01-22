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

import edu.cesur.fullstackProyecto.entities.Evento;
import edu.cesur.fullstackProyecto.services.EventoService;

@RestController
@RequestMapping("/eventos")
public class EventoController {
	
	@Autowired
	EventoService eventoService;
	
	@PostMapping("/registrar")
	ResponseEntity<?> crearEvento(@RequestBody Evento evento){
		long id = eventoService.crearEvento(evento);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/" + id)
				.buildAndExpand(id)
				.toUri();
		
		return ResponseEntity.created(location).build();
		
		
	}
	
	@GetMapping
	ResponseEntity<?> getEventos(){
		
		List<Evento> eventos = eventoService.getEventos();
		if(eventos.isEmpty()) {
			return ResponseEntity.noContent().build();			
		}
		
		
		return ResponseEntity.ok(eventos);
		
	}
	
	@GetMapping("/filtros")
	ResponseEntity<?> getEventosBy(@RequestParam String campo, @RequestParam String valor){
		List<Evento> eventos = null;
		try {
			eventos = (List<Evento>) eventoService.getEventosby(campo, valor);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(eventos);
		
	}

}
