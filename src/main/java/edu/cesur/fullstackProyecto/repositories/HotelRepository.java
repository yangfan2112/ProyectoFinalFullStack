package edu.cesur.fullstackProyecto.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.cesur.fullstackProyecto.entities.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long>, GlobalRepository<Hotel>{

}
