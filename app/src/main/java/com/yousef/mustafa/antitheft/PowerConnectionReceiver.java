package com.yousef.mustafa.antitheft;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by myousef on 10.11.17.
 */

public class PowerConnectionReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "Flugmodus aktiviert", Toast.LENGTH_LONG).show();

    }
}