package com.andi.alquran.p026c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.andi.alquran.c.e */
public class C0889e {
    private C0888d f1720a;

    public C0889e(Context context) {
        this.f1720a = new C0888d(context);
    }

    public void m3083a() {
        SQLiteDatabase writableDatabase = this.f1720a.getWritableDatabase();
        writableDatabase.execSQL("DELETE FROM history");
        writableDatabase.execSQL("DELETE FROM SQLITE_SEQUENCE WHERE name='history'");
        writableDatabase.close();
    }

    public void m3084a(String str) {
        String sqlEscapeString = DatabaseUtils.sqlEscapeString(str);
        SQLiteDatabase writableDatabase = this.f1720a.getWritableDatabase();
        writableDatabase.delete("history", "name=" + sqlEscapeString, null);
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", str);
        writableDatabase.insert("history", null, contentValues);
        writableDatabase.close();
    }

    public ArrayList<HashMap<String, String>> m3085b() {
        SQLiteDatabase readableDatabase = this.f1720a.getReadableDatabase();
        ArrayList<HashMap<String, String>> arrayList = new ArrayList();
        Cursor rawQuery = readableDatabase.rawQuery("SELECT  _id,name FROM history ORDER BY _id DESC", null);
        if (rawQuery.moveToFirst()) {
            do {
                HashMap hashMap = new HashMap();
                hashMap.put("id", rawQuery.getString(rawQuery.getColumnIndex("_id")));
                hashMap.put("name", rawQuery.getString(rawQuery.getColumnIndex("name")));
                arrayList.add(hashMap);
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        readableDatabase.close();
        return arrayList;
    }
}
