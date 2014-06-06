package com.test.playlistdemo;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	public static final int PLAYLIST = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		TextView 	trackTitleView;
		TextView	artistNameView;
		TextView	albumTitleView;
		Button		playlistBtn;
		
		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			
			trackTitleView = (TextView)rootView.findViewById(R.id.textView1);
			artistNameView = (TextView)rootView.findViewById(R.id.textView2);
			albumTitleView = (TextView)rootView.findViewById(R.id.textView3);
			
			playlistBtn = (Button)rootView.findViewById(R.id.playlistBtn);
			playlistBtn.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(getActivity(), PlayListActivity.class);
					startActivityForResult(intent, PLAYLIST);
				}
			});
			
			return rootView;
		}
		
		@Override
		public void onActivityResult(int requestCode, int resultCode, Intent data) {
			if (requestCode == PLAYLIST && resultCode == RESULT_OK) {
				Bundle bundle = data.getExtras();
				trackTitleView.setText(bundle.getString("track_title"));
				artistNameView.setText(bundle.getString("artist_name"));
				albumTitleView.setText(bundle.getString("album_title"));	
			}
		}
	}
	
}
