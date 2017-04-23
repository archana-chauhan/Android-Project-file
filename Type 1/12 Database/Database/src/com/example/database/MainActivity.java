package com.example.database;


import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
	EditText username, password;
	Button update, insert, delete, data;
	TextView table;
	DAO dao;
	Activity a;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		username=(EditText)findViewById(R.id.username);
		password=(EditText)findViewById(R.id.password);
		update=(Button)findViewById(R.id.Update);
		data=(Button)findViewById(R.id.data);
		delete=(Button)findViewById(R.id.Delete);
		table=(TextView)findViewById(R.id.table);
		insert=(Button)findViewById(R.id.Insert);
		dao= new DAO(this);
		a=this;
		insert.setOnClickListener(new View.OnClickListener() {


			public void onClick(View v) {
				// TODO Auto-generated method stub

				if(username.getText().toString()!=null && password.getText().toString()!=null)
				{
					
					if(!dao.insert(username.getText().toString(),password.getText().toString()))
					{
						Toast.makeText(a, "Unable to add to database", Toast.LENGTH_SHORT).show();
						username.setText("");
						password.setText("");
					}
					else
					{
						Toast.makeText(a, "Added to database", Toast.LENGTH_SHORT).show();
						username.setText("");
						password.setText("");
					}
				}
			}
		});

		data.setOnClickListener(new View.OnClickListener() {


			public void onClick(View v) {
				// TODO Auto-generated method stub
				String table_entry="";
				dao.openForReading();
				Cursor cr= dao.getTable();

				while(!cr.isAfterLast())
				{
					table_entry=table_entry.concat(" (");
					table_entry=table_entry.concat(cr.getString(cr.getColumnIndex(DBAdapter.USERNAME)));
					table_entry=table_entry.concat(",");
					table_entry=table_entry.concat(cr.getString(cr.getColumnIndex(DBAdapter.PASSWORD)));
					table_entry=table_entry.concat(") ");
					cr.moveToNext();
				}
				cr.close();

				table.setText(table_entry);
			}


		});

		delete.setOnClickListener(new View.OnClickListener() {


			public void onClick(View v) {
				// TODO Auto-generated method stub
				

				if(username.getText().toString()!=null )
				{
					if(!dao.delete(username.getText().toString()))
					{
						Toast.makeText(a, "Unable to delete from database", Toast.LENGTH_SHORT).show();
						username.setText("");
						password.setText("");
					}
					else
					{
						Toast.makeText(a, "Deleted from database", Toast.LENGTH_SHORT).show();
						username.setText("");
						password.setText("");
					}
				}
			}
		});

		update.setOnClickListener(new View.OnClickListener() {


			public void onClick(View v) {
				// TODO Auto-generated method stub

				if(username.getText().toString()!=null && password.getText().toString()!=null)
				{

					if(!dao.update(username.getText().toString(),password.getText().toString()))
					{
						Toast.makeText(a, "Unable to update to database", Toast.LENGTH_SHORT).show();
						username.setText("");
						password.setText("");
					}
					else
					{
						Toast.makeText(a, "Updated in database", Toast.LENGTH_SHORT).show();
						username.setText("");
						password.setText("");
					}
				}
			}
		});


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
}
