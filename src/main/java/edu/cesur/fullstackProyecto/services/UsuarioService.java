package edu.cesur.fullstackProyecto.services;

import java.util.List;
import java.util.Map;

import edu.cesur.fullstackProyecto.entities.Usuario;

public interface UsuarioService {
	
	long crearUsuario(Usuario usuarioEntity);
	List<Usuario> getUsuarios();
	List<Usuario> getUsuariosby(Map<String, String> filtros);

}
