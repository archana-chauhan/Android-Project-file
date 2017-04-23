package com.example.mahima.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSendMessage(View view) {
        EditText msgText = (EditText)findViewById(R.id.message);
        String messageText = msgText.getText().toString();
        Intent intent = new Intent(this, ReceiveMessage.class);
        intent.setType("text/plain");
        intent.putExtra(ReceiveMessage.EXTRA_MESSAGE, messageText);
        startActivity(intent);
    }

}
