package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.maps.GoogleMap;
import java.util.List;

@op
class iw extends RelativeLayout {
    private static final float[] f4446a;
    private final RelativeLayout f4447b;
    private AnimationDrawable f4448c;

    static {
        f4446a = new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f};
    }

    public iw(Context context, iv ivVar) {
        super(context);
        C1314c.m4623a((Object) ivVar);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        switch (ivVar.m6782g()) {
            case GoogleMap.MAP_TYPE_NONE /*0*/:
                layoutParams.addRule(10);
                layoutParams.addRule(9);
                break;
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                layoutParams.addRule(12);
                layoutParams.addRule(11);
                break;
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                layoutParams.addRule(12);
                layoutParams.addRule(9);
                break;
            default:
                layoutParams.addRule(10);
                layoutParams.addRule(11);
                break;
        }
        Drawable shapeDrawable = new ShapeDrawable(new RoundRectShape(f4446a, null, null));
        shapeDrawable.getPaint().setColor(ivVar.m6778c());
        this.f4447b = new RelativeLayout(context);
        this.f4447b.setLayoutParams(layoutParams);
        zzv.zzcL().m8567a(this.f4447b, shapeDrawable);
        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (!TextUtils.isEmpty(ivVar.m6776a())) {
            LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            View textView = new TextView(context);
            textView.setLayoutParams(layoutParams2);
            textView.setId(1195835393);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setText(ivVar.m6776a());
            textView.setTextColor(ivVar.m6779d());
            textView.setTextSize((float) ivVar.m6780e());
            textView.setPadding(gr.m6416a().m8690a(context, 4), 0, gr.m6416a().m8690a(context, 4), 0);
            this.f4447b.addView(textView);
            layoutParams.addRule(1, textView.getId());
        }
        View imageView = new ImageView(context);
        imageView.setLayoutParams(layoutParams);
        imageView.setId(1195835394);
        List<Drawable> b = ivVar.m6777b();
        if (b.size() > 1) {
            this.f4448c = new AnimationDrawable();
            for (Drawable addFrame : b) {
                this.f4448c.addFrame(addFrame, ivVar.m6781f());
            }
            zzv.zzcL().m8567a(imageView, this.f4448c);
        } else if (b.size() == 1) {
            imageView.setImageDrawable((Drawable) b.get(0));
        }
        this.f4447b.addView(imageView);
        addView(this.f4447b);
    }

    public ViewGroup m6783a() {
        return this.f4447b;
    }

    public void onAttachedToWindow() {
        if (this.f4448c != null) {
            this.f4448c.start();
        }
        super.onAttachedToWindow();
    }
}
