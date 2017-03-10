package com.andi.alquran.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.preference.Preference;
import android.support.v7.recyclerview.BuildConfig;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.andi.alquran.App;
import com.andi.alquran.C0861R;

public class MySeekBarPreference extends Preference implements OnSeekBarChangeListener {
    private int f1726a;
    private int f1727b;
    private int f1728c;
    private int f1729d;
    private SeekBar f1730e;
    private TextView f1731f;

    public MySeekBarPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1726a = 60;
        this.f1727b = 0;
        this.f1728c = 1;
        m3087a(attributeSet);
    }

    public MySeekBarPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1726a = 60;
        this.f1727b = 0;
        this.f1728c = 1;
        m3087a(attributeSet);
    }

    private void m3087a(AttributeSet attributeSet) {
        this.f1726a = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "max", 60);
        this.f1727b = attributeSet.getAttributeIntValue("susilo", "min", 0);
        try {
            String attributeValue = attributeSet.getAttributeValue("susilo", "interval");
            if (attributeValue != null) {
                this.f1728c = Integer.parseInt(attributeValue);
            }
        } catch (NumberFormatException e) {
        }
    }

    protected void m3088a() {
        if (this.f1731f != null) {
            if (this.f1729d < 0) {
                this.f1731f.setText(App.m2860a().getString(C0861R.string.minute_minus) + " " + String.valueOf(this.f1729d).replace("-", BuildConfig.VERSION_NAME));
            } else if (this.f1729d == 0) {
                this.f1731f.setText(String.valueOf(this.f1729d));
            } else {
                this.f1731f.setText(App.m2860a().getString(C0861R.string.minute_plus) + " " + String.valueOf(this.f1729d));
            }
        }
        if (this.f1730e != null) {
            this.f1730e.setProgress(this.f1729d - this.f1727b);
        }
    }

    public void onBindView(View view) {
        super.onBindView(view);
        m3088a();
    }

    protected View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        View findViewById = onCreateView.findViewById(16908304);
        if (findViewById != null) {
            ViewParent parent = findViewById.getParent();
            if (parent instanceof ViewGroup) {
                ViewGroup viewGroup2 = (ViewGroup) parent;
                ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(C0861R.layout.pref_seekbarpreference, viewGroup2);
                this.f1730e = (SeekBar) viewGroup2.findViewById(C0861R.id.seekBar);
                this.f1730e.setMax(this.f1726a - this.f1727b);
                this.f1730e.setOnSeekBarChangeListener(this);
                this.f1731f = (TextView) viewGroup2.findViewById(C0861R.id.seekBarPrefValue);
            }
        }
        return onCreateView;
    }

    protected Object onGetDefaultValue(TypedArray typedArray, int i) {
        return Integer.valueOf(typedArray.getInt(i, 0));
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        int i2 = this.f1727b + i;
        if (i2 > this.f1726a) {
            i2 = this.f1726a;
        } else if (i2 < this.f1727b) {
            i2 = this.f1727b;
        } else if (!(this.f1728c == 1 || i2 % this.f1728c == 0)) {
            i2 = Math.round(((float) i2) / ((float) this.f1728c)) * this.f1728c;
        }
        if (callChangeListener(Integer.valueOf(i2))) {
            this.f1729d = i2;
            if (this.f1731f != null) {
                if (i2 < 0) {
                    this.f1731f.setText(App.m2860a().getString(C0861R.string.minute_minus) + " " + String.valueOf(i2).replace("-", BuildConfig.VERSION_NAME));
                } else if (i2 == 0) {
                    this.f1731f.setText(String.valueOf(i2));
                } else {
                    this.f1731f.setText(App.m2860a().getString(C0861R.string.minute_plus) + " " + String.valueOf(i2));
                }
            }
            persistInt(i2);
            return;
        }
        seekBar.setProgress(this.f1729d - this.f1727b);
    }

    protected void onSetInitialValue(boolean z, Object obj) {
        if (z) {
            this.f1729d = getPersistedInt(this.f1729d);
            return;
        }
        int i = 0;
        if (obj instanceof Integer) {
            i = ((Integer) obj).intValue();
        }
        persistInt(i);
        this.f1729d = i;
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        notifyChanged();
    }
}
