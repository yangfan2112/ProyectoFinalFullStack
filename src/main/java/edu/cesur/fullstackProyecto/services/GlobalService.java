package edu.cesur.fullstackProyecto.services;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import edu.cesur.fullstackProyecto.entities.Evento;
import edu.cesur.fullstackProyecto.entities.Resena;
import edu.cesur.fullstackProyecto.entities.Usuario;

public interface GlobalService {

	public List<Usuario> buscarUsuario(Specification<Usuario> specification);
	public List<Evento> buscarEvento(Specification<Evento> specification);
	public List<Resena> buscarResena(Specification<Resena> specification);
	
}