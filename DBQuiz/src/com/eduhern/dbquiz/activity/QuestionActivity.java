package com.eduhern.dbquiz.activity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import com.eduhern.dbquiz.R;
import com.eduhern.dbquiz.database.DatabaseHelper;
import com.eduhern.dbquiz.models.Pregunta;
import com.eduhern.dbquiz.models.Respuesta;
import com.j256.ormlite.android.apptools.OrmLiteBaseListActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class QuestionActivity extends OrmLiteBaseListActivity<DatabaseHelper> implements OnItemClickListener {

	private RespuestaAdapter adapter;
	private List<Respuesta> transacciones = new ArrayList<Respuesta>();
	private int correctas = 0;
	private int numero_pregunta;
	private int preguntas_jugadas = 0;
	public static final int MAXIMO_PREGUNTAS = 10;
	private int numero_preguntas_total;
	private Random numero_pregunta_aleatorio;
	private HashSet<Integer> preguntas_ya_jugadas = new HashSet<Integer>(); 
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        numero_pregunta_aleatorio = new Random();      
        numero_preguntas_total = (int) getHelper().getPreguntaDAO().countOf();
        Log.d("DEPURACION",String.valueOf(numero_preguntas_total));
        numero_pregunta = numero_pregunta_aleatorio.nextInt(numero_preguntas_total);
        numero_pregunta++;
        preguntas_ya_jugadas.add(numero_pregunta);
        preguntas_jugadas++;
        
        transacciones = getHelper().getRespuestaDAO().queryForEq("id_pregunta", numero_pregunta);
    	Pregunta pregunta = getHelper().getPreguntaDAO().queryForId(numero_pregunta);
    	
    	ImageView imagen = (ImageView)findViewById(R.id.imageView2);
    	int id = getResources().getIdentifier(pregunta.getImagen(), "drawable", getPackageName());   	

    	Resources resources = getResources();    	
    	Drawable drawable = resources.getDrawable(id);
    	imagen.setImageDrawable(drawable);
    	
    	TextView textViewPregunta = (TextView)findViewById(R.id.texto_pregunta);
    	textViewPregunta.setText(pregunta.getDescripcion());
    		
        adapter = new RespuestaAdapter(this, com.eduhern.dbquiz.R.layout.fila
        	        , transacciones);
        setListAdapter(adapter);
        
        ListView dataListView = (ListView)findViewById(android.R.id.list);     
        dataListView.setOnItemClickListener(this);
            
    }
    
    public void onItemClick(AdapterView<?> arg0, View vista, int posicion, long arg3) {
    	if(transacciones.get(posicion).isCorrecta()){
        	Toast.makeText(this, "CORRECTO", Toast.LENGTH_SHORT).show();
        	correctas++;
    	}else{
        	Toast.makeText(this, "FALLO", Toast.LENGTH_SHORT).show();    		
    	}
    	((TextView)findViewById(R.id.puntuacion1)).setText(String.valueOf(correctas));;
    	
    	if(preguntas_jugadas == MAXIMO_PREGUNTAS){

    		Intent intent = new Intent(this, ResultadoActivity.class);
    		intent.putExtra("resultado", String.valueOf(correctas));
    		finish();
    		startActivity(intent);
    		
    	}else{
        
    	do{
    	numero_pregunta = numero_pregunta_aleatorio.nextInt(numero_preguntas_total);
        numero_pregunta++;
    	}while(preguntas_ya_jugadas.contains(numero_pregunta));
        
    	preguntas_ya_jugadas.add(numero_pregunta);
        preguntas_jugadas++;
            
    	Pregunta pregunta = getHelper().getPreguntaDAO().queryForId(numero_pregunta);
    	
    	ImageView imagen = (ImageView)findViewById(R.id.imageView2);
    	int id = getResources().getIdentifier(pregunta.getImagen(), "drawable", getPackageName());   	
    	Resources resources  = getResources();    	
        Drawable drawable = resources.getDrawable(id);
    	imagen.setImageDrawable(drawable);
    	
    	TextView textViewPregunta = (TextView)findViewById(R.id.texto_pregunta);
    	textViewPregunta.setText(pregunta.getDescripcion());

    	adapter.clear();
    	transacciones = getHelper().getRespuestaDAO().queryForEq("id_pregunta", numero_pregunta);
    	adapter.addAll(transacciones);
    	adapter.notifyDataSetChanged();
    	
    	
    	}
    }
}
