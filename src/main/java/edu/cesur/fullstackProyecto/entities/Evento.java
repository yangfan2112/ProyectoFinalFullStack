package edu.cesur.fullstackProyecto.entities;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "eventos")
public class Evento extends Negocio{

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
    @Column(nullable = false)
	private String nombre;
	@Column(nullable = false)
	private String empresa;
	@Column(nullable = false, unique=true)
	private String email;
	@Column(nullable = false, unique=true)
	private String tlf;
    @Column(nullable = false)
	private Date fechaini;
    private Date fechafin;
	private Date fechareg = new Date(System.currentTimeMillis());
    @Column(nullable = false)
	private String ubicacion;
    @Column(nullable = false)
	private String pais;
    @Column(nullable = false)
    private String contraseña;
	private Float valoracion;
    @Column(unique = true)
    private String url;
	
	
	public Evento(){}


	


	public Evento(Long id, String nombre, String empresa, String email, String tlf, Date fechaini, Date fechafin,
			Date fechareg, String ubicacion, String pais, String contraseña, Float valoracion, String url) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.empresa = empresa;
		this.email = email;
		this.tlf = tlf;
		this.fechaini = fechaini;
		this.fechafin = fechafin;
		this.fechareg = fechareg;
		this.ubicacion = ubicacion;
		this.pais = pais;
		this.contraseña = contraseña;
		this.valoracion = valoracion;
		this.url = url;
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


	public String getEmpresa() {
		return empresa;
	}


	public void setEmpresa(String empresa) {
		this.empresa = empresa;
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


	public String getUbicacion() {
		return ubicacion;
	}


	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}


	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}


	public Float getValoracion() {
		return valoracion;
	}


	public void setValoracion(Float valoracion) {
		this.valoracion = valoracion;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}





	public String getContraseña() {
		return contraseña;
	}





	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	
	


	
	
	
}
