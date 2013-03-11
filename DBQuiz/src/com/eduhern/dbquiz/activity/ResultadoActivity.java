package com.eduhern.dbquiz.activity;

import com.eduhern.dbquiz.R;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultadoActivity extends Activity implements OnLongClickListener, OnClickListener {
	ImageView imagen_fin;
	boolean fin = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_resultado);
    	TextView textViewPregunta = (TextView)findViewById(R.id.texto_resultado);
    	textViewPregunta.setText(getIntent().getStringExtra("resultado")+" respuestas correctas");
	
    	imagen_fin = (ImageView)findViewById(R.id.imagen_resultado);
    	
    	imagen_fin.setOnLongClickListener(this);

        Button boton = (Button)findViewById(R.id.boton1);
        boton.setOnClickListener(this); 
    	
	}

	public void onClick(View v) {
		finish();
	}

	public boolean onLongClick(View v) {
		// TODO Auto-generated method stub
		MediaPlayer musica;
		
		if(fin){
			  musica = MediaPlayer.create(this, R.raw.teletransporte);
			}else{
			  musica = MediaPlayer.create(this, R.raw.foto);	
			}
		
		musica.start();
        
    	int resultado = Integer.parseInt(getIntent().getStringExtra("resultado"));
    	int id_imagen_final;
    	
    	if(resultado < 5){
        	id_imagen_final = getResources().getIdentifier("foto_camara_1", "drawable", getPackageName());
    	}else if(5 <= resultado && resultado < 15){
        	id_imagen_final = getResources().getIdentifier("foto_camara_2", "drawable", getPackageName());
    	}else if(15 <= resultado && resultado < 20){
        	id_imagen_final = getResources().getIdentifier("foto_camara_3", "drawable", getPackageName());    		
    	}else if(20 <= resultado && resultado < 30){
        	id_imagen_final = getResources().getIdentifier("foto_camara_4", "drawable", getPackageName()); 			
    	}else{
        	id_imagen_final = getResources().getIdentifier("foto_camara_5", "drawable", getPackageName());
    	}
    	
        Drawable drawable = getResources().getDrawable(id_imagen_final);
    	imagen_fin.setImageDrawable(drawable);
    	
    	fin = true;
    	
    	return true;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.resultado, menu);
		return true;
	}

}
