package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;

public class cg {
    private static final String[] f3669e;
    private String f3670a;
    private String f3671b;
    private String f3672c;
    private String[] f3673d;
    private bk f3674f;

    static {
        f3669e = new String[]{"/aclk", "/pcs/click"};
    }

    public cg(bk bkVar) {
        this.f3670a = "googleads.g.doubleclick.net";
        this.f3671b = "/pagead/ads";
        this.f3672c = "ad.doubleclick.net";
        this.f3673d = new String[]{".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
        this.f3674f = bkVar;
    }

    private Uri m5526a(Uri uri, Context context, String str, boolean z, View view) {
        try {
            boolean b = m5537b(uri);
            if (b) {
                if (uri.toString().contains("dc_ms=")) {
                    throw new ch("Parameter already exists: dc_ms");
                }
            } else if (uri.getQueryParameter("ms") != null) {
                throw new ch("Query parameter already exists: ms");
            }
            String a = z ? this.f3674f.m3927a(context, str, view) : this.f3674f.m3926a(context);
            return b ? m5528b(uri, "dc_ms", a) : m5527a(uri, "ms", a);
        } catch (UnsupportedOperationException e) {
            throw new ch("Provided Uri is not in a valid state");
        }
    }

    private Uri m5527a(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl");
        }
        return indexOf != -1 ? Uri.parse(new StringBuilder(uri2.substring(0, indexOf + 1)).append(str).append("=").append(str2).append("&").append(uri2.substring(indexOf + 1)).toString()) : uri.buildUpon().appendQueryParameter(str, str2).build();
    }

    private Uri m5528b(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf(";adurl");
        if (indexOf != -1) {
            return Uri.parse(new StringBuilder(uri2.substring(0, indexOf + 1)).append(str).append("=").append(str2).append(";").append(uri2.substring(indexOf + 1)).toString());
        }
        String encodedPath = uri.getEncodedPath();
        int indexOf2 = uri2.indexOf(encodedPath);
        return Uri.parse(new StringBuilder(uri2.substring(0, encodedPath.length() + indexOf2)).append(";").append(str).append("=").append(str2).append(";").append(uri2.substring(encodedPath.length() + indexOf2)).toString());
    }

    public Uri m5529a(Uri uri, Context context) {
        return m5526a(uri, context, null, false, null);
    }

    public Uri m5530a(Uri uri, Context context, View view) {
        try {
            return m5526a(uri, context, uri.getQueryParameter("ai"), true, view);
        } catch (UnsupportedOperationException e) {
            throw new ch("Provided Uri is not in a valid state");
        }
    }

    public bk m5531a() {
        return this.f3674f;
    }

    public void m5532a(MotionEvent motionEvent) {
        this.f3674f.m3929a(motionEvent);
    }

    public void m5533a(String str) {
        this.f3673d = str.split(",");
    }

    public void m5534a(String str, String str2) {
        this.f3670a = str;
        this.f3671b = str2;
    }

    public boolean m5535a(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            return uri.getHost().equals(this.f3670a) && uri.getPath().equals(this.f3671b);
        } catch (NullPointerException e) {
            return false;
        }
    }

    @Deprecated
    public Uri m5536b(Uri uri, Context context) {
        return m5530a(uri, context, null);
    }

    public boolean m5537b(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            return uri.getHost().equals(this.f3672c);
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean m5538c(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            String host = uri.getHost();
            for (String endsWith : this.f3673d) {
                if (host.endsWith(endsWith)) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean m5539d(Uri uri) {
        if (!m5538c(uri)) {
            return false;
        }
        for (String endsWith : f3669e) {
            if (uri.getPath().endsWith(endsWith)) {
                return true;
            }
        }
        return false;
    }
}
