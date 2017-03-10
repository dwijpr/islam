package com.andi.alquran.p032j;

import android.support.v7.recyclerview.BuildConfig;
import android.text.InputFilter;
import android.text.Spanned;

/* renamed from: com.andi.alquran.j.g */
public class C0947g implements InputFilter {
    private int f1897a;
    private int f1898b;

    public C0947g(int i, int i2) {
        this.f1897a = i;
        this.f1898b = i2;
    }

    private boolean m3285a(int i, int i2, int i3) {
        return i2 > i ? i3 >= i && i3 <= i2 : i3 >= i2 && i3 <= i;
    }

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        try {
            if (m3285a(this.f1897a, this.f1898b, Integer.parseInt(spanned.toString() + charSequence.toString()))) {
                return null;
            }
        } catch (NumberFormatException e) {
        }
        return BuildConfig.VERSION_NAME;
    }
}
