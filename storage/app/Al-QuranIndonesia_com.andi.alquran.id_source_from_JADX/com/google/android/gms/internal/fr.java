package com.google.android.gms.internal;

import android.support.v7.recyclerview.BuildConfig;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.util.Base64OutputStream;
import com.google.android.gms.internal.fu.C1581a;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

@op
public class fr {
    private final int f4106a;
    private final int f4107b;
    private final int f4108c;
    private final fq f4109d;

    /* renamed from: com.google.android.gms.internal.fr.1 */
    class C15791 implements Comparator<C1581a> {
        C15791(fr frVar) {
        }

        public int m6225a(C1581a c1581a, C1581a c1581a2) {
            int i = c1581a.f4113c - c1581a2.f4113c;
            return i != 0 ? i : (int) (c1581a.f4111a - c1581a2.f4111a);
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m6225a((C1581a) obj, (C1581a) obj2);
        }
    }

    /* renamed from: com.google.android.gms.internal.fr.a */
    static class C1580a {
        ByteArrayOutputStream f4104a;
        Base64OutputStream f4105b;

        public C1580a() {
            this.f4104a = new ByteArrayOutputStream(ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT);
            this.f4105b = new Base64OutputStream(this.f4104a, 10);
        }

        public void m6226a(byte[] bArr) {
            this.f4105b.write(bArr);
        }

        public String toString() {
            String byteArrayOutputStream;
            try {
                this.f4105b.close();
            } catch (Throwable e) {
                sg.m8445b("HashManager: Unable to convert to Base64.", e);
            }
            try {
                this.f4104a.close();
                byteArrayOutputStream = this.f4104a.toString();
            } catch (Throwable e2) {
                sg.m8445b("HashManager: Unable to convert to Base64.", e2);
                byteArrayOutputStream = BuildConfig.VERSION_NAME;
            } finally {
                this.f4104a = null;
                this.f4105b = null;
            }
            return byteArrayOutputStream;
        }
    }

    public fr(int i) {
        this.f4109d = new ft();
        this.f4107b = i;
        this.f4106a = 6;
        this.f4108c = 0;
    }

    C1580a m6227a() {
        return new C1580a();
    }

    String m6228a(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return BuildConfig.VERSION_NAME;
        }
        C1580a a = m6227a();
        PriorityQueue priorityQueue = new PriorityQueue(this.f4107b, new C15791(this));
        for (String b : split) {
            String[] b2 = fs.m6235b(b);
            if (b2.length != 0) {
                fu.m6245a(b2, this.f4107b, this.f4106a, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                a.m6226a(this.f4109d.m6224a(((C1581a) it.next()).f4112b));
            } catch (Throwable e) {
                sg.m8445b("Error while writing hash to byteStream", e);
            }
        }
        return a.toString();
    }

    public String m6229a(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(((String) it.next()).toLowerCase(Locale.US));
            stringBuffer.append('\n');
        }
        return m6228a(stringBuffer.toString());
    }
}
