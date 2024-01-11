package edu.cesur.fullstackProyecto.services;

import java.util.List;

import edu.cesur.fullstackProyecto.entities.UsuarioEntity;
import edu.cesur.fullstackProyecto.model.UsuarioDTO;

public interface UsuarioService {
	
	long crearUsuario(UsuarioEntity usuarioEntity);
	List<UsuarioDTO> getUsuarios();

}
