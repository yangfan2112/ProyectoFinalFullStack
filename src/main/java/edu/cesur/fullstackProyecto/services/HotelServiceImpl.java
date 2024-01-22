package edu.cesur.fullstackProyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cesur.fullstackProyecto.entities.Hotel;
import edu.cesur.fullstackProyecto.repositories.HotelRespository;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	HotelRespository hotelRepository;
	
	@Override
	public long crearHotel(Hotel hotelEntity) {
		hotelRepository.save(hotelEntity);
		return hotelEntity.getId();
	}

	@Override
	public List<Hotel> getHoteles() {
		return hotelRepository.findAll();
	}

}
