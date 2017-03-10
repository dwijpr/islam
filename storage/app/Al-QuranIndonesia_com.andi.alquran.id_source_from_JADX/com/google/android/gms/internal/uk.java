package com.google.android.gms.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.recyclerview.BuildConfig;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C1314c;
import com.google.android.gms.common.util.C1384j;
import java.io.Closeable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class uk extends ud implements Closeable {
    private static final String f6094a;
    private static final String f6095b;
    private final C2028a f6096c;
    private final vn f6097d;
    private final vn f6098e;

    /* renamed from: com.google.android.gms.internal.uk.a */
    class C2028a extends SQLiteOpenHelper {
        final /* synthetic */ uk f6093a;

        C2028a(uk ukVar, Context context, String str) {
            this.f6093a = ukVar;
            super(context, str, null, 1);
        }

        private void m9232a(SQLiteDatabase sQLiteDatabase) {
            int i = 1;
            Set b = m9234b(sQLiteDatabase, "hits2");
            String[] strArr = new String[]{"hit_id", "hit_string", "hit_time", "hit_url"};
            int i2 = 0;
            while (i2 < 4) {
                Object obj = strArr[i2];
                if (b.remove(obj)) {
                    i2++;
                } else {
                    String str = "Database hits2 is missing required column: ";
                    String valueOf = String.valueOf(obj);
                    throw new SQLiteException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                }
            }
            if (b.remove("hit_app_id")) {
                i = 0;
            }
            if (!b.isEmpty()) {
                throw new SQLiteException("Database hits2 has extra columns");
            } else if (i != 0) {
                sQLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id INTEGER");
            }
        }

        private boolean m9233a(SQLiteDatabase sQLiteDatabase, String str) {
            Object e;
            Throwable th;
            Cursor cursor = null;
            Cursor query;
            try {
                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                query = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                try {
                    boolean moveToFirst = query.moveToFirst();
                    if (query == null) {
                        return moveToFirst;
                    }
                    query.close();
                    return moveToFirst;
                } catch (SQLiteException e2) {
                    e = e2;
                    try {
                        this.f6093a.m4256c("Error querying for table", str, e);
                        if (query != null) {
                            query.close();
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
            } catch (SQLiteException e3) {
                e = e3;
                query = null;
                this.f6093a.m4256c("Error querying for table", str, e);
                if (query != null) {
                    query.close();
                }
                return false;
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }

        private Set<String> m9234b(SQLiteDatabase sQLiteDatabase, String str) {
            Set<String> hashSet = new HashSet();
            Cursor rawQuery = sQLiteDatabase.rawQuery(new StringBuilder(String.valueOf(str).length() + 22).append("SELECT * FROM ").append(str).append(" LIMIT 0").toString(), null);
            try {
                String[] columnNames = rawQuery.getColumnNames();
                for (Object add : columnNames) {
                    hashSet.add(add);
                }
                return hashSet;
            } finally {
                rawQuery.close();
            }
        }

        private void m9235b(SQLiteDatabase sQLiteDatabase) {
            int i = 0;
            Set b = m9234b(sQLiteDatabase, "properties");
            String[] strArr = new String[]{"app_uid", "cid", "tid", "params", "adid", "hits_count"};
            while (i < 6) {
                Object obj = strArr[i];
                if (b.remove(obj)) {
                    i++;
                } else {
                    String str = "Database properties is missing required column: ";
                    String valueOf = String.valueOf(obj);
                    throw new SQLiteException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                }
            }
            if (!b.isEmpty()) {
                throw new SQLiteException("Database properties table has extra columns");
            }
        }

        public SQLiteDatabase getWritableDatabase() {
            if (this.f6093a.f6098e.m9502a(3600000)) {
                SQLiteDatabase writableDatabase;
                try {
                    writableDatabase = super.getWritableDatabase();
                } catch (SQLiteException e) {
                    this.f6093a.f6098e.m9501a();
                    this.f6093a.m4262f("Opening the database failed, dropping the table and recreating it");
                    this.f6093a.m4266l().getDatabasePath(this.f6093a.m9238F()).delete();
                    try {
                        writableDatabase = super.getWritableDatabase();
                        this.f6093a.f6098e.m9503b();
                    } catch (SQLiteException e2) {
                        this.f6093a.m4261e("Failed to open freshly created database", e2);
                        throw e2;
                    }
                }
                return writableDatabase;
            }
            throw new SQLiteException("Database open failed");
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            uy.m9372a(sQLiteDatabase.getPath());
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
            if (m9233a(sQLiteDatabase, "hits2")) {
                m9232a(sQLiteDatabase);
            } else {
                sQLiteDatabase.execSQL(uk.f6094a);
            }
            if (m9233a(sQLiteDatabase, "properties")) {
                m9235b(sQLiteDatabase);
            } else {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS properties ( app_uid INTEGER NOT NULL, cid TEXT NOT NULL, tid TEXT NOT NULL, params TEXT NOT NULL, adid INTEGER NOT NULL, hits_count INTEGER NOT NULL, PRIMARY KEY (app_uid, cid, tid)) ;");
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    static {
        f6094a = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", new Object[]{"hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id"});
        f6095b = String.format("SELECT MAX(%s) FROM %s WHERE 1;", new Object[]{"hit_time", "hits2"});
    }

    uk(uf ufVar) {
        super(ufVar);
        this.f6097d = new vn(m4265k());
        this.f6098e = new vn(m4265k());
        this.f6096c = new C2028a(this, ufVar.m9154b(), m9238F());
    }

    private void m9237E() {
        int x = m4268n().m9355x();
        long e = m9261e();
        if (e > ((long) (x - 1))) {
            List a = m9248a((e - ((long) x)) + 1);
            m4258d("Store full, deleting hits to make room, count", Integer.valueOf(a.size()));
            m9254a(a);
        }
    }

    private String m9238F() {
        return m4268n().m9357z();
    }

    private long m9239a(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = m9246C().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            m4259d("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private long m9240a(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            cursor = m9246C().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor != null) {
                cursor.close();
            }
            return j;
        } catch (SQLiteException e) {
            m4259d("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private static String m9242a(Map<String, String> map) {
        C1314c.m4623a((Object) map);
        Builder builder = new Builder();
        for (Entry entry : map.entrySet()) {
            builder.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        String encodedQuery = builder.build().getEncodedQuery();
        return encodedQuery == null ? BuildConfig.VERSION_NAME : encodedQuery;
    }

    private String m9244b(vc vcVar) {
        return vcVar.m9411f() ? m4268n().m9345n() : m4268n().m9346o();
    }

    private static String m9245c(vc vcVar) {
        C1314c.m4623a((Object) vcVar);
        Builder builder = new Builder();
        for (Entry entry : vcVar.m9407b().entrySet()) {
            String str = (String) entry.getKey();
            if (!("ht".equals(str) || "qt".equals(str) || "AppUID".equals(str))) {
                builder.appendQueryParameter(str, (String) entry.getValue());
            }
        }
        String encodedQuery = builder.build().getEncodedQuery();
        return encodedQuery == null ? BuildConfig.VERSION_NAME : encodedQuery;
    }

    SQLiteDatabase m9246C() {
        try {
            return this.f6096c.getWritableDatabase();
        } catch (SQLiteException e) {
            m4258d("Error opening database", e);
            throw e;
        }
    }

    public long m9247a(long j, String str, String str2) {
        C1314c.m4625a(str);
        C1314c.m4625a(str2);
        m4280A();
        m4264j();
        return m9240a("SELECT hits_count FROM properties WHERE app_uid=? AND cid=? AND tid=?", new String[]{String.valueOf(j), str, str2}, 0);
    }

    public List<Long> m9248a(long j) {
        Object e;
        Throwable th;
        Cursor cursor = null;
        m4264j();
        m4280A();
        if (j <= 0) {
            return Collections.emptyList();
        }
        SQLiteDatabase C = m9246C();
        List<Long> arrayList = new ArrayList();
        Cursor query;
        try {
            query = C.query("hits2", new String[]{"hit_id"}, null, null, null, null, String.format("%s ASC", new Object[]{"hit_id"}), Long.toString(j));
            try {
                if (query.moveToFirst()) {
                    do {
                        arrayList.add(Long.valueOf(query.getLong(0)));
                    } while (query.moveToNext());
                }
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    m4258d("Error selecting hit ids", e);
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            m4258d("Error selecting hit ids", e);
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return arrayList;
    }

    Map<String, String> m9249a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            if (!str.startsWith("?")) {
                String str2 = "?";
                String valueOf = String.valueOf(str);
                str = valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2);
            }
            return C1384j.m4952a(new URI(str), "UTF-8");
        } catch (URISyntaxException e) {
            m4261e("Error parsing hit parameters", e);
            return new HashMap(0);
        }
    }

    protected void m9250a() {
    }

    public void m9251a(long j, String str) {
        C1314c.m4625a(str);
        m4280A();
        m4264j();
        int delete = m9246C().delete("properties", "app_uid=? AND cid<>?", new String[]{String.valueOf(j), str});
        if (delete > 0) {
            m4247a("Deleted property records", Integer.valueOf(delete));
        }
    }

    public void m9252a(uh uhVar) {
        C1314c.m4623a((Object) uhVar);
        m4280A();
        m4264j();
        SQLiteDatabase C = m9246C();
        String a = m9242a(uhVar.m9198f());
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_uid", Long.valueOf(uhVar.m9192a()));
        contentValues.put("cid", uhVar.m9194b());
        contentValues.put("tid", uhVar.m9195c());
        contentValues.put("adid", Integer.valueOf(uhVar.m9196d() ? 1 : 0));
        contentValues.put("hits_count", Long.valueOf(uhVar.m9197e()));
        contentValues.put("params", a);
        try {
            if (C.insertWithOnConflict("properties", null, contentValues, 5) == -1) {
                m4262f("Failed to insert/update a property (got -1)");
            }
        } catch (SQLiteException e) {
            m4261e("Error storing a property", e);
        }
    }

    public void m9253a(vc vcVar) {
        C1314c.m4623a((Object) vcVar);
        m4264j();
        m4280A();
        String c = m9245c(vcVar);
        if (c.length() > FragmentTransaction.TRANSIT_EXIT_MASK) {
            m4267m().m9432a(vcVar, "Hit length exceeds the maximum allowed size");
            return;
        }
        m9237E();
        SQLiteDatabase C = m9246C();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hit_string", c);
        contentValues.put("hit_time", Long.valueOf(vcVar.m9409d()));
        contentValues.put("hit_app_id", Integer.valueOf(vcVar.m9406a()));
        contentValues.put("hit_url", m9244b(vcVar));
        try {
            long insert = C.insert("hits2", null, contentValues);
            if (insert == -1) {
                m4262f("Failed to insert a hit (got -1)");
            } else {
                m4252b("Hit saved to database. db-id, hit", Long.valueOf(insert), vcVar);
            }
        } catch (SQLiteException e) {
            m4261e("Error storing a hit", e);
        }
    }

    public void m9254a(List<Long> list) {
        C1314c.m4623a((Object) list);
        m4264j();
        m4280A();
        if (!list.isEmpty()) {
            int i;
            StringBuilder stringBuilder = new StringBuilder("hit_id");
            stringBuilder.append(" in (");
            for (i = 0; i < list.size(); i++) {
                Long l = (Long) list.get(i);
                if (l == null || l.longValue() == 0) {
                    throw new SQLiteException("Invalid hit id");
                }
                if (i > 0) {
                    stringBuilder.append(",");
                }
                stringBuilder.append(l);
            }
            stringBuilder.append(")");
            String stringBuilder2 = stringBuilder.toString();
            try {
                SQLiteDatabase C = m9246C();
                m4247a("Deleting dispatched hits. count", Integer.valueOf(list.size()));
                i = C.delete("hits2", stringBuilder2, null);
                if (i != list.size()) {
                    m4253b("Deleted fewer hits then expected", Integer.valueOf(list.size()), Integer.valueOf(i), stringBuilder2);
                }
            } catch (SQLiteException e) {
                m4261e("Error deleting hits", e);
                throw e;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.google.android.gms.internal.vc> m9255b(long r14) {
        /*
        r13 = this;
        r0 = 1;
        r1 = 0;
        r9 = 0;
        r2 = 0;
        r2 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1));
        if (r2 < 0) goto L_0x008f;
    L_0x0009:
        com.google.android.gms.common.internal.C1314c.m4632b(r0);
        r13.m4264j();
        r13.m4280A();
        r0 = r13.m9246C();
        r1 = "hits2";
        r2 = 5;
        r2 = new java.lang.String[r2];	 Catch:{ SQLiteException -> 0x0092, all -> 0x00a2 }
        r3 = 0;
        r4 = "hit_id";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0092, all -> 0x00a2 }
        r3 = 1;
        r4 = "hit_time";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0092, all -> 0x00a2 }
        r3 = 2;
        r4 = "hit_string";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0092, all -> 0x00a2 }
        r3 = 3;
        r4 = "hit_url";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0092, all -> 0x00a2 }
        r3 = 4;
        r4 = "hit_app_id";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x0092, all -> 0x00a2 }
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = "%s ASC";
        r8 = 1;
        r8 = new java.lang.Object[r8];	 Catch:{ SQLiteException -> 0x0092, all -> 0x00a2 }
        r10 = 0;
        r11 = "hit_id";
        r8[r10] = r11;	 Catch:{ SQLiteException -> 0x0092, all -> 0x00a2 }
        r7 = java.lang.String.format(r7, r8);	 Catch:{ SQLiteException -> 0x0092, all -> 0x00a2 }
        r8 = java.lang.Long.toString(r14);	 Catch:{ SQLiteException -> 0x0092, all -> 0x00a2 }
        r9 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ SQLiteException -> 0x0092, all -> 0x00a2 }
        r10 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x00a4, all -> 0x00a2 }
        r10.<init>();	 Catch:{ SQLiteException -> 0x00a4, all -> 0x00a2 }
        r0 = r9.moveToFirst();	 Catch:{ SQLiteException -> 0x00a4, all -> 0x00a2 }
        if (r0 == 0) goto L_0x0089;
    L_0x0059:
        r0 = 0;
        r6 = r9.getLong(r0);	 Catch:{ SQLiteException -> 0x00a4, all -> 0x00a2 }
        r0 = 1;
        r3 = r9.getLong(r0);	 Catch:{ SQLiteException -> 0x00a4, all -> 0x00a2 }
        r0 = 2;
        r0 = r9.getString(r0);	 Catch:{ SQLiteException -> 0x00a4, all -> 0x00a2 }
        r1 = 3;
        r1 = r9.getString(r1);	 Catch:{ SQLiteException -> 0x00a4, all -> 0x00a2 }
        r2 = 4;
        r8 = r9.getInt(r2);	 Catch:{ SQLiteException -> 0x00a4, all -> 0x00a2 }
        r2 = r13.m9249a(r0);	 Catch:{ SQLiteException -> 0x00a4, all -> 0x00a2 }
        r5 = com.google.android.gms.internal.vp.m9521d(r1);	 Catch:{ SQLiteException -> 0x00a4, all -> 0x00a2 }
        r0 = new com.google.android.gms.internal.vc;	 Catch:{ SQLiteException -> 0x00a4, all -> 0x00a2 }
        r1 = r13;
        r0.<init>(r1, r2, r3, r5, r6, r8);	 Catch:{ SQLiteException -> 0x00a4, all -> 0x00a2 }
        r10.add(r0);	 Catch:{ SQLiteException -> 0x00a4, all -> 0x00a2 }
        r0 = r9.moveToNext();	 Catch:{ SQLiteException -> 0x00a4, all -> 0x00a2 }
        if (r0 != 0) goto L_0x0059;
    L_0x0089:
        if (r9 == 0) goto L_0x008e;
    L_0x008b:
        r9.close();
    L_0x008e:
        return r10;
    L_0x008f:
        r0 = r1;
        goto L_0x0009;
    L_0x0092:
        r0 = move-exception;
        r1 = r9;
    L_0x0094:
        r2 = "Error loading hits from the database";
        r13.m4261e(r2, r0);	 Catch:{ all -> 0x009a }
        throw r0;	 Catch:{ all -> 0x009a }
    L_0x009a:
        r0 = move-exception;
        r9 = r1;
    L_0x009c:
        if (r9 == 0) goto L_0x00a1;
    L_0x009e:
        r9.close();
    L_0x00a1:
        throw r0;
    L_0x00a2:
        r0 = move-exception;
        goto L_0x009c;
    L_0x00a4:
        r0 = move-exception;
        r1 = r9;
        goto L_0x0094;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.uk.b(long):java.util.List<com.google.android.gms.internal.vc>");
    }

    public void m9256b() {
        m4280A();
        m9246C().beginTransaction();
    }

    public void m9257c() {
        m4280A();
        m9246C().setTransactionSuccessful();
    }

    public void m9258c(long j) {
        m4264j();
        m4280A();
        List arrayList = new ArrayList(1);
        arrayList.add(Long.valueOf(j));
        m4247a("Deleting hit, id", Long.valueOf(j));
        m9254a(arrayList);
    }

    public void close() {
        try {
            this.f6096c.close();
        } catch (SQLiteException e) {
            m4261e("Sql error closing database", e);
        } catch (IllegalStateException e2) {
            m4261e("Error closing database", e2);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.google.android.gms.internal.uh> m9259d(long r14) {
        /*
        r13 = this;
        r13.m4280A();
        r13.m4264j();
        r0 = r13.m9246C();
        r9 = 0;
        r1 = 5;
        r2 = new java.lang.String[r1];	 Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
        r1 = 0;
        r3 = "cid";
        r2[r1] = r3;	 Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
        r1 = 1;
        r3 = "tid";
        r2[r1] = r3;	 Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
        r1 = 2;
        r3 = "adid";
        r2[r1] = r3;	 Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
        r1 = 3;
        r3 = "hits_count";
        r2[r1] = r3;	 Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
        r1 = 4;
        r3 = "params";
        r2[r1] = r3;	 Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
        r1 = r13.m4268n();	 Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
        r10 = r1.m9356y();	 Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
        r8 = java.lang.String.valueOf(r10);	 Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
        r3 = "app_uid=?";
        r1 = 1;
        r4 = new java.lang.String[r1];	 Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
        r1 = 0;
        r5 = java.lang.String.valueOf(r14);	 Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
        r4[r1] = r5;	 Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
        r1 = "properties";
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r9 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
        r11 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x00a8, all -> 0x00b8 }
        r11.<init>();	 Catch:{ SQLiteException -> 0x00a8, all -> 0x00b8 }
        r0 = r9.moveToFirst();	 Catch:{ SQLiteException -> 0x00a8, all -> 0x00b8 }
        if (r0 == 0) goto L_0x008b;
    L_0x0053:
        r0 = 0;
        r3 = r9.getString(r0);	 Catch:{ SQLiteException -> 0x00a8, all -> 0x00b8 }
        r0 = 1;
        r4 = r9.getString(r0);	 Catch:{ SQLiteException -> 0x00a8, all -> 0x00b8 }
        r0 = 2;
        r0 = r9.getInt(r0);	 Catch:{ SQLiteException -> 0x00a8, all -> 0x00b8 }
        if (r0 == 0) goto L_0x009c;
    L_0x0064:
        r5 = 1;
    L_0x0065:
        r0 = 3;
        r0 = r9.getInt(r0);	 Catch:{ SQLiteException -> 0x00a8, all -> 0x00b8 }
        r6 = (long) r0;	 Catch:{ SQLiteException -> 0x00a8, all -> 0x00b8 }
        r0 = 4;
        r0 = r9.getString(r0);	 Catch:{ SQLiteException -> 0x00a8, all -> 0x00b8 }
        r8 = r13.m9264g(r0);	 Catch:{ SQLiteException -> 0x00a8, all -> 0x00b8 }
        r0 = android.text.TextUtils.isEmpty(r3);	 Catch:{ SQLiteException -> 0x00a8, all -> 0x00b8 }
        if (r0 != 0) goto L_0x0080;
    L_0x007a:
        r0 = android.text.TextUtils.isEmpty(r4);	 Catch:{ SQLiteException -> 0x00a8, all -> 0x00b8 }
        if (r0 == 0) goto L_0x009e;
    L_0x0080:
        r0 = "Read property with empty client id or tracker id";
        r13.m4256c(r0, r3, r4);	 Catch:{ SQLiteException -> 0x00a8, all -> 0x00b8 }
    L_0x0085:
        r0 = r9.moveToNext();	 Catch:{ SQLiteException -> 0x00a8, all -> 0x00b8 }
        if (r0 != 0) goto L_0x0053;
    L_0x008b:
        r0 = r11.size();	 Catch:{ SQLiteException -> 0x00a8, all -> 0x00b8 }
        if (r0 < r10) goto L_0x0096;
    L_0x0091:
        r0 = "Sending hits to too many properties. Campaign report might be incorrect";
        r13.m4260e(r0);	 Catch:{ SQLiteException -> 0x00a8, all -> 0x00b8 }
    L_0x0096:
        if (r9 == 0) goto L_0x009b;
    L_0x0098:
        r9.close();
    L_0x009b:
        return r11;
    L_0x009c:
        r5 = 0;
        goto L_0x0065;
    L_0x009e:
        r0 = new com.google.android.gms.internal.uh;	 Catch:{ SQLiteException -> 0x00a8, all -> 0x00b8 }
        r1 = r14;
        r0.<init>(r1, r3, r4, r5, r6, r8);	 Catch:{ SQLiteException -> 0x00a8, all -> 0x00b8 }
        r11.add(r0);	 Catch:{ SQLiteException -> 0x00a8, all -> 0x00b8 }
        goto L_0x0085;
    L_0x00a8:
        r0 = move-exception;
        r1 = r9;
    L_0x00aa:
        r2 = "Error loading hits from the database";
        r13.m4261e(r2, r0);	 Catch:{ all -> 0x00b0 }
        throw r0;	 Catch:{ all -> 0x00b0 }
    L_0x00b0:
        r0 = move-exception;
        r9 = r1;
    L_0x00b2:
        if (r9 == 0) goto L_0x00b7;
    L_0x00b4:
        r9.close();
    L_0x00b7:
        throw r0;
    L_0x00b8:
        r0 = move-exception;
        goto L_0x00b2;
    L_0x00ba:
        r0 = move-exception;
        r1 = r9;
        goto L_0x00aa;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.uk.d(long):java.util.List<com.google.android.gms.internal.uh>");
    }

    public void m9260d() {
        m4280A();
        m9246C().endTransaction();
    }

    public long m9261e() {
        m4264j();
        m4280A();
        return m9239a("SELECT COUNT(*) FROM hits2", null);
    }

    boolean m9262f() {
        return m9261e() == 0;
    }

    public int m9263g() {
        m4264j();
        m4280A();
        if (!this.f6097d.m9502a(86400000)) {
            return 0;
        }
        this.f6097d.m9501a();
        m4250b("Deleting stale hits (if any)");
        int delete = m9246C().delete("hits2", "hit_time < ?", new String[]{Long.toString(m4265k().m4926a() - 2592000000L)});
        m4247a("Deleted stale hits, count", Integer.valueOf(delete));
        return delete;
    }

    Map<String, String> m9264g(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            String str2 = "?";
            String valueOf = String.valueOf(str);
            return C1384j.m4952a(new URI(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2)), "UTF-8");
        } catch (URISyntaxException e) {
            m4261e("Error parsing property parameters", e);
            return new HashMap(0);
        }
    }

    public long m9265h() {
        m4264j();
        m4280A();
        return m9240a(f6095b, null, 0);
    }
}
