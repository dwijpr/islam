package com.andi.alquran.arabic;

import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class BacaArab {
    static {
        System.loadLibrary("bacaarab");
    }

    public static void m3034a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int read = inputStream.read();
                if (read != -1) {
                    byteArrayOutputStream.write(read);
                } else {
                    setTextStart(byteArrayOutputStream.toByteArray());
                    return;
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    public static native int[] setBitmap(String str, int i);

    public static native Bitmap setTextEnd(String str, int i);

    public static native void setTextStart(byte[] bArr);
}
