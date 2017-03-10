package com.andi.alquran.p031i;

import android.content.Context;
import android.os.AsyncTask;
import com.andi.alquran.p022f.C0775c;
import com.andi.alquran.p027d.C0896c;

/* renamed from: com.andi.alquran.i.e */
public class C0928e extends AsyncTask<Void, Void, String> {
    private Context f1860a;
    private double f1861b;
    private double f1862c;
    private C0775c f1863d;

    public C0928e(Context context, double d, double d2, C0775c c0775c) {
        this.f1861b = d2;
        this.f1862c = d;
        this.f1860a = context;
        this.f1863d = c0775c;
    }

    protected String m3223a(Void... voidArr) {
        return C0896c.m3113a(this.f1860a, this.f1862c, this.f1861b);
    }

    protected void m3224a(String str) {
        this.f1863d.m2640b(str);
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m3223a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m3224a((String) obj);
    }
}
