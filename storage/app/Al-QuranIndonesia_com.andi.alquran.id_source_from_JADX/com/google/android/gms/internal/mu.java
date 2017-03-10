package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract.Events;
import android.support.v7.recyclerview.BuildConfig;
import android.text.TextUtils;
import com.google.android.gms.C1114a.C1095b;
import com.google.android.gms.ads.internal.zzv;
import java.util.Map;

@op
public class mu extends na {
    private final Map<String, String> f5009a;
    private final Context f5010b;
    private String f5011c;
    private long f5012d;
    private long f5013e;
    private String f5014f;
    private String f5015g;

    /* renamed from: com.google.android.gms.internal.mu.1 */
    class C18211 implements OnClickListener {
        final /* synthetic */ mu f5005a;

        C18211(mu muVar) {
            this.f5005a = muVar;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            zzv.zzcJ().m8509a(this.f5005a.f5010b, this.f5005a.m7698b());
        }
    }

    /* renamed from: com.google.android.gms.internal.mu.2 */
    class C18222 implements OnClickListener {
        final /* synthetic */ mu f5006a;

        C18222(mu muVar) {
            this.f5006a = muVar;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f5006a.m7690b("Operation denied by user.");
        }
    }

    public mu(sx sxVar, Map<String, String> map) {
        super(sxVar, "createCalendarEvent");
        this.f5009a = map;
        this.f5010b = sxVar.m8770f();
        m7695c();
    }

    private String m7694a(String str) {
        return TextUtils.isEmpty((CharSequence) this.f5009a.get(str)) ? BuildConfig.VERSION_NAME : (String) this.f5009a.get(str);
    }

    private void m7695c() {
        this.f5011c = m7694a("description");
        this.f5014f = m7694a("summary");
        this.f5012d = m7696e("start_ticks");
        this.f5013e = m7696e("end_ticks");
        this.f5015g = m7694a("location");
    }

    private long m7696e(String str) {
        String str2 = (String) this.f5009a.get(str);
        if (str2 == null) {
            return -1;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void m7697a() {
        if (this.f5010b == null) {
            m7690b("Activity context is not available.");
        } else if (zzv.zzcJ().m8545e(this.f5010b).m6647e()) {
            Builder d = zzv.zzcJ().m8542d(this.f5010b);
            Resources s = zzv.zzcN().m8425s();
            d.setTitle(s != null ? s.getString(C1095b.create_calendar_title) : "Create calendar event");
            d.setMessage(s != null ? s.getString(C1095b.create_calendar_message) : "Allow Ad to create a calendar event?");
            d.setPositiveButton(s != null ? s.getString(C1095b.accept) : "Accept", new C18211(this));
            d.setNegativeButton(s != null ? s.getString(C1095b.decline) : "Decline", new C18222(this));
            d.create().show();
        } else {
            m7690b("This feature is not available on the device.");
        }
    }

    @TargetApi(14)
    Intent m7698b() {
        Intent data = new Intent("android.intent.action.EDIT").setData(Events.CONTENT_URI);
        data.putExtra("title", this.f5011c);
        data.putExtra("eventLocation", this.f5015g);
        data.putExtra("description", this.f5014f);
        if (this.f5012d > -1) {
            data.putExtra("beginTime", this.f5012d);
        }
        if (this.f5013e > -1) {
            data.putExtra("endTime", this.f5013e);
        }
        data.setFlags(268435456);
        return data;
    }
}
