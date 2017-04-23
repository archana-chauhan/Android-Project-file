package com.example.mahima.login10;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Intent intent = getIntent();
        String messageText = intent.getStringExtra(EXTRA_MESSAGE);
        TextView messageView = (TextView)findViewById(R.id.textView);
        messageView.setText(messageText);
    }

    public void fnLogOut(View view) {
        Context c = Welcome.this;

        AlertDialog.Builder builder = new AlertDialog.Builder(c);


        // Setting Dialog Title
        builder.setTitle("Logout?");

        // Setting Dialog Message
        builder.setMessage("You can press Ok or cancel");

        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Welcome.this.finish();
                    }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }
}