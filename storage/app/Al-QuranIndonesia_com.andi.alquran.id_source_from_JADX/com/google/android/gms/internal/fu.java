package com.google.android.gms.internal;

import android.support.v7.recyclerview.BuildConfig;
import java.util.PriorityQueue;

@op
public class fu {

    /* renamed from: com.google.android.gms.internal.fu.a */
    public static class C1581a {
        final long f4111a;
        final String f4112b;
        final int f4113c;

        C1581a(long j, String str, int i) {
            this.f4111a = j;
            this.f4112b = str;
            this.f4113c = i;
        }

        public boolean equals(Object obj) {
            return (obj == null || !(obj instanceof C1581a)) ? false : ((C1581a) obj).f4111a == this.f4111a && ((C1581a) obj).f4113c == this.f4113c;
        }

        public int hashCode() {
            return (int) this.f4111a;
        }
    }

    static long m6241a(int i, int i2, long j, long j2, long j3) {
        return ((((((j + 1073807359) - ((((((long) i) + 2147483647L) % 1073807359) * j2) % 1073807359)) % 1073807359) * j3) % 1073807359) + ((((long) i2) + 2147483647L) % 1073807359)) % 1073807359;
    }

    static long m6242a(long j, int i) {
        return i == 0 ? 1 : i != 1 ? i % 2 == 0 ? m6242a((j * j) % 1073807359, i / 2) % 1073807359 : ((m6242a((j * j) % 1073807359, i / 2) % 1073807359) * j) % 1073807359 : j;
    }

    static String m6243a(String[] strArr, int i, int i2) {
        if (strArr.length < i + i2) {
            sg.m8446c("Unable to construct shingle");
            return BuildConfig.VERSION_NAME;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = i; i3 < (i + i2) - 1; i3++) {
            stringBuffer.append(strArr[i3]);
            stringBuffer.append(' ');
        }
        stringBuffer.append(strArr[(i + i2) - 1]);
        return stringBuffer.toString();
    }

    static void m6244a(int i, long j, String str, int i2, PriorityQueue<C1581a> priorityQueue) {
        C1581a c1581a = new C1581a(j, str, i2);
        if ((priorityQueue.size() != i || (((C1581a) priorityQueue.peek()).f4113c <= c1581a.f4113c && ((C1581a) priorityQueue.peek()).f4111a <= c1581a.f4111a)) && !priorityQueue.contains(c1581a)) {
            priorityQueue.add(c1581a);
            if (priorityQueue.size() > i) {
                priorityQueue.poll();
            }
        }
    }

    public static void m6245a(String[] strArr, int i, int i2, PriorityQueue<C1581a> priorityQueue) {
        if (strArr.length < i2) {
            int i3 = i;
            m6244a(i3, m6246b(strArr, 0, strArr.length), m6243a(strArr, 0, strArr.length), strArr.length, (PriorityQueue) priorityQueue);
            return;
        }
        long b = m6246b(strArr, 0, i2);
        m6244a(i, b, m6243a(strArr, 0, i2), i2, (PriorityQueue) priorityQueue);
        long a = m6242a(16785407, i2 - 1);
        int i4 = 1;
        while (i4 < (strArr.length - i2) + 1) {
            long a2 = m6241a(fs.m6230a(strArr[i4 - 1]), fs.m6230a(strArr[(i4 + i2) - 1]), b, a, 16785407);
            m6244a(i, a2, m6243a(strArr, i4, i2), strArr.length, (PriorityQueue) priorityQueue);
            i4++;
            b = a2;
        }
    }

    private static long m6246b(String[] strArr, int i, int i2) {
        long a = (((long) fs.m6230a(strArr[i])) + 2147483647L) % 1073807359;
        for (int i3 = i + 1; i3 < i + i2; i3++) {
            a = (((a * 16785407) % 1073807359) + ((((long) fs.m6230a(strArr[i3])) + 2147483647L) % 1073807359)) % 1073807359;
        }
        return a;
    }
}
