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
import edu.cesur.fullstackProyecto.dtos.ResenaDTO;
import edu.cesur.fullstackProyecto.entities.Resena;
import edu.cesur.fullstackProyecto.services.EventoService;
import edu.cesur.fullstackProyecto.services.GlobalService;
import edu.cesur.fullstackProyecto.services.ResenaService;

@RestController
@RequestMapping("/resenas")
public class ResenaController {
	
	@Autowired
	ResenaService resenaService;
	@Autowired
	EventoService eventoService;
	@Autowired
	GlobalService globalService;
	
	@PostMapping("/publicar")
	ResponseEntity<?> crearResena(@RequestBody ResenaDTO resenaDto){
		long id = resenaService.crearResena(resenaDto);
		eventoService.actualizarValoracion(resenaDto.getEvento());
		
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
	
	@GetMapping("/filtro")
	ResponseEntity<?> getResenasBy(@RequestBody Map<String, String> filtros){
		
        Specification<Resena> especificacion = Specifications.filtrar(filtros);
        List<Resena> resultados = globalService.buscarResena(especificacion);
        
		return ResponseEntity.ok(resultados);
		
	}

}
