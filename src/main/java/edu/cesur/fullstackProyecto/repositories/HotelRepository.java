package edu.cesur.fullstackProyecto.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.cesur.fullstackProyecto.entities.Hotel;
import edu.cesur.fullstackProyecto.entities.Restaurante;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long>, GlobalRepository<Hotel>{

}
