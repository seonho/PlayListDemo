package com.test.playlistdemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

	String sql;
	public DBHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
		sql = "CREATE TABLE track (_id INTEGER PRIMARY KEY AUTOINCREMENT, track_title TEXT, artist_name TEXT, album_title TEXT );";
		db.execSQL(sql);
		
		db.execSQL("INSERT INTO track VALUES(NULL, 'Your Scent', 'Jung In & Gary', 'Your Scent');");
		db.execSQL("INSERT INTO track VALUES(NULL, 'The meaing of you (Feat. KIm Chang Wan', 'IU', 'Flower Bookmark');");
		db.execSQL("INSERT INTO track VALUES(NULL, 'The word, Love', 'Taeyon', 'OST');");
		db.execSQL("INSERT INTO track VALUES(NULL, 'You whom I love', 'Shin Yong Jae', 'You whom I love');");
		db.execSQL("INSERT INTO track VALUES(NULL, 'Whats wrong with me? (Feat. Kang Min Hee of Miss S)', 'San E', 'OST');");
		
		Log.d("DBHelper", "Table has been created");
		
	}
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
}
