package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@op
public final class zzmm extends zza {
    public static final Creator<zzmm> CREATOR;
    public final int f6608a;
    public final boolean f6609b;
    public final List<String> f6610c;

    static {
        CREATOR = new oy();
    }

    public zzmm() {
        this(1, false, Collections.emptyList());
    }

    public zzmm(int i, boolean z, List<String> list) {
        this.f6608a = i;
        this.f6609b = z;
        this.f6610c = list;
    }

    public zzmm(boolean z) {
        this(1, z, Collections.emptyList());
    }

    public zzmm(boolean z, List<String> list) {
        this(1, z, list);
    }

    public static zzmm m9774a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new zzmm();
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("reporting_urls");
        List arrayList = new ArrayList();
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    arrayList.add(optJSONArray.getString(i));
                } catch (Throwable e) {
                    sg.m8447c("Error grabbing url from json.", e);
                }
            }
        }
        return new zzmm(jSONObject.optBoolean("enable_protection"), arrayList);
    }

    public void writeToParcel(Parcel parcel, int i) {
        oy.m7990a(this, parcel, i);
    }
}
