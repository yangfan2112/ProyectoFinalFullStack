package edu.cesur.fullstackProyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cesur.fullstackProyecto.entities.Usuario;
import edu.cesur.fullstackProyecto.repositories.UsuarioRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario login(String email, String password) {
        return usuarioRepository.findByEmailAndContraseña(email, password);
    }
}
