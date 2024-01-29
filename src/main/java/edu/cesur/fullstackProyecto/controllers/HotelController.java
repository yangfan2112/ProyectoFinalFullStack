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
import edu.cesur.fullstackProyecto.entities.Hotel;
import edu.cesur.fullstackProyecto.services.GlobalService;
import edu.cesur.fullstackProyecto.services.HotelService;


@RestController
@RequestMapping("/hoteles")
public class HotelController {

	@Autowired
	HotelService hotelService;
	@Autowired
	GlobalService globalService;
	
	@PostMapping("/registrarHotel")
	ResponseEntity<?> crearHotel(@RequestBody Hotel hotelEntity){
		long id = hotelService.crearHotel(hotelEntity);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/" + id)
				.buildAndExpand(id)
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping
	ResponseEntity<?> getHoteles(){
		
		List<Hotel> hoteles = hotelService.getHoteles();
		if(hoteles.isEmpty()) {
			return ResponseEntity.noContent().build();			
		}
		
		
		return ResponseEntity.ok(hoteles);
		
	}
	
	@GetMapping("/filtro")
	ResponseEntity<?> getHotelesBy(@RequestBody Map<String, String> filtros){
		
        Specification<Hotel> especificacion = Specifications.filtrar(filtros);
        List<Hotel> resultados = globalService.buscarHotel(especificacion);
        
		return ResponseEntity.ok(resultados);
		
	}
}
