package edu.cesur.fullstackProyecto.services;

import java.util.List;

import edu.cesur.fullstackProyecto.entities.Restaurante;


public interface RestauranteService {

	long crearRestaurante(Restaurante restauranteEntity);
	List<Restaurante> getRestaurantes();
}
