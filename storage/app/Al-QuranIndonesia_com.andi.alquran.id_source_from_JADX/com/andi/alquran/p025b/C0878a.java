package com.andi.alquran.p025b;

import android.app.backup.BackupManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.andi.alquran.App;
import com.google.p033a.C1073e;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.andi.alquran.b.a */
public class C0878a {
    private ArrayList<C0876a> f1643a;

    /* renamed from: com.andi.alquran.b.a.a */
    public static class C0876a {
        private String f1636a;
        private int f1637b;
        private ArrayList<C0877b> f1638c;

        public C0876a(String str, int i) {
            this.f1636a = str;
            this.f1637b = i;
            this.f1638c = new ArrayList();
        }

        public String m3042a() {
            return this.f1636a;
        }

        public void m3043a(int i) {
            this.f1637b = i;
            if (i == 0) {
                while (this.f1638c.size() > 1) {
                    this.f1638c.remove(1);
                }
            }
            BackupManager.dataChanged(App.f1447a);
        }

        public void m3044a(C0877b c0877b) {
            if (this.f1637b == 0) {
                this.f1638c.clear();
            } else {
                int i = 0;
                while (i < this.f1638c.size()) {
                    C0877b c0877b2 = (C0877b) this.f1638c.get(i);
                    if (c0877b2.f1639a == c0877b.f1639a && c0877b2.f1640b == c0877b.f1640b) {
                        this.f1638c.remove(c0877b2);
                        i--;
                    }
                    i++;
                }
            }
            this.f1638c.add(c0877b);
            BackupManager.dataChanged(App.f1447a);
        }

        public void m3045a(String str) {
            this.f1636a = str;
            BackupManager.dataChanged(App.f1447a);
        }

        public int m3046b() {
            return this.f1638c.size();
        }

        public C0877b m3047b(int i) {
            return (C0877b) this.f1638c.get(i);
        }

        public void m3048b(C0877b c0877b) {
            this.f1638c.remove(c0877b);
            BackupManager.dataChanged(App.f1447a);
        }
    }

    /* renamed from: com.andi.alquran.b.a.b */
    public static class C0877b {
        private int f1639a;
        private int f1640b;
        private int f1641c;
        private long f1642d;

        public C0877b(int i, int i2, int i3) {
            this(i, i2, i3, System.currentTimeMillis());
        }

        public C0877b(int i, int i2, int i3, long j) {
            this.f1639a = i;
            this.f1640b = i2;
            this.f1641c = i3;
            this.f1642d = j;
        }

        public int m3051a() {
            return this.f1639a;
        }

        public int m3052b() {
            return this.f1640b;
        }

        public long m3053c() {
            return this.f1642d;
        }
    }

    public C0878a() {
        this.f1643a = new ArrayList();
    }

    public int m3054a() {
        return this.f1643a.size();
    }

    public C0876a m3055a(int i) {
        return (C0876a) this.f1643a.get(i);
    }

    public C0876a m3056a(C0877b c0877b) {
        Iterator it = this.f1643a.iterator();
        while (it.hasNext()) {
            C0876a c0876a = (C0876a) it.next();
            if (c0876a.f1638c.contains(c0877b)) {
                return c0876a;
            }
        }
        return null;
    }

    public void m3057a(Context context) {
        Editor edit = context.getSharedPreferences("bookmark_activity", 0).edit();
        edit.putString("bookmark_activity", new C1073e().m3804a((Object) this, (Type) C0878a.class));
        edit.apply();
    }

    public void m3058a(C0876a c0876a) {
        this.f1643a.add(c0876a);
        BackupManager.dataChanged(App.f1447a);
    }

    public void m3059b(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("bookmark_activity", 0);
        try {
            this.f1643a = null;
            this.f1643a = ((C0878a) new C1073e().m3802a(sharedPreferences.getString("bookmark_activity", "{}"), C0878a.class)).f1643a;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.f1643a == null) {
            this.f1643a = new ArrayList();
        }
    }

    public void m3060b(C0876a c0876a) {
        this.f1643a.remove(c0876a);
        BackupManager.dataChanged(App.f1447a);
    }
}
