package com.google.android.gms.internal;

import com.google.android.gms.internal.ll.C1781c;
import java.util.Map;
import java.util.concurrent.Future;

@op
public final class pk {
    C1781c f5409a;
    public final kg f5410b;
    public final kg f5411c;
    public final kg f5412d;
    private final Object f5413e;
    private String f5414f;
    private String f5415g;
    private sk<pn> f5416h;

    /* renamed from: com.google.android.gms.internal.pk.1 */
    class C19141 implements kg {
        final /* synthetic */ pk f5406a;

        C19141(pk pkVar) {
            this.f5406a = pkVar;
        }

        public void m8133a(sx sxVar, Map<String, String> map) {
            synchronized (this.f5406a.f5413e) {
                if (this.f5406a.f5416h.isDone()) {
                } else if (this.f5406a.f5414f.equals(map.get("request_id"))) {
                    Object pnVar = new pn(1, map);
                    String valueOf = String.valueOf(pnVar.m8188f());
                    String valueOf2 = String.valueOf(pnVar.m8184b());
                    sg.m8449e(new StringBuilder((String.valueOf(valueOf).length() + 24) + String.valueOf(valueOf2).length()).append("Invalid ").append(valueOf).append(" request error: ").append(valueOf2).toString());
                    this.f5406a.f5416h.m7304b(pnVar);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.pk.2 */
    class C19152 implements kg {
        final /* synthetic */ pk f5407a;

        C19152(pk pkVar) {
            this.f5407a = pkVar;
        }

        public void m8134a(sx sxVar, Map<String, String> map) {
            synchronized (this.f5407a.f5413e) {
                if (this.f5407a.f5416h.isDone()) {
                    return;
                }
                Object pnVar = new pn(-2, map);
                if (this.f5407a.f5414f.equals(pnVar.m8190h())) {
                    String e = pnVar.m8187e();
                    if (e == null) {
                        sg.m8449e("URL missing in loadAdUrl GMSG.");
                        return;
                    }
                    if (e.contains("%40mediation_adapters%40")) {
                        String replaceAll = e.replaceAll("%40mediation_adapters%40", rk.m8440a(sxVar.getContext(), (String) map.get("check_adapters"), this.f5407a.f5415g));
                        pnVar.m8183a(replaceAll);
                        e = "Ad request URL modified to ";
                        replaceAll = String.valueOf(replaceAll);
                        rm.m8450a(replaceAll.length() != 0 ? e.concat(replaceAll) : new String(e));
                    }
                    this.f5407a.f5416h.m7304b(pnVar);
                    return;
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.pk.3 */
    class C19163 implements kg {
        final /* synthetic */ pk f5408a;

        C19163(pk pkVar) {
            this.f5408a = pkVar;
        }

        public void m8135a(sx sxVar, Map<String, String> map) {
            synchronized (this.f5408a.f5413e) {
                if (this.f5408a.f5416h.isDone()) {
                    return;
                }
                Object pnVar = new pn(-2, map);
                if (this.f5408a.f5414f.equals(pnVar.m8190h())) {
                    this.f5408a.f5416h.m7304b(pnVar);
                    return;
                }
            }
        }
    }

    public pk(String str, String str2) {
        this.f5413e = new Object();
        this.f5416h = new sk();
        this.f5410b = new C19141(this);
        this.f5411c = new C19152(this);
        this.f5412d = new C19163(this);
        this.f5415g = str2;
        this.f5414f = str;
    }

    public C1781c m8140a() {
        return this.f5409a;
    }

    public void m8141a(C1781c c1781c) {
        this.f5409a = c1781c;
    }

    public Future<pn> m8142b() {
        return this.f5416h;
    }
}
