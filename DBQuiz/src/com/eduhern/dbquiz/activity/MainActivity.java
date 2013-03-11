package com.eduhern.dbquiz.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.eduhern.dbquiz.R;
import com.eduhern.dbquiz.database.DatabaseHelper;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;

public class MainActivity extends OrmLiteBaseActivity<DatabaseHelper> implements
		OnClickListener {
	MediaPlayer musica;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final Button boton = (Button) findViewById(R.id.boton1);
		boton.setOnClickListener(this);

		musica = MediaPlayer.create(this, R.raw.dbquiz_music);
		musica.start();
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	public void onClick(View arg0) {
		musica.stop();
		Intent intent = new Intent(this, QuestionActivity.class);
		startActivity(intent);
	}

}
