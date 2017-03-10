package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* renamed from: com.google.android.gms.common.internal.safeparcel.b */
public class C1355b {
    public static int m4826a(Parcel parcel) {
        return C1355b.m4848b(parcel, 20293);
    }

    public static void m4827a(Parcel parcel, int i) {
        C1355b.m4851c(parcel, i);
    }

    public static void m4828a(Parcel parcel, int i, byte b) {
        C1355b.m4849b(parcel, i, 4);
        parcel.writeInt(b);
    }

    public static void m4829a(Parcel parcel, int i, double d) {
        C1355b.m4849b(parcel, i, 8);
        parcel.writeDouble(d);
    }

    public static void m4830a(Parcel parcel, int i, float f) {
        C1355b.m4849b(parcel, i, 4);
        parcel.writeFloat(f);
    }

    public static void m4831a(Parcel parcel, int i, int i2) {
        C1355b.m4849b(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static void m4832a(Parcel parcel, int i, long j) {
        C1355b.m4849b(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void m4833a(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle != null) {
            int b = C1355b.m4848b(parcel, i);
            parcel.writeBundle(bundle);
            C1355b.m4851c(parcel, b);
        } else if (z) {
            C1355b.m4849b(parcel, i, 0);
        }
    }

    public static void m4834a(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder != null) {
            int b = C1355b.m4848b(parcel, i);
            parcel.writeStrongBinder(iBinder);
            C1355b.m4851c(parcel, b);
        } else if (z) {
            C1355b.m4849b(parcel, i, 0);
        }
    }

    public static void m4835a(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable != null) {
            int b = C1355b.m4848b(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            C1355b.m4851c(parcel, b);
        } else if (z) {
            C1355b.m4849b(parcel, i, 0);
        }
    }

    public static void m4836a(Parcel parcel, int i, Float f, boolean z) {
        if (f != null) {
            C1355b.m4849b(parcel, i, 4);
            parcel.writeFloat(f.floatValue());
        } else if (z) {
            C1355b.m4849b(parcel, i, 0);
        }
    }

    public static void m4837a(Parcel parcel, int i, Integer num, boolean z) {
        if (num != null) {
            C1355b.m4849b(parcel, i, 4);
            parcel.writeInt(num.intValue());
        } else if (z) {
            C1355b.m4849b(parcel, i, 0);
        }
    }

    public static void m4838a(Parcel parcel, int i, String str, boolean z) {
        if (str != null) {
            int b = C1355b.m4848b(parcel, i);
            parcel.writeString(str);
            C1355b.m4851c(parcel, b);
        } else if (z) {
            C1355b.m4849b(parcel, i, 0);
        }
    }

    public static void m4839a(Parcel parcel, int i, List<Integer> list, boolean z) {
        if (list != null) {
            int b = C1355b.m4848b(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(((Integer) list.get(i2)).intValue());
            }
            C1355b.m4851c(parcel, b);
        } else if (z) {
            C1355b.m4849b(parcel, i, 0);
        }
    }

    public static void m4840a(Parcel parcel, int i, short s) {
        C1355b.m4849b(parcel, i, 4);
        parcel.writeInt(s);
    }

    public static void m4841a(Parcel parcel, int i, boolean z) {
        C1355b.m4849b(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void m4842a(Parcel parcel, int i, byte[] bArr, boolean z) {
        if (bArr != null) {
            int b = C1355b.m4848b(parcel, i);
            parcel.writeByteArray(bArr);
            C1355b.m4851c(parcel, b);
        } else if (z) {
            C1355b.m4849b(parcel, i, 0);
        }
    }

    public static void m4843a(Parcel parcel, int i, int[] iArr, boolean z) {
        if (iArr != null) {
            int b = C1355b.m4848b(parcel, i);
            parcel.writeIntArray(iArr);
            C1355b.m4851c(parcel, b);
        } else if (z) {
            C1355b.m4849b(parcel, i, 0);
        }
    }

    public static <T extends Parcelable> void m4844a(Parcel parcel, int i, T[] tArr, int i2, boolean z) {
        if (tArr != null) {
            int b = C1355b.m4848b(parcel, i);
            parcel.writeInt(r3);
            for (Parcelable parcelable : tArr) {
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    C1355b.m4847a(parcel, parcelable, i2);
                }
            }
            C1355b.m4851c(parcel, b);
        } else if (z) {
            C1355b.m4849b(parcel, i, 0);
        }
    }

    public static void m4845a(Parcel parcel, int i, String[] strArr, boolean z) {
        if (strArr != null) {
            int b = C1355b.m4848b(parcel, i);
            parcel.writeStringArray(strArr);
            C1355b.m4851c(parcel, b);
        } else if (z) {
            C1355b.m4849b(parcel, i, 0);
        }
    }

    public static void m4846a(Parcel parcel, int i, byte[][] bArr, boolean z) {
        int i2 = 0;
        if (bArr != null) {
            int b = C1355b.m4848b(parcel, i);
            int length = bArr.length;
            parcel.writeInt(length);
            while (i2 < length) {
                parcel.writeByteArray(bArr[i2]);
                i2++;
            }
            C1355b.m4851c(parcel, b);
        } else if (z) {
            C1355b.m4849b(parcel, i, 0);
        }
    }

    private static <T extends Parcelable> void m4847a(Parcel parcel, T t, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    private static int m4848b(Parcel parcel, int i) {
        parcel.writeInt(-65536 | i);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void m4849b(Parcel parcel, int i, int i2) {
        if (i2 >= 65535) {
            parcel.writeInt(-65536 | i);
            parcel.writeInt(i2);
            return;
        }
        parcel.writeInt((i2 << 16) | i);
    }

    public static void m4850b(Parcel parcel, int i, List<String> list, boolean z) {
        if (list != null) {
            int b = C1355b.m4848b(parcel, i);
            parcel.writeStringList(list);
            C1355b.m4851c(parcel, b);
        } else if (z) {
            C1355b.m4849b(parcel, i, 0);
        }
    }

    private static void m4851c(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        int i2 = dataPosition - i;
        parcel.setDataPosition(i - 4);
        parcel.writeInt(i2);
        parcel.setDataPosition(dataPosition);
    }

    public static <T extends Parcelable> void m4852c(Parcel parcel, int i, List<T> list, boolean z) {
        if (list != null) {
            int b = C1355b.m4848b(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                Parcelable parcelable = (Parcelable) list.get(i2);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    C1355b.m4847a(parcel, parcelable, 0);
                }
            }
            C1355b.m4851c(parcel, b);
        } else if (z) {
            C1355b.m4849b(parcel, i, 0);
        }
    }

    public static void m4853d(Parcel parcel, int i, List list, boolean z) {
        if (list != null) {
            int b = C1355b.m4848b(parcel, i);
            parcel.writeList(list);
            C1355b.m4851c(parcel, b);
        } else if (z) {
            C1355b.m4849b(parcel, i, 0);
        }
    }
}
