package com.example.tc2r.youtubeplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;


public class StandaloneActivity extends AppCompatActivity implements View.OnClickListener {


	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_standalone);

		Button btnPlayVideo = (Button) findViewById(R.id.btn_play_video);
		Button btnPlaylist = (Button) findViewById(R.id.btnplaylist);


		btnPlaylist.setOnClickListener(this);
		btnPlayVideo.setOnClickListener(this);

	}

	@Override
	public void onClick(View view) {
		Intent intent = null;
		switch (view.getId()) {
			case R.id.btn_play_video:
				// Play single Video by using intent
				intent = YouTubeStandalonePlayer.createVideoIntent(this, YoutubeActivity.Google_API_KEY, YoutubeActivity.YOUTUBE_VIDEO_ID, 0,true, true);



				break;

			case R.id.btnplaylist:
				// Play Playlist by using intent
				intent = YouTubeStandalonePlayer.createPlaylistIntent(this, YoutubeActivity.Google_API_KEY, YoutubeActivity.YOUTUBE_PLAYLIST, 0, 0 , true, false);
				break;
		}

		if(intent != null){
			startActivity(intent);
		}
	}
}
