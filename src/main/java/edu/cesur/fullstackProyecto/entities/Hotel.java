package edu.cesur.fullstackProyecto.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hoteles")
public class Hotel {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
    @Column(nullable = false)
	private String nombre;
    @Column(nullable = false, unique=true)
	private String email;
	private Float valoracion;
	@Column(nullable = false, unique=true)
	private String ubicacion;
	@Column(nullable = false)
	private String descripcion;
	@Column(nullable = false)
	private String tipoHab;
    @Column(nullable = false)
	private Date servicios;
    @Column(nullable = false)
	private String pais;
    @Column(nullable = false)
	private Date fechaini;
    private Date fechafin;
	private Date fechareg = new Date(System.currentTimeMillis());
    @Column(nullable = false, unique=true)
	private String tlf;
    @Column(unique = true)
    private String url;
    
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Hotel(Long id, String nombre, String email, String ubicacion, String descripcion, String tipoHab,
			Date servicios, String pais, Date fechaini, Date fechafin, Date fechareg, String tlf) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.ubicacion = ubicacion;
		this.descripcion = descripcion;
		this.tipoHab = tipoHab;
		this.servicios = servicios;
		this.pais = pais;
		this.fechaini = fechaini;
		this.fechafin = fechafin;
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

	public String getTipoHab() {
		return tipoHab;
	}

	public void setTipoHab(String tipoHab) {
		this.tipoHab = tipoHab;
	}

	public Date getServicios() {
		return servicios;
	}

	public void setServicios(Date servicios) {
		this.servicios = servicios;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Date getFechaini() {
		return fechaini;
	}

	public void setFechaini(Date fechaini) {
		this.fechaini = fechaini;
	}

	public Date getFechafin() {
		return fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
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
