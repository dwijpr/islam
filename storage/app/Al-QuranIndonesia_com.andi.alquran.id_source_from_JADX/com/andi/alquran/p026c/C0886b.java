package com.andi.alquran.p026c;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.recyclerview.BuildConfig;
import com.andi.alquran.p030h.C0918b;
import java.io.File;
import java.util.ArrayList;

/* renamed from: com.andi.alquran.c.b */
public class C0886b {
    private SQLiteDatabase f1716a;
    private String f1717b;

    private void m3076a() {
        if (this.f1716a != null) {
            this.f1716a.close();
            this.f1716a = null;
            this.f1717b = null;
        }
    }

    public String m3077a(int i, int i2) {
        if (this.f1716a == null) {
            return BuildConfig.VERSION_NAME;
        }
        try {
            Cursor query = this.f1716a.query("quran", new String[]{"text"}, "sura=? and aya=?", new String[]{BuildConfig.VERSION_NAME + i, BuildConfig.VERSION_NAME + i2}, null, null, null);
            query.moveToFirst();
            String string = query.getString(0);
            query.close();
            return string;
        } catch (SQLiteException e) {
            e.printStackTrace();
            m3076a();
            return BuildConfig.VERSION_NAME;
        }
    }

    public ArrayList<C0918b> m3078a(String str, int i) {
        ArrayList<C0918b> arrayList = new ArrayList();
        if (str.length() == 1) {
            str = str.replaceAll("\\?", "fksjdlkjsdf45");
        }
        try {
            Cursor rawQuery = this.f1716a.rawQuery("SELECT * FROM quran WHERE sura = " + i + " AND text LIKE " + DatabaseUtils.sqlEscapeString("%" + str + "%"), new String[0]);
            if (rawQuery != null) {
                if (rawQuery.moveToFirst()) {
                    do {
                        String string = rawQuery.getString(rawQuery.getColumnIndex("sura"));
                        String string2 = rawQuery.getString(rawQuery.getColumnIndex("aya"));
                        String string3 = rawQuery.getString(rawQuery.getColumnIndex("text"));
                        C0918b c0918b = new C0918b(string, string2, string3);
                        c0918b.m3203a(string);
                        c0918b.m3205b(string2);
                        c0918b.m3207c(string3);
                        arrayList.add(c0918b);
                    } while (rawQuery.moveToNext());
                }
                if (!(rawQuery == null || rawQuery.isClosed())) {
                    rawQuery.close();
                }
            }
            rawQuery.close();
        } catch (SQLiteException e) {
            e.printStackTrace();
            m3076a();
        }
        return arrayList;
    }

    public boolean m3079a(Context context, String str) {
        if (!new File(str).exists()) {
            return false;
        }
        if (!str.equals(this.f1717b)) {
            try {
                m3076a();
                this.f1716a = SQLiteDatabase.openDatabase(str, null, 17);
                this.f1717b = str;
            } catch (SQLiteException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
}
