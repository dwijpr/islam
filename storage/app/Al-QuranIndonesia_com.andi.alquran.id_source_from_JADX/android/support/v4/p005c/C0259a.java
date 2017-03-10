package android.support.v4.p005c;

import android.graphics.Color;

/* renamed from: android.support.v4.c.a */
public final class C0259a {
    private static final ThreadLocal<double[]> f578a;

    static {
        f578a = new ThreadLocal();
    }

    public static int m903a(int i, int i2) {
        int alpha = Color.alpha(i2);
        int alpha2 = Color.alpha(i);
        int c = C0259a.m906c(alpha2, alpha);
        return Color.argb(c, C0259a.m904a(Color.red(i), alpha2, Color.red(i2), alpha, c), C0259a.m904a(Color.green(i), alpha2, Color.green(i2), alpha, c), C0259a.m904a(Color.blue(i), alpha2, Color.blue(i2), alpha, c));
    }

    private static int m904a(int i, int i2, int i3, int i4, int i5) {
        return i5 == 0 ? 0 : (((i * 255) * i2) + ((i3 * i4) * (255 - i2))) / (i5 * 255);
    }

    public static int m905b(int i, int i2) {
        if (i2 >= 0 && i2 <= 255) {
            return (16777215 & i) | (i2 << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }

    private static int m906c(int i, int i2) {
        return 255 - (((255 - i2) * (255 - i)) / 255);
    }
}
