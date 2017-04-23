package com.example.mahima.radiogroup7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    int pos;
    int pos1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg = (RadioGroup)findViewById(R.id.radioGroup);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub

                // Method For Getting Index of RadioButton
                pos=rg.indexOfChild(findViewById(checkedId));

                TextView txt = (TextView)findViewById(R.id.textView);
                switch (pos)
                {
                    case 0 :
                        txt.setText("Isha Pathak");
                        break;
                    case 1 :
                        txt.setText("Dinesh Yadav");
                        break;
                    case 2 :
                        txt.setText("Latika Mehendiratta");
                        break;
                    default :
                        //The default selection is RadioButton 1
                        txt.setText("Choose one");
                        break;
                }
    }
    });
}
};

