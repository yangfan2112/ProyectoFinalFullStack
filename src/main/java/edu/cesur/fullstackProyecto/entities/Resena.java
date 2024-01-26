package edu.cesur.fullstackProyecto.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "Resenas")
public class Resena {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@ManyToOne
    @JoinColumn(name = "usuario")
    private Usuario usuario;
	@ManyToOne
    @JoinColumn(name = "evento")
    private Evento evento; 
	@ManyToOne
    @JoinColumn(name = "hotel")
    private Hotel hotel; 
    @Column(nullable = false)
    private Float valoracion;
    private String comentario;
	private Date fechares = new Date(System.currentTimeMillis());
	
	public Resena(){}
	
	
	

	public Resena(Usuario usuario, Evento evento,Hotel hotel, Float valoracion, String comentario) {
		super();
		this.usuario = usuario;
		this.evento = evento;
		this.hotel = hotel;
		this.valoracion = valoracion;
		this.comentario = comentario;
	}




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Float getValoracion() {
		return valoracion;
	}

	public void setValoracion(Float valoracion) {
		this.valoracion = valoracion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Date getFechares() {
		return fechares;
	}

	public void setFechares(Date fechares) {
		this.fechares = fechares;
	}


	

	
	
	
}
