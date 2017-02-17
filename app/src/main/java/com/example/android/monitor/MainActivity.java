package com.example.android.monitor;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv ;
    private BroadcastReceiver mReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mReceiver = new BatteryBroadcastReceiver();
        tv = (TextView) findViewById(R.id.text_view);
    }
    @Override
    protected void onStart() {
        Log.v("onStart :" , "start");
        registerReceiver(mReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        super.onStart();
    }
    @Override
    protected void onStop() {
        Log.v("onStop :" , "stop");
        registerReceiver(mReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
       // unregisterReceiver(mReceiver);
        super.onStop();
    }

    @Override
    protected void onPause() {
        Log.v("onPause :" , "pause");
        //registerReceiver(mReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.v("onResume :" , "resume");
        super.onResume();
    }

    private class BatteryBroadcastReceiver extends BroadcastReceiver {
        private final static String BATTERY_LEVEL = "level";
        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getIntExtra(BATTERY_LEVEL, 0);
           /* mBatteryLevelText.setText(getString(R.string.battery_level) + " " + level);
            mBatteryLevelProgress.setProgress(level);*/
            if (level == 83){
                tv.setText(String.valueOf(level));
                String tittle= "sai";
                String subject= "BatteryLevel";
                String body= "80%";

                NotificationManager notif=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                //Uri sound = Uri.parse("android.resource://" + this.getPackageName() + "/raw/notifysnd");
                Notification notify=new Notification.Builder
                        (getApplicationContext()).setContentTitle(tittle).setContentText(body).
                        setContentTitle(subject).setSmallIcon(R.drawable.placeholder).setDefaults(Notification.DEFAULT_SOUND).build();

                notify.flags |= Notification.FLAG_AUTO_CANCEL;
                notif.notify(0, notify);
            }
            Log.v("level :", String.valueOf(level));
        }
    }
}
