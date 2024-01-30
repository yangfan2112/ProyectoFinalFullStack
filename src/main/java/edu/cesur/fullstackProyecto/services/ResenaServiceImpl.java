package edu.cesur.fullstackProyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;	
import org.springframework.stereotype.Service;

import edu.cesur.fullstackProyecto.dtos.ResenaDTO;
import edu.cesur.fullstackProyecto.entities.Resena;
import edu.cesur.fullstackProyecto.repositories.EventoRepository;
import edu.cesur.fullstackProyecto.repositories.HotelRepository;
import edu.cesur.fullstackProyecto.repositories.ResenaRepository;
import edu.cesur.fullstackProyecto.repositories.UsuarioRepository;

@Service
public class ResenaServiceImpl implements ResenaService {

	@Autowired
	ResenaRepository resenaRepository;
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	EventoRepository eventoRepository;
	@Autowired
	HotelRepository hotelRepository;
	@Autowired
	NegocioService negocioService;


	@Override
	public long crearResena(ResenaDTO resenaDto) {
		Resena resena = new Resena(
				usuarioRepository.findById((long) resenaDto.getUsuario()).orElse(null),
				negocioService.findNegocioById(resenaDto.getNegocio()),
				resenaDto.getPuntuacion(),
				resenaDto.getComentario()
				);
		
		resenaRepository.save(resena);
		return resena.getId();
	}

	@Override
	public List<Resena> getResenas() {
		return resenaRepository.findAll();
	}

}