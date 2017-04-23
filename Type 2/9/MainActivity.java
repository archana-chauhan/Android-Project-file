package com.mac.practicalnine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button blueBtn, greenBtn, yellowBtn;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        blueBtn = (Button) findViewById(R.id.blue_btn);
        greenBtn = (Button) findViewById(R.id.green_btn);
        yellowBtn = (Button) findViewById(R.id.yellow_btn);

        linearLayout = (LinearLayout) findViewById(R.id.linear_layout);

        blueBtn.setOnClickListener(this);
        yellowBtn.setOnClickListener(this);
        greenBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int itemId = v.getId();
        switch (itemId) {
            case R.id.blue_btn:
                linearLayout.setBackgroundColor(getResources().getColor(R.color.blue));
                break;
            case R.id.green_btn:
                linearLayout.setBackgroundColor(getResources().getColor(R.color.green));
                break;
            case R.id.yellow_btn:
                linearLayout.setBackgroundColor(getResources().getColor(R.color.yellow));
                break;
        }
    }

}
