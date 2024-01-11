package edu.cesur.fullstackProyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cesur.fullstackProyecto.entities.UsuarioEntity;
import edu.cesur.fullstackProyecto.mappers.UsuarioMapper;
import edu.cesur.fullstackProyecto.model.UsuarioDTO;
import edu.cesur.fullstackProyecto.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	UsuarioMapper usuarioMapper;

	@Override
	public long crearUsuario(UsuarioEntity usuarioEntity) {
		
		//DEBUG	
		System.out.println(usuarioEntity.toString());
		//DEBUG	
		usuarioRepository.save(usuarioEntity);
		return usuarioEntity.getId();
	}

	@Override
	public List<UsuarioDTO> getUsuarios() {
		return usuarioMapper.toDTOList(usuarioRepository.findAll());
	}

}