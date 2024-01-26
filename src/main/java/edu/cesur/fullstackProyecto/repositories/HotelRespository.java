package edu.cesur.fullstackProyecto.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import edu.cesur.fullstackProyecto.entities.Hotel;

@Repository
public interface HotelRespository extends JpaRepository<Hotel, Long>, GlobalRepository<Hotel>{

	@Query("SELECT ROUND(AVG(h.valoracion), 1) FROM Hotel h WHERE h.hotel = :hotel")
	Float obtenerMediaValoracionPorHotel(Hotel hotel);
}
