package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public class dk {
    public static final Uri f3793a;
    public static final Uri f3794b;
    public static final Pattern f3795c;
    public static final Pattern f3796d;
    static HashMap<String, String> f3797e;
    static String[] f3798f;
    private static final AtomicBoolean f3799g;
    private static Object f3800h;
    private static boolean f3801i;

    /* renamed from: com.google.android.gms.internal.dk.1 */
    class C15231 extends ContentObserver {
        C15231(Handler handler) {
            super(handler);
        }

        public void onChange(boolean z) {
            dk.f3799g.set(true);
        }
    }

    static {
        f3793a = Uri.parse("content://com.google.android.gsf.gservices");
        f3794b = Uri.parse("content://com.google.android.gsf.gservices/prefix");
        f3795c = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
        f3796d = Pattern.compile("^(0|false|f|off|no|n)$", 2);
        f3799g = new AtomicBoolean();
        f3798f = new String[0];
    }

    public static long m5747a(ContentResolver contentResolver, String str, long j) {
        String a = m5748a(contentResolver, str);
        if (a != null) {
            try {
                j = Long.parseLong(a);
            } catch (NumberFormatException e) {
            }
        }
        return j;
    }

    @Deprecated
    public static String m5748a(ContentResolver contentResolver, String str) {
        return m5749a(contentResolver, str, null);
    }

    public static String m5749a(ContentResolver contentResolver, String str, String str2) {
        synchronized (dk.class) {
            m5752a(contentResolver);
            Object obj = f3800h;
            String str3;
            if (f3797e.containsKey(str)) {
                str3 = (String) f3797e.get(str);
                if (str3 != null) {
                    str2 = str3;
                }
            } else {
                String[] strArr = f3798f;
                int length = strArr.length;
                int i = 0;
                while (i < length) {
                    if (str.startsWith(strArr[i])) {
                        if (!f3801i || f3797e.isEmpty()) {
                            m5756c(contentResolver, f3798f);
                            if (f3797e.containsKey(str)) {
                                str3 = (String) f3797e.get(str);
                                if (str3 != null) {
                                    str2 = str3;
                                }
                            }
                        }
                    } else {
                        i++;
                    }
                }
                Cursor query = contentResolver.query(f3793a, null, null, new String[]{str}, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            str3 = query.getString(1);
                            if (str3 != null && str3.equals(str2)) {
                                str3 = str2;
                            }
                            m5753a(obj, str, str3);
                            if (str3 != null) {
                                str2 = str3;
                            }
                            if (query != null) {
                                query.close();
                            }
                        }
                    } catch (Throwable th) {
                        if (query != null) {
                            query.close();
                        }
                    }
                }
                m5753a(obj, str, null);
                if (query != null) {
                    query.close();
                }
            }
        }
        return str2;
    }

    public static Map<String, String> m5750a(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(f3794b, null, null, strArr, null);
        Map<String, String> treeMap = new TreeMap();
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    treeMap.put(query.getString(0), query.getString(1));
                } finally {
                    query.close();
                }
            }
        }
        return treeMap;
    }

    private static void m5752a(ContentResolver contentResolver) {
        if (f3797e == null) {
            f3799g.set(false);
            f3797e = new HashMap();
            f3800h = new Object();
            f3801i = false;
            contentResolver.registerContentObserver(f3793a, true, new C15231(null));
        } else if (f3799g.getAndSet(false)) {
            f3797e.clear();
            f3800h = new Object();
            f3801i = false;
        }
    }

    private static void m5753a(Object obj, String str, String str2) {
        synchronized (dk.class) {
            if (obj == f3800h) {
                f3797e.put(str, str2);
            }
        }
    }

    private static String[] m5754a(String[] strArr) {
        HashSet hashSet = new HashSet((((f3798f.length + strArr.length) * 4) / 3) + 1);
        hashSet.addAll(Arrays.asList(f3798f));
        ArrayList arrayList = new ArrayList();
        for (Object obj : strArr) {
            if (hashSet.add(obj)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return new String[0];
        }
        f3798f = (String[]) hashSet.toArray(new String[hashSet.size()]);
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static void m5755b(ContentResolver contentResolver, String... strArr) {
        if (strArr.length != 0) {
            synchronized (dk.class) {
                m5752a(contentResolver);
                String[] a = m5754a(strArr);
                if (!f3801i || f3797e.isEmpty()) {
                    m5756c(contentResolver, f3798f);
                } else if (a.length != 0) {
                    m5756c(contentResolver, a);
                }
            }
        }
    }

    private static void m5756c(ContentResolver contentResolver, String[] strArr) {
        f3797e.putAll(m5750a(contentResolver, strArr));
        f3801i = true;
    }
}
