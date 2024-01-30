package edu.cesur.fullstackProyecto.dtos;

public class ResenaDTO {

    private Long usuario;
    private Long negocio;
    private Float puntuacion;
    private String comentario;
    
 
    
    
	public ResenaDTO(Long usuario, Long negocio, Float puntuacion, String comentario) {
		super();
		this.usuario = usuario;
		this.negocio = negocio;
		this.puntuacion = puntuacion;
		this.comentario = comentario;
	}
	public Long getUsuario() {
		return usuario;
	}
	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}
	public Long getNegocio() {
		return negocio;
	}
	public void setNegocio(Long negocio) {
		this.negocio = negocio;
	}
	public Float getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(Float puntuacion) {
		this.puntuacion = puntuacion;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
    

    
    
    
}
