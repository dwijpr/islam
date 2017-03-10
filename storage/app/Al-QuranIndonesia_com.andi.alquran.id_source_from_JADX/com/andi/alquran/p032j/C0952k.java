package com.andi.alquran.p032j;

import android.support.v7.recyclerview.BuildConfig;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* renamed from: com.andi.alquran.j.k */
public class C0952k {
    private String f1920a;
    private String f1921b;

    public C0952k(String str, String str2) {
        this.f1920a = str;
        this.f1921b = str2;
        m3322a(BuildConfig.VERSION_NAME);
    }

    private void m3322a(String str) {
        File file = new File(this.f1921b + str);
        if (!file.isDirectory()) {
            file.mkdirs();
        }
    }

    public void m3323a() {
        try {
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(this.f1920a));
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    zipInputStream.close();
                    return;
                } else if (nextEntry.isDirectory()) {
                    m3322a(nextEntry.getName());
                } else {
                    OutputStream fileOutputStream = new FileOutputStream(this.f1921b + nextEntry.getName());
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
                }
            }
        } catch (Exception e) {
        }
    }
}
