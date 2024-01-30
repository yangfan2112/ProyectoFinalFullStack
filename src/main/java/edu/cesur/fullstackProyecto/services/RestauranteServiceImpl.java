package edu.cesur.fullstackProyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cesur.fullstackProyecto.entities.Restaurante;
import edu.cesur.fullstackProyecto.repositories.RestauranteRepository;

@Service
public class RestauranteServiceImpl implements RestauranteService {

	@Autowired
	RestauranteRepository restauranteRepository;
	
	@Override
	public long crearRestaurante(Restaurante restauranteEntity) {
		restauranteRepository.save(restauranteEntity);
		return restauranteEntity.getId();
	}

	@Override
	public List<Restaurante> getRestaurantes() {
		return restauranteRepository.findAll();
	}

}
