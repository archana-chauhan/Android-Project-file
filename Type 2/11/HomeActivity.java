package com.mac.practicaleleven;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView usernameTv;
    private Button logoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        usernameTv = (TextView) findViewById(R.id.username_tv);
        logoutBtn = (Button) findViewById(R.id.logout_btn);

        logoutBtn.setOnClickListener(this);

        Intent intent = getIntent();
        if (intent.hasExtra("username")) {
            usernameTv.setText(intent.getStringExtra("username"));
        }

    }

    @Override
    public void onClick(View v) {
        int clickedViewId = v.getId();
        switch (clickedViewId) {
            case R.id.logout_btn:
                showValidAlertMessage();
                break;
        }
    }

    private void showValidAlertMessage() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Do you want to logout?").
                setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        logout();
                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        builder.create().show();
    }

    private void logout() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
