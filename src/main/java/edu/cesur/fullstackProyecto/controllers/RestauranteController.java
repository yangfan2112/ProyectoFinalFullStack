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
import edu.cesur.fullstackProyecto.entities.Restaurante;
import edu.cesur.fullstackProyecto.services.GlobalService;
import edu.cesur.fullstackProyecto.services.RestauranteService;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

	@Autowired
	RestauranteService restauranteService;
	@Autowired
	GlobalService globalService;
	
	@PostMapping("/registrar")
	ResponseEntity<?> crearRestaurante(@RequestBody Restaurante restauranteEntity){
		long id = restauranteService.crearRestaurante(restauranteEntity);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/" + id)
				.buildAndExpand(id)
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping
	ResponseEntity<?> getRestauranteS(){
		
		List<Restaurante> restaurantes = restauranteService.getRestaurantes();
		if(restaurantes.isEmpty()) {
			return ResponseEntity.noContent().build();			
		}
		
		
		return ResponseEntity.ok(restaurantes);
		
	}
	
	@GetMapping("/filtro")
	ResponseEntity<?> getRestaurantesBy(@RequestBody Map<String, String> filtros){
		
        Specification<Restaurante> especificacion = Specifications.filtrar(filtros);
        List<Restaurante> resultados = globalService.buscarRestaurante(especificacion);
        
		return ResponseEntity.ok(resultados);
		
	}
}
