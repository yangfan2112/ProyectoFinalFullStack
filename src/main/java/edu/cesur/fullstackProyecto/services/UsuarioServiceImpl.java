package edu.cesur.fullstackProyecto.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import edu.cesur.fullstackProyecto.Specifications.UsuarioSpecifications;
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
	public List<Usuario> getUsuariosby(Map<String, String> filtros) {

		Specification<Usuario> especificacion = UsuarioSpecifications.conFiltros(filtros);
        return usuarioRepository.findAll(especificacion);
	}

}