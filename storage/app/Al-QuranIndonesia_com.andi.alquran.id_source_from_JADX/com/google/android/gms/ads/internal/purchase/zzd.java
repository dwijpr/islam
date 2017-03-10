package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.v7.recyclerview.BuildConfig;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.nk.C1149a;
import com.google.android.gms.internal.op;
import com.google.android.gms.internal.sg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@op
public class zzd extends C1149a {
    private String f2519a;
    private Context f2520b;
    private String f2521c;
    private ArrayList<String> f2522d;

    public zzd(String str, ArrayList<String> arrayList, Context context, String str2) {
        this.f2521c = str;
        this.f2522d = arrayList;
        this.f2519a = str2;
        this.f2520b = context;
    }

    protected int m4021a(int i) {
        return i == 0 ? 1 : i == 1 ? 2 : i == 4 ? 3 : 0;
    }

    Map<String, String> m4022a() {
        String packageName = this.f2520b.getPackageName();
        Object obj = BuildConfig.VERSION_NAME;
        try {
            obj = this.f2520b.getPackageManager().getPackageInfo(packageName, 0).versionName;
        } catch (Throwable e) {
            sg.m8447c("Error to retrieve app version", e);
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - zzv.zzcN().m8410e().m8430a();
        Map<String, String> hashMap = new HashMap();
        hashMap.put("sessionid", zzv.zzcN().m8388a());
        hashMap.put("appid", packageName);
        hashMap.put("osversion", String.valueOf(VERSION.SDK_INT));
        hashMap.put("sdkversion", this.f2519a);
        hashMap.put("appversion", obj);
        hashMap.put("timestamp", String.valueOf(elapsedRealtime));
        return hashMap;
    }

    void m4023b() {
        try {
            this.f2520b.getClassLoader().loadClass("com.google.ads.conversiontracking.IAPConversionReporter").getDeclaredMethod("reportWithProductId", new Class[]{Context.class, String.class, String.class, Boolean.TYPE}).invoke(null, new Object[]{this.f2520b, this.f2521c, BuildConfig.VERSION_NAME, Boolean.valueOf(true)});
        } catch (ClassNotFoundException e) {
            sg.m8449e("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        } catch (NoSuchMethodException e2) {
            sg.m8449e("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        } catch (Throwable e3) {
            sg.m8447c("Fail to report a conversion.", e3);
        }
    }

    public String getProductId() {
        return this.f2521c;
    }

    public void recordPlayBillingResolution(int i) {
        if (i == 0) {
            m4023b();
        }
        Map a = m4022a();
        a.put("google_play_status", String.valueOf(i));
        a.put("sku", this.f2521c);
        a.put(NotificationCompatApi24.CATEGORY_STATUS, String.valueOf(m4021a(i)));
        List linkedList = new LinkedList();
        Iterator it = this.f2522d.iterator();
        while (it.hasNext()) {
            linkedList.add(zzv.zzcJ().m8502a((String) it.next(), a));
        }
        zzv.zzcJ().m8514a(this.f2520b, this.f2519a, linkedList);
    }

    public void recordResolution(int i) {
        if (i == 1) {
            m4023b();
        }
        Map a = m4022a();
        a.put(NotificationCompatApi24.CATEGORY_STATUS, String.valueOf(i));
        a.put("sku", this.f2521c);
        List linkedList = new LinkedList();
        Iterator it = this.f2522d.iterator();
        while (it.hasNext()) {
            linkedList.add(zzv.zzcJ().m8502a((String) it.next(), a));
        }
        zzv.zzcJ().m8514a(this.f2520b, this.f2519a, linkedList);
    }
}
