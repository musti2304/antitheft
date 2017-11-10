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
    PowerConnectionReceiver powerConnectionReceiver;
    BroadcastReceiver powerDisconnectedBroadcastReceiver;
    BroadcastReceiver powerConnectedBroadcastReceiver;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        powerConnectionReceiver = new PowerConnectionReceiver(true);
        startServiceButton = (ToggleButton) findViewById(R.id.startServiceButton);

        powerDisconnectedBroadcastReceiver = new PowerConnectionReceiver(true);
        powerConnectedBroadcastReceiver = new PowerConnectionReceiver(false);

        startServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (startServiceButton.isActivated()) {
                    unregisterReceiver(powerDisconnectedBroadcastReceiver);
                    unregisterReceiver(powerConnectedBroadcastReceiver);
                    Toast.makeText(MainActivity.this, "Service stopped", Toast.LENGTH_SHORT).show();
                    startServiceButton.setActivated(false);
                } else {
                    monitorBatteryChanges();
                }
            }
        });
    }

    private void monitorBatteryChanges() {

        IntentFilter powerDisconnectedIntentFilter = new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED");
        registerReceiver(powerDisconnectedBroadcastReceiver, powerDisconnectedIntentFilter);

        IntentFilter powerConnectedIntentFilter = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");
        registerReceiver(powerConnectedBroadcastReceiver, powerConnectedIntentFilter);

        Toast.makeText(MainActivity.this, "Service started", Toast.LENGTH_SHORT).show();
        startServiceButton.setActivated(true);
    }

}