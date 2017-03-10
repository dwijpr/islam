package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.recyclerview.BuildConfig;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

@op
public class zzdo extends zza {
    public static final Creator<zzdo> CREATOR;
    public final int f6425a;
    public final String f6426b;
    public final long f6427c;
    public final String f6428d;
    public final String f6429e;
    public final String f6430f;
    public final Bundle f6431g;
    public final boolean f6432h;

    static {
        CREATOR = new ga();
    }

    zzdo(int i, String str, long j, String str2, String str3, String str4, Bundle bundle, boolean z) {
        this.f6425a = i;
        this.f6426b = str;
        this.f6427c = j;
        if (str2 == null) {
            str2 = BuildConfig.VERSION_NAME;
        }
        this.f6428d = str2;
        if (str3 == null) {
            str3 = BuildConfig.VERSION_NAME;
        }
        this.f6429e = str3;
        if (str4 == null) {
            str4 = BuildConfig.VERSION_NAME;
        }
        this.f6430f = str4;
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.f6431g = bundle;
        this.f6432h = z;
    }

    public static zzdo m9764a(Uri uri) {
        Throwable e;
        try {
            if (!"gcache".equals(uri.getScheme())) {
                return null;
            }
            List pathSegments = uri.getPathSegments();
            if (pathSegments.size() != 2) {
                sg.m8449e("Expected 2 path parts for namespace and id, found :" + pathSegments.size());
                return null;
            }
            String str = (String) pathSegments.get(0);
            String str2 = (String) pathSegments.get(1);
            String host = uri.getHost();
            String queryParameter = uri.getQueryParameter("url");
            boolean equals = "1".equals(uri.getQueryParameter("read_only"));
            String queryParameter2 = uri.getQueryParameter("expiration");
            long parseLong = queryParameter2 == null ? 0 : Long.parseLong(queryParameter2);
            Bundle bundle = new Bundle();
            for (String queryParameter22 : zzv.zzcL().m8565a(uri)) {
                if (queryParameter22.startsWith("tag.")) {
                    bundle.putString(queryParameter22.substring("tag.".length()), uri.getQueryParameter(queryParameter22));
                }
            }
            return new zzdo(1, queryParameter, parseLong, host, str, str2, bundle, equals);
        } catch (NullPointerException e2) {
            e = e2;
            sg.m8447c("Unable to parse Uri into cache offering.", e);
            return null;
        } catch (NumberFormatException e3) {
            e = e3;
            sg.m8447c("Unable to parse Uri into cache offering.", e);
            return null;
        }
    }

    public static zzdo m9765a(String str) {
        return m9764a(Uri.parse(str));
    }

    public void writeToParcel(Parcel parcel, int i) {
        ga.m6302a(this, parcel, i);
    }
}
