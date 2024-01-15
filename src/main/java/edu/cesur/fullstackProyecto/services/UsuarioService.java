package edu.cesur.fullstackProyecto.services;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import edu.cesur.fullstackProyecto.entities.Usuario;

public interface UsuarioService {
	
	long crearUsuario(Usuario usuarioEntity);
	List<Usuario> getUsuarios();
	List<Usuario> getUsuariosby(String campo, String valor) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException;

}
