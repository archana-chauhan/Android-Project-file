package com.mac.practicaleleven;

import android.content.Intent;
import android.os.Bundle;
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
            Intent intent = new Intent(this, HomeActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
            finish();
        } else {
            showToastMessage("Incorrect username and password!!");
        }
    }

    private void showToastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
