package com.example.database;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

public class DAO {
	private Context context;
	private SQLiteDatabase database;
	private DBAdapter adapter;


	public DAO(Context c)
	{
		this.context=c;
		adapter=new DBAdapter(context);
	}

	private void openConnection() 
	{
		database= adapter.getWritableDatabase();
	}

	private void closeConnection() 
	{
		database.close();
		adapter.close();
	}

	public void openForReading()
	{
		openConnection();

	}
	public boolean insert(String username, String password) 
	{
		boolean isAdded =false;
		openConnection();

		SQLiteStatement insert = database.compileStatement(DBAdapter.INSERT_TABLE);
		database.beginTransaction();
		insert.bindString(1, username);
		insert.bindString(2, password);
		insert.execute();
		isAdded=true;
		database.setTransactionSuccessful();
		database.endTransaction();

		closeConnection();

		return isAdded;
	}
	public boolean delete(String username) 
	{
		boolean isdeleted =false;
		openConnection();

		SQLiteStatement delete = database.compileStatement(DBAdapter.DELETE_FROM_TABLE);
		database.beginTransaction();
		delete.bindString(1, username);
		delete.execute();
		isdeleted=true;
		database.setTransactionSuccessful();
		database.endTransaction();

		closeConnection();

		return isdeleted;
	}
	public boolean update(String username, String password) 
	{
		boolean isupdated =false;
		openConnection();

		SQLiteStatement update = database.compileStatement(DBAdapter.UPDATE_TABLE);
		database.beginTransaction();
		update.bindString(1, password);
		update.bindString(2, username);
		update.execute();
		isupdated=true;
		database.setTransactionSuccessful();
		database.endTransaction();

		closeConnection();

		return isupdated;
	}

	public Cursor getTable()
	{   
		openConnection();
		Cursor cr =database.rawQuery("select * from " + DBAdapter.TABLE_NAME,null);
		cr.moveToFirst();
		closeConnection();
		return cr;
	}

	public void close() {
		database= adapter.getReadableDatabase();

	}

}
