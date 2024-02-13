package edu.cesur.fullstackProyecto.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.cesur.fullstackProyecto.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>, GlobalRepository<Usuario>{	
	@Query("SELECT u FROM Usuario u WHERE u.email = :email AND u.password = :password")
    Usuario findByEmailAndContraseña(@Param("email") String email, @Param("password") String password);
}