package edu.cesur.fullstackProyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;	
import org.springframework.stereotype.Service;

import edu.cesur.fullstackProyecto.entities.Usuario;
import edu.cesur.fullstackProyecto.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public long crearUsuario(Usuario usuarioEntity) {
		
		usuarioRepository.save(usuarioEntity);
		return usuarioEntity.getId();
	}

	@Override
	public List<Usuario> getUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public Object getUsuariosby(String campo, String valor) {
		
        switch(campo) {
        case "id":
        	return usuarioRepository.buscarPorId(Long.parseLong(valor));
        case "documentacion":
        	return usuarioRepository.buscarPorDocumentacion(valor);
        case "email":
        	return usuarioRepository.buscarPorEmail(valor);
        case "tlf":
        	return usuarioRepository.buscarPorTlf(valor);
        case "idioma":
        	return usuarioRepository.buscarPorIdioma(valor);
        case "nacionalidad":
        	return usuarioRepository.buscarPorNacionalidad(valor);
        }
        return null;
	}

}