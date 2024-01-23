package edu.cesur.fullstackProyecto.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
    @Column(nullable = false)
	private String nombre;
    @Column(nullable = false)
	private String apellidos;
	@Column(nullable = false, unique=true)
	private String documentacion;
	@Column(nullable = false, unique=true)
	private String email;
	@Column(nullable = false, unique=true)
	private String tlf;
    @Column(nullable = false)
	private Date fechanac;
	private Date fechareg = new Date(System.currentTimeMillis());
    @Column(nullable = false)
	private String idioma;
    @Column(nullable = false)
	private String nacionalidad;

	
	
	public Usuario(){}


	public Usuario(Long id, String nombre, String apellidos, String documentacion, String email, String tlf,
			Date fechanac, Date fechareg, String idioma, String nacionalidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.documentacion = documentacion;
		this.email = email;
		this.tlf = tlf;
		this.fechanac = fechanac;
		this.fechareg = fechareg;
		this.idioma = idioma;
		this.nacionalidad = nacionalidad;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getDocumentacion() {
		return documentacion;
	}


	public void setDocumentacion(String documentacion) {
		this.documentacion = documentacion;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTlf() {
		return tlf;
	}


	public void setTlf(String tlf) {
		this.tlf = tlf;
	}


	public Date getFechanac() {
		return fechanac;
	}


	public void setFechanac(Date fechanac) {
		this.fechanac = fechanac;
	}


	public Date getFechareg() {
		return fechareg;
	}


	public void setFechareg(Date fechareg) {
		this.fechareg = fechareg;
	}


	public String getIdioma() {
		return idioma;
	}


	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}


	public String getNacionalidad() {
		return nacionalidad;
	}


	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	
}
