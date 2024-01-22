package edu.cesur.fullstackProyecto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.cesur.fullstackProyecto.entities.Resena;

@Repository
public interface ResenaRepository extends JpaRepository<Resena, Long>{	

    @Query("SELECT u FROM Resena u WHERE u.usuario = :usuario")
    List<Resena> buscarPorUsuario(Long usuario);
    
    @Query("SELECT u FROM Resena u WHERE u.evento = :evento")
    List<Resena> buscarPorEvento(Long evento);
} 