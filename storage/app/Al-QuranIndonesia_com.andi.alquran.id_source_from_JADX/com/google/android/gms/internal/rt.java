package com.google.android.gms.internal;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.C1114a.C1095b;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@op
public class rt {
    private final Context f5771a;
    private String f5772b;
    private String f5773c;
    private final float f5774d;
    private float f5775e;
    private float f5776f;
    private float f5777g;
    private int f5778h;

    /* renamed from: com.google.android.gms.internal.rt.1 */
    class C19741 implements OnClickListener {
        final /* synthetic */ int f5763a;
        final /* synthetic */ int f5764b;
        final /* synthetic */ int f5765c;
        final /* synthetic */ rt f5766d;

        C19741(rt rtVar, int i, int i2, int i3) {
            this.f5766d = rtVar;
            this.f5763a = i;
            this.f5764b = i2;
            this.f5765c = i3;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (i == this.f5763a) {
                this.f5766d.m8614c();
            } else if (i == this.f5764b && ((Boolean) C1648if.da.m6682c()).booleanValue()) {
                this.f5766d.m8617d();
            } else if (i == this.f5765c && ((Boolean) C1648if.db.m6682c()).booleanValue()) {
                this.f5766d.m8619e();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.rt.2 */
    class C19752 implements OnClickListener {
        final /* synthetic */ String f5767a;
        final /* synthetic */ rt f5768b;

        C19752(rt rtVar, String str) {
            this.f5768b = rtVar;
            this.f5767a = str;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            zzv.zzcJ().m8509a(this.f5768b.f5771a, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", this.f5767a), "Share via"));
        }
    }

    /* renamed from: com.google.android.gms.internal.rt.3 */
    class C19763 implements OnClickListener {
        C19763(rt rtVar) {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.google.android.gms.internal.rt.4 */
    class C19774 implements Runnable {
        final /* synthetic */ rt f5769a;

        C19774(rt rtVar) {
            this.f5769a = rtVar;
        }

        public void run() {
            zzv.zzcR().m8633a(this.f5769a.f5771a, this.f5769a.f5773c);
        }
    }

    /* renamed from: com.google.android.gms.internal.rt.5 */
    class C19785 implements Runnable {
        final /* synthetic */ rt f5770a;

        C19785(rt rtVar) {
            this.f5770a = rtVar;
        }

        public void run() {
            zzv.zzcR().m8637b(this.f5770a.f5771a, this.f5770a.f5773c);
        }
    }

    public rt(Context context) {
        this.f5778h = 0;
        this.f5771a = context;
        this.f5774d = context.getResources().getDisplayMetrics().density;
    }

    public rt(Context context, String str) {
        this(context);
        this.f5772b = str;
    }

    private int m8609a(List<String> list, String str, boolean z) {
        if (!z) {
            return -1;
        }
        list.add(str);
        return list.size() - 1;
    }

    private void m8611b() {
        if (this.f5771a instanceof Activity) {
            CharSequence string;
            Resources s = zzv.zzcN().m8425s();
            if (s != null) {
                string = s.getString(C1095b.debug_menu_title);
            } else {
                Object obj = "Select a Debug Mode";
            }
            String string2 = s != null ? s.getString(C1095b.debug_menu_ad_information) : "Ad Information";
            String string3 = s != null ? s.getString(C1095b.debug_menu_creative_preview) : "Creative Preview";
            String string4 = s != null ? s.getString(C1095b.debug_menu_troubleshooting) : "Troubleshooting";
            List arrayList = new ArrayList();
            new Builder(this.f5771a).setTitle(string).setItems((CharSequence[]) arrayList.toArray(new String[0]), new C19741(this, m8609a(arrayList, string2, true), m8609a(arrayList, string3, ((Boolean) C1648if.da.m6682c()).booleanValue()), m8609a(arrayList, string4, ((Boolean) C1648if.db.m6682c()).booleanValue()))).create().show();
            return;
        }
        sg.m8448d("Can not create dialog without Activity Context");
    }

    static String m8613c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "No debug information";
        }
        Uri build = new Uri.Builder().encodedQuery(str.replaceAll("\\+", "%20")).build();
        StringBuilder stringBuilder = new StringBuilder();
        Map a = zzv.zzcJ().m8503a(build);
        for (String str2 : a.keySet()) {
            stringBuilder.append(str2).append(" = ").append((String) a.get(str2)).append("\n\n");
        }
        Object trim = stringBuilder.toString().trim();
        return TextUtils.isEmpty(trim) ? "No debug information" : trim;
    }

    private void m8614c() {
        if (this.f5771a instanceof Activity) {
            Object c = m8613c(this.f5772b);
            Builder builder = new Builder(this.f5771a);
            builder.setMessage(c);
            builder.setTitle("Ad Information");
            builder.setPositiveButton("Share", new C19752(this, c));
            builder.setNegativeButton("Close", new C19763(this));
            builder.create().show();
            return;
        }
        sg.m8448d("Can not create dialog without Activity Context");
    }

    private void m8617d() {
        sg.m8444b("Debug mode [Creative Preview] selected.");
        rp.m8472a(new C19774(this));
    }

    private void m8619e() {
        sg.m8444b("Debug mode [Troubleshooting] selected.");
        rp.m8472a(new C19785(this));
    }

    public void m8620a() {
        if (((Boolean) C1648if.db.m6682c()).booleanValue() || ((Boolean) C1648if.da.m6682c()).booleanValue()) {
            m8611b();
        } else {
            m8614c();
        }
    }

    void m8621a(int i, float f, float f2) {
        if (i == 0) {
            this.f5778h = 0;
            this.f5775e = f;
            this.f5776f = f2;
            this.f5777g = f2;
        } else if (this.f5778h == -1) {
        } else {
            if (i == 2) {
                if (f2 > this.f5776f) {
                    this.f5776f = f2;
                } else if (f2 < this.f5777g) {
                    this.f5777g = f2;
                }
                if (this.f5776f - this.f5777g > BitmapDescriptorFactory.HUE_ORANGE * this.f5774d) {
                    this.f5778h = -1;
                    return;
                }
                if (this.f5778h == 0 || this.f5778h == 2) {
                    if (f - this.f5775e >= 50.0f * this.f5774d) {
                        this.f5775e = f;
                        this.f5778h++;
                    }
                } else if ((this.f5778h == 1 || this.f5778h == 3) && f - this.f5775e <= -50.0f * this.f5774d) {
                    this.f5775e = f;
                    this.f5778h++;
                }
                if (this.f5778h == 1 || this.f5778h == 3) {
                    if (f > this.f5775e) {
                        this.f5775e = f;
                    }
                } else if (this.f5778h == 2 && f < this.f5775e) {
                    this.f5775e = f;
                }
            } else if (i == 1 && this.f5778h == 4) {
                m8620a();
            }
        }
    }

    public void m8622a(MotionEvent motionEvent) {
        int historySize = motionEvent.getHistorySize();
        for (int i = 0; i < historySize; i++) {
            m8621a(motionEvent.getActionMasked(), motionEvent.getHistoricalX(0, i), motionEvent.getHistoricalY(0, i));
        }
        m8621a(motionEvent.getActionMasked(), motionEvent.getX(), motionEvent.getY());
    }

    public void m8623a(String str) {
        this.f5773c = str;
    }

    public void m8624b(String str) {
        this.f5772b = str;
    }
}
