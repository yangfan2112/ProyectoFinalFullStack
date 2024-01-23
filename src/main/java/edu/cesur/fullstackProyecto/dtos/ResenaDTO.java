package edu.cesur.fullstackProyecto.dtos;

public class ResenaDTO {

    private Long usuario;
    private Long evento;
    private Float puntuacion;
    private String comentario;
    
    
    
	@Override
	public String toString() {
		return "ResenaDTO [usuario=" + usuario + ", evento=" + evento + ", puntuacion=" + puntuacion + ", comentario="
				+ comentario + "]";
	}
	public ResenaDTO(Long usuario, Long evento, Float puntuacion, String comentario) {
		super();
		this.usuario = usuario;
		this.evento = evento;
		this.puntuacion = puntuacion;
		this.comentario = comentario;
	}
	public Long getUsuario() {
		return usuario;
	}
	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}
	public Long getEvento() {
		return evento;
	}
	public void setEvento(Long evento) {
		this.evento = evento;
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
