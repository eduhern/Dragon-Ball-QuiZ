package com.eduhern.dbquiz.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Categoria implements Parcelable {

	@DatabaseField(generatedId = true)
	int id;

	@DatabaseField
	String descripcion;

	@DatabaseField
	String fondo;

	@DatabaseField
	String descripcion_ext;

	public String getDescripcion_ext() {
		return descripcion_ext;
	}

	public void setDescripcion_ext(String descripcion_ext) {
		this.descripcion_ext = descripcion_ext;
	}

	public String getFondo() {
		return fondo;
	}

	public void setFondo(String fondo) {
		this.fondo = fondo;
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

	public Categoria(int id, String descripcion, String fondo, String descripcion_ext) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.fondo = fondo;
		this.descripcion_ext = descripcion_ext;
	}

	public Categoria() {
	}

	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}


	public static final Parcelable.Creator<Categoria> CREATOR = new Parcelable.Creator<Categoria>() {
		public Categoria createFromParcel(Parcel in) {
			return new Categoria(in);
		}

		public Categoria[] newArray(int size) {
			return new Categoria[size];
		}
	};
	
	public Categoria(Parcel source) {
		this.id = source.readInt();
		this.descripcion = source.readString();
		this.descripcion_ext = source.readString();
		this.fondo = source.readString();
	}
	
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(id);
		dest.writeString(descripcion);
		dest.writeString(descripcion_ext);
		dest.writeString(fondo);
	}


}
