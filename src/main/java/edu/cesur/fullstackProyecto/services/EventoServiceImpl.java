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
	public Object getEventosby(String campo, String valor) {
		
        switch(campo) {
        case "id":
        	return eventoRepository.buscarPorId(Long.parseLong(valor));
        case "empresa":
        	return eventoRepository.buscarPorEmpresa(valor);
        case "email":
        	return eventoRepository.buscarPorEmail(valor);
        case "tlf":
        	return eventoRepository.buscarPorTlf(valor);
        case "pais":
        	return eventoRepository.buscarPorPais(valor);
        case "fechanaci":
        	return eventoRepository.buscarPorFechaini(valor);
        case "fechafin":
        	return eventoRepository.buscarPorFechafin(valor);
        }
        return null;
	}

}