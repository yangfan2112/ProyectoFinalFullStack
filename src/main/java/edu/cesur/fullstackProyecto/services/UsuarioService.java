package edu.cesur.fullstackProyecto.services;

import java.util.List;

import edu.cesur.fullstackProyecto.entities.Usuario;
import edu.cesur.fullstackProyecto.model.UsuarioDTO;

public interface UsuarioService {
	
	long crearUsuario(Usuario usuarioEntity);
	List<Usuario> getUsuarios();

}
