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
import edu.cesur.fullstackProyecto.entities.Evento;
import edu.cesur.fullstackProyecto.services.EventoService;
import edu.cesur.fullstackProyecto.services.GlobalService;

@RestController
@RequestMapping("/eventos")
public class EventoController {
	
	@Autowired
	EventoService eventoService;
	@Autowired
	GlobalService globalService;
	
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
		
		List<Evento> eventos = eventoService.getEventosOrderedByValoracionDesc();
		if(eventos.isEmpty()) {
			return ResponseEntity.noContent().build();			
		}
		
		
		return ResponseEntity.ok(eventos);
		
	}
	
	@GetMapping("/filtro")
	ResponseEntity<?> getEventosBy(@RequestBody Map<String, String> filtros){
		
        Specification<Evento> especificacion = Specifications.filtrar(filtros);
        List<Evento> resultados = globalService.buscarEvento(especificacion);
        
		return ResponseEntity.ok(resultados);
		
	}

}
