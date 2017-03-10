package com.andi.alquran.p031i;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import com.andi.alquran.App;
import com.andi.alquran.p022f.C0774a;
import com.andi.alquran.p028g.C0915a;
import com.andi.alquran.p028g.C0916b;
import com.andi.alquran.p032j.C0950i;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

/* renamed from: com.andi.alquran.i.a */
public class C0919a extends AsyncTask<C0916b, Void, ArrayList<C0915a>> {
    private C0774a f1843a;
    private SharedPreferences f1844b;

    public C0919a(SharedPreferences sharedPreferences, C0774a c0774a) {
        this.f1843a = c0774a;
        this.f1844b = sharedPreferences;
    }

    protected ArrayList<C0915a> m3208a(C0916b... c0916bArr) {
        C0950i c0950i = new C0950i(App.m2868b(this.f1844b, "typeCalc", 0), App.m2868b(this.f1844b, "typeJuristic", 0), App.m2868b(this.f1844b, "typeTimeFormat", 0), App.m2868b(this.f1844b, "typeAdjustHighLat", 3));
        Calendar instance = Calendar.getInstance(Locale.getDefault());
        C0916b c0916b = c0916bArr[0];
        return c0950i.m3305a(this.f1844b, instance, c0916b.f1835b, c0916b.f1834a, c0916b.f1836c);
    }

    protected void m3209a(ArrayList<C0915a> arrayList) {
        this.f1843a.m2639a(arrayList);
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m3208a((C0916b[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m3209a((ArrayList) obj);
    }
}
