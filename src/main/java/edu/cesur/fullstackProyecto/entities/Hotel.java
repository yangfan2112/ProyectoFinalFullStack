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
public class Hotel extends Negocio{

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
    @Column(nullable = false)
	private String nombre;
    private Float valoracion;
	@Column(nullable = false, unique=true)
	private String ubicacion;
	@Column(nullable = false)
	private String descripcion;
	@Column(nullable = false)
	private String tipoHab;
    @Column(nullable = false)
	private Date servicios;
	private Date fechareg = new Date(System.currentTimeMillis());
    @Column(nullable = false, unique=true)
	private String tlf;
    
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Hotel(Long id, String nombre, Float valoracion, String ubicacion, String descripcion, String tipoHab,
			Date servicios, Date fechareg, String tlf) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.valoracion = valoracion;
		this.ubicacion = ubicacion;
		this.descripcion = descripcion;
		this.tipoHab = tipoHab;
		this.servicios = servicios;
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
	@Override
	public String toString() {
		return "Hotel [id=" + id + ", nombre=" + nombre + ", valoracion=" + valoracion + ", ubicacion=" + ubicacion
				+ ", descripcion=" + descripcion + ", tipoHab=" + tipoHab + ", servicios=" + servicios + ", fechareg="
				+ fechareg + ", tlf=" + tlf + "]";
	}
    
    
    
}
