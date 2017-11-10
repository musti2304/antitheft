package com.yousef.mustafa.antitheft;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

public class PowerConnectionReceiver extends BroadcastReceiver {

    MediaPlayer mediaPlayer = new MediaPlayer();

    // Determine whether the AC is disconnected or not
    private boolean POWER_DISCONNECTED = true;

    PowerConnectionReceiver(boolean disconnected) {
        this.POWER_DISCONNECTED = disconnected;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (POWER_DISCONNECTED) {
            mediaPlayer = MediaPlayer.create(context, R.raw.alarm_2);
            Toast.makeText(context, "Alarm started", Toast.LENGTH_SHORT).show();
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
        } else {
            Toast.makeText(context, "Alarm stopped", Toast.LENGTH_SHORT).show();
            if (mediaPlayer.isPlaying())
            {
                mediaPlayer.reset();
                mediaPlayer.release();
            }
        }
    }


}