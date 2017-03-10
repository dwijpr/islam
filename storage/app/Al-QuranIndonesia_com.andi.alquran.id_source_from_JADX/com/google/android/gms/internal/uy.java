package com.google.android.gms.internal;

import android.os.Build.VERSION;
import java.io.File;

public class uy {
    public static int m9371a() {
        try {
            return Integer.parseInt(VERSION.SDK);
        } catch (NumberFormatException e) {
            vf.m9425a("Invalid version number", VERSION.SDK);
            return 0;
        }
    }

    public static boolean m9372a(String str) {
        if (m9371a() < 9) {
            return false;
        }
        File file = new File(str);
        file.setReadable(false, false);
        file.setWritable(false, false);
        file.setReadable(true, true);
        file.setWritable(true, true);
        return true;
    }
}
