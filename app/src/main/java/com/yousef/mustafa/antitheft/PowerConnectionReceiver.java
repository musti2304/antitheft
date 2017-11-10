package com.yousef.mustafa.antitheft;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;

/**
 * Created by myousef on 10.11.17.
 */

public class PowerConnectionReceiver extends BroadcastReceiver {

    Intent batteryStatus = new Intent();
    IntentFilter batteryChangedIntentFilter;


    @Override
    public void onReceive(Context context, Intent intent) {
        batteryStatus = context.registerReceiver(this, batteryChangedIntentFilter);

        int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
                status == BatteryManager.BATTERY_STATUS_FULL;

        int chargePlug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
        boolean usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
        boolean acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC;
    }

    public boolean checkIfPowerIsConnected() {

        return true;

    }
}
