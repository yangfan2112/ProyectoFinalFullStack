package edu.cesur.fullstackProyecto.services;

import java.util.List;

import edu.cesur.fullstackProyecto.model.UsuarioDTO;

public interface UsuarioService {
	
	UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO);
	List<UsuarioDTO> getUsuarios();

}
