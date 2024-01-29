package edu.cesur.fullstackProyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.cesur.fullstackProyecto.entities.Restaurante;



@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long>, GlobalRepository<Restaurante>{

	@Query("SELECT ROUND(AVG(r.valoracion), 1) FROM Resena r WHERE r.restaurante = :restaurante")
    Float obtenerMediaValoracionPorRestaurante(Restaurante restaurante);
}