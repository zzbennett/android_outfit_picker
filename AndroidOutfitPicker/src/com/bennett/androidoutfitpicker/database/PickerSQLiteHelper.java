package com.bennett.androidoutfitpicker.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class PickerSQLiteHelper extends SQLiteOpenHelper {

	public static final String DATABASE_NAME = "picker.db";
	public static final int DATABASE_VERSION = 1;

	public PickerSQLiteHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	public PickerSQLiteHelper(Context context, String name,
			CursorFactory factory, int version,
			DatabaseErrorHandler errorHandler) {
		super(context, name, factory, version, errorHandler);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
