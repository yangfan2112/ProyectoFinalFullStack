package edu.cesur.fullstackProyecto.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.cesur.fullstackProyecto.entities.Negocio;
import edu.cesur.fullstackProyecto.entities.Resena;

@Repository
public interface ResenaRepository extends JpaRepository<Resena, Long>, GlobalRepository<Resena>{	
	
  @Query("SELECT ROUND(AVG(e.valoracion), 1) FROM Resena e WHERE e.negocio = :negocio")
  Float obtenerMediaValoracion(Negocio negocio);

} 