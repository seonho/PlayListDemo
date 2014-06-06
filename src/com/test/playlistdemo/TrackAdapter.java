package com.test.playlistdemo;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class TrackAdapter extends CursorAdapter {

	public TrackAdapter(Context context, Cursor c) {
		super(context, c, true);
	}
	@Override
	public void bindView(View view, Context context, Cursor cursor) {
		// TODO Auto-generated method stub

		@SuppressWarnings("unused")
		final ImageView image = (ImageView)view.findViewById(R.id.track_icon);
		
		final TextView track_title = (TextView)view.findViewById(R.id.track_title);
		final TextView artist_name = (TextView)view.findViewById(R.id.artist_name);
		final TextView album_title = (TextView)view.findViewById(R.id.album_title);
		
		// Set image
		
		track_title.setText(cursor.getString(cursor.getColumnIndex("track_title")));
		artist_name.setText(cursor.getString(cursor.getColumnIndex("artist_name")));
		album_title.setText(cursor.getString(cursor.getColumnIndex("album_title")));
	}

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = LayoutInflater.from(context);
		View v = inflater.inflate(R.layout.trackitem, parent, false);
		return v;
	}
}
