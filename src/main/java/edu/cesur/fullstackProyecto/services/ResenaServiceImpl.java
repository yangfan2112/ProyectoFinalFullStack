package edu.cesur.fullstackProyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;	
import org.springframework.stereotype.Service;

import edu.cesur.fullstackProyecto.dtos.ResenaDTO;
import edu.cesur.fullstackProyecto.entities.Resena;
import edu.cesur.fullstackProyecto.repositories.EventoRepository;
import edu.cesur.fullstackProyecto.repositories.HotelRespository;
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
	

	@Override
	public long crearResena(ResenaDTO resenaDto) {
		Resena resena = new Resena(
				usuarioRepository.findById((long) resenaDto.getUsuario()).orElse(null),
				eventoRepository.findById((long) resenaDto.getEvento()).orElse(null),
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