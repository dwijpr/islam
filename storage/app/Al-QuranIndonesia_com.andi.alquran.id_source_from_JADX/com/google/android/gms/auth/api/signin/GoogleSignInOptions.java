package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.p041a.C1244a;
import com.google.android.gms.common.api.C1274a.C1240a.C1243d;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class GoogleSignInOptions extends zza implements C1243d, ReflectedParcelable {
    public static final Creator<GoogleSignInOptions> CREATOR;
    public static final Scope f2919a;
    public static final Scope f2920b;
    public static final Scope f2921c;
    public static final GoogleSignInOptions f2922d;
    private static Comparator<Scope> f2923m;
    final int f2924e;
    private final ArrayList<Scope> f2925f;
    private Account f2926g;
    private boolean f2927h;
    private final boolean f2928i;
    private final boolean f2929j;
    private String f2930k;
    private String f2931l;

    /* renamed from: com.google.android.gms.auth.api.signin.GoogleSignInOptions.1 */
    class C12381 implements Comparator<Scope> {
        C12381() {
        }

        public int m4391a(Scope scope, Scope scope2) {
            return scope.m4500a().compareTo(scope2.m4500a());
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m4391a((Scope) obj, (Scope) obj2);
        }
    }

    /* renamed from: com.google.android.gms.auth.api.signin.GoogleSignInOptions.a */
    public static final class C1239a {
        private Set<Scope> f2912a;
        private boolean f2913b;
        private boolean f2914c;
        private boolean f2915d;
        private String f2916e;
        private Account f2917f;
        private String f2918g;

        public C1239a() {
            this.f2912a = new HashSet();
        }

        public C1239a m4392a() {
            this.f2912a.add(GoogleSignInOptions.f2921c);
            return this;
        }

        public C1239a m4393b() {
            this.f2912a.add(GoogleSignInOptions.f2919a);
            return this;
        }

        public GoogleSignInOptions m4394c() {
            if (this.f2915d && (this.f2917f == null || !this.f2912a.isEmpty())) {
                m4392a();
            }
            return new GoogleSignInOptions(this.f2917f, this.f2915d, this.f2913b, this.f2914c, this.f2916e, this.f2918g, null);
        }
    }

    static {
        f2919a = new Scope("profile");
        f2920b = new Scope(NotificationCompatApi24.CATEGORY_EMAIL);
        f2921c = new Scope("openid");
        f2922d = new C1239a().m4392a().m4393b().m4394c();
        CREATOR = new C1247b();
        f2923m = new C12381();
    }

    GoogleSignInOptions(int i, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2) {
        this.f2924e = i;
        this.f2925f = arrayList;
        this.f2926g = account;
        this.f2927h = z;
        this.f2928i = z2;
        this.f2929j = z3;
        this.f2930k = str;
        this.f2931l = str2;
    }

    private GoogleSignInOptions(Set<Scope> set, Account account, boolean z, boolean z2, boolean z3, String str, String str2) {
        this(2, new ArrayList(set), account, z, z2, z3, str, str2);
    }

    public static GoogleSignInOptions m4395a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        Set hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        Object optString = jSONObject.optString("accountName", null);
        return new GoogleSignInOptions(hashSet, !TextUtils.isEmpty(optString) ? new Account(optString, "com.google") : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.optString("serverClientId", null), jSONObject.optString("hostedDomain", null));
    }

    public ArrayList<Scope> m4396a() {
        return new ArrayList(this.f2925f);
    }

    public Account m4397b() {
        return this.f2926g;
    }

    public boolean m4398c() {
        return this.f2927h;
    }

    public boolean m4399d() {
        return this.f2928i;
    }

    public boolean m4400e() {
        return this.f2929j;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
            if (this.f2925f.size() != googleSignInOptions.m4396a().size() || !this.f2925f.containsAll(googleSignInOptions.m4396a())) {
                return false;
            }
            if (this.f2926g == null) {
                if (googleSignInOptions.m4397b() != null) {
                    return false;
                }
            } else if (!this.f2926g.equals(googleSignInOptions.m4397b())) {
                return false;
            }
            if (TextUtils.isEmpty(this.f2930k)) {
                if (!TextUtils.isEmpty(googleSignInOptions.m4401f())) {
                    return false;
                }
            } else if (!this.f2930k.equals(googleSignInOptions.m4401f())) {
                return false;
            }
            return this.f2929j == googleSignInOptions.m4400e() && this.f2927h == googleSignInOptions.m4398c() && this.f2928i == googleSignInOptions.m4399d();
        } catch (ClassCastException e) {
            return false;
        }
    }

    public String m4401f() {
        return this.f2930k;
    }

    public String m4402g() {
        return this.f2931l;
    }

    public int hashCode() {
        Object arrayList = new ArrayList();
        Iterator it = this.f2925f.iterator();
        while (it.hasNext()) {
            arrayList.add(((Scope) it.next()).m4500a());
        }
        Collections.sort(arrayList);
        return new C1244a().m4404a(arrayList).m4404a(this.f2926g).m4404a(this.f2930k).m4405a(this.f2929j).m4405a(this.f2927h).m4405a(this.f2928i).m4403a();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1247b.m4416a(this, parcel, i);
    }
}
