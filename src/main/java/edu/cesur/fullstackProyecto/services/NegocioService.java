package edu.cesur.fullstackProyecto.services;

import edu.cesur.fullstackProyecto.entities.Negocio;

public interface NegocioService {
	
    public Negocio findNegocioById(Long id);
    public void actualizarValoracion(Long id);

}
