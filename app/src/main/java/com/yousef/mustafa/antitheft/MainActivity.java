package com.yousef.mustafa.antitheft;


import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
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
    Intent batteryStatus = new Intent();
    IntentFilter batteryChangedIntentFilter;
    PowerConnectionReceiver powerConnectionReceiver;

    /*
    // Get status (charging or full)
    int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);

    // Is the device currently loading battery?
    boolean isCharging = status == BatteryManager.BATTERY_STATUS_FULL;

    // Get status (AC or USB)
    int chargePlug = batteryStatus.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);

    // Is the device loading with AC or USB?
    boolean usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
    boolean acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC;
    */

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startServiceButton = (ToggleButton) findViewById(R.id.startServiceButton);
        batteryChangedIntentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        powerConnectionReceiver = new PowerConnectionReceiver();

        batteryStatus = getApplicationContext().registerReceiver(null, batteryChangedIntentFilter);


        startServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (startServiceButton.isActivated()) {
                    Toast.makeText(MainActivity.this, "Service stopped", Toast.LENGTH_SHORT).show();
                    Log.i("button disabled", "Button is disabled, monitoring stopped");
                    startServiceButton.setActivated(false);
                } else {
                    monitorBatteryChanges();
                }
            }
        });
    }

    // Replace
    private void monitorBatteryChanges() {

        Log.i("button enabled", "Button is enabled, monitoring started");
        Toast.makeText(MainActivity.this, "Service started", Toast.LENGTH_LONG).show();

        startServiceButton.setActivated(true);
        playAlarmIfChargerWasRemoved();

    }

    private void playAlarmIfChargerWasRemoved() {
        // TODO
    }
}
