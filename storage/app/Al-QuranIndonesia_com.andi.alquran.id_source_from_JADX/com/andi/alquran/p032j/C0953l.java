package com.andi.alquran.p032j;

import android.support.v7.recyclerview.BuildConfig;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import com.andi.alquran.App;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* renamed from: com.andi.alquran.j.l */
public class C0953l {
    private String f1922a;
    private String f1923b;

    public C0953l(String str, String str2) {
        this.f1922a = str;
        this.f1923b = str2;
        m3324a(BuildConfig.VERSION_NAME);
    }

    private void m3324a(String str) {
        File file = new File(this.f1923b + str);
        if (!file.isDirectory()) {
            file.mkdirs();
        }
    }

    public void m3325a() {
        try {
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(this.f1922a));
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    zipInputStream.close();
                    return;
                } else if (nextEntry.isDirectory()) {
                    m3324a(nextEntry.getName());
                } else {
                    OutputStream fileOutputStream = new FileOutputStream(this.f1923b + nextEntry.getName());
                    byte[] bArr = new byte[ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT];
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream, bArr.length);
                    while (true) {
                        int read = zipInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        bufferedOutputStream.write(bArr, 0, read);
                    }
                    zipInputStream.closeEntry();
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    fileOutputStream.close();
                    new File(App.m2887l() + nextEntry.getName()).renameTo(new File(App.m2887l() + new C0942d(App.m2887l() + nextEntry.getName(), '/', '.').m3278a() + ".dat"));
                }
            }
        } catch (Exception e) {
        }
    }
}
