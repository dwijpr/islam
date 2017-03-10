package com.andi.alquran.p026c;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.recyclerview.BuildConfig;
import java.io.File;

/* renamed from: com.andi.alquran.c.c */
public class C0887c {
    private SQLiteDatabase f1718a;
    private String f1719b;

    private void m3080a() {
        if (this.f1718a != null) {
            this.f1718a.close();
            this.f1718a = null;
            this.f1719b = null;
        }
    }

    public boolean m3081a(Context context, String str) {
        if (!new File(str).exists()) {
            return false;
        }
        if (!str.equals(this.f1719b)) {
            try {
                m3080a();
                this.f1718a = SQLiteDatabase.openDatabase(str, null, 17);
                this.f1719b = str;
            } catch (SQLiteException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public String[][] m3082a(int i, int i2) {
        if (this.f1718a == null) {
            return new String[0][];
        }
        try {
            Cursor query = this.f1718a.query("quran", new String[]{"ar", "tr"}, "sura=? and aya=?", new String[]{BuildConfig.VERSION_NAME + i, BuildConfig.VERSION_NAME + i2}, null, null, "word");
            int count = query.getCount();
            String[][] strArr = new String[count][];
            for (int i3 = 0; i3 < count; i3++) {
                query.moveToNext();
                String string = query.getString(0);
                String string2 = query.getString(1);
                strArr[i3] = new String[]{string, string2};
            }
            query.close();
            return strArr;
        } catch (SQLiteException e) {
            e.printStackTrace();
            m3080a();
            return new String[0][];
        }
    }
}
