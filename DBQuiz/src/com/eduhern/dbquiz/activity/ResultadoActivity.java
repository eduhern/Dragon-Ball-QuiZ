package com.eduhern.dbquiz.activity;

import com.eduhern.dbquiz.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class ResultadoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_resultado);
    	TextView textViewPregunta = (TextView)findViewById(R.id.texto_resultado);
    	textViewPregunta.setText(getIntent().getStringExtra("resultado")+" respuestas correctas");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.resultado, menu);
		return true;
	}

}
