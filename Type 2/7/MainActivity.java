package com.mac.practicalseven;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView teacherInchargeTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teacherInchargeTv = (TextView) findViewById(R.id.teacher_incharge_tv);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.dept_cs_radio_btn:
                if (checked) {
                    teacherInchargeTv.setText("Kalpana Nigam");
                }
                break;
            case R.id.dept_electronics_radio_btn:
                if (checked) {
                    teacherInchargeTv.setText("Elec Incharge");
                }
                break;
            case R.id.dept_english_radio_btn:
                if (checked) {
                    teacherInchargeTv.setText("English Incharge");
                }
                break;
            case R.id.dept_hindi_radio_btn:
                if (checked) {
                    teacherInchargeTv.setText("Hindi Incharge");
                }
                break;
        }
    }
}
