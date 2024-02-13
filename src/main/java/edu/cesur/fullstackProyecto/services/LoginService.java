package edu.cesur.fullstackProyecto.services;

import edu.cesur.fullstackProyecto.entities.Usuario;

public interface LoginService {

	Usuario login(String email, String contraseña);
}
