package com.google.android.gms.internal;

import java.util.Map;
import org.json.JSONObject;

@op
public class fe implements fg {
    private final fc f3977a;
    private final lm f3978b;
    private final kg f3979c;
    private final kg f3980d;
    private final kg f3981e;

    /* renamed from: com.google.android.gms.internal.fe.1 */
    class C15491 implements kg {
        final /* synthetic */ fe f3974a;

        C15491(fe feVar) {
            this.f3974a = feVar;
        }

        public void m6109a(sx sxVar, Map<String, String> map) {
            this.f3974a.f3977a.m6085a(sxVar, (Map) map);
        }
    }

    /* renamed from: com.google.android.gms.internal.fe.2 */
    class C15502 implements kg {
        final /* synthetic */ fe f3975a;

        C15502(fe feVar) {
            this.f3975a = feVar;
        }

        public void m6110a(sx sxVar, Map<String, String> map) {
            this.f3975a.f3977a.m6084a(this.f3975a, (Map) map);
        }
    }

    /* renamed from: com.google.android.gms.internal.fe.3 */
    class C15513 implements kg {
        final /* synthetic */ fe f3976a;

        C15513(fe feVar) {
            this.f3976a = feVar;
        }

        public void m6111a(sx sxVar, Map<String, String> map) {
            this.f3976a.f3977a.m6091b((Map) map);
        }
    }

    public fe(fc fcVar, lm lmVar) {
        this.f3979c = new C15491(this);
        this.f3980d = new C15502(this);
        this.f3981e = new C15513(this);
        this.f3977a = fcVar;
        this.f3978b = lmVar;
        m6116a(this.f3978b);
        String str = "Custom JS tracking ad unit: ";
        String valueOf = String.valueOf(this.f3977a.m6108r().m6046d());
        sg.m8444b(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    void m6116a(lm lmVar) {
        lmVar.m7287a("/updateActiveView", this.f3979c);
        lmVar.m7287a("/untrackActiveViewUnit", this.f3980d);
        lmVar.m7287a("/visibilityChanged", this.f3981e);
    }

    public void m6117a(JSONObject jSONObject, boolean z) {
        if (z) {
            this.f3977a.m6090b((fg) this);
        } else {
            this.f3978b.m7289a("AFMA_updateActiveView", jSONObject);
        }
    }

    public boolean m6118a() {
        return true;
    }

    public void m6119b() {
        m6120b(this.f3978b);
    }

    void m6120b(lm lmVar) {
        lmVar.m7290b("/visibilityChanged", this.f3981e);
        lmVar.m7290b("/untrackActiveViewUnit", this.f3980d);
        lmVar.m7290b("/updateActiveView", this.f3979c);
    }
}
