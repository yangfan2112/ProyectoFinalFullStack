package edu.cesur.fullstackProyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cesur.fullstackProyecto.entities.Evento;
import edu.cesur.fullstackProyecto.entities.Hotel;
import edu.cesur.fullstackProyecto.entities.Negocio;
import edu.cesur.fullstackProyecto.repositories.EventoRepository;
import edu.cesur.fullstackProyecto.repositories.HotelRepository;
import edu.cesur.fullstackProyecto.repositories.ResenaRepository;

@Service
public class NegocioServiceImpl implements NegocioService{
    
	@Autowired
	EventoRepository eventoRepository;
	@Autowired
	HotelRepository hotelRepository;
	@Autowired
	ResenaRepository resenaRepository;


    public Negocio findNegocioById(Long id) {
        if (eventoRepository.findById(id).orElse(null) != null) {
        	return eventoRepository.findById(id).orElse(null);
        	
        } else if (hotelRepository.findById(id).orElse(null) != null) {
        	return hotelRepository.findById(id).orElse(null);
        	
        } else {
        	return null;
        }
    }

	@Override
	public void actualizarValoracion(Long id) {
		Negocio negocio = findNegocioById(id);
		negocio.setValoracion(resenaRepository.obtenerMediaValoracion(negocio));

        if (negocio instanceof Evento) {
            eventoRepository.save((Evento) negocio);
        } else if (negocio instanceof Hotel) {
            hotelRepository.save((Hotel) negocio);
        }
		
	}
}
