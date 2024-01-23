package edu.cesur.fullstackProyecto.services;

import java.util.List;

import edu.cesur.fullstackProyecto.entities.Usuario;

public interface UsuarioService {
	
	long crearUsuario(Usuario usuarioEntity);
	List<Usuario> getUsuarios();

}
