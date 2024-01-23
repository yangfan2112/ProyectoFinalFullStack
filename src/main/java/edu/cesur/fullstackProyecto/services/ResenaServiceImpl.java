package edu.cesur.fullstackProyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;	
import org.springframework.stereotype.Service;

import edu.cesur.fullstackProyecto.dtos.ResenaDTO;
import edu.cesur.fullstackProyecto.entities.Resena;
import edu.cesur.fullstackProyecto.repositories.EventoRepository;
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
				usuarioRepository.buscarPorId((long) resenaDto.getUsuario()),
				eventoRepository.buscarPorId((long) resenaDto.getEvento()),
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

	@Override
	public List<Resena> getResenasby(String campo, Long valor) {
		
        switch(campo) {
        case "usuario":
        	return resenaRepository.buscarPorUsuario(valor);
        case "evento":
        	return resenaRepository.buscarPorEvento(valor);
        }
        return null;
	}

}