package android.support.v4.p005c.p006a;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.p005c.p006a.C0252i.C0250a;

@TargetApi(11)
/* renamed from: android.support.v4.c.a.j */
class C0254j extends C0252i {

    /* renamed from: android.support.v4.c.a.j.a */
    private static class C0253a extends C0250a {
        C0253a(C0250a c0250a, Resources resources) {
            super(c0250a, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0254j(this, resources);
        }
    }

    C0254j(Drawable drawable) {
        super(drawable);
    }

    C0254j(C0250a c0250a, Resources resources) {
        super(c0250a, resources);
    }

    C0250a m899b() {
        return new C0253a(this.b, null);
    }

    public void jumpToCurrentState() {
        this.c.jumpToCurrentState();
    }
}
