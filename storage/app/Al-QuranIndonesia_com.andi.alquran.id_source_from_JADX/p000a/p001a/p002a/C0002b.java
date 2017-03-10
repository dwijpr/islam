package p000a.p001a.p002a;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.PopupWindow;

/* renamed from: a.a.a.b */
public class C0002b {
    protected Context f5a;
    protected PopupWindow f6b;
    protected View f7c;
    protected Drawable f8d;
    protected WindowManager f9e;

    /* renamed from: a.a.a.b.1 */
    class C00011 implements OnTouchListener {
        final /* synthetic */ C0002b f4a;

        C00011(C0002b c0002b) {
            this.f4a = c0002b;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 4) {
                return false;
            }
            this.f4a.f6b.dismiss();
            return true;
        }
    }

    public C0002b(Context context) {
        this.f8d = null;
        this.f5a = context;
        this.f6b = new PopupWindow(context);
        this.f6b.setTouchInterceptor(new C00011(this));
        this.f9e = (WindowManager) context.getSystemService("window");
    }

    protected void m4a() {
    }

    public void m5a(View view) {
        this.f7c = view;
        this.f6b.setContentView(view);
    }

    protected void m6b() {
        if (this.f7c == null) {
            throw new IllegalStateException("setContentView was not called with a view to display.");
        }
        m4a();
        if (this.f8d == null) {
            this.f6b.setBackgroundDrawable(new BitmapDrawable());
        } else {
            this.f6b.setBackgroundDrawable(this.f8d);
        }
        this.f6b.setWidth(-2);
        this.f6b.setHeight(-2);
        this.f6b.setTouchable(true);
        this.f6b.setFocusable(true);
        this.f6b.setOutsideTouchable(true);
        this.f6b.setContentView(this.f7c);
    }

    public void m7c() {
        this.f6b.dismiss();
    }

    protected void onDismiss() {
    }
}
