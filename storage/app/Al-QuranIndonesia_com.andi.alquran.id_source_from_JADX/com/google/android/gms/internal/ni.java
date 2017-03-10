package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import org.json.JSONObject;

@op
public class ni extends Handler {
    private final nh f5086a;

    public ni(Context context) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this(new nj(context));
    }

    public ni(nh nhVar) {
        this.f5086a = nhVar;
    }

    private void m7765a(JSONObject jSONObject) {
        try {
            this.f5086a.m7764a(jSONObject.getString("request_id"), jSONObject.getString("base_url"), jSONObject.getString("html"));
        } catch (Exception e) {
        }
    }

    public void handleMessage(Message message) {
        try {
            Bundle data = message.getData();
            if (data != null) {
                JSONObject jSONObject = new JSONObject(data.getString("data"));
                if ("fetch_html".equals(jSONObject.getString("message_name"))) {
                    m7765a(jSONObject);
                }
            }
        } catch (Exception e) {
        }
    }
}
