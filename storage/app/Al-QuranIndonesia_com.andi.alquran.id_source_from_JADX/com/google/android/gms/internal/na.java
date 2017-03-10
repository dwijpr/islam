package com.google.android.gms.internal;

import android.support.v7.recyclerview.BuildConfig;
import org.json.JSONObject;

@op
public class na {
    private final sx f5007a;
    private final String f5008b;

    public na(sx sxVar) {
        this(sxVar, BuildConfig.VERSION_NAME);
    }

    public na(sx sxVar, String str) {
        this.f5007a = sxVar;
        this.f5008b = str;
    }

    public void m7687a(int i, int i2, int i3, int i4) {
        try {
            this.f5007a.m7291b("onSizeChanged", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (Throwable e) {
            sg.m8445b("Error occured while dispatching size change.", e);
        }
    }

    public void m7688a(int i, int i2, int i3, int i4, float f, int i5) {
        try {
            this.f5007a.m7291b("onScreenInfoChanged", new JSONObject().put("width", i).put("height", i2).put("maxSizeWidth", i3).put("maxSizeHeight", i4).put("density", (double) f).put("rotation", i5));
        } catch (Throwable e) {
            sg.m8445b("Error occured while obtaining screen information.", e);
        }
    }

    public void m7689b(int i, int i2, int i3, int i4) {
        try {
            this.f5007a.m7291b("onDefaultPositionReceived", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (Throwable e) {
            sg.m8445b("Error occured while dispatching default position.", e);
        }
    }

    public void m7690b(String str) {
        try {
            this.f5007a.m7291b("onError", new JSONObject().put("message", str).put("action", this.f5008b));
        } catch (Throwable e) {
            sg.m8445b("Error occurred while dispatching error event.", e);
        }
    }

    public void m7691c(String str) {
        try {
            this.f5007a.m7291b("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (Throwable e) {
            sg.m8445b("Error occured while dispatching ready Event.", e);
        }
    }

    public void m7692d(String str) {
        try {
            this.f5007a.m7291b("onStateChanged", new JSONObject().put("state", str));
        } catch (Throwable e) {
            sg.m8445b("Error occured while dispatching state change.", e);
        }
    }
}
