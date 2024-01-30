package edu.cesur.fullstackProyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;	
import org.springframework.stereotype.Service;

import edu.cesur.fullstackProyecto.entities.Evento;
import edu.cesur.fullstackProyecto.repositories.EventoRepository;

@Service
public class EventoServiceImpl implements EventoService {

	@Autowired
	EventoRepository eventoRepository;

	@Override
	public long crearEvento(Evento evento) {
		
		eventoRepository.save(evento);
		return evento.getId();
	}

	@Override
	public List<Evento> getEventos() {
		return eventoRepository.findAll();
	}

	@Override
	public void actualizarValoracion(Long id) {
		
		Evento evento = eventoRepository.findById(id).orElse(null);

//        evento.setValoracion(eventoRepository.obtenerMediaValoracionPorEvento(evento));

        eventoRepository.save(evento);

	}

}