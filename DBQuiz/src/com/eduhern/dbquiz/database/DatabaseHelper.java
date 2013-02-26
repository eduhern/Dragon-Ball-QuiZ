package com.eduhern.dbquiz.database;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.eduhern.dbquiz.R;
import com.eduhern.dbquiz.models.*;


public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

	private static final String DATABASE_NAME = "helloAndroid.db";
	private static final int DATABASE_VERSION = 12;

	private RuntimeExceptionDao<Pregunta, Integer> preguntaDAO = null;
	private RuntimeExceptionDao<Respuesta, Integer> respuestaDAO = null;


	public DatabaseHelper(final Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION,
				R.raw.ormlite_config);
	}

	@Override
	public void onCreate(final SQLiteDatabase db,
			final ConnectionSource connectionSource) {
		try {
			TableUtils.createTable(connectionSource, Pregunta.class);
			TableUtils.createTable(connectionSource, Respuesta.class);

		} catch (final SQLException e) {
			Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
			throw new RuntimeException(e);
		}
	}

	@Override
	public void onUpgrade(final SQLiteDatabase db,
			final ConnectionSource connectionSource, final int oldVersion,
			final int newVersion) {
		try {
			TableUtils.dropTable(connectionSource, Pregunta.class, true);
			TableUtils.dropTable(connectionSource, Respuesta.class, true);
			onCreate(db, connectionSource);
	        this.getPreguntaDAO().create(new Pregunta(1, "¿Cuál es el nombre de estos tres famosos villanos?", "imagen1"));
	        this.getPreguntaDAO().create(new Pregunta(2, "¿Cuál es el nombre de este famoso personaje?", "imagen2"));
	        this.getPreguntaDAO().create(new Pregunta(3, "¿Cómo se llama el personaje?", "imagen3"));
	        this.getPreguntaDAO().create(new Pregunta(4, "¿Cuál es el nombre de este androide de base humana creado por el Dr. Gero?", "imagen4"));
	        this.getPreguntaDAO().create(new Pregunta(5, "Fue el segundo maestro de Goku, ¿a qué nombre responde?", "imagen5"));
	        this.getPreguntaDAO().create(new Pregunta(6, "¿En qué año se empezó a emitir la serie de animación que continuaba de forma canónica el manga de Toriyama?", "imagen6"));
	        this.getPreguntaDAO().create(new Pregunta(7, "¿Cuál es el título del primer tankobon del manga de Dragon Ball?", "imagen7"));
	        this.getPreguntaDAO().create(new Pregunta(8, "¿En qué año se estrenó el film de Dragon Ball 'Saikyo e no michi'?", "imagen8"));
	        this.getPreguntaDAO().create(new Pregunta(9, "¿Cómo se llama el hermando de Freezer?", "imagen9"));
	        this.getPreguntaDAO().create(new Pregunta(10, "¿Cuál es el nombre de estos dos personajes del film de 2013 Dragon Ball Z 'Battle of Gods'?", "imagen10"));
	        this.getPreguntaDAO().create(new Pregunta(11, "¿Para qué sirve el objeto de la fotografía?", "imagen11"));
	        this.getPreguntaDAO().create(new Pregunta(12, "¿Para qué sirve el objeto de la fotografía?", "imagen12"));
	        this.getPreguntaDAO().create(new Pregunta(13, "¿En qué plataforma podemos disfrutar del juego Dragon Ball Z 'Buyu Retsuden'?", "imagen13"));
	        this.getPreguntaDAO().create(new Pregunta(14, "¿Cuál era el principal poder del personaje de la imagen?", "imagen14"));
	        this.getPreguntaDAO().create(new Pregunta(15, "¿En qué capítulo de Dragon Ball GT alcanza Goku el estado de SSJ3 siendo un niño?", "imagen15"));
	        this.getPreguntaDAO().create(new Pregunta(16, "¿Qué parentesco comparte el personaje de la fotografía con Goku (Kakarotto)?", "imagen16"));
	        this.getPreguntaDAO().create(new Pregunta(17, "Goku adulto en DBGT convertido en SSJ, ¿es posible?", "imagen17"));
        
	        this.getRespuestaDAO().create(new Respuesta(0, true, "Pilaf, Mai y Suu", 1));
	        this.getRespuestaDAO().create(new Respuesta(1, false, "Pilaf, Mai y Ginew", 1));
	        this.getRespuestaDAO().create(new Respuesta(2, false, "Vegeta, Mai y Zarbon", 1));
	        this.getRespuestaDAO().create(new Respuesta(3, false, "Dodoria, Kiwi y Zarbon", 1));
	        this.getRespuestaDAO().create(new Respuesta(4, false, "Cell", 2));
	        this.getRespuestaDAO().create(new Respuesta(5, false, "Super Bu", 2));
	        this.getRespuestaDAO().create(new Respuesta(6, true, "Mr Bu", 2));
	        this.getRespuestaDAO().create(new Respuesta(7, false, "Kid Bu", 2));
			this.getRespuestaDAO().create(new Respuesta(8, false, "Ten Shin Han", 3));
			this.getRespuestaDAO().create(new Respuesta(9, true, "Yamcha", 3));
			this.getRespuestaDAO().create(new Respuesta(10, false, "Puar", 3));
			this.getRespuestaDAO().create(new Respuesta(11, false, "Oolong", 3));
			this.getRespuestaDAO().create(new Respuesta(12, false, "C17", 4));
			this.getRespuestaDAO().create(new Respuesta(13, true, "C18", 4));
			this.getRespuestaDAO().create(new Respuesta(14, false, "C19", 4));
			this.getRespuestaDAO().create(new Respuesta(15, false, "C20", 4));
			this.getRespuestaDAO().create(new Respuesta(16, false, "Gyumaoh", 5));
			this.getRespuestaDAO().create(new Respuesta(17, false, "Youmaoh", 5));
			this.getRespuestaDAO().create(new Respuesta(18, true, "Mutenroshi", 5));
			this.getRespuestaDAO().create(new Respuesta(19, false, "Mutaito", 5));
			this.getRespuestaDAO().create(new Respuesta(20, false, "1994", 6));
			this.getRespuestaDAO().create(new Respuesta(21, false, "1995", 6));
			this.getRespuestaDAO().create(new Respuesta(22, true, "1996", 6));
			this.getRespuestaDAO().create(new Respuesta(23, false, "1997", 6));
			this.getRespuestaDAO().create(new Respuesta(24, true, "Son Goku y sus amigos", 7));
			this.getRespuestaDAO().create(new Respuesta(25, false, "El gran combate", 7));
			this.getRespuestaDAO().create(new Respuesta(26, false, "¡Adelante Son Goku!", 7));
			this.getRespuestaDAO().create(new Respuesta(27, false, "Un plan diabólico", 7));
			this.getRespuestaDAO().create(new Respuesta(28, false, "1989", 8));
			this.getRespuestaDAO().create(new Respuesta(29, false, "1990", 8));
			this.getRespuestaDAO().create(new Respuesta(30, false, "1993", 8));
			this.getRespuestaDAO().create(new Respuesta(31, true, "1996", 8));
			this.getRespuestaDAO().create(new Respuesta(32, false, "Raditz", 9));
			this.getRespuestaDAO().create(new Respuesta(33, false, "King Cold", 9));
			this.getRespuestaDAO().create(new Respuesta(34, true, "Cooler", 9));
			this.getRespuestaDAO().create(new Respuesta(35, false, "Broly", 9));				
			this.getRespuestaDAO().create(new Respuesta(36, false, "Abo y Kado", 10));
			this.getRespuestaDAO().create(new Respuesta(37, true, "Birusu y Wisu", 10));
			this.getRespuestaDAO().create(new Respuesta(38, false, "Zarbón y Dodoria", 10));
			this.getRespuestaDAO().create(new Respuesta(39, false, "Vegeta y Nappa", 10));
			this.getRespuestaDAO().create(new Respuesta(40, false, "Todo aquel que lleva puesto el pendiente incrementa su fuerza.", 11));
			this.getRespuestaDAO().create(new Respuesta(41, false, "Es meramente un elemento estético", 11));
			this.getRespuestaDAO().create(new Respuesta(42, true, "Es un pendiente de los dioses kaio shin. Permite realizar una ancestral fusión", 11));
			this.getRespuestaDAO().create(new Respuesta(43, false, "Es un simple reloj", 12));
			this.getRespuestaDAO().create(new Respuesta(44, true, "Permite detectar las bolas de dragón", 12));
			this.getRespuestaDAO().create(new Respuesta(45, false, "Permite localizar focos de ki", 12));
			this.getRespuestaDAO().create(new Respuesta(46, false, "Es el nuevo smartphone de apple", 12));
			this.getRespuestaDAO().create(new Respuesta(47, true, "Sega Megadrive / Genesis", 13));
			this.getRespuestaDAO().create(new Respuesta(48, false, "Super nintendo / Famicom", 13));
			this.getRespuestaDAO().create(new Respuesta(49, false, "Nintendo Game Boy", 13));
			this.getRespuestaDAO().create(new Respuesta(50, false, "Neo Geo", 13));
			this.getRespuestaDAO().create(new Respuesta(51, false, "Puede realizar el Kame Hame Ha", 14));
			this.getRespuestaDAO().create(new Respuesta(52, true, "Tiene la capacidad de variar el tamaño de su cuerpo", 14));
			this.getRespuestaDAO().create(new Respuesta(53, false, "Tiene poderes curativos", 14));
			this.getRespuestaDAO().create(new Respuesta(54, false, "Ninguno, es un simple humano", 14));
			this.getRespuestaDAO().create(new Respuesta(55, false, "Episodio 6", 15));
			this.getRespuestaDAO().create(new Respuesta(56, false, "Episodio 25", 15));
			this.getRespuestaDAO().create(new Respuesta(57, true, "Episodio 29", 15));
			this.getRespuestaDAO().create(new Respuesta(58, false, "Episodio 33", 15));
			this.getRespuestaDAO().create(new Respuesta(59, false, "Sobrino", 16));
			this.getRespuestaDAO().create(new Respuesta(60, false, "Hijo", 16));
			this.getRespuestaDAO().create(new Respuesta(61, false, "Hermano", 16));
			this.getRespuestaDAO().create(new Respuesta(62, true, "Tataranieto", 16));
			this.getRespuestaDAO().create(new Respuesta(63, false, "No, no lo es", 17));
			this.getRespuestaDAO().create(new Respuesta(64, true, "Sí, aparece como personaje seleccionable en el Dragon Ball 'Final Bout' de PSX", 17));
			this.getRespuestaDAO().create(new Respuesta(65, false, "Sí, en el primer capítulo de DBGT le podemos ver en este estado", 17));
			this.getRespuestaDAO().create(new Respuesta(66, false, "Sí, en el último capítulo de DBGT le podemos ver en este estado", 17));
		} catch (final java.sql.SQLException e) {
			Log.e(DatabaseHelper.class.getName(), "Can't drop databases", e);
			throw new RuntimeException(e);
		}
	}

	public RuntimeExceptionDao<Pregunta, Integer> getPreguntaDAO() {
		if (preguntaDAO == null) {
			preguntaDAO = getRuntimeExceptionDao(Pregunta.class);
		}
		return preguntaDAO;
	}

	public RuntimeExceptionDao<Respuesta, Integer> getRespuestaDAO() {
		if (respuestaDAO == null) {
			respuestaDAO = getRuntimeExceptionDao(Respuesta.class);
		}
		return respuestaDAO;
	}
	
	@Override
	public void close() {
		super.close();
		preguntaDAO = null;
		respuestaDAO = null;
	}

}