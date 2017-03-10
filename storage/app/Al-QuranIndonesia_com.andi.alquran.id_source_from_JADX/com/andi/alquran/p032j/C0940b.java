package com.andi.alquran.p032j;

import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.andi.alquran.j.b */
public class C0940b {
    public String m3275a(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
            httpURLConnection.setUseCaches(true);
            if (httpURLConnection.getResponseCode() == Callback.DEFAULT_DRAG_ANIMATION_DURATION) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        stringBuffer.append(readLine);
                    } else {
                        bufferedReader.close();
                        httpURLConnection.disconnect();
                        return stringBuffer.toString();
                    }
                }
            }
            httpURLConnection.disconnect();
            return null;
        } catch (IOException e) {
            return null;
        }
    }
}
