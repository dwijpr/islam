package android.support.v4.p014g;

import android.support.v4.app.NotificationCompat;
import android.util.Log;
import java.io.Writer;

/* renamed from: android.support.v4.g.d */
public class C0301d extends Writer {
    private final String f634a;
    private StringBuilder f635b;

    public C0301d(String str) {
        this.f635b = new StringBuilder(NotificationCompat.FLAG_HIGH_PRIORITY);
        this.f634a = str;
    }

    private void m1014a() {
        if (this.f635b.length() > 0) {
            Log.d(this.f634a, this.f635b.toString());
            this.f635b.delete(0, this.f635b.length());
        }
    }

    public void close() {
        m1014a();
    }

    public void flush() {
        m1014a();
    }

    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                m1014a();
            } else {
                this.f635b.append(c);
            }
        }
    }
}
