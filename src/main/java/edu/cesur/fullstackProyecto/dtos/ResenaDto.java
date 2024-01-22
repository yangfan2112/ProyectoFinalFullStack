package edu.cesur.fullstackProyecto.dtos;

public class ResenaDto {

    private int usuarioId;
    private int eventoId;
    private byte puntuacion;
    private String comentario;
    
    
    
    
    
	public ResenaDto(int usuarioId, int eventoId, byte puntuacion, String comentario) {
		super();
		this.usuarioId = usuarioId;
		this.eventoId = eventoId;
		this.puntuacion = puntuacion;
		this.comentario = comentario;
	}
	public int getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}
	public int getEventoId() {
		return eventoId;
	}
	public void setEventoId(int eventoId) {
		this.eventoId = eventoId;
	}
	public byte getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(byte puntuacion) {
		this.puntuacion = puntuacion;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
    
    
}
