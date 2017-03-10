package com.google.android.gms.internal;

import android.os.Parcel;
import android.support.v7.recyclerview.BuildConfig;
import android.util.Base64;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@op
class lg {
    final zzdy f4754a;
    final String f4755b;
    final int f4756c;

    lg(le leVar) {
        this(leVar.m7270a(), leVar.m7274c(), leVar.m7273b());
    }

    lg(zzdy com_google_android_gms_internal_zzdy, String str, int i) {
        this.f4754a = com_google_android_gms_internal_zzdy;
        this.f4755b = str;
        this.f4756c = i;
    }

    static lg m7284a(String str) {
        String[] split = str.split("\u0000");
        if (split.length != 3) {
            throw new IOException("Incorrect field count for QueueSeed.");
        }
        Parcel obtain = Parcel.obtain();
        try {
            String str2 = new String(Base64.decode(split[0], 0), "UTF-8");
            int parseInt = Integer.parseInt(split[1]);
            byte[] decode = Base64.decode(split[2], 0);
            obtain.unmarshall(decode, 0, decode.length);
            obtain.setDataPosition(0);
            lg lgVar = new lg((zzdy) zzdy.CREATOR.createFromParcel(obtain), str2, parseInt);
            obtain.recycle();
            return lgVar;
        } catch (Throwable th) {
            obtain.recycle();
        }
    }

    String m7285a() {
        String encodeToString;
        Parcel obtain = Parcel.obtain();
        try {
            encodeToString = Base64.encodeToString(this.f4755b.getBytes("UTF-8"), 0);
            String num = Integer.toString(this.f4756c);
            this.f4754a.writeToParcel(obtain, 0);
            String encodeToString2 = Base64.encodeToString(obtain.marshall(), 0);
            encodeToString = new StringBuilder(((String.valueOf(encodeToString).length() + 2) + String.valueOf(num).length()) + String.valueOf(encodeToString2).length()).append(encodeToString).append("\u0000").append(num).append("\u0000").append(encodeToString2).toString();
            return encodeToString;
        } catch (UnsupportedEncodingException e) {
            encodeToString = "QueueSeed encode failed because UTF-8 is not available.";
            sg.m8446c(encodeToString);
            return BuildConfig.VERSION_NAME;
        } finally {
            obtain.recycle();
        }
    }
}
