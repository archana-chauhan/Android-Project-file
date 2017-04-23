package com.example.mahima.changecolor8;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void changeBlue(View view){
        RelativeLayout mylay = (RelativeLayout)findViewById(R.id.layout);
        mylay.setBackgroundColor(Color.BLUE);
    }
    public void changeRed(View view){
        RelativeLayout mylay = (RelativeLayout)findViewById(R.id.layout);
        mylay.setBackgroundColor(Color.RED);
    }
    public void changeGreen(View view){
        RelativeLayout mylay = (RelativeLayout)findViewById(R.id.layout);
        mylay.setBackgroundColor(Color.GREEN);
    }
}
