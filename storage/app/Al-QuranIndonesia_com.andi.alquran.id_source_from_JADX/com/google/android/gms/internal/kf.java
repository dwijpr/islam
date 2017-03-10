package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzv;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@op
public final class kf {
    public static final kg f4591a;
    public static final kg f4592b;
    public static final kg f4593c;
    public static final kg f4594d;
    public static final kg f4595e;
    public static final kg f4596f;
    public static final kg f4597g;
    public static final kg f4598h;
    public static final kg f4599i;
    public static final kg f4600j;
    public static final kg f4601k;
    public static final kg f4602l;
    public static final kg f4603m;
    public static final kg f4604n;
    public static final kg f4605o;
    public static final kg f4606p;
    public static final kg f4607q;
    public static final kp f4608r;
    public static final kg f4609s;
    public static final kg f4610t;
    public static final kg f4611u;

    /* renamed from: com.google.android.gms.internal.kf.1 */
    class C17021 implements kg {
        C17021() {
        }

        public void m7080a(sx sxVar, Map<String, String> map) {
        }
    }

    /* renamed from: com.google.android.gms.internal.kf.2 */
    class C17032 implements kg {
        C17032() {
        }

        public void m7081a(sx sxVar, Map<String, String> map) {
            PackageManager packageManager = sxVar.getContext().getPackageManager();
            try {
                try {
                    JSONArray jSONArray = new JSONObject((String) map.get("data")).getJSONArray("intents");
                    JSONObject jSONObject = new JSONObject();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String optString = jSONObject2.optString("id");
                            Object optString2 = jSONObject2.optString("u");
                            Object optString3 = jSONObject2.optString("i");
                            Object optString4 = jSONObject2.optString("m");
                            Object optString5 = jSONObject2.optString("p");
                            Object optString6 = jSONObject2.optString("c");
                            jSONObject2.optString("f");
                            jSONObject2.optString("e");
                            Intent intent = new Intent();
                            if (!TextUtils.isEmpty(optString2)) {
                                intent.setData(Uri.parse(optString2));
                            }
                            if (!TextUtils.isEmpty(optString3)) {
                                intent.setAction(optString3);
                            }
                            if (!TextUtils.isEmpty(optString4)) {
                                intent.setType(optString4);
                            }
                            if (!TextUtils.isEmpty(optString5)) {
                                intent.setPackage(optString5);
                            }
                            if (!TextUtils.isEmpty(optString6)) {
                                String[] split = optString6.split("/", 2);
                                if (split.length == 2) {
                                    intent.setComponent(new ComponentName(split[0], split[1]));
                                }
                            }
                            try {
                                jSONObject.put(optString, packageManager.resolveActivity(intent, 65536) != null);
                            } catch (Throwable e) {
                                sg.m8445b("Error constructing openable urls response.", e);
                            }
                        } catch (Throwable e2) {
                            sg.m8445b("Error parsing the intent data.", e2);
                        }
                    }
                    sxVar.m7291b("openableIntents", jSONObject);
                } catch (JSONException e3) {
                    sxVar.m7291b("openableIntents", new JSONObject());
                }
            } catch (JSONException e4) {
                sxVar.m7291b("openableIntents", new JSONObject());
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.kf.3 */
    class C17043 implements kg {
        C17043() {
        }

        public void m7082a(sx sxVar, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                sg.m8449e("URL missing from click GMSG.");
                return;
            }
            Uri a;
            Uri parse = Uri.parse(str);
            try {
                cg n = sxVar.m8778n();
                if (n != null && n.m5538c(parse)) {
                    a = n.m5530a(parse, sxVar.getContext(), sxVar.m8760b());
                    new sa(sxVar.getContext(), sxVar.m8779o().f6636b, a.toString()).zziw();
                }
            } catch (ch e) {
                String str2 = "Unable to append parameter to URL: ";
                str = String.valueOf(str);
                sg.m8449e(str.length() != 0 ? str2.concat(str) : new String(str2));
            }
            a = parse;
            new sa(sxVar.getContext(), sxVar.m8779o().f6636b, a.toString()).zziw();
        }
    }

    /* renamed from: com.google.android.gms.internal.kf.4 */
    class C17054 implements kg {
        C17054() {
        }

        public void m7083a(sx sxVar, Map<String, String> map) {
            zze i = sxVar.m8773i();
            if (i != null) {
                i.close();
                return;
            }
            i = sxVar.m8774j();
            if (i != null) {
                i.close();
            } else {
                sg.m8449e("A GMSG tried to close something that wasn't an overlay.");
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.kf.5 */
    class C17065 implements kg {
        C17065() {
        }

        private void m7084a(sx sxVar) {
            sg.m8448d("Received support message, responding.");
            zzd h = sxVar.m8772h();
            if (!(h == null || h.zzsO == null)) {
                sxVar.getContext();
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(NotificationCompatApi24.CATEGORY_EVENT, "checkSupport");
                jSONObject.put("supports", false);
                sxVar.m7291b("appStreaming", jSONObject);
            } catch (Throwable th) {
            }
        }

        public void m7085a(sx sxVar, Map<String, String> map) {
            if ("checkSupport".equals(map.get("action"))) {
                m7084a(sxVar);
                return;
            }
            zze i = sxVar.m8773i();
            if (i != null) {
                i.zzg(sxVar, map);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.kf.6 */
    class C17076 implements kg {
        C17076() {
        }

        public void m7086a(sx sxVar, Map<String, String> map) {
            sxVar.m8764b("1".equals(map.get("custom_close")));
        }
    }

    /* renamed from: com.google.android.gms.internal.kf.7 */
    class C17087 implements kg {
        C17087() {
        }

        public void m7087a(sx sxVar, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                sg.m8449e("URL missing from httpTrack GMSG.");
            } else {
                new sa(sxVar.getContext(), sxVar.m8779o().f6636b, str).zziw();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.kf.8 */
    class C17098 implements kg {
        C17098() {
        }

        public void m7088a(sx sxVar, Map<String, String> map) {
            String str = "Received log message: ";
            String valueOf = String.valueOf((String) map.get("string"));
            sg.m8448d(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    /* renamed from: com.google.android.gms.internal.kf.9 */
    class C17109 implements kg {
        C17109() {
        }

        public void m7089a(sx sxVar, Map<String, String> map) {
            jb E = sxVar.m8745E();
            if (E != null) {
                E.m6915a();
            }
        }
    }

    static {
        f4591a = new C17021();
        f4592b = new kg() {
            public void m7079a(sx sxVar, Map<String, String> map) {
                String str = (String) map.get("urls");
                if (TextUtils.isEmpty(str)) {
                    sg.m8449e("URLs missing in canOpenURLs GMSG.");
                    return;
                }
                String[] split = str.split(",");
                Map hashMap = new HashMap();
                PackageManager packageManager = sxVar.getContext().getPackageManager();
                for (String str2 : split) {
                    String[] split2 = str2.split(";", 2);
                    hashMap.put(str2, Boolean.valueOf(packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), 65536) != null));
                }
                sxVar.m8757a("openableURLs", hashMap);
            }
        };
        f4593c = new C17032();
        f4594d = new C17043();
        f4595e = new C17054();
        f4596f = new C17065();
        f4597g = new C17076();
        f4598h = new C17087();
        f4599i = new C17098();
        f4600j = new C17109();
        f4601k = new kg() {
            public void m7073a(sx sxVar, Map<String, String> map) {
                String str = (String) map.get("ty");
                String str2 = (String) map.get("td");
                try {
                    int parseInt = Integer.parseInt((String) map.get("tx"));
                    int parseInt2 = Integer.parseInt(str);
                    int parseInt3 = Integer.parseInt(str2);
                    cg n = sxVar.m8778n();
                    if (n != null) {
                        n.m5531a().m3928a(parseInt, parseInt2, parseInt3);
                    }
                } catch (NumberFormatException e) {
                    sg.m8449e("Could not parse touch parameters from gmsg.");
                }
            }
        };
        f4602l = new kg() {
            public void m7074a(sx sxVar, Map<String, String> map) {
                if (((Boolean) C1648if.bh.m6682c()).booleanValue()) {
                    sxVar.m8766c(!Boolean.parseBoolean((String) map.get("disabled")));
                }
            }
        };
        f4603m = new kg() {
            public void m7075a(sx sxVar, Map<String, String> map) {
                String str = (String) map.get("action");
                if ("pause".equals(str)) {
                    sxVar.zzbV();
                } else if ("resume".equals(str)) {
                    sxVar.zzbW();
                }
            }
        };
        f4604n = new kr();
        f4605o = new ks();
        f4606p = new kw();
        f4607q = new ke();
        f4608r = new kp();
        f4609s = new kg() {
            public void m7076a(sx sxVar, Map<String, String> map) {
                if (map.keySet().contains("start")) {
                    sxVar.m8776l().m8823i();
                } else if (map.keySet().contains("stop")) {
                    sxVar.m8776l().m8824j();
                } else if (map.keySet().contains("cancel")) {
                    sxVar.m8776l().m8825k();
                }
            }
        };
        f4610t = new kg() {
            public void m7077a(sx sxVar, Map<String, String> map) {
                if (map.keySet().contains("start")) {
                    sxVar.m8768d(true);
                }
                if (map.keySet().contains("stop")) {
                    sxVar.m8768d(false);
                }
            }
        };
        f4611u = new kg() {
            public void m7078a(sx sxVar, Map<String, String> map) {
                sxVar.m8757a("locationReady", zzv.zzcJ().m8504a((View) sxVar, (WindowManager) sxVar.getContext().getSystemService("window")));
                sg.m8449e("GET LOCATION COMPILED");
            }
        };
    }
}
