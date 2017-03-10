package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.as.C1438a;
import com.google.android.gms.internal.au.C1444a;
import com.google.android.gms.maps.GoogleMap;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class bl implements bk {
    protected MotionEvent f3604a;
    protected LinkedList<MotionEvent> f3605b;
    protected long f3606c;
    protected long f3607d;
    protected long f3608e;
    protected long f3609f;
    protected long f3610g;
    protected long f3611h;
    protected long f3612i;
    protected boolean f3613j;
    protected DisplayMetrics f3614k;
    private boolean f3615l;

    protected bl(Context context) {
        this.f3605b = new LinkedList();
        this.f3606c = 0;
        this.f3607d = 0;
        this.f3608e = 0;
        this.f3609f = 0;
        this.f3610g = 0;
        this.f3611h = 0;
        this.f3612i = 0;
        this.f3615l = false;
        this.f3613j = false;
        try {
            ba.m5237a();
            this.f3614k = context.getResources().getDisplayMetrics();
        } catch (Throwable th) {
        }
    }

    private String m5289a(Context context, String str, boolean z, View view, byte[] bArr) {
        boolean z2 = true;
        C1438a c1438a = null;
        if (bArr != null && bArr.length > 0) {
            try {
                c1438a = C1438a.m5156a(bArr);
            } catch (ef e) {
            }
        }
        if (z) {
            try {
                C1444a a = m5294a(context, view);
                this.f3615l = true;
            } catch (NoSuchAlgorithmException e2) {
                return Integer.toString(7);
            } catch (UnsupportedEncodingException e3) {
                return Integer.toString(7);
            } catch (Throwable th) {
                return Integer.toString(3);
            }
        }
        a = m5295a(context, c1438a);
        if (a == null || a.m5155g() == 0) {
            return Integer.toString(5);
        }
        if (m5291a(z)) {
            z2 = false;
        }
        return ba.m5232a(a, str, z2);
    }

    private static boolean m5290a(dd ddVar) {
        return (ddVar == null || ddVar.f3761d == null || ddVar.f3764g == null) ? false : true;
    }

    private static boolean m5291a(boolean z) {
        return !((Boolean) C1648if.bs.m6682c()).booleanValue() ? true : ((Boolean) C1648if.bN.m6682c()).booleanValue() && z;
    }

    private boolean m5292b(dd ddVar) {
        return (this.f3614k == null || ddVar == null || ddVar.f3762e == null || ddVar.f3765h == null) ? false : true;
    }

    protected abstract long m5293a(StackTraceElement[] stackTraceElementArr);

    protected abstract C1444a m5294a(Context context, View view);

    protected abstract C1444a m5295a(Context context, C1438a c1438a);

    public String m5296a(Context context) {
        if (!de.m5721b() || !((Boolean) C1648if.bM.m6682c()).booleanValue()) {
            return m5289a(context, null, false, null, null);
        }
        throw new IllegalStateException("The caller must not be called from the UI thread.");
    }

    public String m5297a(Context context, String str) {
        return m5298a(context, str, null);
    }

    public String m5298a(Context context, String str, View view) {
        return m5289a(context, str, true, view, null);
    }

    public String m5299a(Context context, byte[] bArr) {
        if (!de.m5721b() || !((Boolean) C1648if.bM.m6682c()).booleanValue()) {
            return m5289a(context, null, false, null, bArr);
        }
        throw new IllegalStateException("The caller must not be called from the UI thread.");
    }

    public void m5300a(int i, int i2, int i3) {
        if (this.f3604a != null) {
            this.f3604a.recycle();
        }
        if (this.f3614k != null) {
            this.f3604a = MotionEvent.obtain(0, (long) i3, 1, ((float) i) * this.f3614k.density, ((float) i2) * this.f3614k.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        } else {
            this.f3604a = null;
        }
        this.f3613j = false;
    }

    public void m5301a(MotionEvent motionEvent) {
        if (this.f3615l) {
            this.f3609f = 0;
            this.f3608e = 0;
            this.f3607d = 0;
            this.f3606c = 0;
            this.f3610g = 0;
            this.f3612i = 0;
            this.f3611h = 0;
            Iterator it = this.f3605b.iterator();
            while (it.hasNext()) {
                ((MotionEvent) it.next()).recycle();
            }
            this.f3605b.clear();
            this.f3604a = null;
            this.f3615l = false;
        }
        switch (motionEvent.getAction()) {
            case GoogleMap.MAP_TYPE_NONE /*0*/:
                this.f3606c++;
                break;
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                this.f3604a = MotionEvent.obtain(motionEvent);
                this.f3605b.add(this.f3604a);
                if (this.f3605b.size() > 6) {
                    ((MotionEvent) this.f3605b.remove()).recycle();
                }
                this.f3608e++;
                try {
                    this.f3610g = m5293a(new Throwable().getStackTrace());
                    break;
                } catch (cy e) {
                    break;
                }
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                this.f3607d += (long) (motionEvent.getHistorySize() + 1);
                if (((Boolean) C1648if.bA.m6682c()).booleanValue() || ((Boolean) C1648if.bv.m6682c()).booleanValue()) {
                    try {
                        dd b = m5302b(motionEvent);
                        if (m5290a(b)) {
                            this.f3611h += b.f3761d.longValue() + b.f3764g.longValue();
                        }
                        if (m5292b(b)) {
                            this.f3612i = (b.f3765h.longValue() + b.f3762e.longValue()) + this.f3612i;
                            break;
                        }
                    } catch (cy e2) {
                        break;
                    }
                }
                break;
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                this.f3609f++;
                break;
        }
        this.f3613j = true;
    }

    protected abstract dd m5302b(MotionEvent motionEvent);
}
