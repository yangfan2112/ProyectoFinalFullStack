package edu.cesur.fullstackProyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;	
import org.springframework.stereotype.Service;

import edu.cesur.fullstackProyecto.dtos.FiltroDTO;
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
	public List<Usuario> getUsuariosby(List<FiltroDTO> filtroDTO) {
		
        return null;
	}

}