package edu.cesur.fullstackProyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import edu.cesur.fullstackProyecto.entities.Hotel;
import edu.cesur.fullstackProyecto.repositories.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	HotelRepository hotelRepository;
	
	@Override
	public long crearHotel(Hotel hotelEntity) {
		hotelRepository.save(hotelEntity);
		return hotelEntity.getId();
	}

	@Override
	public List<Hotel> getHotelesOrderedByValoracionDesc() {
		return hotelRepository.findAll(Sort.by(Sort.Direction.DESC, "valoracion"));
	}
	

}
