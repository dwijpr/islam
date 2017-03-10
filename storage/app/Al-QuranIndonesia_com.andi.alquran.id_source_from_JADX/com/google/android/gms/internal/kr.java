package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.overlay.zzl;
import java.util.Map;
import org.json.JSONObject;

@op
public final class kr implements kg {
    private boolean f4649a;

    private static int m7129a(Context context, Map<String, String> map, String str, int i) {
        String str2 = (String) map.get(str);
        if (str2 != null) {
            try {
                i = gr.m6416a().m8690a(context, Integer.parseInt(str2));
            } catch (NumberFormatException e) {
                sg.m8449e(new StringBuilder((String.valueOf(str).length() + 34) + String.valueOf(str2).length()).append("Could not parse ").append(str).append(" in a video GMSG: ").append(str2).toString());
            }
        }
        return i;
    }

    public void m7130a(sx sxVar, Map<String, String> map) {
        String str = (String) map.get("action");
        if (str == null) {
            sg.m8449e("Action missing from video GMSG.");
            return;
        }
        if (sg.m8443a(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String valueOf = String.valueOf(jSONObject.toString());
            sg.m8444b(new StringBuilder((String.valueOf(str).length() + 13) + String.valueOf(valueOf).length()).append("Video GMSG: ").append(str).append(" ").append(valueOf).toString());
        }
        if ("background".equals(str)) {
            valueOf = (String) map.get("color");
            if (TextUtils.isEmpty(valueOf)) {
                sg.m8449e("Color parameter missing from color video GMSG.");
                return;
            }
            try {
                sxVar.setBackgroundColor(Color.parseColor(valueOf));
                return;
            } catch (IllegalArgumentException e) {
                sg.m8449e("Invalid color parameter in video GMSG.");
                return;
            }
        }
        sw w = sxVar.m8787w();
        if (w == null) {
            sg.m8449e("Could not get underlay container for a video GMSG.");
            return;
        }
        boolean equals = "new".equals(str);
        boolean equals2 = "position".equals(str);
        int a;
        int min;
        if (equals || equals2) {
            Context context = sxVar.getContext();
            int a2 = m7129a(context, map, "x", 0);
            a = m7129a(context, map, "y", 0);
            int a3 = m7129a(context, map, "w", -1);
            int a4 = m7129a(context, map, "h", -1);
            if (((Boolean) C1648if.cl.m6682c()).booleanValue()) {
                min = Math.min(a3, sxVar.getMeasuredWidth() - a2);
                a4 = Math.min(a4, sxVar.getMeasuredHeight() - a);
            } else {
                min = a3;
            }
            try {
                a3 = Integer.parseInt((String) map.get("player"));
            } catch (NumberFormatException e2) {
                a3 = 0;
            }
            boolean parseBoolean = Boolean.parseBoolean((String) map.get("spherical"));
            if (equals && w.m8736a() == null) {
                w.m8738a(a2, a, min, a4, a3, parseBoolean);
                return;
            } else {
                w.m8737a(a2, a, min, a4);
                return;
            }
        }
        zzl a5 = w.m8736a();
        if (a5 == null) {
            zzl.zzi(sxVar);
        } else if ("click".equals(str)) {
            r0 = sxVar.getContext();
            a = m7129a(r0, map, "x", 0);
            min = m7129a(r0, map, "y", 0);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) a, (float) min, 0);
            a5.zzf(obtain);
            obtain.recycle();
        } else if ("currentTime".equals(str)) {
            valueOf = (String) map.get("time");
            if (valueOf == null) {
                sg.m8449e("Time parameter missing from currentTime video GMSG.");
                return;
            }
            try {
                a5.seekTo((int) (Float.parseFloat(valueOf) * 1000.0f));
            } catch (NumberFormatException e3) {
                str = "Could not parse time parameter from currentTime video GMSG: ";
                valueOf = String.valueOf(valueOf);
                sg.m8449e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            }
        } else if ("hide".equals(str)) {
            a5.setVisibility(4);
        } else if ("load".equals(str)) {
            a5.zzgq();
        } else if ("muted".equals(str)) {
            if (Boolean.parseBoolean((String) map.get("muted"))) {
                a5.zzhE();
            } else {
                a5.zzhF();
            }
        } else if ("pause".equals(str)) {
            a5.pause();
        } else if ("play".equals(str)) {
            a5.play();
        } else if ("show".equals(str)) {
            a5.setVisibility(0);
        } else if ("src".equals(str)) {
            a5.zzaB((String) map.get("src"));
        } else if ("touchMove".equals(str)) {
            r0 = sxVar.getContext();
            a5.zza((float) m7129a(r0, map, "dx", 0), (float) m7129a(r0, map, "dy", 0));
            if (!this.f4649a) {
                sxVar.m8773i().zzhq();
                this.f4649a = true;
            }
        } else if ("volume".equals(str)) {
            valueOf = (String) map.get("volume");
            if (valueOf == null) {
                sg.m8449e("Level parameter missing from volume video GMSG.");
                return;
            }
            try {
                a5.zzb(Float.parseFloat(valueOf));
            } catch (NumberFormatException e4) {
                str = "Could not parse volume parameter from volume video GMSG: ";
                valueOf = String.valueOf(valueOf);
                sg.m8449e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            }
        } else if ("watermark".equals(str)) {
            a5.zzhG();
        } else {
            String str2 = "Unknown video action: ";
            valueOf = String.valueOf(str);
            sg.m8449e(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
    }
}
