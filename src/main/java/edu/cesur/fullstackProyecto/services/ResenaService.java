package edu.cesur.fullstackProyecto.services;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import edu.cesur.fullstackProyecto.dtos.ResenaDto;
import edu.cesur.fullstackProyecto.entities.Resena;

public interface ResenaService {
	
	long crearResena(ResenaDto resena);
	List<Resena> getResenas();
	List<Resena> getResenasby(String campo, Long valor) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException;

}
