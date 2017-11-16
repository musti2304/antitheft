package com.yousef.mustafa.antitheft;

import android.content.Intent;
import android.os.Bundle;

import com.manusunny.pinlock.SetPinActivity;

/**
 * Created by myousef on 15.11.17.
 */

public class SetPinMainActivity extends SetPinActivity {

    Intent intent;

    @Override
    public void onPinSet(String pin) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin);
        intent = new Intent(SetPinMainActivity.this, MainActivity.class);



        //SetPinMainActivity.this.startActivity(intent);

    }
}
