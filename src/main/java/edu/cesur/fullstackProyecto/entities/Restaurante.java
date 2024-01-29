package edu.cesur.fullstackProyecto.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "restaurantes")
public class Restaurante {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false, unique = true)
	private String email;
	private Float valoracion;
	@Column(nullable = false)
	private String ubicacion;
	@Column(nullable = false)
	private String descripcion;
	@Column(nullable = false)
	private String tipoCocina;
	@Column(nullable = false)
	private Date horarioApertura;
	@Column(nullable = false)
	private Date horarioCierre;
	@Column(nullable = false)
	private Date fechareg = new Date(System.currentTimeMillis());
	@Column(nullable = false, unique = true)
	private String tlf;
	@Column(unique = true)
	private String url;
	
	public Restaurante() {
		
	}

	public Restaurante(Long id, String nombre, String email, String ubicacion, String descripcion,
			String tipoCocina, Date horarioApertura, Date horarioCierre, Date fechareg, String tlf) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.ubicacion = ubicacion;
		this.descripcion = descripcion;
		this.tipoCocina = tipoCocina;
		this.horarioApertura = horarioApertura;
		this.horarioCierre = horarioCierre;
		this.fechareg = fechareg;
		this.tlf = tlf;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Float getValoracion() {
		return valoracion;
	}

	public void setValoracion(Float valoracion) {
		this.valoracion = valoracion;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipoCocina() {
		return tipoCocina;
	}

	public void setTipoCocina(String tipoCocina) {
		this.tipoCocina = tipoCocina;
	}

	public Date getHorarioApertura() {
		return horarioApertura;
	}

	public void setHorarioApertura(Date horarioApertura) {
		this.horarioApertura = horarioApertura;
	}

	public Date getHorarioCierre() {
		return horarioCierre;
	}

	public void setHorarioCierre(Date horarioCierre) {
		this.horarioCierre = horarioCierre;
	}

	public Date getFechareg() {
		return fechareg;
	}

	public void setFechareg(Date fechareg) {
		this.fechareg = fechareg;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
	
}
