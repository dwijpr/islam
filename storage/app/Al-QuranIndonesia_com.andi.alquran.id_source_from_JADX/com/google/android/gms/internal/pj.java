package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug.MemoryInfo;
import android.support.v7.recyclerview.BuildConfig;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.ps.C1919a;
import com.google.android.gms.maps.GoogleMap;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@op
public final class pj {
    private static final SimpleDateFormat f5405a;

    static {
        f5405a = new SimpleDateFormat("yyyyMMdd", Locale.US);
    }

    private static Bundle m8118a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("runtime_free", Long.toString(bundle.getLong("runtime_free_memory", -1)));
        bundle2.putString("runtime_max", Long.toString(bundle.getLong("runtime_max_memory", -1)));
        bundle2.putString("runtime_total", Long.toString(bundle.getLong("runtime_total_memory", -1)));
        MemoryInfo memoryInfo = (MemoryInfo) bundle.getParcelable("debug_memory_info");
        if (memoryInfo != null) {
            bundle2.putString("debug_info_dalvik_private_dirty", Integer.toString(memoryInfo.dalvikPrivateDirty));
            bundle2.putString("debug_info_dalvik_pss", Integer.toString(memoryInfo.dalvikPss));
            bundle2.putString("debug_info_dalvik_shared_dirty", Integer.toString(memoryInfo.dalvikSharedDirty));
            bundle2.putString("debug_info_native_private_dirty", Integer.toString(memoryInfo.nativePrivateDirty));
            bundle2.putString("debug_info_native_pss", Integer.toString(memoryInfo.nativePss));
            bundle2.putString("debug_info_native_shared_dirty", Integer.toString(memoryInfo.nativeSharedDirty));
            bundle2.putString("debug_info_other_private_dirty", Integer.toString(memoryInfo.otherPrivateDirty));
            bundle2.putString("debug_info_other_pss", Integer.toString(memoryInfo.otherPss));
            bundle2.putString("debug_info_other_shared_dirty", Integer.toString(memoryInfo.otherSharedDirty));
        }
        return bundle2;
    }

    public static zzmk m8119a(Context context, zzmh com_google_android_gms_internal_zzmh, String str) {
        String optString;
        try {
            String str2;
            JSONObject jSONObject = new JSONObject(str);
            String optString2 = jSONObject.optString("ad_base_url", null);
            Object optString3 = jSONObject.optString("ad_url", null);
            String optString4 = jSONObject.optString("ad_size", null);
            String optString5 = jSONObject.optString("ad_slot_size", optString4);
            boolean z = (com_google_android_gms_internal_zzmh == null || com_google_android_gms_internal_zzmh.f6552m == 0) ? false : true;
            CharSequence optString6 = jSONObject.optString("ad_json", null);
            if (optString6 == null) {
                optString6 = jSONObject.optString("ad_html", null);
            }
            if (optString6 == null) {
                optString6 = jSONObject.optString("body", null);
            }
            long j = -1;
            String optString7 = jSONObject.optString("debug_dialog", null);
            String optString8 = jSONObject.optString("debug_signals", null);
            long j2 = jSONObject.has("interstitial_timeout") ? (long) (jSONObject.getDouble("interstitial_timeout") * 1000.0d) : -1;
            optString = jSONObject.optString("orientation", null);
            int i = -1;
            if ("portrait".equals(optString)) {
                i = zzv.zzcL().m8574b();
            } else if ("landscape".equals(optString)) {
                i = zzv.zzcL().m8560a();
            }
            zzmk com_google_android_gms_internal_zzmk = null;
            if (!TextUtils.isEmpty(optString6) || TextUtils.isEmpty(optString3)) {
                CharSequence charSequence = optString6;
            } else {
                com_google_android_gms_internal_zzmk = ph.m8113a(com_google_android_gms_internal_zzmh, context, com_google_android_gms_internal_zzmh.f6550k.f6636b, optString3, null, null, null, null);
                optString2 = com_google_android_gms_internal_zzmk.f6583b;
                str2 = com_google_android_gms_internal_zzmk.f6584c;
                j = com_google_android_gms_internal_zzmk.f6595n;
            }
            if (str2 == null) {
                return new zzmk(0);
            }
            long j3;
            String optString9;
            String str3;
            boolean optBoolean;
            JSONArray optJSONArray = jSONObject.optJSONArray("click_urls");
            List list = com_google_android_gms_internal_zzmk == null ? null : com_google_android_gms_internal_zzmk.f6585d;
            if (optJSONArray != null) {
                list = m8123a(optJSONArray, list);
            }
            optJSONArray = jSONObject.optJSONArray("impression_urls");
            List list2 = com_google_android_gms_internal_zzmk == null ? null : com_google_android_gms_internal_zzmk.f6587f;
            if (optJSONArray != null) {
                list2 = m8123a(optJSONArray, list2);
            }
            optJSONArray = jSONObject.optJSONArray("manual_impression_urls");
            List list3 = com_google_android_gms_internal_zzmk == null ? null : com_google_android_gms_internal_zzmk.f6591j;
            if (optJSONArray != null) {
                list3 = m8123a(optJSONArray, list3);
            }
            if (com_google_android_gms_internal_zzmk != null) {
                if (com_google_android_gms_internal_zzmk.f6593l != -1) {
                    i = com_google_android_gms_internal_zzmk.f6593l;
                }
                if (com_google_android_gms_internal_zzmk.f6588g > 0) {
                    j3 = com_google_android_gms_internal_zzmk.f6588g;
                    optString9 = jSONObject.optString("active_view");
                    str3 = null;
                    optBoolean = jSONObject.optBoolean("ad_is_javascript", false);
                    if (optBoolean) {
                        str3 = jSONObject.optString("ad_passback_url", null);
                    }
                    return new zzmk(com_google_android_gms_internal_zzmh, optString2, str2, list, list2, j3, jSONObject.optBoolean("mediation", false), jSONObject.optLong("mediation_config_cache_time_milliseconds", -1), list3, jSONObject.optLong("refresh_interval_milliseconds", -1), i, optString4, j, optString7, optBoolean, str3, optString9, jSONObject.optBoolean("custom_render_allowed", false), z, com_google_android_gms_internal_zzmh.f6555p, jSONObject.optBoolean("content_url_opted_out", true), jSONObject.optBoolean("prefetch", false), jSONObject.optString("gws_query_id", BuildConfig.VERSION_NAME), "height".equals(jSONObject.optString("fluid", BuildConfig.VERSION_NAME)), jSONObject.optBoolean("native_express", false), zzok.m9780a(jSONObject.optJSONArray("rewards")), m8123a(jSONObject.optJSONArray("video_start_urls"), null), m8123a(jSONObject.optJSONArray("video_complete_urls"), null), jSONObject.optBoolean("use_displayed_impression", false), zzmm.m9774a(jSONObject.optJSONObject("auto_protection_configuration")), com_google_android_gms_internal_zzmh.f6532I, jSONObject.optString("set_cookie", BuildConfig.VERSION_NAME), m8123a(jSONObject.optJSONArray("remote_ping_urls"), null), jSONObject.optBoolean("render_in_browser", com_google_android_gms_internal_zzmh.f6536M), optString5, zzon.m9782a(jSONObject.optJSONObject("safe_browsing")), optString8, jSONObject.optBoolean("content_vertical_opted_out", true));
                }
            }
            j3 = j2;
            optString9 = jSONObject.optString("active_view");
            str3 = null;
            optBoolean = jSONObject.optBoolean("ad_is_javascript", false);
            if (optBoolean) {
                str3 = jSONObject.optString("ad_passback_url", null);
            }
            return new zzmk(com_google_android_gms_internal_zzmh, optString2, str2, list, list2, j3, jSONObject.optBoolean("mediation", false), jSONObject.optLong("mediation_config_cache_time_milliseconds", -1), list3, jSONObject.optLong("refresh_interval_milliseconds", -1), i, optString4, j, optString7, optBoolean, str3, optString9, jSONObject.optBoolean("custom_render_allowed", false), z, com_google_android_gms_internal_zzmh.f6555p, jSONObject.optBoolean("content_url_opted_out", true), jSONObject.optBoolean("prefetch", false), jSONObject.optString("gws_query_id", BuildConfig.VERSION_NAME), "height".equals(jSONObject.optString("fluid", BuildConfig.VERSION_NAME)), jSONObject.optBoolean("native_express", false), zzok.m9780a(jSONObject.optJSONArray("rewards")), m8123a(jSONObject.optJSONArray("video_start_urls"), null), m8123a(jSONObject.optJSONArray("video_complete_urls"), null), jSONObject.optBoolean("use_displayed_impression", false), zzmm.m9774a(jSONObject.optJSONObject("auto_protection_configuration")), com_google_android_gms_internal_zzmh.f6532I, jSONObject.optString("set_cookie", BuildConfig.VERSION_NAME), m8123a(jSONObject.optJSONArray("remote_ping_urls"), null), jSONObject.optBoolean("render_in_browser", com_google_android_gms_internal_zzmh.f6536M), optString5, zzon.m9782a(jSONObject.optJSONObject("safe_browsing")), optString8, jSONObject.optBoolean("content_vertical_opted_out", true));
        } catch (JSONException e) {
            String str4 = "Could not parse the inline ad response: ";
            optString = String.valueOf(e.getMessage());
            sg.m8449e(optString.length() != 0 ? str4.concat(optString) : new String(str4));
            return new zzmk(0);
        }
    }

    private static Integer m8120a(boolean z) {
        return Integer.valueOf(z ? 1 : 0);
    }

    private static String m8121a(int i) {
        return String.format(Locale.US, "#%06x", new Object[]{Integer.valueOf(16777215 & i)});
    }

    private static String m8122a(zzgw com_google_android_gms_internal_zzgw) {
        switch (com_google_android_gms_internal_zzgw != null ? com_google_android_gms_internal_zzgw.f6481c : 0) {
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                return "portrait";
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                return "landscape";
            default:
                return "any";
        }
    }

    private static List<String> m8123a(JSONArray jSONArray, List<String> list) {
        if (jSONArray == null) {
            return null;
        }
        if (list == null) {
            list = new LinkedList();
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            list.add(jSONArray.getString(i));
        }
        return list;
    }

    static JSONArray m8124a(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        for (String put : list) {
            jSONArray.put(put);
        }
        return jSONArray;
    }

    public static JSONObject m8125a(Context context, pf pfVar) {
        Object obj;
        String str;
        String valueOf;
        zzmh com_google_android_gms_internal_zzmh = pfVar.f5368h;
        Location location = pfVar.f5364d;
        po poVar = pfVar.f5369i;
        Bundle bundle = pfVar.f5361a;
        JSONObject jSONObject = pfVar.f5370j;
        HashMap hashMap = new HashMap();
        hashMap.put("extra_caps", C1648if.bX.m6682c());
        if (pfVar.f5363c.size() > 0) {
            hashMap.put("eid", TextUtils.join(",", pfVar.f5363c));
        }
        if (com_google_android_gms_internal_zzmh.f6541b != null) {
            hashMap.put("ad_pos", com_google_android_gms_internal_zzmh.f6541b);
        }
        m8130a(hashMap, com_google_android_gms_internal_zzmh.f6542c);
        if (com_google_android_gms_internal_zzmh.f6543d.f6458h != null) {
            obj = null;
            Object obj2 = null;
            for (zzec com_google_android_gms_internal_zzec : com_google_android_gms_internal_zzmh.f6543d.f6458h) {
                if (!com_google_android_gms_internal_zzec.f6460j && r3 == null) {
                    hashMap.put("format", com_google_android_gms_internal_zzec.f6452b);
                    obj2 = 1;
                }
                if (com_google_android_gms_internal_zzec.f6460j && r2 == null) {
                    hashMap.put("fluid", "height");
                    obj = 1;
                }
                if (obj2 != null && r2 != null) {
                    break;
                }
            }
        } else {
            hashMap.put("format", com_google_android_gms_internal_zzmh.f6543d.f6452b);
            if (com_google_android_gms_internal_zzmh.f6543d.f6460j) {
                hashMap.put("fluid", "height");
            }
        }
        if (com_google_android_gms_internal_zzmh.f6543d.f6456f == -1) {
            hashMap.put("smart_w", "full");
        }
        if (com_google_android_gms_internal_zzmh.f6543d.f6453c == -2) {
            hashMap.put("smart_h", "auto");
        }
        if (com_google_android_gms_internal_zzmh.f6543d.f6458h != null) {
            StringBuilder stringBuilder = new StringBuilder();
            obj = null;
            for (zzec com_google_android_gms_internal_zzec2 : com_google_android_gms_internal_zzmh.f6543d.f6458h) {
                if (com_google_android_gms_internal_zzec2.f6460j) {
                    obj = 1;
                } else {
                    int i;
                    if (stringBuilder.length() != 0) {
                        stringBuilder.append("|");
                    }
                    if (com_google_android_gms_internal_zzec2.f6456f == -1) {
                        i = (int) (((float) com_google_android_gms_internal_zzec2.f6457g) / poVar.f5506r);
                    } else {
                        try {
                            i = com_google_android_gms_internal_zzec2.f6456f;
                        } catch (JSONException e) {
                            str = "Problem serializing ad request to JSON: ";
                            valueOf = String.valueOf(e.getMessage());
                            sg.m8449e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                            return null;
                        }
                    }
                    stringBuilder.append(i);
                    stringBuilder.append("x");
                    stringBuilder.append(com_google_android_gms_internal_zzec2.f6453c == -2 ? (int) (((float) com_google_android_gms_internal_zzec2.f6454d) / poVar.f5506r) : com_google_android_gms_internal_zzec2.f6453c);
                }
            }
            if (obj != null) {
                if (stringBuilder.length() != 0) {
                    stringBuilder.insert(0, "|");
                }
                stringBuilder.insert(0, "320x50");
            }
            hashMap.put("sz", stringBuilder);
        }
        if (com_google_android_gms_internal_zzmh.f6552m != 0) {
            hashMap.put("native_version", Integer.valueOf(com_google_android_gms_internal_zzmh.f6552m));
            hashMap.put("native_templates", com_google_android_gms_internal_zzmh.f6553n);
            hashMap.put("native_image_orientation", m8122a(com_google_android_gms_internal_zzmh.f6565z));
            if (!com_google_android_gms_internal_zzmh.f6524A.isEmpty()) {
                hashMap.put("native_custom_templates", com_google_android_gms_internal_zzmh.f6524A);
            }
        }
        if (com_google_android_gms_internal_zzmh.f6543d.f6461k) {
            hashMap.put("ene", Boolean.valueOf(true));
        }
        hashMap.put("slotname", com_google_android_gms_internal_zzmh.f6544e);
        hashMap.put("pn", com_google_android_gms_internal_zzmh.f6545f.packageName);
        if (com_google_android_gms_internal_zzmh.f6546g != null) {
            hashMap.put("vc", Integer.valueOf(com_google_android_gms_internal_zzmh.f6546g.versionCode));
        }
        hashMap.put("ms", pfVar.f5367g);
        hashMap.put("seq_num", com_google_android_gms_internal_zzmh.f6548i);
        hashMap.put("session_id", com_google_android_gms_internal_zzmh.f6549j);
        hashMap.put("js", com_google_android_gms_internal_zzmh.f6550k.f6636b);
        m8129a(hashMap, poVar, pfVar.f5365e, com_google_android_gms_internal_zzmh.f6538O, pfVar.f5362b);
        m8132a(hashMap, pfVar.f5366f);
        hashMap.put("platform", Build.MANUFACTURER);
        hashMap.put("submodel", Build.MODEL);
        if (location != null) {
            m8128a(hashMap, location);
        } else if (com_google_android_gms_internal_zzmh.f6542c.f6433a >= 2 && com_google_android_gms_internal_zzmh.f6542c.f6443k != null) {
            m8128a(hashMap, com_google_android_gms_internal_zzmh.f6542c.f6443k);
        }
        if (com_google_android_gms_internal_zzmh.f6540a >= 2) {
            hashMap.put("quality_signals", com_google_android_gms_internal_zzmh.f6551l);
        }
        if (com_google_android_gms_internal_zzmh.f6540a >= 4 && com_google_android_gms_internal_zzmh.f6555p) {
            hashMap.put("forceHttps", Boolean.valueOf(com_google_android_gms_internal_zzmh.f6555p));
        }
        if (bundle != null) {
            hashMap.put("content_info", bundle);
        }
        if (com_google_android_gms_internal_zzmh.f6540a >= 5) {
            hashMap.put("u_sd", Float.valueOf(com_google_android_gms_internal_zzmh.f6559t));
            hashMap.put("sh", Integer.valueOf(com_google_android_gms_internal_zzmh.f6558s));
            hashMap.put("sw", Integer.valueOf(com_google_android_gms_internal_zzmh.f6557r));
        } else {
            hashMap.put("u_sd", Float.valueOf(poVar.f5506r));
            hashMap.put("sh", Integer.valueOf(poVar.f5508t));
            hashMap.put("sw", Integer.valueOf(poVar.f5507s));
        }
        if (com_google_android_gms_internal_zzmh.f6540a >= 6) {
            if (!TextUtils.isEmpty(com_google_android_gms_internal_zzmh.f6560u)) {
                try {
                    hashMap.put("view_hierarchy", new JSONObject(com_google_android_gms_internal_zzmh.f6560u));
                } catch (Throwable e2) {
                    sg.m8447c("Problem serializing view hierarchy to JSON", e2);
                }
            }
            hashMap.put("correlation_id", Long.valueOf(com_google_android_gms_internal_zzmh.f6561v));
        }
        if (com_google_android_gms_internal_zzmh.f6540a >= 7) {
            hashMap.put("request_id", com_google_android_gms_internal_zzmh.f6562w);
        }
        if (com_google_android_gms_internal_zzmh.f6540a >= 11 && com_google_android_gms_internal_zzmh.f6526C != null) {
            hashMap.put("capability", com_google_android_gms_internal_zzmh.f6526C.m9775a());
        }
        if (com_google_android_gms_internal_zzmh.f6540a >= 12 && !TextUtils.isEmpty(com_google_android_gms_internal_zzmh.f6527D)) {
            hashMap.put("anchor", com_google_android_gms_internal_zzmh.f6527D);
        }
        if (com_google_android_gms_internal_zzmh.f6540a >= 13) {
            hashMap.put("android_app_volume", Float.valueOf(com_google_android_gms_internal_zzmh.f6528E));
        }
        if (com_google_android_gms_internal_zzmh.f6540a >= 18) {
            hashMap.put("android_app_muted", Boolean.valueOf(com_google_android_gms_internal_zzmh.f6534K));
        }
        if (com_google_android_gms_internal_zzmh.f6540a >= 14 && com_google_android_gms_internal_zzmh.f6529F > 0) {
            hashMap.put("target_api", Integer.valueOf(com_google_android_gms_internal_zzmh.f6529F));
        }
        if (com_google_android_gms_internal_zzmh.f6540a >= 15) {
            hashMap.put("scroll_index", Integer.valueOf(com_google_android_gms_internal_zzmh.f6530G == -1 ? -1 : com_google_android_gms_internal_zzmh.f6530G));
        }
        if (com_google_android_gms_internal_zzmh.f6540a >= 16) {
            hashMap.put("_activity_context", Boolean.valueOf(com_google_android_gms_internal_zzmh.f6531H));
        }
        if (com_google_android_gms_internal_zzmh.f6540a >= 18) {
            if (!TextUtils.isEmpty(com_google_android_gms_internal_zzmh.f6535L)) {
                try {
                    hashMap.put("app_settings", new JSONObject(com_google_android_gms_internal_zzmh.f6535L));
                } catch (Throwable e22) {
                    sg.m8447c("Problem creating json from app settings", e22);
                }
            }
            hashMap.put("render_in_browser", Boolean.valueOf(com_google_android_gms_internal_zzmh.f6536M));
        }
        if (com_google_android_gms_internal_zzmh.f6540a >= 18) {
            hashMap.put("android_num_video_cache_tasks", Integer.valueOf(com_google_android_gms_internal_zzmh.f6537N));
        }
        m8127a(hashMap);
        hashMap.put("cache_state", jSONObject);
        if (com_google_android_gms_internal_zzmh.f6540a >= 19) {
            hashMap.put("gct", com_google_android_gms_internal_zzmh.f6539P);
        }
        if (sg.m8443a(2)) {
            str = "Ad Request JSON: ";
            valueOf = String.valueOf(zzv.zzcJ().m8506a((Map) hashMap).toString(2));
            rm.m8450a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
        return zzv.zzcJ().m8506a((Map) hashMap);
    }

    public static JSONObject m8126a(zzmk com_google_android_gms_internal_zzmk) {
        JSONObject jSONObject = new JSONObject();
        if (com_google_android_gms_internal_zzmk.f6583b != null) {
            jSONObject.put("ad_base_url", com_google_android_gms_internal_zzmk.f6583b);
        }
        if (com_google_android_gms_internal_zzmk.f6594m != null) {
            jSONObject.put("ad_size", com_google_android_gms_internal_zzmk.f6594m);
        }
        jSONObject.put("native", com_google_android_gms_internal_zzmk.f6601t);
        if (com_google_android_gms_internal_zzmk.f6601t) {
            jSONObject.put("ad_json", com_google_android_gms_internal_zzmk.f6584c);
        } else {
            jSONObject.put("ad_html", com_google_android_gms_internal_zzmk.f6584c);
        }
        if (com_google_android_gms_internal_zzmk.f6596o != null) {
            jSONObject.put("debug_dialog", com_google_android_gms_internal_zzmk.f6596o);
        }
        if (com_google_android_gms_internal_zzmk.f6579N != null) {
            jSONObject.put("debug_signals", com_google_android_gms_internal_zzmk.f6579N);
        }
        if (com_google_android_gms_internal_zzmk.f6588g != -1) {
            jSONObject.put("interstitial_timeout", ((double) com_google_android_gms_internal_zzmk.f6588g) / 1000.0d);
        }
        if (com_google_android_gms_internal_zzmk.f6593l == zzv.zzcL().m8574b()) {
            jSONObject.put("orientation", "portrait");
        } else if (com_google_android_gms_internal_zzmk.f6593l == zzv.zzcL().m8560a()) {
            jSONObject.put("orientation", "landscape");
        }
        if (com_google_android_gms_internal_zzmk.f6585d != null) {
            jSONObject.put("click_urls", m8124a(com_google_android_gms_internal_zzmk.f6585d));
        }
        if (com_google_android_gms_internal_zzmk.f6587f != null) {
            jSONObject.put("impression_urls", m8124a(com_google_android_gms_internal_zzmk.f6587f));
        }
        if (com_google_android_gms_internal_zzmk.f6591j != null) {
            jSONObject.put("manual_impression_urls", m8124a(com_google_android_gms_internal_zzmk.f6591j));
        }
        if (com_google_android_gms_internal_zzmk.f6599r != null) {
            jSONObject.put("active_view", com_google_android_gms_internal_zzmk.f6599r);
        }
        jSONObject.put("ad_is_javascript", com_google_android_gms_internal_zzmk.f6597p);
        if (com_google_android_gms_internal_zzmk.f6598q != null) {
            jSONObject.put("ad_passback_url", com_google_android_gms_internal_zzmk.f6598q);
        }
        jSONObject.put("mediation", com_google_android_gms_internal_zzmk.f6589h);
        jSONObject.put("custom_render_allowed", com_google_android_gms_internal_zzmk.f6600s);
        jSONObject.put("content_url_opted_out", com_google_android_gms_internal_zzmk.f6603v);
        jSONObject.put("content_vertical_opted_out", com_google_android_gms_internal_zzmk.f6580O);
        jSONObject.put("prefetch", com_google_android_gms_internal_zzmk.f6604w);
        if (com_google_android_gms_internal_zzmk.f6592k != -1) {
            jSONObject.put("refresh_interval_milliseconds", com_google_android_gms_internal_zzmk.f6592k);
        }
        if (com_google_android_gms_internal_zzmk.f6590i != -1) {
            jSONObject.put("mediation_config_cache_time_milliseconds", com_google_android_gms_internal_zzmk.f6590i);
        }
        if (!TextUtils.isEmpty(com_google_android_gms_internal_zzmk.f6607z)) {
            jSONObject.put("gws_query_id", com_google_android_gms_internal_zzmk.f6607z);
        }
        jSONObject.put("fluid", com_google_android_gms_internal_zzmk.f6566A ? "height" : BuildConfig.VERSION_NAME);
        jSONObject.put("native_express", com_google_android_gms_internal_zzmk.f6567B);
        if (com_google_android_gms_internal_zzmk.f6569D != null) {
            jSONObject.put("video_start_urls", m8124a(com_google_android_gms_internal_zzmk.f6569D));
        }
        if (com_google_android_gms_internal_zzmk.f6570E != null) {
            jSONObject.put("video_complete_urls", m8124a(com_google_android_gms_internal_zzmk.f6570E));
        }
        if (com_google_android_gms_internal_zzmk.f6568C != null) {
            jSONObject.put("rewards", com_google_android_gms_internal_zzmk.f6568C.m9781a());
        }
        jSONObject.put("use_displayed_impression", com_google_android_gms_internal_zzmk.f6571F);
        jSONObject.put("auto_protection_configuration", com_google_android_gms_internal_zzmk.f6572G);
        jSONObject.put("render_in_browser", com_google_android_gms_internal_zzmk.f6576K);
        return jSONObject;
    }

    private static void m8127a(HashMap<String, Object> hashMap) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle2.putString("cl", "139965458");
        bundle2.putString("rapid_rc", "dev");
        bundle2.putString("rapid_rollup", "HEAD");
        bundle.putBundle("build_meta", bundle2);
        bundle.putString("mf", Boolean.toString(((Boolean) C1648if.bZ.m6682c()).booleanValue()));
        hashMap.put("sdk_env", bundle);
    }

    private static void m8128a(HashMap<String, Object> hashMap, Location location) {
        HashMap hashMap2 = new HashMap();
        Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
        Long valueOf2 = Long.valueOf(location.getTime() * 1000);
        Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
        Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
        hashMap2.put("radius", valueOf);
        hashMap2.put("lat", valueOf3);
        hashMap2.put("long", valueOf4);
        hashMap2.put("time", valueOf2);
        hashMap.put("uule", hashMap2);
    }

    private static void m8129a(HashMap<String, Object> hashMap, po poVar, C1919a c1919a, Bundle bundle, Bundle bundle2) {
        hashMap.put("am", Integer.valueOf(poVar.f5489a));
        hashMap.put("cog", m8120a(poVar.f5490b));
        hashMap.put("coh", m8120a(poVar.f5491c));
        if (!TextUtils.isEmpty(poVar.f5492d)) {
            hashMap.put("carrier", poVar.f5492d);
        }
        hashMap.put("gl", poVar.f5493e);
        if (poVar.f5494f) {
            hashMap.put("simulator", Integer.valueOf(1));
        }
        if (poVar.f5495g) {
            hashMap.put("is_sidewinder", Integer.valueOf(1));
        }
        hashMap.put("ma", m8120a(poVar.f5496h));
        hashMap.put("sp", m8120a(poVar.f5497i));
        hashMap.put("hl", poVar.f5498j);
        if (!TextUtils.isEmpty(poVar.f5499k)) {
            hashMap.put("mv", poVar.f5499k);
        }
        hashMap.put("muv", Integer.valueOf(poVar.f5500l));
        if (poVar.f5501m != -2) {
            hashMap.put("cnt", Integer.valueOf(poVar.f5501m));
        }
        hashMap.put("gnt", Integer.valueOf(poVar.f5502n));
        hashMap.put("pt", Integer.valueOf(poVar.f5503o));
        hashMap.put("rm", Integer.valueOf(poVar.f5504p));
        hashMap.put("riv", Integer.valueOf(poVar.f5505q));
        Bundle bundle3 = new Bundle();
        bundle3.putString("build", poVar.f5513y);
        Bundle bundle4 = new Bundle();
        bundle4.putBoolean("is_charging", poVar.f5510v);
        bundle4.putDouble("battery_level", poVar.f5509u);
        bundle3.putBundle("battery", bundle4);
        bundle4 = new Bundle();
        bundle4.putInt("active_network_state", poVar.f5512x);
        bundle4.putBoolean("active_network_metered", poVar.f5511w);
        if (c1919a != null) {
            Bundle bundle5 = new Bundle();
            bundle5.putInt("predicted_latency_micros", c1919a.f5518a);
            bundle5.putLong("predicted_down_throughput_bps", c1919a.f5519b);
            bundle5.putLong("predicted_up_throughput_bps", c1919a.f5520c);
            bundle4.putBundle("predictions", bundle5);
        }
        bundle3.putBundle("network", bundle4);
        bundle4 = new Bundle();
        bundle4.putBoolean("is_browser_custom_tabs_capable", poVar.f5514z);
        bundle3.putBundle("browser", bundle4);
        if (bundle != null) {
            bundle3.putBundle("android_mem_info", m8118a(bundle));
        }
        bundle4 = new Bundle();
        bundle4.putBundle("parental_controls", bundle2);
        bundle3.putBundle("play_store", bundle4);
        hashMap.put("device", bundle3);
    }

    private static void m8130a(HashMap<String, Object> hashMap, zzdy com_google_android_gms_internal_zzdy) {
        String a = rk.m8439a();
        if (a != null) {
            hashMap.put("abf", a);
        }
        if (com_google_android_gms_internal_zzdy.f6434b != -1) {
            hashMap.put("cust_age", f5405a.format(new Date(com_google_android_gms_internal_zzdy.f6434b)));
        }
        if (com_google_android_gms_internal_zzdy.f6435c != null) {
            hashMap.put("extras", com_google_android_gms_internal_zzdy.f6435c);
        }
        if (com_google_android_gms_internal_zzdy.f6436d != -1) {
            hashMap.put("cust_gender", Integer.valueOf(com_google_android_gms_internal_zzdy.f6436d));
        }
        if (com_google_android_gms_internal_zzdy.f6437e != null) {
            hashMap.put("kw", com_google_android_gms_internal_zzdy.f6437e);
        }
        if (com_google_android_gms_internal_zzdy.f6439g != -1) {
            hashMap.put("tag_for_child_directed_treatment", Integer.valueOf(com_google_android_gms_internal_zzdy.f6439g));
        }
        if (com_google_android_gms_internal_zzdy.f6438f) {
            hashMap.put("adtest", "on");
        }
        if (com_google_android_gms_internal_zzdy.f6433a >= 2) {
            if (com_google_android_gms_internal_zzdy.f6440h) {
                hashMap.put("d_imp_hdr", Integer.valueOf(1));
            }
            if (!TextUtils.isEmpty(com_google_android_gms_internal_zzdy.f6441i)) {
                hashMap.put("ppid", com_google_android_gms_internal_zzdy.f6441i);
            }
            if (com_google_android_gms_internal_zzdy.f6442j != null) {
                m8131a((HashMap) hashMap, com_google_android_gms_internal_zzdy.f6442j);
            }
        }
        if (com_google_android_gms_internal_zzdy.f6433a >= 3 && com_google_android_gms_internal_zzdy.f6444l != null) {
            hashMap.put("url", com_google_android_gms_internal_zzdy.f6444l);
        }
        if (com_google_android_gms_internal_zzdy.f6433a >= 5) {
            if (com_google_android_gms_internal_zzdy.f6446n != null) {
                hashMap.put("custom_targeting", com_google_android_gms_internal_zzdy.f6446n);
            }
            if (com_google_android_gms_internal_zzdy.f6447o != null) {
                hashMap.put("category_exclusions", com_google_android_gms_internal_zzdy.f6447o);
            }
            if (com_google_android_gms_internal_zzdy.f6448p != null) {
                hashMap.put("request_agent", com_google_android_gms_internal_zzdy.f6448p);
            }
        }
        if (com_google_android_gms_internal_zzdy.f6433a >= 6 && com_google_android_gms_internal_zzdy.f6449q != null) {
            hashMap.put("request_pkg", com_google_android_gms_internal_zzdy.f6449q);
        }
        if (com_google_android_gms_internal_zzdy.f6433a >= 7) {
            hashMap.put("is_designed_for_families", Boolean.valueOf(com_google_android_gms_internal_zzdy.f6450r));
        }
    }

    private static void m8131a(HashMap<String, Object> hashMap, zzfj com_google_android_gms_internal_zzfj) {
        Object obj;
        Object obj2 = null;
        if (Color.alpha(com_google_android_gms_internal_zzfj.f6463b) != 0) {
            hashMap.put("acolor", m8121a(com_google_android_gms_internal_zzfj.f6463b));
        }
        if (Color.alpha(com_google_android_gms_internal_zzfj.f6464c) != 0) {
            hashMap.put("bgcolor", m8121a(com_google_android_gms_internal_zzfj.f6464c));
        }
        if (!(Color.alpha(com_google_android_gms_internal_zzfj.f6465d) == 0 || Color.alpha(com_google_android_gms_internal_zzfj.f6466e) == 0)) {
            hashMap.put("gradientto", m8121a(com_google_android_gms_internal_zzfj.f6465d));
            hashMap.put("gradientfrom", m8121a(com_google_android_gms_internal_zzfj.f6466e));
        }
        if (Color.alpha(com_google_android_gms_internal_zzfj.f6467f) != 0) {
            hashMap.put("bcolor", m8121a(com_google_android_gms_internal_zzfj.f6467f));
        }
        hashMap.put("bthick", Integer.toString(com_google_android_gms_internal_zzfj.f6468g));
        switch (com_google_android_gms_internal_zzfj.f6469h) {
            case GoogleMap.MAP_TYPE_NONE /*0*/:
                obj = "none";
                break;
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                obj = "dashed";
                break;
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                obj = "dotted";
                break;
            case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                obj = "solid";
                break;
            default:
                obj = null;
                break;
        }
        if (obj != null) {
            hashMap.put("btype", obj);
        }
        switch (com_google_android_gms_internal_zzfj.f6470i) {
            case GoogleMap.MAP_TYPE_NONE /*0*/:
                obj2 = "light";
                break;
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                obj2 = "medium";
                break;
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                obj2 = "dark";
                break;
        }
        if (obj2 != null) {
            hashMap.put("callbuttoncolor", obj2);
        }
        if (com_google_android_gms_internal_zzfj.f6471j != null) {
            hashMap.put("channel", com_google_android_gms_internal_zzfj.f6471j);
        }
        if (Color.alpha(com_google_android_gms_internal_zzfj.f6472k) != 0) {
            hashMap.put("dcolor", m8121a(com_google_android_gms_internal_zzfj.f6472k));
        }
        if (com_google_android_gms_internal_zzfj.f6473l != null) {
            hashMap.put("font", com_google_android_gms_internal_zzfj.f6473l);
        }
        if (Color.alpha(com_google_android_gms_internal_zzfj.f6474m) != 0) {
            hashMap.put("hcolor", m8121a(com_google_android_gms_internal_zzfj.f6474m));
        }
        hashMap.put("headersize", Integer.toString(com_google_android_gms_internal_zzfj.f6475n));
        if (com_google_android_gms_internal_zzfj.f6476o != null) {
            hashMap.put("q", com_google_android_gms_internal_zzfj.f6476o);
        }
    }

    private static void m8132a(HashMap<String, Object> hashMap, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("doritos", str);
        hashMap.put("pii", bundle);
    }
}
