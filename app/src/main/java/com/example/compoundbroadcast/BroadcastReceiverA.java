package com.example.compoundbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BroadcastReceiverA extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Broadsted message received in Receiver A: " + intent.getStringExtra("MESS"), Toast.LENGTH_SHORT).show();
    }
}
