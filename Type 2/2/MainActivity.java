package com.mac.practicaltwo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView lifeCycleTv;

    private static final String TAG = MainActivity.class.getSimpleName();

    public static final String LIFECYCLE_CALLBACKS_TEXT_KEY = "lifecycle_value";

    private static final String ON_CREATE = "onCreate";
    private static final String ON_START = "onStart";
    private static final String ON_RESUME = "onResume";
    private static final String ON_PAUSE = "onPause";
    private static final String ON_STOP = "onStop";
    private static final String ON_RESTART = "onRestart";
    private static final String ON_DESTROY = "onDestroy";
    private static final String ON_SAVE_INSTANCE_STATE = "onSaveInstanceState";

    private static final ArrayList<String> mLifecycleCallbacks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lifeCycleTv = (TextView) findViewById(R.id.life_cycle_tv);
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(LIFECYCLE_CALLBACKS_TEXT_KEY)) {
                String lifeCyclePreviousCallbacks = savedInstanceState.getString(LIFECYCLE_CALLBACKS_TEXT_KEY);
                lifeCycleTv.setText(lifeCyclePreviousCallbacks);
            }
        }

        for (int index = mLifecycleCallbacks.size() - 1; index >= 0; index--) {
            lifeCycleTv.append(mLifecycleCallbacks.get(index) + "\n");
        }

        mLifecycleCallbacks.clear();

        logAndAppend(ON_CREATE);

    }

    @Override
    protected void onStart() {
        super.onStart();
        logAndAppend(ON_START);
    }

    @Override
    protected void onResume() {
        super.onResume();
        logAndAppend(ON_RESUME);
    }

    @Override
    protected void onPause() {
        super.onPause();
        logAndAppend(ON_PAUSE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mLifecycleCallbacks.add(0, ON_STOP);
        logAndAppend(ON_STOP);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        logAndAppend(ON_RESTART);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLifecycleCallbacks.add(0, ON_DESTROY);
        logAndAppend(ON_DESTROY);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        logAndAppend(ON_SAVE_INSTANCE_STATE);
        String lifeCycleTextValue = lifeCycleTv.getText().toString();
        outState.putString(LIFECYCLE_CALLBACKS_TEXT_KEY, lifeCycleTextValue);
    }

    public void clearLogs(View view) {
        lifeCycleTv.setText("");
    }

    private void logAndAppend(String lifeCycleEvent) {
        Log.d(TAG, "Life Cycle Event: " + lifeCycleEvent);
        lifeCycleTv.append(lifeCycleEvent + "\n");
    }

}
