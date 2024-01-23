package edu.cesur.fullstackProyecto.services;

import java.util.List;

import edu.cesur.fullstackProyecto.entities.Evento;

public interface EventoService {
	
	long crearEvento(Evento evento);
	List<Evento> getEventos();
	void actualizarValoracion(Long id);
}
