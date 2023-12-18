package edu.cesur.fullstackProyecto.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import edu.cesur.fullstackProyecto.entities.UsuarioEntity;
import edu.cesur.fullstackProyecto.model.UsuarioDTO;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
	
	UsuarioDTO toDTO(UsuarioEntity usuarioEntity);
	
	UsuarioEntity toEntity(UsuarioDTO usuarioDTO);
	
	List<UsuarioDTO> toDTOList(List<UsuarioEntity> usuarios);

}