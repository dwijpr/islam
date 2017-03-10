package com.andi.alquran;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.preference.PreferenceManager;
import android.support.v4.p009b.C0173a;
import android.support.v7.recyclerview.BuildConfig;
import android.view.ViewConfiguration;
import android.widget.Toast;
import com.andi.alquran.arabic.BacaArab;
import com.andi.alquran.arabic.C0875a;
import com.andi.alquran.p025b.C0878a;
import com.andi.alquran.p025b.C0880c;
import com.andi.alquran.p025b.C0881d;
import com.andi.alquran.p025b.C0882e;
import com.andi.alquran.p026c.C0885a;
import com.andi.alquran.p026c.C0885a.C0883a;
import com.andi.alquran.p026c.C0886b;
import com.andi.alquran.p026c.C0887c;
import com.google.android.gms.analytics.C1215c;
import com.google.android.gms.analytics.C1223g;
import com.google.android.gms.maps.GoogleMap;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Locale;

public class App extends Application {
    public static String f1447a;
    public static App f1448m;
    private static Context f1449p;
    public final C0881d f1450b;
    public final C0880c f1451c;
    public final C0878a f1452d;
    public final C0885a f1453e;
    public final C0886b f1454f;
    public final C0886b f1455g;
    public final C0886b f1456h;
    public final C0886b f1457i;
    public final C0886b f1458j;
    public final C0886b f1459k;
    public final C0887c f1460l;
    private int f1461n;
    private int f1462o;

    public App() {
        this.f1450b = new C0881d();
        this.f1451c = new C0880c();
        this.f1452d = new C0878a();
        this.f1453e = new C0885a();
        this.f1454f = new C0886b();
        this.f1455g = new C0886b();
        this.f1456h = new C0886b();
        this.f1457i = new C0886b();
        this.f1458j = new C0886b();
        this.f1459k = new C0886b();
        this.f1460l = new C0887c();
        this.f1461n = -1;
        this.f1462o = -1;
    }

    private String m2846A() {
        return new File(m2882g(), "al-quran-indopak").toString();
    }

    private String m2847B() {
        return new File(m2882g(), "al-quran-utsmani").toString();
    }

    private String m2848C() {
        return new File(m2882g(), "terjemahan").toString();
    }

    private String m2849D() {
        return new File(m2882g(), "jalalayn").toString();
    }

    private String m2850E() {
        return new File(m2882g(), "latin").toString();
    }

    private String m2851F() {
        return new File(m2882g(), "latin-english").toString();
    }

    private String m2852G() {
        return new File(m2882g(), "kata").toString();
    }

    private boolean m2853H() {
        return new File(m2882g(), C0882e.f1690i).exists();
    }

    private boolean m2854I() {
        if (!(this.f1461n == this.f1450b.f1670i && this.f1462o == this.f1450b.f1671j)) {
            try {
                BacaArab.m3034a(getAssets().open(m2880f(this.f1450b.f1670i)));
                C0875a.m3035a().m3039b();
                this.f1461n = this.f1450b.f1670i;
                this.f1462o = this.f1450b.f1671j;
            } catch (IOException e) {
                e.printStackTrace();
                this.f1461n = -1;
                this.f1462o = -1;
                return false;
            }
        }
        return true;
    }

    private static String m2855J() {
        return BuildConfig.APPLICATION_ID.equals(BuildConfig.APPLICATION_ID) ? "UA-51752609-21" : BuildConfig.APPLICATION_ID.equals("com.andi.alquran.melayu") ? "UA-51752609-26" : BuildConfig.APPLICATION_ID.equals("com.andi.alquran.en") ? "UA-51752609-22" : BuildConfig.APPLICATION_ID.equals("com.andi.alquran.francais") ? "UA-51752609-28" : BuildConfig.APPLICATION_ID.equals("com.andi.alquran.urdu") ? "UA-51752609-25" : "UA-51752609-21";
    }

    public static double m2856a(SharedPreferences sharedPreferences, String str, double d) {
        try {
            return Double.valueOf(sharedPreferences.getString(str, Double.toString(d))).doubleValue();
        } catch (NumberFormatException e) {
            return 0.0d;
        }
    }

    public static int m2857a(Context context) {
        switch (context.getResources().getConfiguration().screenLayout & 15) {
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                return 1;
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                return 3;
            case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                return 4;
            default:
                return 2;
        }
    }

    public static int m2858a(SharedPreferences sharedPreferences, String str, int i) {
        return Integer.parseInt(sharedPreferences.getString(str, Integer.toString(i)));
    }

    public static long m2859a(File file) {
        long j = 0;
        if (!file.exists() || file == null) {
            return 0;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length <= 0) {
            return 0;
        }
        for (int i = 0; i < listFiles.length; i++) {
            j = listFiles[i].isDirectory() ? j + m2859a(listFiles[i]) : j + listFiles[i].length();
        }
        return (long) Math.round((float) (j / 1024));
    }

    public static Context m2860a() {
        return f1449p;
    }

    public static Drawable m2861a(Context context, int i) {
        return VERSION.SDK_INT >= 21 ? C0173a.getDrawable(context, i) : context.getResources().getDrawable(i);
    }

    public static String m2862a(double d, boolean z) {
        int floor = (int) Math.floor(d);
        int floor2 = (int) Math.floor((d - ((double) floor)) * 60.0d);
        String str = BuildConfig.VERSION_NAME;
        if (floor > 0) {
            if (floor > 1) {
                str = f1448m.getResources().getString(C0861R.string.hours, new Object[]{Integer.valueOf(floor)}) + " ";
            } else {
                str = f1448m.getResources().getString(C0861R.string.hour, new Object[]{Integer.valueOf(floor)}) + " ";
            }
        }
        if (z) {
            if (floor2 > 1) {
                return str + f1448m.getResources().getString(C0861R.string.minutes_soon, new Object[]{Integer.valueOf(floor2)});
            }
            return str + f1448m.getResources().getString(C0861R.string.minute_soon, new Object[]{Integer.valueOf(floor2)});
        } else if (floor2 > 1) {
            return str + f1448m.getResources().getString(C0861R.string.minutes_past, new Object[]{Integer.valueOf(floor2)});
        } else {
            return str + f1448m.getResources().getString(C0861R.string.minute_past, new Object[]{Integer.valueOf(floor2)});
        }
    }

    public static String m2863a(int i) {
        return f1448m.getResources().getStringArray(C0861R.array.sura_name)[i - 1];
    }

    public static String m2864a(int i, int i2) {
        String string = f1448m.getResources().getString(C0861R.string.sura_makkiyah);
        if (i == 1) {
            string = f1448m.getResources().getString(C0861R.string.sura_madaniyah);
        }
        return string + " | " + i2 + " " + f1448m.getResources().getString(C0861R.string.ayats_name);
    }

    public static void m2865a(String str) {
        Toast.makeText(f1449p, str, 1).show();
    }

    public static int m2866b() {
        return f1449p.getSharedPreferences(C0882e.f1683b, 0).getInt(C0882e.f1688g, C0882e.f1689h);
    }

    public static int m2867b(Context context, int i) {
        return VERSION.SDK_INT >= 23 ? C0173a.getColor(context, i) : context.getResources().getColor(i);
    }

    public static int m2868b(SharedPreferences sharedPreferences, String str, int i) {
        return Integer.parseInt(sharedPreferences.getString(str, Integer.toString(i)));
    }

    public static String m2869b(int i) {
        return f1448m.getResources().getStringArray(C0861R.array.sura_artinya)[i - 1];
    }

    public static String m2870b(int i, int i2) {
        return String.format(Locale.ENGLISH, "%03d", new Object[]{Integer.valueOf(i)}) + String.format(Locale.ENGLISH, "%03d", new Object[]{Integer.valueOf(i2)}) + ".dat";
    }

    public static void m2871b(String str) {
        Toast.makeText(f1449p, str, 0).show();
    }

    public static Boolean m2872c(String str) {
        return Boolean.valueOf(new File(m2887l() + File.separator + str).exists());
    }

    public static String m2873c() {
        return f1449p.getSharedPreferences(C0882e.f1683b, 0).getString(C0882e.f1697p, C0882e.f1698q) + "/";
    }

    public static boolean m2874c(int i) {
        return new File(m2887l() + File.separator + m2870b(i, 1)).exists();
    }

    public static int m2875d(String str) {
        if (!new File(str).exists()) {
            return 0;
        }
        long blockSizeLong;
        StatFs statFs = new StatFs(str);
        if (VERSION.SDK_INT > 17) {
            blockSizeLong = statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
        } else {
            blockSizeLong = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        }
        return Math.round((float) (blockSizeLong / 1048576));
    }

    public static String m2876d(int i) {
        return String.format(Locale.ENGLISH, "%03d", new Object[]{Integer.valueOf(i)}) + ".zip";
    }

    public static int m2877e(String str) {
        if (!new File(str).exists()) {
            return 0;
        }
        long blockSizeLong;
        StatFs statFs = new StatFs(str);
        if (VERSION.SDK_INT > 17) {
            blockSizeLong = statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
        } else {
            blockSizeLong = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        }
        return Math.round((float) (blockSizeLong / 1048576));
    }

    public static String m2878e() {
        String[] stringArray = f1448m.getResources().getStringArray(C0861R.array.arrTypeQori);
        return f1448m.f1450b.f1669h == 1 ? stringArray[0] : f1448m.f1450b.f1669h == 2 ? stringArray[1] : f1448m.f1450b.f1669h == 3 ? stringArray[2] : f1448m.f1450b.f1669h == 4 ? stringArray[3] : f1448m.f1450b.f1669h == 5 ? stringArray[4] : f1448m.f1450b.f1669h == 6 ? stringArray[5] : f1448m.f1450b.f1669h == 7 ? stringArray[6] : BuildConfig.VERSION_NAME;
    }

    public static String m2879e(int i) {
        return String.format(Locale.ENGLISH, "%03d", new Object[]{Integer.valueOf(i)});
    }

    private String m2880f(int i) {
        switch (i) {
            case GoogleMap.MAP_TYPE_NONE /*0*/:
                return "qalam_majeed.ttf";
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                return "hafs9.otf";
            default:
                return "qalam_majeed.ttf";
        }
    }

    public static boolean m2881f() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) f1448m.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public static File m2882g() {
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return new File(f1449p.getFilesDir().getAbsolutePath() + File.separator);
        }
        File externalFilesDir = f1449p.getExternalFilesDir(null);
        return externalFilesDir == null ? new File(f1449p.getFilesDir().getAbsolutePath() + File.separator) : new File(externalFilesDir.getAbsolutePath() + File.separator);
    }

    public static String m2883h() {
        return m2885j() + File.separator + "QuranMurottal";
    }

    public static String m2884i() {
        return PreferenceManager.getDefaultSharedPreferences(f1449p).getString("mp3Directory", m2883h());
    }

    public static String m2885j() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            String str = Environment.getExternalStorageDirectory().getPath() + File.separator + "data" + File.separator + BuildConfig.APPLICATION_ID;
            new File(str).mkdirs();
            return str;
        }
        try {
            str = f1449p.getPackageManager().getPackageInfo(BuildConfig.APPLICATION_ID, 0).applicationInfo.dataDir;
            new File(str).mkdirs();
            return str;
        } catch (NameNotFoundException e) {
            return BuildConfig.VERSION_NAME;
        }
    }

    public static String m2886k() {
        File[] externalFilesDirs = C0173a.getExternalFilesDirs(f1449p, null);
        if (externalFilesDirs.length > 1 && externalFilesDirs[1] != null) {
            String absolutePath = externalFilesDirs[1].getAbsolutePath();
            if (new File(absolutePath).canWrite()) {
                return absolutePath;
            }
        }
        return BuildConfig.VERSION_NAME;
    }

    public static String m2887l() {
        String i = m2884i();
        File file = new File(i);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(i + File.separator + "mp3");
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(i + File.separator + "mp3_2");
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(i + File.separator + "mp3_3");
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(i + File.separator + "mp3_mahmud");
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(i + File.separator + "mp3_maher");
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(i + File.separator + "mp3_ghamdi");
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(i + File.separator + "mp3_jebril");
        if (!file.exists()) {
            file.mkdirs();
        }
        int a = m2858a(PreferenceManager.getDefaultSharedPreferences(f1449p), "qoriSelected", 2);
        return a == 1 ? i + File.separator + "mp3" + File.separator : a == 2 ? i + File.separator + "mp3_2" + File.separator : a == 3 ? i + File.separator + "mp3_3" + File.separator : a == 4 ? i + File.separator + "mp3_mahmud" + File.separator : a == 5 ? i + File.separator + "mp3_maher" + File.separator : a == 6 ? i + File.separator + "mp3_ghamdi" + File.separator : a == 7 ? i + File.separator + "mp3_jebril" + File.separator : i + File.separator + "mp3_2" + File.separator;
    }

    public static String m2888m() {
        int i = 0;
        int a = m2858a(PreferenceManager.getDefaultSharedPreferences(f1449p), "qoriSelected", 2);
        String string = f1449p.getSharedPreferences(C0882e.f1683b, 0).getString(C0882e.f1691j, C0882e.f1694m);
        if (string.equals("http://www.everyayah.com/data")) {
            i = 1;
        }
        return a == 1 ? i != 0 ? string + "/Hani_Rifai_64kbps/zips/" : string + "/refai-64/" : a == 2 ? i != 0 ? string + "/Alafasy_64kbps/zips/" : string + "/afasy-64/" : a == 3 ? i != 0 ? string + "/Fares_Abbad_64kbps/zips/" : string + "/fares-64/" : a == 4 ? i != 0 ? string + "/Husary_64kbps/zips/" : string + "/husary-64/" : a == 5 ? i != 0 ? string + "/Maher_AlMuaiqly_64kbps/zips/" : string + "/muaiqly-64/" : a == 6 ? i != 0 ? string + "/Ghamadi_40kbps/zips/" : string + "/ghamdi-40/" : a == 7 ? i != 0 ? string + "/Muhammad_Jibreel_64kbps/zips/" : string + "/jebril-64/" : i != 0 ? string + "/Alafasy_64kbps/zips/" : string + "/afasy-64/";
    }

    public static String m2889n() {
        int i = 0;
        int a = m2858a(PreferenceManager.getDefaultSharedPreferences(f1449p), "qoriSelected", 2);
        String string = f1449p.getSharedPreferences(C0882e.f1683b, 0).getString(C0882e.f1692k, C0882e.f1695n);
        if (string.equals("http://www.everyayah.com/data")) {
            i = 1;
        }
        return a == 1 ? i != 0 ? string + "/Hani_Rifai_64kbps/zips/" : string + "/refai-64/" : a == 2 ? i != 0 ? string + "/Alafasy_64kbps/zips/" : string + "/afasy-64/" : a == 3 ? i != 0 ? string + "/Fares_Abbad_64kbps/zips/" : string + "/fares-64/" : a == 4 ? i != 0 ? string + "/Husary_64kbps/zips/" : string + "/husary-64/" : a == 5 ? i != 0 ? string + "/Maher_AlMuaiqly_64kbps/zips/" : string + "/muaiqly-64/" : a == 6 ? i != 0 ? string + "/Ghamadi_40kbps/zips/" : string + "/ghamdi-40/" : a == 7 ? i != 0 ? string + "/Muhammad_Jibreel_64kbps/zips/" : string + "/jebril-64/" : i != 0 ? string + "/Alafasy_64kbps/zips/" : string + "/afasy-64/";
    }

    public static String m2890o() {
        int i = 0;
        int a = m2858a(PreferenceManager.getDefaultSharedPreferences(f1449p), "qoriSelected", 2);
        String string = f1449p.getSharedPreferences(C0882e.f1683b, 0).getString(C0882e.f1693l, C0882e.f1696o);
        if (string.equals("http://www.everyayah.com/data")) {
            i = 1;
        }
        return a == 1 ? i != 0 ? string + "/Hani_Rifai_64kbps/zips/" : string + "/refai-64/" : a == 2 ? i != 0 ? string + "/Alafasy_64kbps/zips/" : string + "/afasy-64/" : a == 3 ? i != 0 ? string + "/Fares_Abbad_64kbps/zips/" : string + "/fares-64/" : a == 4 ? i != 0 ? string + "/Husary_64kbps/zips/" : string + "/husary-64/" : a == 5 ? i != 0 ? string + "/Maher_AlMuaiqly_64kbps/zips/" : string + "/muaiqly-64/" : a == 6 ? i != 0 ? string + "/Ghamadi_40kbps/zips/" : string + "/ghamdi-40/" : a == 7 ? i != 0 ? string + "/Muhammad_Jibreel_64kbps/zips/" : string + "/jebril-64/" : i != 0 ? string + "/Alafasy_64kbps/zips/" : string + "/afasy-64/";
    }

    public static boolean m2891p() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static String m2892q() {
        return BuildConfig.APPLICATION_ID.equals(BuildConfig.APPLICATION_ID) ? "ca-app-pub-6455769858294363/4573830107" : BuildConfig.APPLICATION_ID.equals("com.andi.alquran.melayu") ? "ca-app-pub-6455769858294363/7550218907" : BuildConfig.APPLICATION_ID.equals("com.andi.alquran.en") ? "ca-app-pub-6455769858294363/5933884904" : BuildConfig.APPLICATION_ID.equals("com.andi.alquran.francais") ? "ca-app-pub-6455769858294363/5500978903" : BuildConfig.APPLICATION_ID.equals("com.andi.alquran.urdu") ? "ca-app-pub-6455769858294363/1503685309" : "ca-app-pub-6455769858294363/4573830107";
    }

    public static String m2893r() {
        return BuildConfig.APPLICATION_ID.equals(BuildConfig.APPLICATION_ID) ? "ca-app-pub-6455769858294363/5082933706" : BuildConfig.APPLICATION_ID.equals("com.andi.alquran.melayu") ? "ca-app-pub-6455769858294363/9026952101" : BuildConfig.APPLICATION_ID.equals("com.andi.alquran.en") ? "ca-app-pub-6455769858294363/7410618102" : BuildConfig.APPLICATION_ID.equals("com.andi.alquran.francais") ? "ca-app-pub-6455769858294363/6977712101" : BuildConfig.APPLICATION_ID.equals("com.andi.alquran.urdu") ? "ca-app-pub-6455769858294363/2980418501" : "ca-app-pub-6455769858294363/5082933706";
    }

    public static String m2894s() {
        return BuildConfig.APPLICATION_ID.equals(BuildConfig.APPLICATION_ID) ? "ca-app-pub-6455769858294363/5871253302" : BuildConfig.APPLICATION_ID.equals("com.andi.alquran.melayu") ? "ca-app-pub-6455769858294363/8404040503" : BuildConfig.APPLICATION_ID.equals("com.andi.alquran.en") ? "ca-app-pub-6455769858294363/7442058103" : BuildConfig.APPLICATION_ID.equals("com.andi.alquran.francais") ? "ca-app-pub-6455769858294363/8454445304" : BuildConfig.APPLICATION_ID.equals("com.andi.alquran.urdu") ? "ca-app-pub-6455769858294363/6305185308" : "ca-app-pub-6455769858294363/5871253302";
    }

    public static String m2895t() {
        return BuildConfig.APPLICATION_ID.equals(BuildConfig.APPLICATION_ID) ? "ca-app-pub-6455769858294363/9347674908" : BuildConfig.APPLICATION_ID.equals("com.andi.alquran.melayu") ? "ca-app-pub-6455769858294363/2357506907" : BuildConfig.APPLICATION_ID.equals("com.andi.alquran.en") ? "ca-app-pub-6455769858294363/6097353703" : BuildConfig.APPLICATION_ID.equals("com.andi.alquran.francais") ? "ca-app-pub-6455769858294363/9931178501" : BuildConfig.APPLICATION_ID.equals("com.andi.alquran.urdu") ? "ca-app-pub-6455769858294363/7781918508" : "ca-app-pub-6455769858294363/9347674908";
    }

    public static String m2896u() {
        return BuildConfig.APPLICATION_ID.equals(BuildConfig.APPLICATION_ID) ? "quran-id.zip" : BuildConfig.APPLICATION_ID.equals("com.andi.alquran.melayu") ? "quran-melayu.zip" : BuildConfig.APPLICATION_ID.equals("com.andi.alquran.en") ? "quran-en.zip" : BuildConfig.APPLICATION_ID.equals("com.andi.alquran.francais") ? "quran-fr.zip" : BuildConfig.APPLICATION_ID.equals("com.andi.alquran.urdu") ? "quran-ur.zip" : "quran-id.zip";
    }

    public static boolean m2897v() {
        return PreferenceManager.getDefaultSharedPreferences(f1449p).getBoolean("translationText", false);
    }

    public static String m2898w() {
        return BuildConfig.APPLICATION_ID.equals(BuildConfig.APPLICATION_ID) ? "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmPp5cU2CiFfOyQoR08qpq4O4KaIGMYixXbhBfBpQ+74TB+4mjDm46rNPEiWYOx3SrSDq3wyZHaFkSMIGzGkR8CqlBM7UV1tLXf1cwXg2AbjsLJWaOieXILjN0dUjO7eRYjQ5FQ4sf69tJWNWXzMqYDW7M7SWep3b7GJ6ghZoJnVx6svG6iOg3TdvCq6hST5jbWr5KT4bvBdFrd7AgzGD4vu/6pPYpjcGf8770TmtlMpVG9OjPQ9Fhz11PC536PPasGdpBHiM2zVxqBaQ5GExOu7TI+hASHPRQvLdS2ZHzO7MODinHx9bCrg+4x8tZSXWWJgTjJCYRHkkylNpwdBguwIDAQAB" : BuildConfig.APPLICATION_ID.equals("com.andi.alquran.melayu") ? "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAo0nT79Tzexo8rhg+yjGkWro/zUO7bC/pISS+AeNx2YA+QrcbndPOmtoqfR6jCvRDJY/eueIMUfHtBZUuoE1CuLRx5DiRpJVmgcg7rtqwdzI4yKR8N05wMJ9O/eBV0p17sd/3YTW7ovFrceifN/TcjgNKL1b3no55kE7xE+66nFjJUD3u3aiAlxhSfqG0/auC9t5yMnPDg1IQJKytim0a1xs+isnfUPBTUTymnPUENZIqmQbHV95rjzFpAC1w3DimU1wQbQ7VjyBhTAAef2pvl34Vq2JKyyLg8hmr4+181QqH5oBbLgNPIcWhK/KwD5YSlFcSS2AvoEdBjCNtwfyAlQIDAQAB" : BuildConfig.APPLICATION_ID.equals("com.andi.alquran.en") ? "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjbeu+/3Y++wINK8Kobo6HXRfQTq6O9kv/+3G0BppU1R4yz+d4e+/fUmkk4Lusno9fP78Xl4a8LRRJse46kVxw2VqXZLxQgqAcnwszYgLkx+9Wv6nEb84G/evHlLE5GE7oh07pphcy5e+6PnHLvpSZt3Z9St3sRVm83J5+ygft74zf6OQ9hL4lNj2POSchiLjIEhwbsetJS9vPDlU45GzwiaI0RarOFDDiTL+rHs/0EdCadpT3q9AK5876B7ww5bHI97L4A4+jvaTGWmfz1kcjTQ29lS+pCJMqna0fHYPdlxCXGLQkPQf3NxdN3/9lPILuAKyALvtqzfRIMN05vjcwQIDAQAB" : BuildConfig.APPLICATION_ID.equals("com.andi.alquran.francais") ? "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkIHfoOD+v363crdR4FWJzSa8J9rShr2eoJLPPy1Es22BRV1nmwVsY3Ho3Li2YSYDrU3ZG58kLPABs1aQmiYAvXr360SUt9TJLE35JHHnMMRnwrvTig3fRWamfZbWJcu9NSAr7xwOB/FBoHdWYUewI+p4L8op50UEDQZWT0oinh/T8UnohYachxUa/Zoc8u8Jl3fPhYIDapv9OrSqNdxLUKLnsNfG+CjT1/+ID5s/jDU+rZqyvfNM43xgxl4tJiyDiYHc4D76Q22KLbT0gBL1K4nlQdxI/z5qGDxqbQ46fPadv9Ujtee7Y9AnWFnsNlaFEVqF2WeygRI4bXI71VbjDwIDAQAB" : BuildConfig.APPLICATION_ID.equals("com.andi.alquran.urdu") ? "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAr/e6T5N6M6ris/vTGrmz1tnbSdZPdioGEbNysALNnQQyAHk1ERDoMV/lKpjlHNRjbsvm+lbsIjkhSpjhOz6tugZw3HeDUP90+21cJMNd5CzIlwuSkB9KQK7oXna5zOMoJRXKqDmCfd1CfkpLNj3SSYr7u3fa1Sm9QboJCfI/EpuPgOkQ7HOCDHdaKaUyxtPjPgBl/mUj9gT2fA0QfQw2yfvaANEWeTdY59TDmt2AE7HMawXI3u7wV/NFXTFaqfyYwtjPgOsKMjLPNrXfo9NnW0pU7+vPb/F5n9h8lQ+zh9cDkhoFSOeOUf1HG6FgQ5NakL+cEWRGqfADQuOGSXK3bQIDAQAB" : BuildConfig.VERSION_NAME;
    }

    public static long m2899x() {
        long j = 0;
        try {
            return f1449p.getPackageManager().getPackageInfo(BuildConfig.APPLICATION_ID, 0).firstInstallTime;
        } catch (NameNotFoundException e) {
            e.getMessage();
            return j;
        }
    }

    public static void m2900y() {
        SharedPreferences sharedPreferences = f1449p.getSharedPreferences("prayer_time_by_andi", 0);
        String string = sharedPreferences.getString("countryCode", BuildConfig.VERSION_NAME);
        if (!string.equals(BuildConfig.VERSION_NAME)) {
            Editor edit = sharedPreferences.edit();
            if (string.equals("BN") || string.equals("ID") || string.equals("KH") || string.equals("LA") || string.equals("MM") || string.equals("MY") || string.equals("PH") || string.equals("SG") || string.equals("TH") || string.equals("TL") || string.equals("VN")) {
                edit.putString("typeCalc", "0");
            } else if (string.equals("AF") || string.equals("AL") || string.equals("AZ") || string.equals("BD") || string.equals("KG") || string.equals("KZ") || string.equals("PK") || string.equals("TJ") || string.equals("TM") || string.equals("AZ")) {
                edit.putString("typeCalc", "1");
                edit.putString("typeJuristic", "1");
            } else if (string.equals("IN")) {
                edit.putString("typeCalc", "1");
            } else if (string.equals("AG") || string.equals("AI") || string.equals("AR") || string.equals("AW") || string.equals("BB") || string.equals("BL") || string.equals("BM") || string.equals("BO") || string.equals("BQ") || string.equals("BR") || string.equals("BS") || string.equals("BZ") || string.equals("CA") || string.equals("CL") || string.equals("CO") || string.equals("CR") || string.equals("CU") || string.equals("CW") || string.equals("DM") || string.equals("DO") || string.equals("EC") || string.equals("GD") || string.equals("GF") || string.equals("GL") || string.equals("GP") || string.equals("GS") || string.equals("GT") || string.equals("GY") || string.equals("HM") || string.equals("HN") || string.equals("HT") || string.equals("JM") || string.equals("KN") || string.equals("KY") || string.equals("LC") || string.equals("MF") || string.equals("MQ") || string.equals("MS") || string.equals("MX") || string.equals("NI") || string.equals("PA") || string.equals("PE") || string.equals("PM") || string.equals("PY") || string.equals("SR") || string.equals("SV") || string.equals("SX") || string.equals("TC") || string.equals("TT") || string.equals("US") || string.equals("UY") || string.equals("VC") || string.equals("VE") || string.equals("VG") || string.equals("VI")) {
                edit.putString("typeCalc", "2");
            } else if (string.equals("AD") || string.equals("AM") || string.equals("AQ") || string.equals("AS") || string.equals("AT") || string.equals("AU") || string.equals("AX") || string.equals("BA") || string.equals("BE") || string.equals("BG") || string.equals("BH") || string.equals("BT") || string.equals("BV") || string.equals("BY") || string.equals("CC") || string.equals("CH") || string.equals("CK") || string.equals("CN") || string.equals("CV") || string.equals("CX") || string.equals("CY") || string.equals("CZ") || string.equals("DE") || string.equals("DK") || string.equals("EE") || string.equals("ES") || string.equals("FI") || string.equals("FJ") || string.equals("FK") || string.equals("FM") || string.equals("FO") || string.equals("GE") || string.equals("GG") || string.equals("GI") || string.equals("GR") || string.equals("GU") || string.equals("HK") || string.equals("HR") || string.equals("HU") || string.equals("IE") || string.equals("IL") || string.equals("IM") || string.equals("IR") || string.equals("IS") || string.equals("IT") || string.equals("JE") || string.equals("JP") || string.equals("KI") || string.equals("KP") || string.equals("KR") || string.equals("LI") || string.equals("LK") || string.equals("LT") || string.equals("LU") || string.equals("LV") || string.equals("MC") || string.equals("MD") || string.equals("ME") || string.equals("MH") || string.equals("MK") || string.equals("MN") || string.equals("MO") || string.equals("MP") || string.equals("MT") || string.equals("NL") || string.equals("NP") || string.equals("NZ") || string.equals("PK") || string.equals("PS") || string.equals("PT") || string.equals("RO") || string.equals("RS") || string.equals("RU") || string.equals("SE") || string.equals("TW") || string.equals("UA") || string.equals("UM") || string.equals("UZ")) {
                edit.putString("typeCalc", "3");
            } else if (string.equals("FR")) {
                edit.putString("typeCalc", "9");
            } else if (string.equals("GB")) {
                edit.putString("typeCalc", "8");
            } else if (string.equals("SA") || string.equals("YE")) {
                edit.putString("typeCalc", "4");
            } else if (string.equals("AE")) {
                edit.putString("typeCalc", "10");
            } else if (string.equals("AO") || string.equals("CF") || string.equals("CM") || string.equals("EH") || string.equals("EG") || string.equals("ER") || string.equals("ET") || string.equals("GH") || string.equals("IO") || string.equals("IQ") || string.equals("KE") || string.equals("LB") || string.equals("LR") || string.equals("MG") || string.equals("MW") || string.equals("NE") || string.equals("NG") || string.equals("SD") || string.equals("SN") || string.equals("SO") || string.equals("SS") || string.equals("SY") || string.equals("UG") || string.equals("YT") || string.equals("ZA") || string.equals("ZM") || string.equals("ZW")) {
                edit.putString("typeCalc", "5");
            }
            edit.apply();
        }
    }

    private void m2901z() {
        try {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(this);
            Field declaredField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                declaredField.setBoolean(viewConfiguration, false);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public String m2902a(int i, int i2, int i3) {
        return "QS. " + m2863a(i) + ": " + i2 + " (Juz: " + i3 + ")";
    }

    public String m2903a(C0883a c0883a) {
        return "QS. " + m2863a(c0883a.f1702a) + ": " + getString(C0861R.string.ayat_name) + " " + c0883a.f1703b;
    }

    public boolean m2904d() {
        return (BuildConfig.APPLICATION_ID.equals(BuildConfig.APPLICATION_ID) || BuildConfig.APPLICATION_ID.equals("com.andi.alquran.melayu")) ? m2854I() && this.f1454f.m3079a((Context) this, m2846A()) && this.f1455g.m3079a((Context) this, m2847B()) && this.f1456h.m3079a((Context) this, m2848C()) && this.f1460l.m3081a((Context) this, m2852G()) && this.f1457i.m3079a((Context) this, m2849D()) && this.f1458j.m3079a((Context) this, m2850E()) && m2853H() : BuildConfig.APPLICATION_ID.equals("com.andi.alquran.en") ? m2854I() && this.f1454f.m3079a((Context) this, m2846A()) && this.f1455g.m3079a((Context) this, m2847B()) && this.f1456h.m3079a((Context) this, m2848C()) && this.f1460l.m3081a((Context) this, m2852G()) && this.f1457i.m3079a((Context) this, m2849D()) && this.f1458j.m3079a((Context) this, m2850E()) && this.f1459k.m3079a((Context) this, m2851F()) && m2853H() : BuildConfig.APPLICATION_ID.equals("com.andi.alquran.francais") ? m2854I() && this.f1454f.m3079a((Context) this, m2846A()) && this.f1455g.m3079a((Context) this, m2847B()) && this.f1456h.m3079a((Context) this, m2848C()) && this.f1460l.m3081a((Context) this, m2852G()) && this.f1458j.m3079a((Context) this, m2850E()) && this.f1459k.m3079a((Context) this, m2851F()) && m2853H() : m2854I() && this.f1454f.m3079a((Context) this, m2846A()) && this.f1455g.m3079a((Context) this, m2847B()) && this.f1456h.m3079a((Context) this, m2848C()) && this.f1457i.m3079a((Context) this, m2849D()) && this.f1458j.m3079a((Context) this, m2850E()) && this.f1459k.m3079a((Context) this, m2851F()) && m2853H();
    }

    public void onCreate() {
        super.onCreate();
        f1447a = BuildConfig.APPLICATION_ID;
        f1448m = this;
        f1449p = getApplicationContext();
        this.f1450b.m3067a(this);
        this.f1451c.m3063a(this);
        this.f1452d.m3059b((Context) this);
        m2901z();
        m2854I();
        C1223g a = C1215c.m4211a((Context) this).m4215a(m2855J());
        a.m4312a(true);
        a.m4315c(true);
        a.m4313b(true);
    }
}
