package com.yousef.mustafa.antitheft;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by myousef on 10.11.17.
 */

public class PowerConnectionReceiver extends BroadcastReceiver {

    // Determine whether the AC is disconnected or not
    private boolean POWER_DISCONNECTED = true;

    PowerConnectionReceiver(boolean disconnected) {
        this.POWER_DISCONNECTED = disconnected;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (POWER_DISCONNECTED) {
            Toast.makeText(context, "Alarm started", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Alarm stopped", Toast.LENGTH_SHORT).show();
        }
    }


}