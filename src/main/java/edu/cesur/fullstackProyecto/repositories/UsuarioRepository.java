package edu.cesur.fullstackProyecto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import edu.cesur.fullstackProyecto.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{	

    @Query("SELECT u FROM Usuario u WHERE u.id = :id")
    Usuario buscarPorId(Long id);
	
    @Query("SELECT u FROM Usuario u WHERE u.documentacion = :documentacion")
    Usuario buscarPorDocumentacion(String documentacion);
    
    @Query("SELECT u FROM Usuario u WHERE u.email = :email")
    Usuario buscarPorEmail(String email);
    
    @Query("SELECT u FROM Usuario u WHERE u.tlf = :tlf")
    Usuario buscarPorTlf(String tlf);
    
    @Query("SELECT u FROM Usuario u WHERE u.idioma = :idioma")
    List<Usuario> buscarPorIdioma(String idioma);
    
    @Query("SELECT u FROM Usuario u WHERE u.nacionalidad = :nacionalidad")
    List<Usuario> buscarPorNacionalidad(String nacionalidad);
}