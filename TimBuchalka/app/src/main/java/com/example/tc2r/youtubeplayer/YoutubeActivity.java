package com.example.tc2r.youtubeplayer;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubeActivity extends YouTubeBaseActivity
implements YouTubePlayer.OnInitializedListener {
	static final String Google_API_KEY = "AIzaSyB2XyHSm_CFWEnJyaTy1qaewJTfDK9s1JY";
	static final String YOUTUBE_VIDEO_ID = "Vvfr5IN33FA";
	static final String YOUTUBE_PLAYLIST = "PLREIjCefU3UxiPkDD5Zfa6oVZ_GH4rIip";
	private static final String TAG = "YoutubeActivity";



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_youtube);
//		RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.activity_youtube);

		RelativeLayout layout = (RelativeLayout) getLayoutInflater().inflate(R.layout.activity_youtube, null);
		setContentView(layout);

//		Button button1 = new Button(this);
//		button1.setLayoutParams(new RelativeLayout.LayoutParams(300, 80));
//		button1.setText("Button Added");
//		layout.addView(button1);

		YouTubePlayerView playerView = new YouTubePlayerView(this);
		playerView.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
		layout.addView(playerView);
		playerView.initialize(Google_API_KEY, this);



		// Play video by initializing the player


	}

	@Override
	public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
		Log.d(TAG, "onInitialization Sucess: provider is " + provider.getClass().toString());
		Toast.makeText(this, "Initialized Youtube Player Successfully", Toast.LENGTH_SHORT).show();

		if (!wasRestored) {
			youTubePlayer.cueVideo(YOUTUBE_VIDEO_ID);
			youTubePlayer.setPlaybackEventListener(playbackEventListener);
			youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);



		}


	}

	@Override
	public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
		final int REQUEST_CODE = 1;

		if (youTubeInitializationResult.isUserRecoverableError()) {
			youTubeInitializationResult.getErrorDialog(this, REQUEST_CODE);

		}else{
			String errorMessage = String.format("There was an error initialize the YouTubePlayer (%1$s)", youTubeInitializationResult.toString());
			Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
		}
	}

	private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
		@Override
		public void onPlaying() {
			Toast.makeText(YoutubeActivity.this, "Good, Video is playing okay", Toast.LENGTH_LONG).show();
		}

		@Override
		public void onPaused() {
			Toast.makeText(YoutubeActivity.this, "VIDEO IS PAUSED", Toast.LENGTH_LONG).show();
		}

		@Override
		public void onStopped() {
			Toast.makeText(YoutubeActivity.this, "VIDEO IS STOPPED", Toast.LENGTH_LONG).show();
		}

		@Override
		public void onBuffering(boolean b) {

		}

		@Override
		public void onSeekTo(int i) {

		}
	};
	private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
		@Override
		public void onLoading() {

		}

		@Override
		public void onLoaded(String s) {

		}

		@Override
		public void onAdStarted() {
			Toast.makeText(YoutubeActivity.this, "Click Ad Now!", Toast.LENGTH_LONG).show();

		}

		@Override
		public void onVideoStarted() {
			Toast.makeText(YoutubeActivity.this, "VIDEO Has Started", Toast.LENGTH_LONG).show();

		}

		@Override
		public void onVideoEnded() {
			Toast.makeText(YoutubeActivity.this, "VIDEO Has Ended", Toast.LENGTH_LONG).show();

		}

		@Override
		public void onError(YouTubePlayer.ErrorReason errorReason) {

		}
	};
}
