package com.google.android.gms.internal;

import com.google.android.gms.internal.ll.C1781c;
import com.google.android.gms.internal.sq.C1171c;
import com.google.android.gms.internal.sq.C1553a;
import com.google.android.gms.internal.sq.C1998b;
import java.util.Map;
import org.json.JSONObject;

@op
public class ff implements fg {
    private final fc f3989a;
    private C1781c f3990b;
    private boolean f3991c;
    private final kg f3992d;
    private final kg f3993e;
    private final kg f3994f;

    /* renamed from: com.google.android.gms.internal.ff.1 */
    class C15521 implements C1171c<lm> {
        final /* synthetic */ ff f3982a;

        C15521(ff ffVar) {
            this.f3982a = ffVar;
        }

        public void m6121a(lm lmVar) {
            this.f3982a.f3991c = true;
            this.f3982a.m6134a(lmVar);
        }

        public /* synthetic */ void m6122a(Object obj) {
            m6121a((lm) obj);
        }
    }

    /* renamed from: com.google.android.gms.internal.ff.2 */
    class C15542 implements C1553a {
        final /* synthetic */ ff f3983a;

        C15542(ff ffVar) {
            this.f3983a = ffVar;
        }

        public void m6124a() {
            this.f3983a.f3989a.m6090b(this.f3983a);
        }
    }

    /* renamed from: com.google.android.gms.internal.ff.3 */
    class C15553 implements C1171c<lm> {
        final /* synthetic */ JSONObject f3984a;

        C15553(ff ffVar, JSONObject jSONObject) {
            this.f3984a = jSONObject;
        }

        public void m6125a(lm lmVar) {
            lmVar.m7289a("AFMA_updateActiveView", this.f3984a);
        }

        public /* synthetic */ void m6126a(Object obj) {
            m6125a((lm) obj);
        }
    }

    /* renamed from: com.google.android.gms.internal.ff.4 */
    class C15564 implements C1171c<lm> {
        final /* synthetic */ ff f3985a;

        C15564(ff ffVar) {
            this.f3985a = ffVar;
        }

        public void m6127a(lm lmVar) {
            this.f3985a.m6138b(lmVar);
        }

        public /* synthetic */ void m6128a(Object obj) {
            m6127a((lm) obj);
        }
    }

    /* renamed from: com.google.android.gms.internal.ff.5 */
    class C15575 implements kg {
        final /* synthetic */ ff f3986a;

        C15575(ff ffVar) {
            this.f3986a = ffVar;
        }

        public void m6129a(sx sxVar, Map<String, String> map) {
            if (this.f3986a.f3989a.m6088a((Map) map)) {
                this.f3986a.f3989a.m6085a(sxVar, (Map) map);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ff.6 */
    class C15586 implements kg {
        final /* synthetic */ ff f3987a;

        C15586(ff ffVar) {
            this.f3987a = ffVar;
        }

        public void m6130a(sx sxVar, Map<String, String> map) {
            if (this.f3987a.f3989a.m6088a((Map) map)) {
                this.f3987a.f3989a.m6084a(this.f3987a, (Map) map);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ff.7 */
    class C15597 implements kg {
        final /* synthetic */ ff f3988a;

        C15597(ff ffVar) {
            this.f3988a = ffVar;
        }

        public void m6131a(sx sxVar, Map<String, String> map) {
            if (this.f3988a.f3989a.m6088a((Map) map)) {
                this.f3988a.f3989a.m6091b((Map) map);
            }
        }
    }

    public ff(fc fcVar, ll llVar) {
        this.f3992d = new C15575(this);
        this.f3993e = new C15586(this);
        this.f3994f = new C15597(this);
        this.f3989a = fcVar;
        this.f3990b = llVar.m7368a();
        this.f3990b.m7340a(new C15521(this), new C15542(this));
        String str = "Core JS tracking ad unit: ";
        String valueOf = String.valueOf(this.f3989a.m6108r().m6046d());
        sg.m8444b(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    void m6134a(lm lmVar) {
        lmVar.m7287a("/updateActiveView", this.f3992d);
        lmVar.m7287a("/untrackActiveViewUnit", this.f3993e);
        lmVar.m7287a("/visibilityChanged", this.f3994f);
    }

    public void m6135a(JSONObject jSONObject, boolean z) {
        this.f3990b.m7340a(new C15553(this, jSONObject), new C1998b());
    }

    public boolean m6136a() {
        return this.f3991c;
    }

    public void m6137b() {
        this.f3990b.m7340a(new C15564(this), new C1998b());
        this.f3990b.b_();
    }

    void m6138b(lm lmVar) {
        lmVar.m7290b("/visibilityChanged", this.f3994f);
        lmVar.m7290b("/untrackActiveViewUnit", this.f3993e);
        lmVar.m7290b("/updateActiveView", this.f3992d);
    }
}
