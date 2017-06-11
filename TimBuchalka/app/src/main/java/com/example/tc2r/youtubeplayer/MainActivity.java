package com.example.tc2r.youtubeplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


/* Instructor: Android Nougat App Masterclass
* Link: https://www.udemy.com/master-android-7-nougat-java-app-development-step-by-step/learn/v4/t/lecture/5615180?start=0
*
* An App that uses the google youtube api to play a video using 2 different methods
* The YouTubePlayerView as well as the StandAlonePlayer Intent
*
*
* Notes on Project:
* Using the Stand Alone Player makes it easier to auto play videos, the last param enables lightbox
* which helps in screen rotation.
*
* Exercised 2 different methods of Programmatically creating the layout.
*
*/
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

	Button btnSingle, btnStandalone;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnSingle = (Button) findViewById(R.id.btn_playsingle);
		btnStandalone = (Button) findViewById(R.id.btn_standalone);

		btnSingle.setOnClickListener(this);
		btnStandalone.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		Intent intent = null;

		switch(view.getId()) {
			case R.id.btn_playsingle:
				intent = new Intent(this, YoutubeActivity.class);
				break;
			case R.id.btn_standalone:
				intent = new Intent(this, StandaloneActivity.class);
				break;
		}

		if (intent != null) {
			startActivity(intent);
		}
	}
}
