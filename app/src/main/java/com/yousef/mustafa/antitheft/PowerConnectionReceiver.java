package com.yousef.mustafa.antitheft;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

public class PowerConnectionReceiver extends BroadcastReceiver {

    MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    public void onReceive(Context context, Intent intent) {
        mediaPlayer = MediaPlayer.create(context, R.raw.alarm_2);
        String action = intent.getAction();

        if (action.equals(Intent.ACTION_POWER_CONNECTED)){
            mediaPlayer.stop();
            mediaPlayer.release();
            Toast.makeText(context, "Alarm stopped", Toast.LENGTH_SHORT).show();
        }
        if (action.equals(Intent.ACTION_POWER_DISCONNECTED)) {
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
            Toast.makeText(context, "Alarm started", Toast.LENGTH_SHORT).show();
        }
    }
}