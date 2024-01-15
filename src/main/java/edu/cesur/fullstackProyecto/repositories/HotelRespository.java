package edu.cesur.fullstackProyecto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.cesur.fullstackProyecto.entities.Hotel;

@Repository
public interface HotelRespository extends JpaRepository<Hotel, Long>{

	@Query("SELECT h FROM Hotel h WHERE h.valoracion = :valoracion")
    List<Hotel> buscarPorValoracion(String valoracion);
    
	@Query("SELECT h FROM Hotel h WHERE h.ubicacion = :ubicacion")
    List<Hotel> buscarPorUbicacion(String ubicacion);
    
	@Query("SELECT h FROM Hotel h WHERE h.tipoHab = :tipoHab")
    List<Hotel> buscarPorTipoHabitacion(String tipoHab);
    
	@Query("SELECT h FROM Hotel h WHERE h.tlf = :tlf")
    List<Hotel> buscarPortlf(String tlf);
    
	@Query("SELECT h FROM Hotel h WHERE h.servicios = :servicios")
    List<Hotel> buscarPorServicios(String servicios);
}
