package edu.cesur.fullstackProyecto.services;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import edu.cesur.fullstackProyecto.entities.Evento;

public interface EventoService {
	
	long crearEvento(Evento evento);
	List<Evento> getEventos();
	Object getEventosby(String campo, String valor) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException;
	void actualizarValoracion(Long id);
}
