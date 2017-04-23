package com.mac.practicalten;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText usernameEt, passwordEt;
    private Button loginBtn;

    static final String USERNAME = "admin";
    static final String PASSWORD = "admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEt = (EditText) findViewById(R.id.username_et);
        passwordEt = (EditText) findViewById(R.id.password_et);
        loginBtn = (Button) findViewById(R.id.login_btn);

        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int clickedViewId = v.getId();
        if (clickedViewId == R.id.login_btn) {
            validateLoginCredentials();
        }
    }

    private void validateLoginCredentials() {
        String username = usernameEt.getText().toString().trim();
        String password = passwordEt.getText().toString();

        if (username.equals("")) {
            showToastMessage("Username cannot be empty!!");
            return;
        }

        if (password.equals("")) {
            showToastMessage("Password cannot be empty!!");
            return;
        }

        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            showValidAlertMessage(USERNAME);
        } else {
            showToastMessage("Incorrect username and password!!");
        }
    }

    private void showToastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void showValidAlertMessage(String username) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Welcome " + username).
                setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
