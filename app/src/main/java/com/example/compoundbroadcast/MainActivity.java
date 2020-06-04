package com.example.compoundbroadcast;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static final String CUSTOM_ACTION = "com.example.compoundbroadcast.ACTION_BCAST";
    private IntentFilter intentFilter;
    private BroadcastReceiverA receiverA;
    private BroadcastReceiverB receiverB;
    private BroadcastReceiverC receiverC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        receiverA = new BroadcastReceiverA();
        receiverB = new BroadcastReceiverB();
        receiverC = new BroadcastReceiverC();

        intentFilter = new IntentFilter(CUSTOM_ACTION);
        //greater number - highest priority
        //intentFilter.setPriority(1);
        registerReceiver(receiverA, intentFilter);
        //intentFilter.setPriority(2);
        registerReceiver(receiverB, intentFilter);
        //intentFilter.setPriority(3);
        registerReceiver(receiverC, intentFilter);


        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(CUSTOM_ACTION);
                intent.putExtra("MESS", "Hello Receiver");
                sendBroadcast(intent);
                //sendOrderedBroadcast(intent, null);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(receiverA);
        unregisterReceiver(receiverB);
        unregisterReceiver(receiverC);
    }
}
