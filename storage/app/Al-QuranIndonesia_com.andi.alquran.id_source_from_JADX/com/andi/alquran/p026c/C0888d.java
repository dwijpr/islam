package com.andi.alquran.p026c;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* renamed from: com.andi.alquran.c.d */
public class C0888d extends SQLiteOpenHelper {
    public C0888d(Context context) {
        super(context, "pencarian_history.db", null, 1);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE history(_id INTEGER PRIMARY KEY AUTOINCREMENT ,name TEXT)");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
