package com.example.mahima.login10;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.app.AlertDialog.Builder;

public class MainActivity extends AppCompatActivity {

    public static final String messageText = "Welcome mahima";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLogin(View view)  {
        EditText user = (EditText)findViewById(R.id.username);
        EditText psd = (EditText)findViewById(R.id.pswrd);

        if( user.getText().toString().equals("ima")&& psd.getText().toString().equals("ima"))   {
            Intent intent = new Intent(this, Welcome.class);
            intent.setType("text/plain");
            intent.putExtra(Welcome.EXTRA_MESSAGE, messageText);
            startActivity(intent);

        }
        else{
            TextView error = (TextView)findViewById(R.id.textView2);
            error.setText("Wrong combination");
        }

    }
}
