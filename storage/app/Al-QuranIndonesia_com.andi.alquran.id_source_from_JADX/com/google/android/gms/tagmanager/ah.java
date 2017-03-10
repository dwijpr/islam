package com.google.android.gms.tagmanager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;

class ah {

    /* renamed from: com.google.android.gms.tagmanager.ah.1 */
    class C22051 implements Runnable {
        final /* synthetic */ Editor f7051a;

        C22051(Editor editor) {
            this.f7051a = editor;
        }

        public void run() {
            this.f7051a.commit();
        }
    }

    @SuppressLint({"CommitPrefEdits"})
    static void m10131a(Context context, String str, String str2, String str3) {
        Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str2, str3);
        m10132a(edit);
    }

    static void m10132a(Editor editor) {
        if (VERSION.SDK_INT >= 9) {
            editor.apply();
        } else {
            new Thread(new C22051(editor)).start();
        }
    }
}
