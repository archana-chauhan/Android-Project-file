package com.mac.practicalthree;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String TEXT_TO_SEND = "text_to_send";

    private EditText editTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextView = (EditText) findViewById(R.id.edit_text_view);
    }

    public void sendText(View view) {
        String textToSend = editTextView.getText().toString().trim();
        if (textToSend.equals("")) {
            sendToastMessage("Cannot send empty value!!");
            return;
        }
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(TEXT_TO_SEND, textToSend);
        startActivity(intent);
    }

    private void sendToastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
