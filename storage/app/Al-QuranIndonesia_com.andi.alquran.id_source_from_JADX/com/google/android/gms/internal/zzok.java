package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.common.internal.C1313b;
import com.google.android.gms.common.internal.safeparcel.zza;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@op
public final class zzok extends zza {
    public static final Creator<zzok> CREATOR;
    public final int f6626a;
    public final String f6627b;
    public final int f6628c;

    static {
        CREATOR = new qt();
    }

    public zzok(int i, String str, int i2) {
        this.f6626a = i;
        this.f6627b = str;
        this.f6628c = i2;
    }

    public zzok(RewardItem rewardItem) {
        this(1, rewardItem.getType(), rewardItem.getAmount());
    }

    public zzok(String str, int i) {
        this(1, str, i);
    }

    public static zzok m9779a(String str) {
        zzok com_google_android_gms_internal_zzok = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                com_google_android_gms_internal_zzok = m9780a(new JSONArray(str));
            } catch (JSONException e) {
            }
        }
        return com_google_android_gms_internal_zzok;
    }

    public static zzok m9780a(JSONArray jSONArray) {
        return (jSONArray == null || jSONArray.length() == 0) ? null : new zzok(jSONArray.getJSONObject(0).optString("rb_type"), jSONArray.getJSONObject(0).optInt("rb_amount"));
    }

    public JSONArray m9781a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("rb_type", this.f6627b);
        jSONObject.put("rb_amount", this.f6628c);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject);
        return jSONArray;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof zzok)) {
            return false;
        }
        zzok com_google_android_gms_internal_zzok = (zzok) obj;
        return C1313b.m4621a(this.f6627b, com_google_android_gms_internal_zzok.f6627b) && C1313b.m4621a(Integer.valueOf(this.f6628c), Integer.valueOf(com_google_android_gms_internal_zzok.f6628c));
    }

    public int hashCode() {
        return C1313b.m4619a(this.f6627b, Integer.valueOf(this.f6628c));
    }

    public void writeToParcel(Parcel parcel, int i) {
        qt.m8353a(this, parcel, i);
    }
}
