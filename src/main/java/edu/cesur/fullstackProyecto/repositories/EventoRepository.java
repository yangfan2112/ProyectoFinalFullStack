package edu.cesur.fullstackProyecto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.cesur.fullstackProyecto.entities.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long>{	

    @Query("SELECT u FROM Evento u WHERE u.id = :id")
    Evento buscarPorId(Long id);	
    
    @Query("SELECT AVG(e.valoracion) FROM Resena e WHERE e.id = :eventoId")
    Double obtenerMediaValoracionPorId(Long eventoId);
	
    @Query("SELECT u FROM Evento u WHERE u.empresa = :empresa")
    List<Evento> buscarPorEmpresa(String empresa);
    
    @Query("SELECT u FROM Evento u WHERE u.email = :email")
    List<Evento> buscarPorEmail(String email);
    
    @Query("SELECT u FROM Evento u WHERE u.tlf = :tlf")
    List<Evento> buscarPorTlf(String tlf);
    
    @Query("SELECT u FROM Evento u WHERE u.pais = :pais")
    List<Evento> buscarPorPais(String pais);
    
    @Query("SELECT u FROM Evento u WHERE u.fechaini = :fechaini")
    List<Evento> buscarPorFechaini(String fechaini);
    
    @Query("SELECT u FROM Evento u WHERE u.fechafin = :fechafin")
    List<Evento> buscarPorFechafin(String fechafin);
}