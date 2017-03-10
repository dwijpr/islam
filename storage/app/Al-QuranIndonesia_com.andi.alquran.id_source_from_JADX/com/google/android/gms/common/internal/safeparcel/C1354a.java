package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.common.internal.safeparcel.a */
public class C1354a {

    /* renamed from: com.google.android.gms.common.internal.safeparcel.a.a */
    public static class C1353a extends RuntimeException {
        public C1353a(String str, Parcel parcel) {
            int dataPosition = parcel.dataPosition();
            super(new StringBuilder(String.valueOf(str).length() + 41).append(str).append(" Parcel: pos=").append(dataPosition).append(" size=").append(parcel.dataSize()).toString());
        }
    }

    public static int m4797a(int i) {
        return 65535 & i;
    }

    public static int m4798a(Parcel parcel) {
        return parcel.readInt();
    }

    public static int m4799a(Parcel parcel, int i) {
        return (i & -65536) != -65536 ? (i >> 16) & 65535 : parcel.readInt();
    }

    public static <T extends Parcelable> T m4800a(Parcel parcel, int i, Creator<T> creator) {
        int a = C1354a.m4799a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(a + dataPosition);
        return parcelable;
    }

    private static void m4801a(Parcel parcel, int i, int i2) {
        int a = C1354a.m4799a(parcel, i);
        if (a != i2) {
            String valueOf = String.valueOf(Integer.toHexString(a));
            throw new C1353a(new StringBuilder(String.valueOf(valueOf).length() + 46).append("Expected size ").append(i2).append(" got ").append(a).append(" (0x").append(valueOf).append(")").toString(), parcel);
        }
    }

    private static void m4802a(Parcel parcel, int i, int i2, int i3) {
        if (i2 != i3) {
            String valueOf = String.valueOf(Integer.toHexString(i2));
            throw new C1353a(new StringBuilder(String.valueOf(valueOf).length() + 46).append("Expected size ").append(i3).append(" got ").append(i2).append(" (0x").append(valueOf).append(")").toString(), parcel);
        }
    }

    public static void m4803a(Parcel parcel, int i, List list, ClassLoader classLoader) {
        int a = C1354a.m4799a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a != 0) {
            parcel.readList(list, classLoader);
            parcel.setDataPosition(a + dataPosition);
        }
    }

    public static int m4804b(Parcel parcel) {
        int a = C1354a.m4798a(parcel);
        int a2 = C1354a.m4799a(parcel, a);
        int dataPosition = parcel.dataPosition();
        if (C1354a.m4797a(a) != 20293) {
            String str = "Expected object header. Got 0x";
            String valueOf = String.valueOf(Integer.toHexString(a));
            throw new C1353a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), parcel);
        }
        a = dataPosition + a2;
        if (a >= dataPosition && a <= parcel.dataSize()) {
            return a;
        }
        throw new C1353a("Size read is invalid start=" + dataPosition + " end=" + a, parcel);
    }

    public static void m4805b(Parcel parcel, int i) {
        parcel.setDataPosition(C1354a.m4799a(parcel, i) + parcel.dataPosition());
    }

    public static <T> T[] m4806b(Parcel parcel, int i, Creator<T> creator) {
        int a = C1354a.m4799a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        T[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(a + dataPosition);
        return createTypedArray;
    }

    public static <T> ArrayList<T> m4807c(Parcel parcel, int i, Creator<T> creator) {
        int a = C1354a.m4799a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(a + dataPosition);
        return createTypedArrayList;
    }

    public static boolean m4808c(Parcel parcel, int i) {
        C1354a.m4801a(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static byte m4809d(Parcel parcel, int i) {
        C1354a.m4801a(parcel, i, 4);
        return (byte) parcel.readInt();
    }

    public static short m4810e(Parcel parcel, int i) {
        C1354a.m4801a(parcel, i, 4);
        return (short) parcel.readInt();
    }

    public static int m4811f(Parcel parcel, int i) {
        C1354a.m4801a(parcel, i, 4);
        return parcel.readInt();
    }

    public static Integer m4812g(Parcel parcel, int i) {
        int a = C1354a.m4799a(parcel, i);
        if (a == 0) {
            return null;
        }
        C1354a.m4802a(parcel, i, a, 4);
        return Integer.valueOf(parcel.readInt());
    }

    public static long m4813h(Parcel parcel, int i) {
        C1354a.m4801a(parcel, i, 8);
        return parcel.readLong();
    }

    public static float m4814i(Parcel parcel, int i) {
        C1354a.m4801a(parcel, i, 4);
        return parcel.readFloat();
    }

    public static Float m4815j(Parcel parcel, int i) {
        int a = C1354a.m4799a(parcel, i);
        if (a == 0) {
            return null;
        }
        C1354a.m4802a(parcel, i, a, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static double m4816k(Parcel parcel, int i) {
        C1354a.m4801a(parcel, i, 8);
        return parcel.readDouble();
    }

    public static String m4817l(Parcel parcel, int i) {
        int a = C1354a.m4799a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(a + dataPosition);
        return readString;
    }

    public static IBinder m4818m(Parcel parcel, int i) {
        int a = C1354a.m4799a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(a + dataPosition);
        return readStrongBinder;
    }

    public static Bundle m4819n(Parcel parcel, int i) {
        int a = C1354a.m4799a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(a + dataPosition);
        return readBundle;
    }

    public static byte[] m4820o(Parcel parcel, int i) {
        int a = C1354a.m4799a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(a + dataPosition);
        return createByteArray;
    }

    public static byte[][] m4821p(Parcel parcel, int i) {
        int a = C1354a.m4799a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        byte[][] bArr = new byte[readInt][];
        for (int i2 = 0; i2 < readInt; i2++) {
            bArr[i2] = parcel.createByteArray();
        }
        parcel.setDataPosition(dataPosition + a);
        return bArr;
    }

    public static int[] m4822q(Parcel parcel, int i) {
        int a = C1354a.m4799a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(a + dataPosition);
        return createIntArray;
    }

    public static String[] m4823r(Parcel parcel, int i) {
        int a = C1354a.m4799a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(a + dataPosition);
        return createStringArray;
    }

    public static ArrayList<Integer> m4824s(Parcel parcel, int i) {
        int a = C1354a.m4799a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(Integer.valueOf(parcel.readInt()));
        }
        parcel.setDataPosition(dataPosition + a);
        return arrayList;
    }

    public static ArrayList<String> m4825t(Parcel parcel, int i) {
        int a = C1354a.m4799a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(a + dataPosition);
        return createStringArrayList;
    }
}
