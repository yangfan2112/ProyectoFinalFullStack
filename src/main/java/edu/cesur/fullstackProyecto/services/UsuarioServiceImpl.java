package edu.cesur.fullstackProyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO) {
		System.out.println(usuarioDTO.toString());
		return usuarioMapper.toDTO(usuarioRepository.save(usuarioMapper.toEntity(usuarioDTO)));
	}

	@Override
	public List<UsuarioDTO> getUsuarios() {
		return usuarioMapper.toDTOList(usuarioRepository.findAll());
	}

}