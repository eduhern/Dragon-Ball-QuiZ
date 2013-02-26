package com.eduhern.dbquiz.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Respuesta {

	@DatabaseField
	int id;
	
	@DatabaseField
	boolean correcta;
	
	@DatabaseField
	String descripcion;
	
	@DatabaseField
	int id_pregunta;

	public Respuesta(){
	}
	
	public Respuesta(int id, boolean correcta, String descripcion,
			int id_pregunta) {
		super();
		this.id = id;
		this.correcta = correcta;
		this.descripcion = descripcion;
		this.id_pregunta = id_pregunta;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isCorrecta() {
		return correcta;
	}
	public void setCorrecta(boolean correcta) {
		this.correcta = correcta;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getId_pregunta() {
		return id_pregunta;
	}
	public void setId_pregunta(int id_pregunta) {
		this.id_pregunta = id_pregunta;
	}
	
	
}
