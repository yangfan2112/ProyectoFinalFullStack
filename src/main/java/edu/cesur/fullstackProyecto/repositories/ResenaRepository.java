package edu.cesur.fullstackProyecto.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.cesur.fullstackProyecto.entities.Resena;

@Repository
public interface ResenaRepository extends JpaRepository<Resena, Long>, GlobalRepository<Resena>{	

} 