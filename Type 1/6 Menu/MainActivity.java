package com.example.mahima.a6menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView option;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        option=(TextView)findViewById(R.id.option);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId())
        {
            case R.id.Option1:
                option.setText("Option 1 is selected");
                return true;
            case R.id.Option2:
                option.setText("Option 2 is selected");
                return true;
            case R.id.Option3:
                option.setText("Option 3 is selected");
                return true;
            case R.id.Option4:
                option.setText("Option 4 is selected");
                return true;
            case R.id.Option5:
                option.setText("Option 5 is selected");
                return true;
            case R.id.Option6:
                option.setText("Option 6 is selected");
                return true;
            default: return super.onOptionsItemSelected(item);

        }


    }
}
