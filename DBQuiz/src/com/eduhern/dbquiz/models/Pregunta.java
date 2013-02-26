package com.eduhern.dbquiz.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Pregunta {

@DatabaseField(generatedId = true)
int id;

@DatabaseField
String descripcion;

@DatabaseField
String imagen;

public String getImagen() {
	return imagen;
}
public void setImagen(String imagen) {
	this.imagen = imagen;
}

public Pregunta() {
}

public Pregunta(int id, String descripcion, String imagen) {
	this.id = id;
	this.descripcion = descripcion;
	this.imagen = imagen;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}


	
}
