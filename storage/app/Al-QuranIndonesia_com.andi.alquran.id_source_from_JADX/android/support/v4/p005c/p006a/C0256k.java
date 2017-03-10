package android.support.v4.p005c.p006a;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.p005c.p006a.C0252i.C0250a;

@TargetApi(19)
/* renamed from: android.support.v4.c.a.k */
class C0256k extends C0254j {

    /* renamed from: android.support.v4.c.a.k.a */
    private static class C0255a extends C0250a {
        C0255a(C0250a c0250a, Resources resources) {
            super(c0250a, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0256k(this, resources);
        }
    }

    C0256k(Drawable drawable) {
        super(drawable);
    }

    C0256k(C0250a c0250a, Resources resources) {
        super(c0250a, resources);
    }

    C0250a m900b() {
        return new C0255a(this.b, null);
    }

    public boolean isAutoMirrored() {
        return this.c.isAutoMirrored();
    }

    public void setAutoMirrored(boolean z) {
        this.c.setAutoMirrored(z);
    }
}
