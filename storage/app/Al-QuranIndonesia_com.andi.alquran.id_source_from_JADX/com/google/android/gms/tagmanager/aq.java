package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.common.util.C1377c;
import com.google.android.gms.common.util.C1379e;
import com.google.android.gms.tagmanager.C2220c.C2213c;
import com.google.android.gms.tagmanager.C2220c.C2213c.C2217a;
import com.google.android.gms.tagmanager.C2220c.C2219a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class aq implements C2213c {
    private static final String f7082a;
    private final Executor f7083b;
    private final Context f7084c;
    private C2211a f7085d;
    private C1377c f7086e;
    private int f7087f;

    /* renamed from: com.google.android.gms.tagmanager.aq.1 */
    class C22091 implements Runnable {
        final /* synthetic */ List f7074a;
        final /* synthetic */ long f7075b;
        final /* synthetic */ aq f7076c;

        C22091(aq aqVar, List list, long j) {
            this.f7076c = aqVar;
            this.f7074a = list;
            this.f7075b = j;
        }

        public void run() {
            this.f7076c.m10194b(this.f7074a, this.f7075b);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.aq.2 */
    class C22102 implements Runnable {
        final /* synthetic */ C2217a f7077a;
        final /* synthetic */ aq f7078b;

        C22102(aq aqVar, C2217a c2217a) {
            this.f7078b = aqVar;
            this.f7077a = c2217a;
        }

        public void run() {
            this.f7077a.m10216a(this.f7078b.m10191b());
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.aq.a */
    class C2211a extends SQLiteOpenHelper {
        final /* synthetic */ aq f7079a;

        C2211a(aq aqVar, Context context, String str) {
            this.f7079a = aqVar;
            super(context, str, null, 1);
        }

        private void m10176a(SQLiteDatabase sQLiteDatabase) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM datalayer WHERE 0", null);
            Set hashSet = new HashSet();
            try {
                String[] columnNames = rawQuery.getColumnNames();
                for (Object add : columnNames) {
                    hashSet.add(add);
                }
                if (!hashSet.remove("key") || !hashSet.remove("value") || !hashSet.remove("ID") || !hashSet.remove("expires")) {
                    throw new SQLiteException("Database column missing");
                } else if (!hashSet.isEmpty()) {
                    throw new SQLiteException("Database has extra columns");
                }
            } finally {
                rawQuery.close();
            }
        }

        private boolean m10177a(String str, SQLiteDatabase sQLiteDatabase) {
            Cursor cursor;
            String str2;
            String valueOf;
            Throwable th;
            Cursor cursor2 = null;
            try {
                Cursor query = sQLiteDatabase.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                try {
                    boolean moveToFirst = query.moveToFirst();
                    if (query == null) {
                        return moveToFirst;
                    }
                    query.close();
                    return moveToFirst;
                } catch (SQLiteException e) {
                    cursor = query;
                    try {
                        str2 = "Error querying for table ";
                        valueOf = String.valueOf(str);
                        C2238n.m10266b(valueOf.length() == 0 ? new String(str2) : str2.concat(valueOf));
                        if (cursor != null) {
                            cursor.close();
                        }
                        return false;
                    } catch (Throwable th2) {
                        cursor2 = cursor;
                        th = th2;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor2 = query;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e2) {
                cursor = null;
                str2 = "Error querying for table ";
                valueOf = String.valueOf(str);
                if (valueOf.length() == 0) {
                }
                C2238n.m10266b(valueOf.length() == 0 ? new String(str2) : str2.concat(valueOf));
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            } catch (Throwable th4) {
                th = th4;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        }

        public SQLiteDatabase getWritableDatabase() {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (SQLiteException e) {
                this.f7079a.f7084c.getDatabasePath("google_tagmanager.db").delete();
            }
            return sQLiteDatabase == null ? super.getWritableDatabase() : sQLiteDatabase;
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            C2234i.m10259a(sQLiteDatabase.getPath());
        }

        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (VERSION.SDK_INT < 15) {
                Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    rawQuery.moveToFirst();
                } finally {
                    rawQuery.close();
                }
            }
            if (m10177a("datalayer", sQLiteDatabase)) {
                m10176a(sQLiteDatabase);
            } else {
                sQLiteDatabase.execSQL(aq.f7082a);
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.aq.b */
    private static class C2212b {
        final String f7080a;
        final byte[] f7081b;

        C2212b(String str, byte[] bArr) {
            this.f7080a = str;
            this.f7081b = bArr;
        }

        public String toString() {
            String str = this.f7080a;
            return new StringBuilder(String.valueOf(str).length() + 54).append("KeyAndSerialized: key = ").append(str).append(" serialized hash = ").append(Arrays.hashCode(this.f7081b)).toString();
        }
    }

    static {
        f7082a = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", new Object[]{"datalayer", "ID", "key", "value", "expires"});
    }

    public aq(Context context) {
        this(context, C1379e.m4937d(), "google_tagmanager.db", 2000, Executors.newSingleThreadExecutor());
    }

    aq(Context context, C1377c c1377c, String str, int i, Executor executor) {
        this.f7084c = context;
        this.f7086e = c1377c;
        this.f7087f = i;
        this.f7083b = executor;
        this.f7085d = new C2211a(this, this.f7084c, str);
    }

    private SQLiteDatabase m10180a(String str) {
        try {
            return this.f7085d.getWritableDatabase();
        } catch (SQLiteException e) {
            C2238n.m10266b(str);
            return null;
        }
    }

    private Object m10181a(byte[] bArr) {
        Object readObject;
        Throwable th;
        ObjectInputStream objectInputStream = null;
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ObjectInputStream objectInputStream2;
        try {
            objectInputStream2 = new ObjectInputStream(byteArrayInputStream);
            try {
                readObject = objectInputStream2.readObject();
                try {
                    objectInputStream2.close();
                    byteArrayInputStream.close();
                } catch (IOException e) {
                }
            } catch (IOException e2) {
                if (objectInputStream2 != null) {
                    try {
                        objectInputStream2.close();
                    } catch (IOException e3) {
                    }
                }
                byteArrayInputStream.close();
                return readObject;
            } catch (ClassNotFoundException e4) {
                if (objectInputStream2 != null) {
                    try {
                        objectInputStream2.close();
                    } catch (IOException e5) {
                    }
                }
                byteArrayInputStream.close();
                return readObject;
            } catch (Throwable th2) {
                th = th2;
                if (objectInputStream2 != null) {
                    try {
                        objectInputStream2.close();
                    } catch (IOException e6) {
                        throw th;
                    }
                }
                byteArrayInputStream.close();
                throw th;
            }
        } catch (IOException e7) {
            objectInputStream2 = objectInputStream;
            if (objectInputStream2 != null) {
                objectInputStream2.close();
            }
            byteArrayInputStream.close();
            return readObject;
        } catch (ClassNotFoundException e8) {
            objectInputStream2 = objectInputStream;
            if (objectInputStream2 != null) {
                objectInputStream2.close();
            }
            byteArrayInputStream.close();
            return readObject;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            objectInputStream2 = objectInputStream;
            th = th4;
            if (objectInputStream2 != null) {
                objectInputStream2.close();
            }
            byteArrayInputStream.close();
            throw th;
        }
        return readObject;
    }

    private List<C2219a> m10184a(List<C2212b> list) {
        List<C2219a> arrayList = new ArrayList();
        for (C2212b c2212b : list) {
            arrayList.add(new C2219a(c2212b.f7080a, m10181a(c2212b.f7081b)));
        }
        return arrayList;
    }

    private void m10185a(int i) {
        int d = (m10197d() - this.f7087f) + i;
        if (d > 0) {
            List b = m10192b(d);
            C2238n.m10268c("DataLayer store full, deleting " + b.size() + " entries to make room.");
            m10188a((String[]) b.toArray(new String[0]));
        }
    }

    private void m10186a(long j) {
        SQLiteDatabase a = m10180a("Error opening database for deleteOlderThan.");
        if (a != null) {
            try {
                C2238n.m10269d("Deleted " + a.delete("datalayer", "expires <= ?", new String[]{Long.toString(j)}) + " expired items");
            } catch (SQLiteException e) {
                C2238n.m10266b("Error deleting old entries.");
            }
        }
    }

    private void m10188a(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            SQLiteDatabase a = m10180a("Error opening database for deleteEntries.");
            if (a != null) {
                try {
                    a.delete("datalayer", String.format("%s in (%s)", new Object[]{"ID", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                } catch (SQLiteException e) {
                    String str = "Error deleting entries ";
                    String valueOf = String.valueOf(Arrays.toString(strArr));
                    C2238n.m10266b(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                }
            }
        }
    }

    private byte[] m10189a(Object obj) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        byte[] bArr = null;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(obj);
                bArr = byteArrayOutputStream.toByteArray();
                try {
                    objectOutputStream.close();
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                }
            } catch (IOException e2) {
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e3) {
                    }
                }
                byteArrayOutputStream.close();
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e4) {
                        throw th;
                    }
                }
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (IOException e5) {
            objectOutputStream = bArr;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
            return bArr;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            objectOutputStream = bArr;
            th = th4;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
            throw th;
        }
        return bArr;
    }

    private List<C2219a> m10191b() {
        try {
            m10186a(this.f7086e.m4926a());
            List<C2219a> a = m10184a(m10195c());
            return a;
        } finally {
            m10198e();
        }
    }

    private List<String> m10192b(int i) {
        Cursor query;
        SQLiteException e;
        String str;
        String valueOf;
        Throwable th;
        List<String> arrayList = new ArrayList();
        if (i <= 0) {
            C2238n.m10266b("Invalid maxEntries specified. Skipping.");
            return arrayList;
        }
        SQLiteDatabase a = m10180a("Error opening database for peekEntryIds.");
        if (a == null) {
            return arrayList;
        }
        try {
            query = a.query("datalayer", new String[]{"ID"}, null, null, null, null, String.format("%s ASC", new Object[]{"ID"}), Integer.toString(i));
            try {
                if (query.moveToFirst()) {
                    do {
                        arrayList.add(String.valueOf(query.getLong(0)));
                    } while (query.moveToNext());
                }
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    str = "Error in peekEntries fetching entryIds: ";
                    valueOf = String.valueOf(e.getMessage());
                    C2238n.m10266b(valueOf.length() == 0 ? str.concat(valueOf) : new String(str));
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            str = "Error in peekEntries fetching entryIds: ";
            valueOf = String.valueOf(e.getMessage());
            if (valueOf.length() == 0) {
            }
            C2238n.m10266b(valueOf.length() == 0 ? str.concat(valueOf) : new String(str));
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return arrayList;
    }

    private List<C2212b> m10193b(List<C2219a> list) {
        List<C2212b> arrayList = new ArrayList();
        for (C2219a c2219a : list) {
            arrayList.add(new C2212b(c2219a.f7090a, m10189a(c2219a.f7091b)));
        }
        return arrayList;
    }

    private synchronized void m10194b(List<C2212b> list, long j) {
        try {
            long a = this.f7086e.m4926a();
            m10186a(a);
            m10185a(list.size());
            m10196c(list, a + j);
            m10198e();
        } catch (Throwable th) {
            m10198e();
        }
    }

    private List<C2212b> m10195c() {
        SQLiteDatabase a = m10180a("Error opening database for loadSerialized.");
        List<C2212b> arrayList = new ArrayList();
        if (a == null) {
            return arrayList;
        }
        Cursor query = a.query("datalayer", new String[]{"key", "value"}, null, null, null, null, "ID", null);
        while (query.moveToNext()) {
            try {
                arrayList.add(new C2212b(query.getString(0), query.getBlob(1)));
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    private void m10196c(List<C2212b> list, long j) {
        SQLiteDatabase a = m10180a("Error opening database for writeEntryToDatabase.");
        if (a != null) {
            for (C2212b c2212b : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("expires", Long.valueOf(j));
                contentValues.put("key", c2212b.f7080a);
                contentValues.put("value", c2212b.f7081b);
                a.insert("datalayer", null, contentValues);
            }
        }
    }

    private int m10197d() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase a = m10180a("Error opening database for getNumStoredEntries.");
        if (a != null) {
            try {
                cursor = a.rawQuery("SELECT COUNT(*) from datalayer", null);
                if (cursor.moveToFirst()) {
                    i = (int) cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e) {
                C2238n.m10266b("Error getting numStoredEntries");
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return i;
    }

    private void m10198e() {
        try {
            this.f7085d.close();
        } catch (SQLiteException e) {
        }
    }

    public void m10199a(C2217a c2217a) {
        this.f7083b.execute(new C22102(this, c2217a));
    }

    public void m10200a(List<C2219a> list, long j) {
        this.f7083b.execute(new C22091(this, m10193b((List) list), j));
    }
}
