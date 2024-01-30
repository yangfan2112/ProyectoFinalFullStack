package edu.cesur.fullstackProyecto.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cesur.fullstackProyecto.entities.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long>, GlobalRepository<Evento>{	
    

}