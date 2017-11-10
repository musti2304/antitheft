package com.yousef.mustafa.antitheft;


import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    Button startServiceButton;
    BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startServiceButton = (ToggleButton) findViewById(R.id.startServiceButton);

        broadcastReceiver = new PowerConnectionReceiver();


        startServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (startServiceButton.isActivated()) {
                    unregisterReceiver(broadcastReceiver);
                    Toast.makeText(MainActivity.this, "Service stopped", Toast.LENGTH_SHORT).show();
                    Log.i("button disabled", "Button is disabled, monitoring stopped");
                    startServiceButton.setActivated(false);
                } else {
                    monitorBatteryChanges();
                }
            }
        });
    }

    private void monitorBatteryChanges() {
        IntentFilter airplaneModeIntentFilter = new IntentFilter("android.intent.action.AIRPLANE_MODE");
        registerReceiver(broadcastReceiver, airplaneModeIntentFilter);

        Log.i("button enabled", "Button is enabled, monitoring started");
        Toast.makeText(MainActivity.this, "Service started", Toast.LENGTH_LONG).show();
        startServiceButton.setActivated(true);

        playAlarmIfChargerWasRemoved();

    }

    private void playAlarmIfChargerWasRemoved() {
        // TODO
    }
}