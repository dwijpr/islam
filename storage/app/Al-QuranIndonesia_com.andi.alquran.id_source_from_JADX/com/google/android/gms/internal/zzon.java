package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.recyclerview.BuildConfig;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

@op
public class zzon extends zza {
    public static final Creator<zzon> CREATOR;
    public final int f6629a;
    public final String f6630b;
    public final String f6631c;
    public final boolean f6632d;
    public final boolean f6633e;
    public final List<String> f6634f;

    static {
        CREATOR = new qv();
    }

    public zzon(int i, String str, String str2, boolean z, boolean z2, List<String> list) {
        this.f6629a = i;
        this.f6630b = str;
        this.f6631c = str2;
        this.f6632d = z;
        this.f6633e = z2;
        this.f6634f = list;
    }

    public static zzon m9782a(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("click_string", BuildConfig.VERSION_NAME);
        String optString2 = jSONObject.optString("report_url", BuildConfig.VERSION_NAME);
        boolean optBoolean = jSONObject.optBoolean("rendered_ad_enabled", false);
        boolean optBoolean2 = jSONObject.optBoolean("non_malicious_reporting_enabled", false);
        JSONArray optJSONArray = jSONObject.optJSONArray("allowed_headers");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        List arrayList = new ArrayList();
        while (i < optJSONArray.length()) {
            Object optString3 = optJSONArray.optString(i);
            if (!TextUtils.isEmpty(optString3)) {
                arrayList.add(optString3.toLowerCase(Locale.ENGLISH));
            }
            i++;
        }
        return new zzon(2, optString, optString2, optBoolean, optBoolean2, arrayList);
    }

    public void writeToParcel(Parcel parcel, int i) {
        qv.m8356a(this, parcel, i);
    }
}
