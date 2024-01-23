package edu.cesur.fullstackProyecto.dtos;

public class FiltroDTO {
	private String columna;
	private Object valor;
	
	public FiltroDTO(String columna, Object valor) {
		super();
		this.columna = columna;
		this.valor = valor;
	}

	public String getColumna() {
		return columna;
	}

	public void setColumna(String columna) {
		this.columna = columna;
	}

	public Object getValor() {
		return valor;
	}

	public void setValor(Object valor) {
		this.valor = valor;
	}
	
	

}
