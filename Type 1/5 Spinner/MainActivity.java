package com.example.mahima.a7spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image=(ImageView)findViewById(R.id.image);
        spinner=(Spinner)findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spinner.getSelectedItemId()==0)
                {
                    image.setImageResource(R.drawable.pikachu);
                }
                else if(spinner.getSelectedItemId()==1)
                {
                    image.setImageResource(R.drawable.togepi);
                }
                else {
                    image.setImageResource(R.drawable.charmander);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                image.setImageResource(R.drawable.pikachu);
            }
        });
    }
}
