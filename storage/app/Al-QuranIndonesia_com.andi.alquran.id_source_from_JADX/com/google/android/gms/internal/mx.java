package com.google.android.gms.internal;

import android.app.AlertDialog.Builder;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.C1114a.C1095b;
import com.google.android.gms.ads.internal.zzv;
import java.util.Map;

@op
public class mx extends na {
    private final Map<String, String> f5043a;
    private final Context f5044b;

    /* renamed from: com.google.android.gms.internal.mx.1 */
    class C18241 implements OnClickListener {
        final /* synthetic */ String f5039a;
        final /* synthetic */ String f5040b;
        final /* synthetic */ mx f5041c;

        C18241(mx mxVar, String str, String str2) {
            this.f5041c = mxVar;
            this.f5039a = str;
            this.f5040b = str2;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                ((DownloadManager) this.f5041c.f5044b.getSystemService("download")).enqueue(this.f5041c.m7712a(this.f5039a, this.f5040b));
            } catch (IllegalStateException e) {
                this.f5041c.m7690b("Could not store picture.");
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.mx.2 */
    class C18252 implements OnClickListener {
        final /* synthetic */ mx f5042a;

        C18252(mx mxVar) {
            this.f5042a = mxVar;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f5042a.m7690b("User canceled the download.");
        }
    }

    public mx(sx sxVar, Map<String, String> map) {
        super(sxVar, "storePicture");
        this.f5043a = map;
        this.f5044b = sxVar.m8770f();
    }

    Request m7712a(String str, String str2) {
        Request request = new Request(Uri.parse(str));
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
        zzv.zzcL().m8569a(request);
        return request;
    }

    String m7713a(String str) {
        return Uri.parse(str).getLastPathSegment();
    }

    public void m7714a() {
        if (this.f5044b == null) {
            m7690b("Activity context is not available");
        } else if (zzv.zzcJ().m8545e(this.f5044b).m6646c()) {
            String str = (String) this.f5043a.get("iurl");
            if (TextUtils.isEmpty(str)) {
                m7690b("Image url cannot be empty.");
            } else if (URLUtil.isValidUrl(str)) {
                String a = m7713a(str);
                if (zzv.zzcJ().m8540c(a)) {
                    Resources s = zzv.zzcN().m8425s();
                    Builder d = zzv.zzcJ().m8542d(this.f5044b);
                    d.setTitle(s != null ? s.getString(C1095b.store_picture_title) : "Save image");
                    d.setMessage(s != null ? s.getString(C1095b.store_picture_message) : "Allow Ad to store image in Picture gallery?");
                    d.setPositiveButton(s != null ? s.getString(C1095b.accept) : "Accept", new C18241(this, str, a));
                    d.setNegativeButton(s != null ? s.getString(C1095b.decline) : "Decline", new C18252(this));
                    d.create().show();
                    return;
                }
                r1 = "Image type not recognized: ";
                str = String.valueOf(a);
                m7690b(str.length() != 0 ? r1.concat(str) : new String(r1));
            } else {
                r1 = "Invalid image url: ";
                str = String.valueOf(str);
                m7690b(str.length() != 0 ? r1.concat(str) : new String(r1));
            }
        } else {
            m7690b("Feature is not supported by the device.");
        }
    }
}
