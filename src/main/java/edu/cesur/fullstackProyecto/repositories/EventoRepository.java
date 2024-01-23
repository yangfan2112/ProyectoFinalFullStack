package edu.cesur.fullstackProyecto.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.cesur.fullstackProyecto.entities.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long>, GlobalRepository<Evento>{	
    
    @Query("SELECT ROUND(AVG(e.valoracion), 1) FROM Resena e WHERE e.evento = :evento")
    Float obtenerMediaValoracionPorEvento(Evento evento);

}