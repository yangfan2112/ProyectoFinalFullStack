package edu.cesur.fullstackProyecto.services;

import java.util.List;

import edu.cesur.fullstackProyecto.dtos.ResenaDTO;
import edu.cesur.fullstackProyecto.entities.Resena;

public interface ResenaService {
	
	long crearResena(ResenaDTO resena);
	List<Resena> getResenas();

}
