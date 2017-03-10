package com.andi.alquran.broadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import com.andi.alquran.services.MurattalService;

public class CallReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent.getStringExtra("state").equals(TelephonyManager.EXTRA_STATE_RINGING) && MurattalService.f1949b) {
            MurattalService.m3349c();
            context.stopService(new Intent(context, MurattalService.class));
        }
    }
}
