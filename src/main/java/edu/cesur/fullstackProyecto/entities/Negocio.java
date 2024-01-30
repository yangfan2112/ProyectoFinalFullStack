package edu.cesur.fullstackProyecto.entities;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Negocio {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	public Negocio() {
		
	}
	
	public abstract void setValoracion(Float valoracion);
}
