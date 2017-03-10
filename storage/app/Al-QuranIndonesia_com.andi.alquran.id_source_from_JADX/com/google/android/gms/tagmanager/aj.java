package com.google.android.gms.tagmanager;

import android.support.v7.recyclerview.BuildConfig;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.internal.aw.C1450a;
import com.google.android.gms.maps.GoogleMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class aj {
    private static final Object f7055a;
    private static Long f7056b;
    private static Double f7057c;
    private static ai f7058d;
    private static String f7059e;
    private static Boolean f7060f;
    private static List<Object> f7061g;
    private static Map<Object, Object> f7062h;
    private static C1450a f7063i;

    static {
        f7055a = null;
        f7056b = new Long(0);
        f7057c = new Double(0.0d);
        f7058d = ai.m10133a(0);
        f7059e = new String(BuildConfig.VERSION_NAME);
        f7060f = new Boolean(false);
        f7061g = new ArrayList(0);
        f7062h = new HashMap();
        f7063i = m10146c(f7059e);
    }

    public static C1450a m10140a() {
        return f7063i;
    }

    private static Boolean m10141a(String str) {
        return "true".equalsIgnoreCase(str) ? Boolean.TRUE : "false".equalsIgnoreCase(str) ? Boolean.FALSE : f7060f;
    }

    public static String m10142a(C1450a c1450a) {
        return m10143a(m10147c(c1450a));
    }

    public static String m10143a(Object obj) {
        return obj == null ? f7059e : obj.toString();
    }

    public static Boolean m10144b(C1450a c1450a) {
        return m10145b(m10147c(c1450a));
    }

    public static Boolean m10145b(Object obj) {
        return obj instanceof Boolean ? (Boolean) obj : m10141a(m10143a(obj));
    }

    public static C1450a m10146c(Object obj) {
        boolean z = false;
        C1450a c1450a = new C1450a();
        if (obj instanceof C1450a) {
            return (C1450a) obj;
        }
        if (obj instanceof String) {
            c1450a.f3503a = 1;
            c1450a.f3504b = (String) obj;
        } else if (obj instanceof List) {
            c1450a.f3503a = 2;
            List<Object> list = (List) obj;
            r5 = new ArrayList(list.size());
            r1 = false;
            for (Object c : list) {
                C1450a c2 = m10146c(c);
                if (c2 == f7063i) {
                    return f7063i;
                }
                r0 = r1 || c2.f3514l;
                r5.add(c2);
                r1 = r0;
            }
            c1450a.f3505c = (C1450a[]) r5.toArray(new C1450a[0]);
            z = r1;
        } else if (obj instanceof Map) {
            c1450a.f3503a = 3;
            Set<Entry> entrySet = ((Map) obj).entrySet();
            r5 = new ArrayList(entrySet.size());
            List arrayList = new ArrayList(entrySet.size());
            r1 = false;
            for (Entry entry : entrySet) {
                C1450a c3 = m10146c(entry.getKey());
                C1450a c4 = m10146c(entry.getValue());
                if (c3 == f7063i || c4 == f7063i) {
                    return f7063i;
                }
                r0 = r1 || c3.f3514l || c4.f3514l;
                r5.add(c3);
                arrayList.add(c4);
                r1 = r0;
            }
            c1450a.f3506d = (C1450a[]) r5.toArray(new C1450a[0]);
            c1450a.f3507e = (C1450a[]) arrayList.toArray(new C1450a[0]);
            z = r1;
        } else if (m10148d(obj)) {
            c1450a.f3503a = 1;
            c1450a.f3504b = obj.toString();
        } else if (m10149e(obj)) {
            c1450a.f3503a = 6;
            c1450a.f3510h = m10150f(obj);
        } else if (obj instanceof Boolean) {
            c1450a.f3503a = 8;
            c1450a.f3511i = ((Boolean) obj).booleanValue();
        } else {
            String str = "Converting to Value from unknown object type: ";
            String valueOf = String.valueOf(obj == null ? "null" : obj.getClass().toString());
            C2238n.m10264a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            return f7063i;
        }
        c1450a.f3514l = z;
        return c1450a;
    }

    public static Object m10147c(C1450a c1450a) {
        int i = 0;
        if (c1450a == null) {
            return null;
        }
        C1450a[] c1450aArr;
        int length;
        switch (c1450a.f3503a) {
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                return c1450a.f3504b;
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                ArrayList arrayList = new ArrayList(c1450a.f3505c.length);
                c1450aArr = c1450a.f3505c;
                length = c1450aArr.length;
                while (i < length) {
                    Object c = m10147c(c1450aArr[i]);
                    if (c == null) {
                        return null;
                    }
                    arrayList.add(c);
                    i++;
                }
                return arrayList;
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                if (c1450a.f3506d.length != c1450a.f3507e.length) {
                    String str = "Converting an invalid value to object: ";
                    String valueOf = String.valueOf(c1450a.toString());
                    C2238n.m10264a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                    return null;
                }
                Map hashMap = new HashMap(c1450a.f3507e.length);
                while (i < c1450a.f3506d.length) {
                    Object c2 = m10147c(c1450a.f3506d[i]);
                    Object c3 = m10147c(c1450a.f3507e[i]);
                    if (c2 == null || c3 == null) {
                        return null;
                    }
                    hashMap.put(c2, c3);
                    i++;
                }
                return hashMap;
            case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                C2238n.m10264a("Trying to convert a macro reference to object");
                return null;
            case C1096c.MapAttrs_cameraZoom /*5*/:
                C2238n.m10264a("Trying to convert a function id to object");
                return null;
            case C1096c.MapAttrs_liteMode /*6*/:
                return Long.valueOf(c1450a.f3510h);
            case C1096c.MapAttrs_uiCompass /*7*/:
                StringBuffer stringBuffer = new StringBuffer();
                c1450aArr = c1450a.f3512j;
                length = c1450aArr.length;
                while (i < length) {
                    String a = m10142a(c1450aArr[i]);
                    if (a == f7059e) {
                        return null;
                    }
                    stringBuffer.append(a);
                    i++;
                }
                return stringBuffer.toString();
            case C1096c.MapAttrs_uiRotateGestures /*8*/:
                return Boolean.valueOf(c1450a.f3511i);
            default:
                C2238n.m10264a("Failed to convert a value of type: " + c1450a.f3503a);
                return null;
        }
    }

    private static boolean m10148d(Object obj) {
        return (obj instanceof Double) || (obj instanceof Float) || ((obj instanceof ai) && ((ai) obj).m10135a());
    }

    private static boolean m10149e(Object obj) {
        return (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || ((obj instanceof ai) && ((ai) obj).m10136b());
    }

    private static long m10150f(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        C2238n.m10264a("getInt64 received non-Number");
        return 0;
    }
}
