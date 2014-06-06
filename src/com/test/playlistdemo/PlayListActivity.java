package com.test.playlistdemo;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class PlayListActivity extends Activity implements OnItemClickListener {

	ListView		listView;
	DBHelper		dbHelper;
	SQLiteDatabase	db;
	String			sql;
	Cursor			cursor;
	
	final static String dbName = "tracks.db";
	final static int dbVersion = 1;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	
	    // TODO Auto-generated method stub
	    setContentView(R.layout.playlist);
	    
	    listView = (ListView)findViewById(R.id.playlist);
	    dbHelper = new DBHelper(this, dbName, null, dbVersion);
	    
	    queryDB();
	    	    
	    listView.setOnItemClickListener(this);
	}
	
	@SuppressWarnings("deprecation")
	private void queryDB() {
		db = dbHelper.getWritableDatabase();
		
		sql = "SELECT * from track;";
		cursor = db.rawQuery(sql, null);
		
		if (cursor.getCount() > 0) {
			startManagingCursor(cursor);
			TrackAdapter trackAdapter = new TrackAdapter(this, cursor);
			listView.setAdapter(trackAdapter);
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		cursor.moveToPosition(position);
		
		Intent data = new Intent();
		data.putExtra("track_title", cursor.getString(cursor.getColumnIndex("track_title")));
		data.putExtra("artist_name", cursor.getString(cursor.getColumnIndex("artist_name")));
		data.putExtra("album_title", cursor.getString(cursor.getColumnIndex("album_title")));
		
		setResult(RESULT_OK, data);
		
		// go back to previous activity.
		finish();
	}

}
