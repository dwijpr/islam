package com.andi.alquran.p032j;

import android.support.v7.recyclerview.BuildConfig;
import com.andi.alquran.App;
import com.andi.alquran.p028g.p029a.C0911a;
import java.io.File;
import java.io.FileFilter;
import java.util.Locale;
import java.util.regex.Pattern;

/* renamed from: com.andi.alquran.j.a */
public class C0939a {

    /* renamed from: com.andi.alquran.j.a.a */
    class C0938a implements FileFilter {
        C0938a() {
        }

        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]+", file.getName());
        }
    }

    public static int m3270a() {
        try {
            File file = new File("/sys/devices/system/cpu/");
            if (!file.exists() || file == null) {
                return 1;
            }
            File[] listFiles = file.listFiles(new C0938a());
            return listFiles != null ? listFiles.length : 1;
        } catch (NullPointerException e) {
            return 1;
        } catch (Exception e2) {
            return 1;
        }
    }

    public static String m3271a(int i, long j) {
        long j2 = (((long) i) * j) / 100;
        if (j >= 1000000) {
            return BuildConfig.VERSION_NAME + String.format(Locale.getDefault(), "%.1f", new Object[]{Float.valueOf(((float) j2) / 1000000.0f)}) + "MB/" + String.format(Locale.getDefault(), "%.1f", new Object[]{Float.valueOf(((float) j) / 1000000.0f)}) + "MB";
        } else if (j < 1000) {
            return BuildConfig.VERSION_NAME + j2 + "/" + j;
        } else {
            return BuildConfig.VERSION_NAME + String.format(Locale.getDefault(), "%.1f", new Object[]{Float.valueOf(((float) j2) / 1000.0f)}) + "Kb/" + String.format(Locale.getDefault(), "%.1f", new Object[]{Float.valueOf(((float) j) / 1000.0f)}) + "Kb";
        }
    }

    public static String m3272a(String str) {
        return App.m2887l() + str + "_tmp.zip";
    }

    public static boolean m3273a(C0911a c0911a) {
        return new File(c0911a.m3164d()).renameTo(new File(c0911a.m3165e()));
    }

    public static String m3274b(String str) {
        return App.m2887l() + str + ".zip";
    }
}
