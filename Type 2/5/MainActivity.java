package com.mac.practicalfive;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private AppCompatSpinner spinner;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (AppCompatSpinner) findViewById(R.id.spinner);
        imageView = (ImageView) findViewById(R.id.image_view);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.cartoon_pics, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        setImage(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        imageView.setBackgroundResource(R.drawable.image_one);
    }

    private void setImage(int position) {
        switch (position) {
            case 0:
                imageView.setBackgroundResource(R.drawable.image_one);
                break;
            case 1:
                imageView.setBackgroundResource(R.drawable.image_two);
                break;
            case 2:
                imageView.setBackgroundResource(R.drawable.image_three);
                break;
            default:
                imageView.setBackgroundResource(R.drawable.image_one);
        }
    }
}
