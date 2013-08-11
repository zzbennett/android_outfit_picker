package com.bennett.androidoutfitpicker.database;

import com.bennett.androidoutfitpicker.models.Garment;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Comment;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;


public class GarmentsDataSource {
	// Database fields
	private SQLiteDatabase database;
	private GarmentTable dbHelper;
	private String[] allColumns = { GarmentTable.COLUMN_ID,
			GarmentTable.COLUMN_GARMENT};

	public GarmentsDataSource(Context context) {
		dbHelper = new GarmentTable(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}

	public Garment createGarment(String garment) {
		ContentValues values = new ContentValues();
		values.put(GarmentTable.COLUMN_GARMENT, garment);
		long insertId = database.insert(GarmentTable.TABLE_GARMENTS, null,
				values);
		Cursor cursor = database.query(GarmentTable.TABLE_GARMENTS,
				allColumns, GarmentTable.COLUMN_ID + " = " + insertId, null,
				null, null, null);
		cursor.moveToFirst();
		Garment newComment = cursorToGarment(cursor);
		cursor.close();
		return newComment;
	}

	public void deleteGarment(Garment garment) {
		long id = garment.getId();
		System.out.println("Comment deleted with id: " + id);
		database.delete(GarmentTable.TABLE_GARMENTS, GarmentTable.COLUMN_ID
				+ " = " + id, null);
	}

	public List<Garment> getAllGarments() {
		List<Garment> garments = new ArrayList<Garment>();

		Cursor cursor = database.query(GarmentTable.TABLE_GARMENTS,
				allColumns, null, null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Garment garment = cursorToGarment(cursor);
			garments.add(garment);
			cursor.moveToNext();
		}
		// Make sure to close the cursor
		cursor.close();
		return garments;
	}

	private Garment cursorToGarment(Cursor cursor) {
		Garment garment = new Garment();
		garment.setId(cursor.getLong(0));
		garment.setDescription(cursor.getString(1));
		return garment;
	}
}

