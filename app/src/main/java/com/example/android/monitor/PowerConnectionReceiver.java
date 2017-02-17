package com.example.android.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.util.Log;

/**
 * Created by Yomna on 2/17/2017.
 */

public class PowerConnectionReceiver extends BroadcastReceiver {
    public PowerConnectionReceiver(){

    }


    @Override
    public void onReceive(Context context, Intent intent) {
        int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
                status == BatteryManager.BATTERY_STATUS_FULL;
        //int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        if(isCharging == true)
        {
            Log.v("charging :", String.valueOf(status));

        }
        else
            Log.v("notCharging :", String.valueOf(status));
        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        Log.v("level :", String.valueOf(level));
        if(level == 71){

            Log.v("level :", String.valueOf(level));
        }


       /* int chargePlug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
        boolean usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
        boolean acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC;*/
    }

}
