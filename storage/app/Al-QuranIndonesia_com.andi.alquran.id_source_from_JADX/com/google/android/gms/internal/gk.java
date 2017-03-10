package com.google.android.gms.internal;

import android.os.Handler;
import java.util.concurrent.Executor;

public class gk implements pi {
    private final Executor f4166a;

    /* renamed from: com.google.android.gms.internal.gk.1 */
    class C15931 implements Executor {
        final /* synthetic */ Handler f4162a;

        C15931(gk gkVar, Handler handler) {
            this.f4162a = handler;
        }

        public void execute(Runnable runnable) {
            this.f4162a.post(runnable);
        }
    }

    /* renamed from: com.google.android.gms.internal.gk.a */
    private class C1594a implements Runnable {
        private final ml f4163a;
        private final on f4164b;
        private final Runnable f4165c;

        public C1594a(gk gkVar, ml mlVar, on onVar, Runnable runnable) {
            this.f4163a = mlVar;
            this.f4164b = onVar;
            this.f4165c = runnable;
        }

        public void run() {
            if (this.f4164b.m7939a()) {
                this.f4163a.m7606a(this.f4164b.f5263a);
            } else {
                this.f4163a.m7608b(this.f4164b.f5265c);
            }
            if (this.f4164b.f5266d) {
                this.f4163a.m7609b("intermediate-response");
            } else {
                this.f4163a.m7611c("done");
            }
            if (this.f4165c != null) {
                this.f4165c.run();
            }
        }
    }

    public gk(Handler handler) {
        this.f4166a = new C15931(this, handler);
    }

    public void m6335a(ml<?> mlVar, on<?> onVar) {
        m6336a(mlVar, onVar, null);
    }

    public void m6336a(ml<?> mlVar, on<?> onVar, Runnable runnable) {
        mlVar.m7624p();
        mlVar.m7609b("post-response");
        this.f4166a.execute(new C1594a(this, mlVar, onVar, runnable));
    }

    public void m6337a(ml<?> mlVar, ti tiVar) {
        mlVar.m7609b("post-error");
        this.f4166a.execute(new C1594a(this, mlVar, on.m7937a(tiVar), null));
    }
}
