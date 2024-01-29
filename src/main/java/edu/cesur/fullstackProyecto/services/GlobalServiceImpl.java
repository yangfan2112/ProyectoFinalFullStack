package edu.cesur.fullstackProyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import edu.cesur.fullstackProyecto.entities.Evento;
import edu.cesur.fullstackProyecto.entities.Hotel;
import edu.cesur.fullstackProyecto.entities.Resena;
import edu.cesur.fullstackProyecto.entities.Restaurante;
import edu.cesur.fullstackProyecto.entities.Usuario;
import edu.cesur.fullstackProyecto.repositories.GlobalRepository;

import java.util.List;

@Service
public class GlobalServiceImpl implements GlobalService {

    @Autowired
    GlobalRepository<Usuario> globalUsuarioRepository;
    @Autowired
    GlobalRepository<Evento> globalEventoRepository;
    @Autowired
    GlobalRepository<Resena> globalResenaRepository;
    @Autowired
    GlobalRepository<Hotel> globalHotelRepository;
    @Autowired
    GlobalRepository<Restaurante> globalRestauranteRepository;

    public List<Usuario> buscarUsuario(Specification<Usuario> specification) {
        return globalUsuarioRepository.findAll(specification);
    }
    
    public List<Evento> buscarEvento(Specification<Evento> specification) {
        return globalEventoRepository.findAll(specification);
    }

	public List<Resena> buscarResena(Specification<Resena> specification) {
		return globalResenaRepository.findAll(specification);
	}

	public List<Hotel> buscarHotel(Specification<Hotel> specification) {
		return globalHotelRepository.findAll(specification);
	}
	
	public List<Restaurante> buscarRestaurante(Specification<Restaurante> specification) {
		return globalRestauranteRepository.findAll(specification);
	}
}
