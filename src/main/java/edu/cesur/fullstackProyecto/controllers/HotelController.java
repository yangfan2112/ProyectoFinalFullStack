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

import edu.cesur.fullstackProyecto.entities.Hotel;
import edu.cesur.fullstackProyecto.entities.Usuario;
import edu.cesur.fullstackProyecto.services.HotelService;


@RestController
@RequestMapping("/hoteles")
public class HotelController {

	@Autowired
	HotelService hotelService;
	
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
}
