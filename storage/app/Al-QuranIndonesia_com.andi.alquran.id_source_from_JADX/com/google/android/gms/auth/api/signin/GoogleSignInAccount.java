package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.util.C1377c;
import com.google.android.gms.common.util.C1379e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class GoogleSignInAccount extends zza implements ReflectedParcelable {
    public static final Creator<GoogleSignInAccount> CREATOR;
    public static C1377c f2898a;
    private static Comparator<Scope> f2899n;
    final int f2900b;
    List<Scope> f2901c;
    private String f2902d;
    private String f2903e;
    private String f2904f;
    private String f2905g;
    private Uri f2906h;
    private String f2907i;
    private long f2908j;
    private String f2909k;
    private String f2910l;
    private String f2911m;

    /* renamed from: com.google.android.gms.auth.api.signin.GoogleSignInAccount.1 */
    class C12371 implements Comparator<Scope> {
        C12371() {
        }

        public int m4375a(Scope scope, Scope scope2) {
            return scope.m4500a().compareTo(scope2.m4500a());
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m4375a((Scope) obj, (Scope) obj2);
        }
    }

    static {
        CREATOR = new C1246a();
        f2898a = C1379e.m4937d();
        f2899n = new C12371();
    }

    GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, List<Scope> list, String str7, String str8) {
        this.f2900b = i;
        this.f2902d = str;
        this.f2903e = str2;
        this.f2904f = str3;
        this.f2905g = str4;
        this.f2906h = uri;
        this.f2907i = str5;
        this.f2908j = j;
        this.f2909k = str6;
        this.f2901c = list;
        this.f2910l = str7;
        this.f2911m = str8;
    }

    public static GoogleSignInAccount m4376a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        Object optString = jSONObject.optString("photoUrl", null);
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        Set hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        return m4377a(jSONObject.optString("id"), jSONObject.optString("tokenId", null), jSONObject.optString(NotificationCompatApi24.CATEGORY_EMAIL, null), jSONObject.optString("displayName", null), jSONObject.optString("givenName", null), jSONObject.optString("familyName", null), parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet).m4380b(jSONObject.optString("serverAuthCode", null));
    }

    public static GoogleSignInAccount m4377a(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l, String str7, Set<Scope> set) {
        if (l == null) {
            l = Long.valueOf(f2898a.m4926a() / 1000);
        }
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, l.longValue(), C1314c.m4625a(str7), new ArrayList((Collection) C1314c.m4623a((Object) set)), str5, str6);
    }

    private JSONObject m4378l() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (m4379a() != null) {
                jSONObject.put("id", m4379a());
            }
            if (m4381b() != null) {
                jSONObject.put("tokenId", m4381b());
            }
            if (m4382c() != null) {
                jSONObject.put(NotificationCompatApi24.CATEGORY_EMAIL, m4382c());
            }
            if (m4383d() != null) {
                jSONObject.put("displayName", m4383d());
            }
            if (m4384e() != null) {
                jSONObject.put("givenName", m4384e());
            }
            if (m4385f() != null) {
                jSONObject.put("familyName", m4385f());
            }
            if (m4386g() != null) {
                jSONObject.put("photoUrl", m4386g().toString());
            }
            if (m4387h() != null) {
                jSONObject.put("serverAuthCode", m4387h());
            }
            jSONObject.put("expirationTime", this.f2908j);
            jSONObject.put("obfuscatedIdentifier", m4389j());
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.f2901c, f2899n);
            for (Scope a : this.f2901c) {
                jSONArray.put(a.m4500a());
            }
            jSONObject.put("grantedScopes", jSONArray);
            return jSONObject;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public String m4379a() {
        return this.f2902d;
    }

    public GoogleSignInAccount m4380b(String str) {
        this.f2907i = str;
        return this;
    }

    public String m4381b() {
        return this.f2903e;
    }

    public String m4382c() {
        return this.f2904f;
    }

    public String m4383d() {
        return this.f2905g;
    }

    public String m4384e() {
        return this.f2910l;
    }

    public boolean equals(Object obj) {
        return !(obj instanceof GoogleSignInAccount) ? false : ((GoogleSignInAccount) obj).m4390k().equals(m4390k());
    }

    public String m4385f() {
        return this.f2911m;
    }

    public Uri m4386g() {
        return this.f2906h;
    }

    public String m4387h() {
        return this.f2907i;
    }

    public int hashCode() {
        return m4390k().hashCode();
    }

    public long m4388i() {
        return this.f2908j;
    }

    public String m4389j() {
        return this.f2909k;
    }

    public String m4390k() {
        return m4378l().toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1246a.m4413a(this, parcel, i);
    }
}
