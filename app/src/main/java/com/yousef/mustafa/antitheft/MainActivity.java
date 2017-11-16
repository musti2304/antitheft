package com.yousef.mustafa.antitheft;


import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    Button startServiceButton;
    BroadcastReceiver powerConnectionBroadcastReceiver;
    IntentFilter powerDisconnectedIntentFilter = new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED");
    IntentFilter powerConnectedIntentFilter = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();

        powerConnectionBroadcastReceiver = new PowerConnectionBroadcastReceiver();
        startServiceButton = (ToggleButton) findViewById(R.id.startServiceButton);

        startServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (startServiceButton.isActivated()) {
                    unregisterReceiver(powerConnectionBroadcastReceiver);
                    startServiceButton.setActivated(false);
                    Toast.makeText(MainActivity.this, "Service stopped", Toast.LENGTH_SHORT).show();
                } else {
                    monitorBatteryChanges();
                }
            }
        });
    }

    private void monitorBatteryChanges() {
        registerReceiver(powerConnectionBroadcastReceiver, powerDisconnectedIntentFilter);
        registerReceiver(powerConnectionBroadcastReceiver, powerConnectedIntentFilter);
        startServiceButton.setActivated(true);
        Toast.makeText(MainActivity.this, "Service started", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }

}