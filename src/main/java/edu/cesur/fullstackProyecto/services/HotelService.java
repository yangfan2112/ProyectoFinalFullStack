package edu.cesur.fullstackProyecto.services;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import edu.cesur.fullstackProyecto.entities.Hotel;

public interface HotelService {

	long crearHotel(Hotel hotelEntity);
	List<Hotel> getHoteles();
	
}
