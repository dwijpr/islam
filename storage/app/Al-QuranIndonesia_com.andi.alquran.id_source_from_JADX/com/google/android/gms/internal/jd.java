package com.google.android.gms.internal;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

public interface jd {

    /* renamed from: com.google.android.gms.internal.jd.a */
    public interface C1660a {
        void m6804a(jd jdVar);

        String m6805k();

        String m6806l();

        iv m6807m();
    }

    void m6917a(MotionEvent motionEvent);

    void m6918a(View view);

    void m6919a(View view, String str, JSONObject jSONObject, Map<String, WeakReference<View>> map, View view2);

    void m6920a(View view, Map<String, WeakReference<View>> map);

    void m6921a(View view, Map<String, WeakReference<View>> map, JSONObject jSONObject, View view2);

    void m6922b(View view, Map<String, WeakReference<View>> map);

    void m6923c(View view, Map<String, WeakReference<View>> map);

    View m6924d();

    Context m6925e();
}
