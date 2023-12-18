package edu.cesur.fullstackProyecto.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "usuarios")
public class UsuarioEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String documentacion; 
	private String nombre;
	private Date fechanac;
	private String nacionalidad;

}
