package edu.cesur.fullstackProyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.cesur.fullstackProyecto.entities.Restaurante;
import edu.cesur.fullstackProyecto.repositories.RestauranteRepository;

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
	
	@Override
	public void actualizarValoracion(Long id) {
		
		Restaurante restaurante = restauranteRepository.findById(id).orElse(null);

        restaurante.setValoracion(restauranteRepository.obtenerMediaValoracionPorRestaurante(restaurante));

        restauranteRepository.save(restaurante);

	}
}
