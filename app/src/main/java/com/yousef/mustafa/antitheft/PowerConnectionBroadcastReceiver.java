package com.yousef.mustafa.antitheft;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

public class PowerConnectionBroadcastReceiver extends BroadcastReceiver {

    MediaPlayer mediaPlayer;

    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();

        if (action.equals(Intent.ACTION_POWER_DISCONNECTED)) {
            mediaPlayer = MediaPlayer.create(context, R.raw.alarm);
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
            Toast.makeText(context, "Alarm started", Toast.LENGTH_SHORT).show();
        } else {
            try {
                if (mediaPlayer != null) {
                    mediaPlayer.release();
                    Toast.makeText(context, "Alarm stopped", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}