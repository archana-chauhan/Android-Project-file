package com.example.mahima.a2lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"Create", Toast.LENGTH_SHORT).show();
    }
    protected void onStart()
    {
        super.onStart();
        Toast.makeText(this, "Onstart", Toast.LENGTH_SHORT).show();
    }

    protected void onPause()
    {
        super.onPause();
        Toast.makeText(this, "OnPause", Toast.LENGTH_SHORT).show();
    }

    protected void onRestart()
    {
        super.onRestart();
        Toast.makeText(this, "OnRestart", Toast.LENGTH_SHORT).show();
    }

    protected void onResume()
    {
        super.onResume();
        Toast.makeText(this, "OnResume", Toast.LENGTH_SHORT).show();
    }

    protected void onDestroy()
    {
        super.onDestroy();
        Toast.makeText(this, "OnDestroy", Toast.LENGTH_SHORT).show();
    }

    protected void onStop()
    {
        super.onStop();
        Toast.makeText(this, "OnDestroy", Toast.LENGTH_SHORT).show();
    }
}
