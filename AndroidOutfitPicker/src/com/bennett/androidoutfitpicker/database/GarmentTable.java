package com.bennett.androidoutfitpicker.database;

import android.content.Context;
import android.util.Log;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class GarmentTable extends SQLiteOpenHelper {

	public static final String TABLE_GARMENTS = "garments";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_GARMENT = "garment";

	// Database creation sql statement
	private static final String DATABASE_CREATE = "create table "
			+ TABLE_GARMENTS + "(" + COLUMN_ID
			+ " integer primary key autoincrement, " + COLUMN_GARMENT
			+ " text not null);";

	public GarmentTable(Context context) {
		super(context, PickerSQLiteHelper.DATABASE_NAME, null, PickerSQLiteHelper.DATABASE_VERSION);
	}

	public GarmentTable(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	public GarmentTable(Context context, String name,
			CursorFactory factory, int version,
			DatabaseErrorHandler errorHandler) {
		super(context, name, factory, version, errorHandler);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DATABASE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(GarmentTable.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_GARMENTS);
		onCreate(db);
	}

}
