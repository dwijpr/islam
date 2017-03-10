package p000a.p001a.p002a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.andi.alquran.C0861R;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.maps.GoogleMap;
import java.util.ArrayList;
import java.util.List;

/* renamed from: a.a.a.c */
public class C0006c extends C0002b implements OnDismissListener {
    private View f13f;
    private ImageView f14g;
    private ImageView f15h;
    private LayoutInflater f16i;
    private ViewGroup f17j;
    private ScrollView f18k;
    private C0004a f19l;
    private C0005b f20m;
    private List<C0000a> f21n;
    private boolean f22o;
    private int f23p;
    private int f24q;
    private int f25r;
    private int f26s;
    private int f27t;

    /* renamed from: a.a.a.c.1 */
    class C00031 implements OnClickListener {
        final /* synthetic */ int f10a;
        final /* synthetic */ int f11b;
        final /* synthetic */ C0006c f12c;

        C00031(C0006c c0006c, int i, int i2) {
            this.f12c = c0006c;
            this.f10a = i;
            this.f11b = i2;
        }

        public void onClick(View view) {
            if (this.f12c.f19l != null) {
                this.f12c.f19l.m8a(this.f12c, this.f10a, this.f11b);
            }
            if (!this.f12c.m14a(this.f10a).m3d()) {
                this.f12c.f22o = true;
                this.f12c.m7c();
            }
        }
    }

    /* renamed from: a.a.a.c.a */
    public interface C0004a {
        void m8a(C0006c c0006c, int i, int i2);
    }

    /* renamed from: a.a.a.c.b */
    public interface C0005b {
        void m9a();
    }

    public C0006c(Context context, int i) {
        super(context);
        this.f21n = new ArrayList();
        this.f27t = 0;
        this.f26s = i;
        this.f16i = (LayoutInflater) context.getSystemService("layout_inflater");
        if (this.f26s == 0) {
            m17b((int) C0861R.layout.popup_horizontal);
        } else {
            m17b((int) C0861R.layout.popup_vertical);
        }
        this.f25r = 5;
        this.f23p = 0;
    }

    private void m11a(int i, int i2) {
        View view = i == C0861R.id.arrow_up ? this.f14g : this.f15h;
        View view2 = i == C0861R.id.arrow_up ? this.f15h : this.f14g;
        int measuredWidth = this.f14g.getMeasuredWidth();
        view.setVisibility(0);
        ((MarginLayoutParams) view.getLayoutParams()).leftMargin = i2 - (measuredWidth / 2);
        view2.setVisibility(4);
    }

    private void m12a(int i, int i2, boolean z) {
        int i3 = C0861R.style.Animations_PopUpMenu_Left;
        int i4 = C0861R.style.Animations_PopUpMenu_Center;
        int i5 = C0861R.style.Animations_PopDownMenu_Right;
        int measuredWidth = i2 - (this.f14g.getMeasuredWidth() / 2);
        PopupWindow popupWindow;
        switch (this.f25r) {
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                popupWindow = this.b;
                if (!z) {
                    i3 = C0861R.style.Animations_PopDownMenu_Left;
                }
                popupWindow.setAnimationStyle(i3);
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                this.b.setAnimationStyle(z ? C0861R.style.Animations_PopUpMenu_Right : C0861R.style.Animations_PopDownMenu_Right);
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                this.b.setAnimationStyle(z ? C0861R.style.Animations_PopUpMenu_Center : C0861R.style.Animations_PopDownMenu_Center);
            case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                this.b.setAnimationStyle(z ? C0861R.style.Animations_PopUpMenu_Reflect : C0861R.style.Animations_PopDownMenu_Reflect);
            case C1096c.MapAttrs_cameraZoom /*5*/:
                if (measuredWidth <= i / 4) {
                    popupWindow = this.b;
                    if (!z) {
                        i3 = C0861R.style.Animations_PopDownMenu_Left;
                    }
                    popupWindow.setAnimationStyle(i3);
                } else if (measuredWidth <= i / 4 || measuredWidth >= (i / 4) * 3) {
                    r0 = this.b;
                    if (z) {
                        i5 = C0861R.style.Animations_PopUpMenu_Right;
                    }
                    r0.setAnimationStyle(i5);
                } else {
                    r0 = this.b;
                    if (!z) {
                        i4 = C0861R.style.Animations_PopDownMenu_Center;
                    }
                    r0.setAnimationStyle(i4);
                }
            default:
        }
    }

    public C0000a m14a(int i) {
        return (C0000a) this.f21n.get(i);
    }

    @SuppressLint({"InflateParams"})
    public void m15a(C0000a c0000a) {
        this.f21n.add(c0000a);
        CharSequence a = c0000a.m0a();
        Drawable b = c0000a.m1b();
        View inflate = this.f26s == 0 ? this.f16i.inflate(C0861R.layout.action_item_horizontal, null) : this.f16i.inflate(C0861R.layout.action_item_vertical, null);
        ImageView imageView = (ImageView) inflate.findViewById(C0861R.id.iv_icon);
        TextView textView = (TextView) inflate.findViewById(C0861R.id.tv_title);
        if (b != null) {
            imageView.setImageDrawable(b);
        } else {
            imageView.setVisibility(8);
        }
        if (a != null) {
            textView.setText(a);
        } else {
            textView.setVisibility(8);
        }
        inflate.setOnClickListener(new C00031(this, this.f23p, c0000a.m2c()));
        inflate.setFocusable(true);
        inflate.setClickable(true);
        if (this.f26s == 0 && this.f23p != 0) {
            View inflate2 = this.f16i.inflate(C0861R.layout.horiz_separator, null);
            inflate2.setLayoutParams(new LayoutParams(-2, -1));
            inflate2.setPadding(5, 0, 5, 0);
            this.f17j.addView(inflate2, this.f24q);
            this.f24q++;
        }
        this.f17j.addView(inflate, this.f24q);
        this.f23p++;
        this.f24q++;
    }

    public void m16a(C0004a c0004a) {
        this.f19l = c0004a;
    }

    public void m17b(int i) {
        this.f13f = (ViewGroup) this.f16i.inflate(i, null);
        this.f17j = (ViewGroup) this.f13f.findViewById(C0861R.id.tracks);
        this.f15h = (ImageView) this.f13f.findViewById(C0861R.id.arrow_down);
        this.f14g = (ImageView) this.f13f.findViewById(C0861R.id.arrow_up);
        this.f18k = (ScrollView) this.f13f.findViewById(C0861R.id.scroller);
        this.f13f.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        m5a(this.f13f);
    }

    public void m18b(View view) {
        int i;
        int i2;
        int width;
        int i3;
        int i4;
        m6b();
        this.f22o = false;
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
        this.f13f.measure(-2, -2);
        int measuredHeight = this.f13f.getMeasuredHeight();
        if (this.f27t == 0) {
            this.f27t = this.f13f.getMeasuredWidth();
        }
        if (VERSION.SDK_INT >= 13) {
            Point point = new Point();
            this.e.getDefaultDisplay().getSize(point);
            i = point.x;
            i2 = point.y;
        } else {
            i = this.e.getDefaultDisplay().getWidth();
            i2 = this.e.getDefaultDisplay().getHeight();
        }
        if (rect.left + this.f27t > i) {
            width = rect.left - (this.f27t - view.getWidth());
            if (width < 0) {
                width = 0;
            }
            i3 = width;
            width = rect.centerX() - width;
        } else {
            width = view.getWidth() > this.f27t ? rect.centerX() - (this.f27t / 2) : rect.left;
            i3 = width;
            width = rect.centerX() - width;
        }
        int i5 = rect.top;
        int i6 = i2 - rect.bottom;
        boolean z = i5 > i6;
        if (!z) {
            i2 = rect.bottom;
            if (measuredHeight > i6) {
                this.f18k.getLayoutParams().height = i6;
            }
            i4 = i2;
        } else if (measuredHeight > i5) {
            this.f18k.getLayoutParams().height = i5 - view.getHeight();
            i4 = 15;
        } else {
            i4 = rect.top - measuredHeight;
        }
        m11a(z ? C0861R.id.arrow_down : C0861R.id.arrow_up, width);
        m12a(i, rect.centerX(), z);
        this.b.showAtLocation(view, 0, i3, i4);
    }

    public void m19c(int i) {
        this.f25r = i;
    }

    public void onDismiss() {
        if (!this.f22o && this.f20m != null) {
            this.f20m.m9a();
        }
    }
}
