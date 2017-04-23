package com.example.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBAdapter extends SQLiteOpenHelper{
	
	private static final int DBversion = 1;

	private static String DBName ="login.db";
	
	public static String USERNAME="username";
	public static String PASSWORD="password";
	public static String TABLE_NAME="login";
	
	//CREATE QUERY
	private static String CREATE_TABLE="create table "+TABLE_NAME+"(" +USERNAME+ " text primary key, "+PASSWORD +" text)";
			
	//INSERT QUERY
	public static String INSERT_TABLE="insert into "+ TABLE_NAME +" ("+USERNAME +"," +PASSWORD +") values(?,?)";
	public static String UPDATE_TABLE="update "+ TABLE_NAME +" set "+PASSWORD +"=? where " +USERNAME+"=?";
	public static String DELETE_FROM_TABLE="delete from "+ TABLE_NAME +" where " +USERNAME+" = ?";
	
	



	public DBAdapter(Context context) {
		super(context, DBName, null, DBversion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_TABLE);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
