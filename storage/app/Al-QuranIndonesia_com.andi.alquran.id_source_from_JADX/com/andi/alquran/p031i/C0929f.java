package com.andi.alquran.p031i;

import android.content.Context;
import android.os.AsyncTask;
import com.andi.alquran.p022f.C0776d;
import com.andi.alquran.p027d.C0897d;

/* renamed from: com.andi.alquran.i.f */
public class C0929f extends AsyncTask<Void, Void, String> {
    private Context f1864a;
    private double f1865b;
    private double f1866c;
    private C0776d f1867d;

    public C0929f(Context context, double d, double d2, C0776d c0776d) {
        this.f1865b = d2;
        this.f1866c = d;
        this.f1864a = context;
        this.f1867d = c0776d;
    }

    protected String m3225a(Void... voidArr) {
        return C0897d.m3114a(this.f1864a, this.f1866c, this.f1865b);
    }

    protected void m3226a(String str) {
        this.f1867d.m2641a(str);
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m3225a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m3226a((String) obj);
    }
}
