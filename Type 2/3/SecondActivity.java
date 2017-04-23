package com.mac.practicalthree;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView sentTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sentTextView = (TextView) findViewById(R.id.sent_text_tv);

        Intent intent = getIntent();
        if (intent.hasExtra(MainActivity.TEXT_TO_SEND)) {
            String text = intent.getStringExtra(MainActivity.TEXT_TO_SEND);
            sentTextView.setText(text);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
