package edu.cesur.fullstackProyecto.model;



import java.sql.Date;


public class UsuarioDTO {

	private Long id;
	private String nombre;
	private String apellidos;
	private String documentacion;
	private String email;
	private Date fechanac;
	private Date fechareg;
	private String idioma;
	private String nacionalidad;
	
	
	public UsuarioDTO(Long id, String nombre, String apellidos, String documentacion, String email, Date fechanac,
			Date fechareg, String idioma, String nacionalidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.documentacion = documentacion;
		this.email = email;
		this.fechanac = fechanac;
		this.fechareg = fechareg;
		this.idioma = idioma;
		this.nacionalidad = nacionalidad;
	}
	
	public UsuarioDTO(){
		
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


	@Override
	public String toString() {
		return "UsuarioDTO [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", documentacion="
				+ documentacion + ", email=" + email + ", fechanac=" + fechanac + ", fechareg=" + fechareg + ", idioma="
				+ idioma + ", nacionalidad=" + nacionalidad + "]";
	}
	
	
	
	
	
	
	
	

   
}