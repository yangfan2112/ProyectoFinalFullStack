package edu.cesur.fullstackProyecto.model;



import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

	private Long id;
	private String nombre;
	private String documentacion;
	private Date fechanac;
	private String nacionalidad;
	
	
	
	
	public UsuarioDTO(Long id, String nombre, String documentacion, Date fechanac, String nacionalidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.documentacion = documentacion;
		this.fechanac = fechanac;
		this.nacionalidad = nacionalidad;
	}
	
	public UsuarioDTO() {
		
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
	public String getDocumentacion() {
		return documentacion;
	}
	public void setDocumentacion(String documentacion) {
		this.documentacion = documentacion;
	}
	public Date getFechanac() {
		return fechanac;
	}
	public void setFechanac(Date fechanac) {
		this.fechanac = fechanac;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	@Override
	public String toString() {
		return "UsuarioDTO [id=" + id + ", nombre=" + nombre + ", documentacion=" + documentacion + ", fechanac="
				+ fechanac + ", nacionalidad=" + nacionalidad + "]";
	}
	
	
	
	

   
}