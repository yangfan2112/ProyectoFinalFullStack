package edu.cesur.fullstackProyecto.services;

import org.springframework.beans.factory.annotation.Autowired;

import edu.cesur.fullstackProyecto.entities.Usuario;
import edu.cesur.fullstackProyecto.repositories.UsuarioRepository;

public class LoginServiceImpl implements LoginService {

	@Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario login(String email, String contraseña) {
        return usuarioRepository.findByEmailAndContraseña(email, contraseña);
    }
}
