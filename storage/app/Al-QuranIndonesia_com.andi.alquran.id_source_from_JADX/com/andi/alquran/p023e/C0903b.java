package com.andi.alquran.p023e;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.recyclerview.BuildConfig;
import android.util.Log;
import com.android.vending.billing.IInAppBillingService;
import com.android.vending.billing.IInAppBillingService.Stub;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

/* renamed from: com.andi.alquran.e.b */
public class C0903b {
    boolean f1763a;
    String f1764b;
    boolean f1765c;
    boolean f1766d;
    boolean f1767e;
    boolean f1768f;
    boolean f1769g;
    boolean f1770h;
    String f1771i;
    Context f1772j;
    IInAppBillingService f1773k;
    ServiceConnection f1774l;
    int f1775m;
    String f1776n;
    String f1777o;
    C0816b f1778p;
    private final Object f1779q;

    /* renamed from: com.andi.alquran.e.b.c */
    public interface C0748c {
        void m2608a(C0904c c0904c);
    }

    /* renamed from: com.andi.alquran.e.b.d */
    public interface C0750d {
        void m2610a(C0904c c0904c, C0905d c0905d);
    }

    /* renamed from: com.andi.alquran.e.b.b */
    public interface C0816b {
        void m2813a(C0904c c0904c, C0906e c0906e);
    }

    /* renamed from: com.andi.alquran.e.b.1 */
    class C08991 implements ServiceConnection {
        final /* synthetic */ C0748c f1752a;
        final /* synthetic */ C0903b f1753b;

        C08991(C0903b c0903b, C0748c c0748c) {
            this.f1753b = c0903b;
            this.f1752a = c0748c;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (!this.f1753b.f1766d) {
                this.f1753b.m3135c("Billing service connected.");
                this.f1753b.f1773k = Stub.m3392a(iBinder);
                String packageName = this.f1753b.f1772j.getPackageName();
                try {
                    this.f1753b.m3135c("Checking for in-app billing 3 support.");
                    int a = this.f1753b.f1773k.m3378a(3, packageName, "inapp");
                    if (a != 0) {
                        if (this.f1752a != null) {
                            this.f1752a.m2608a(new C0904c(a, "Error checking for billing v3 support."));
                        }
                        this.f1753b.f1768f = false;
                        this.f1753b.f1769g = false;
                        return;
                    }
                    this.f1753b.m3135c("In-app billing version 3 supported for " + packageName);
                    if (this.f1753b.f1773k.m3378a(5, packageName, "subs") == 0) {
                        this.f1753b.m3135c("Subscription re-signup AVAILABLE.");
                        this.f1753b.f1769g = true;
                    } else {
                        this.f1753b.m3135c("Subscription re-signup not available.");
                        this.f1753b.f1769g = false;
                    }
                    if (this.f1753b.f1769g) {
                        this.f1753b.f1768f = true;
                    } else {
                        int a2 = this.f1753b.f1773k.m3378a(3, packageName, "subs");
                        if (a2 == 0) {
                            this.f1753b.m3135c("Subscriptions AVAILABLE.");
                            this.f1753b.f1768f = true;
                        } else {
                            this.f1753b.m3135c("Subscriptions NOT AVAILABLE. Response: " + a2);
                            this.f1753b.f1768f = false;
                            this.f1753b.f1769g = false;
                        }
                    }
                    this.f1753b.f1765c = true;
                    if (this.f1752a != null) {
                        this.f1752a.m2608a(new C0904c(0, "Setup successful."));
                    }
                } catch (RemoteException e) {
                    if (this.f1752a != null) {
                        this.f1752a.m2608a(new C0904c(-1001, "RemoteException while setting up in-app billing."));
                    }
                    e.printStackTrace();
                }
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            this.f1753b.m3135c("Billing service disconnected.");
            this.f1753b.f1773k = null;
        }
    }

    /* renamed from: com.andi.alquran.e.b.2 */
    class C09012 implements Runnable {
        final /* synthetic */ boolean f1757a;
        final /* synthetic */ List f1758b;
        final /* synthetic */ List f1759c;
        final /* synthetic */ C0750d f1760d;
        final /* synthetic */ Handler f1761e;
        final /* synthetic */ C0903b f1762f;

        /* renamed from: com.andi.alquran.e.b.2.1 */
        class C09001 implements Runnable {
            final /* synthetic */ C0904c f1754a;
            final /* synthetic */ C0905d f1755b;
            final /* synthetic */ C09012 f1756c;

            C09001(C09012 c09012, C0904c c0904c, C0905d c0905d) {
                this.f1756c = c09012;
                this.f1754a = c0904c;
                this.f1755b = c0905d;
            }

            public void run() {
                this.f1756c.f1760d.m2610a(this.f1754a, this.f1755b);
            }
        }

        C09012(C0903b c0903b, boolean z, List list, List list2, C0750d c0750d, Handler handler) {
            this.f1762f = c0903b;
            this.f1757a = z;
            this.f1758b = list;
            this.f1759c = list2;
            this.f1760d = c0750d;
            this.f1761e = handler;
        }

        public void run() {
            C0904c c0904c = new C0904c(0, "Inventory refresh successful.");
            C0905d c0905d = null;
            try {
                c0905d = this.f1762f.m3122a(this.f1757a, this.f1758b, this.f1759c);
            } catch (C0898a e) {
                c0904c = e.m3115a();
            }
            this.f1762f.m3134c();
            if (!this.f1762f.f1766d && this.f1760d != null) {
                this.f1761e.post(new C09001(this, c0904c, c0905d));
            }
        }
    }

    /* renamed from: com.andi.alquran.e.b.a */
    public static class C0902a extends Exception {
        public C0902a(String str) {
            super(str);
        }
    }

    public C0903b(Context context, String str) {
        this.f1763a = false;
        this.f1764b = "IabHelper";
        this.f1765c = false;
        this.f1766d = false;
        this.f1767e = false;
        this.f1768f = false;
        this.f1769g = false;
        this.f1770h = false;
        this.f1779q = new Object();
        this.f1771i = BuildConfig.VERSION_NAME;
        this.f1777o = null;
        this.f1772j = context.getApplicationContext();
        this.f1777o = str;
        m3135c("IAB helper created.");
    }

    public static String m3116a(int i) {
        String[] split = "0:OK/1:User Canceled/2:Unknown/3:Billing Unavailable/4:Item unavailable/5:Developer Error/6:Error/7:Item Already Owned/8:Item not owned".split("/");
        String[] split2 = "0:OK/-1001:Remote exception during initialization/-1002:Bad response received/-1003:Purchase signature verification failed/-1004:Send intent failed/-1005:User cancelled/-1006:Unknown purchase response/-1007:Missing token/-1008:Unknown error/-1009:Subscriptions not available/-1010:Invalid consumption attempt".split("/");
        if (i > NotificationManagerCompat.IMPORTANCE_UNSPECIFIED) {
            return (i < 0 || i >= split.length) ? String.valueOf(i) + ":Unknown" : split[i];
        } else {
            int i2 = -1000 - i;
            return (i2 < 0 || i2 >= split2.length) ? String.valueOf(i) + ":Unknown IAB Helper Error" : split2[i2];
        }
    }

    private void m3117d() {
        if (this.f1766d) {
            throw new IllegalStateException("IabHelper was disposed of, so it cannot be used.");
        }
    }

    int m3118a(Intent intent) {
        Object obj = intent.getExtras().get("RESPONSE_CODE");
        if (obj == null) {
            m3136d("Intent with no response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            m3136d("Unexpected type for intent response code.");
            m3136d(obj.getClass().getName());
            throw new RuntimeException("Unexpected type for intent response code: " + obj.getClass().getName());
        }
    }

    int m3119a(Bundle bundle) {
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            m3135c("Bundle with null response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            m3136d("Unexpected type for bundle response code.");
            m3136d(obj.getClass().getName());
            throw new RuntimeException("Unexpected type for bundle response code: " + obj.getClass().getName());
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    int m3120a(com.andi.alquran.p023e.C0905d r13, java.lang.String r14) {
        /*
        r12 = this;
        r3 = 0;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "Querying owned items, item type: ";
        r0 = r0.append(r1);
        r0 = r0.append(r14);
        r0 = r0.toString();
        r12.m3135c(r0);
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "Package name: ";
        r0 = r0.append(r1);
        r1 = r12.f1772j;
        r1 = r1.getPackageName();
        r0 = r0.append(r1);
        r0 = r0.toString();
        r12.m3135c(r0);
        r0 = 0;
        r1 = r3;
    L_0x0035:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r4 = "Calling getPurchases with continuation token: ";
        r2 = r2.append(r4);
        r2 = r2.append(r0);
        r2 = r2.toString();
        r12.m3135c(r2);
        r2 = r12.f1773k;
        r4 = 3;
        r5 = r12.f1772j;
        r5 = r5.getPackageName();
        r6 = r2.m3380a(r4, r5, r14, r0);
        r0 = r12.m3119a(r6);
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r4 = "Owned items response: ";
        r2 = r2.append(r4);
        r4 = java.lang.String.valueOf(r0);
        r2 = r2.append(r4);
        r2 = r2.toString();
        r12.m3135c(r2);
        if (r0 == 0) goto L_0x0094;
    L_0x0078:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "getPurchases() failed: ";
        r1 = r1.append(r2);
        r2 = com.andi.alquran.p023e.C0903b.m3116a(r0);
        r1 = r1.append(r2);
        r1 = r1.toString();
        r12.m3135c(r1);
        r3 = r0;
    L_0x0093:
        return r3;
    L_0x0094:
        r0 = "INAPP_PURCHASE_ITEM_LIST";
        r0 = r6.containsKey(r0);
        if (r0 == 0) goto L_0x00ac;
    L_0x009c:
        r0 = "INAPP_PURCHASE_DATA_LIST";
        r0 = r6.containsKey(r0);
        if (r0 == 0) goto L_0x00ac;
    L_0x00a4:
        r0 = "INAPP_DATA_SIGNATURE_LIST";
        r0 = r6.containsKey(r0);
        if (r0 != 0) goto L_0x00b4;
    L_0x00ac:
        r0 = "Bundle returned from getPurchases() doesn't contain required fields.";
        r12.m3136d(r0);
        r3 = -1002; // 0xfffffffffffffc16 float:NaN double:NaN;
        goto L_0x0093;
    L_0x00b4:
        r0 = "INAPP_PURCHASE_ITEM_LIST";
        r7 = r6.getStringArrayList(r0);
        r0 = "INAPP_PURCHASE_DATA_LIST";
        r8 = r6.getStringArrayList(r0);
        r0 = "INAPP_DATA_SIGNATURE_LIST";
        r9 = r6.getStringArrayList(r0);
        r5 = r3;
        r4 = r1;
    L_0x00c8:
        r0 = r8.size();
        if (r5 >= r0) goto L_0x0162;
    L_0x00ce:
        r0 = r8.get(r5);
        r0 = (java.lang.String) r0;
        r1 = r9.get(r5);
        r1 = (java.lang.String) r1;
        r2 = r7.get(r5);
        r2 = (java.lang.String) r2;
        r10 = r12.f1777o;
        r10 = com.andi.alquran.p023e.C0907f.m3150a(r10, r0, r1);
        if (r10 == 0) goto L_0x012f;
    L_0x00e8:
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r11 = "Sku is owned: ";
        r10 = r10.append(r11);
        r2 = r10.append(r2);
        r2 = r2.toString();
        r12.m3135c(r2);
        r2 = new com.andi.alquran.e.e;
        r2.<init>(r14, r0, r1);
        r1 = r2.m3148d();
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 == 0) goto L_0x0128;
    L_0x010d:
        r1 = "BUG: empty/null token!";
        r12.m3137e(r1);
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r10 = "Purchase data: ";
        r1 = r1.append(r10);
        r0 = r1.append(r0);
        r0 = r0.toString();
        r12.m3135c(r0);
    L_0x0128:
        r13.m3142a(r2);
    L_0x012b:
        r0 = r5 + 1;
        r5 = r0;
        goto L_0x00c8;
    L_0x012f:
        r2 = "Purchase signature verification **FAILED**. Not adding item.";
        r12.m3137e(r2);
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r4 = "   Purchase data: ";
        r2 = r2.append(r4);
        r0 = r2.append(r0);
        r0 = r0.toString();
        r12.m3135c(r0);
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = "   Signature: ";
        r0 = r0.append(r2);
        r0 = r0.append(r1);
        r0 = r0.toString();
        r12.m3135c(r0);
        r4 = 1;
        goto L_0x012b;
    L_0x0162:
        r0 = "INAPP_CONTINUATION_TOKEN";
        r0 = r6.getString(r0);
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Continuation token: ";
        r1 = r1.append(r2);
        r1 = r1.append(r0);
        r1 = r1.toString();
        r12.m3135c(r1);
        r1 = android.text.TextUtils.isEmpty(r0);
        if (r1 == 0) goto L_0x018a;
    L_0x0184:
        if (r4 == 0) goto L_0x0093;
    L_0x0186:
        r3 = -1003; // 0xfffffffffffffc15 float:NaN double:NaN;
        goto L_0x0093;
    L_0x018a:
        r1 = r4;
        goto L_0x0035;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.andi.alquran.e.b.a(com.andi.alquran.e.d, java.lang.String):int");
    }

    int m3121a(String str, C0905d c0905d, List<String> list) {
        Iterator it;
        m3135c("Querying SKU details.");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(c0905d.m3144b(str));
        if (list != null) {
            for (String str2 : list) {
                if (!arrayList.contains(str2)) {
                    arrayList.add(str2);
                }
            }
        }
        if (arrayList.size() == 0) {
            m3135c("queryPrices: nothing to do because there are no SKUs.");
            return 0;
        }
        Iterator it2;
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size() / 20;
        int size2 = arrayList.size() % 20;
        for (int i = 0; i < size; i++) {
            ArrayList arrayList3 = new ArrayList();
            for (String str22 : arrayList.subList(i * 20, (i * 20) + 20)) {
                arrayList3.add(str22);
            }
            arrayList2.add(arrayList3);
        }
        if (size2 != 0) {
            ArrayList arrayList4 = new ArrayList();
            for (String str222 : arrayList.subList(size * 20, (size * 20) + size2)) {
                arrayList4.add(str222);
            }
            arrayList2.add(arrayList4);
        }
        it = arrayList2.iterator();
        while (it.hasNext()) {
            ArrayList arrayList5 = (ArrayList) it.next();
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList5);
            Bundle a = this.f1773k.m3379a(3, this.f1772j.getPackageName(), str, bundle);
            if (a.containsKey("DETAILS_LIST")) {
                it2 = a.getStringArrayList("DETAILS_LIST").iterator();
                while (it2.hasNext()) {
                    C0908g c0908g = new C0908g(str, (String) it2.next());
                    m3135c("Got sku details: " + c0908g);
                    c0905d.m3143a(c0908g);
                }
            } else {
                int a2 = m3119a(a);
                if (a2 != 0) {
                    m3135c("getSkuDetails() failed: " + C0903b.m3116a(a2));
                    return a2;
                }
                m3136d("getSkuDetails() returned a bundle with neither an error nor a detail list.");
                return -1002;
            }
        }
        return 0;
    }

    public C0905d m3122a(boolean z, List<String> list, List<String> list2) {
        m3117d();
        m3128a("queryInventory");
        try {
            C0905d c0905d = new C0905d();
            int a = m3120a(c0905d, "inapp");
            if (a != 0) {
                throw new C0898a(a, "Error refreshing inventory (querying owned items).");
            }
            if (z) {
                a = m3121a("inapp", c0905d, (List) list);
                if (a != 0) {
                    throw new C0898a(a, "Error refreshing inventory (querying prices of items).");
                }
            }
            if (this.f1768f) {
                a = m3120a(c0905d, "subs");
                if (a != 0) {
                    throw new C0898a(a, "Error refreshing inventory (querying owned subscriptions).");
                } else if (z) {
                    a = m3121a("subs", c0905d, (List) list2);
                    if (a != 0) {
                        throw new C0898a(a, "Error refreshing inventory (querying prices of subscriptions).");
                    }
                }
            }
            return c0905d;
        } catch (Exception e) {
            throw new C0898a(-1001, "Remote exception while refreshing inventory.", e);
        } catch (Exception e2) {
            throw new C0898a(-1002, "Error parsing JSON response while refreshing inventory.", e2);
        }
    }

    public void m3123a() {
        synchronized (this.f1779q) {
            if (this.f1770h) {
                throw new C0902a("Can't dispose because an async operation (" + this.f1771i + ") is in progress.");
            }
        }
        m3135c("Disposing.");
        this.f1765c = false;
        if (this.f1774l != null) {
            m3135c("Unbinding from service.");
            if (this.f1772j != null) {
                try {
                    this.f1772j.unbindService(this.f1774l);
                } catch (IllegalArgumentException e) {
                }
            }
        }
        this.f1766d = true;
        this.f1772j = null;
        this.f1774l = null;
        this.f1773k = null;
        this.f1778p = null;
    }

    public void m3124a(Activity activity, String str, int i, C0816b c0816b, String str2) {
        m3125a(activity, str, "inapp", null, i, c0816b, str2);
    }

    public void m3125a(Activity activity, String str, String str2, List<String> list, int i, C0816b c0816b, String str3) {
        C0904c c0904c;
        m3117d();
        m3128a("launchPurchaseFlow");
        m3133b("launchPurchaseFlow");
        if (!str2.equals("subs") || this.f1768f) {
            try {
                Bundle a;
                m3135c("Constructing buy intent for " + str + ", item type: " + str2);
                if (list == null || list.isEmpty()) {
                    a = this.f1773k.m3381a(3, this.f1772j.getPackageName(), str, str2, str3);
                } else if (this.f1769g) {
                    a = this.f1773k.m3382a(5, this.f1772j.getPackageName(), list, str, str2, str3);
                } else {
                    c0904c = new C0904c(-1011, "Subscription updates are not available.");
                    m3134c();
                    if (c0816b != null) {
                        c0816b.m2813a(c0904c, null);
                        return;
                    }
                    return;
                }
                int a2 = m3119a(a);
                if (a2 != 0) {
                    m3136d("Unable to buy item, Error response: " + C0903b.m3116a(a2));
                    m3134c();
                    c0904c = new C0904c(a2, "Unable to buy item");
                    if (c0816b != null) {
                        c0816b.m2813a(c0904c, null);
                        return;
                    }
                    return;
                }
                PendingIntent pendingIntent = (PendingIntent) a.getParcelable("BUY_INTENT");
                m3135c("Launching buy intent for " + str + ". Request code: " + i);
                this.f1775m = i;
                this.f1778p = c0816b;
                this.f1776n = str2;
                activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
                return;
            } catch (SendIntentException e) {
                m3136d("SendIntentException while launching purchase flow for sku " + str);
                e.printStackTrace();
                m3134c();
                c0904c = new C0904c(-1004, "Failed to send intent.");
                if (c0816b != null) {
                    c0816b.m2813a(c0904c, null);
                    return;
                }
                return;
            } catch (RemoteException e2) {
                m3136d("RemoteException while launching purchase flow for sku " + str);
                e2.printStackTrace();
                m3134c();
                c0904c = new C0904c(-1001, "Remote exception while starting purchase flow");
                if (c0816b != null) {
                    c0816b.m2813a(c0904c, null);
                    return;
                }
                return;
            }
        }
        c0904c = new C0904c(-1009, "Subscriptions are not available.");
        m3134c();
        if (c0816b != null) {
            c0816b.m2813a(c0904c, null);
        }
    }

    public void m3126a(C0748c c0748c) {
        m3117d();
        if (this.f1765c) {
            throw new IllegalStateException("IAB helper is already set up.");
        }
        m3135c("Starting in-app billing setup.");
        this.f1774l = new C08991(this, c0748c);
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        List queryIntentServices = this.f1772j.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
            this.f1772j.bindService(intent, this.f1774l, 1);
        } else if (c0748c != null) {
            c0748c.m2608a(new C0904c(3, "Billing service unavailable on device."));
        }
    }

    public void m3127a(C0750d c0750d) {
        m3130a(false, null, null, c0750d);
    }

    void m3128a(String str) {
        if (!this.f1765c) {
            m3136d("Illegal state for operation (" + str + "): IAB helper is not set up.");
            throw new IllegalStateException("IAB helper is not set up. Can't perform operation: " + str);
        }
    }

    public void m3129a(boolean z) {
        m3117d();
        this.f1763a = z;
    }

    public void m3130a(boolean z, List<String> list, List<String> list2, C0750d c0750d) {
        Handler handler = new Handler();
        m3117d();
        m3128a("queryInventory");
        m3133b("refresh inventory");
        new Thread(new C09012(this, z, list, list2, c0750d, handler)).start();
    }

    public boolean m3131a(int i, int i2, Intent intent) {
        C0904c c0904c;
        if (i != this.f1775m) {
            return false;
        }
        m3117d();
        m3128a("handleActivityResult");
        m3134c();
        if (intent == null) {
            m3136d("Null data in IAB activity result.");
            c0904c = new C0904c(-1002, "Null data in IAB result");
            if (this.f1778p != null) {
                this.f1778p.m2813a(c0904c, null);
            }
            return true;
        }
        int a = m3118a(intent);
        String stringExtra = intent.getStringExtra("INAPP_PURCHASE_DATA");
        String stringExtra2 = intent.getStringExtra("INAPP_DATA_SIGNATURE");
        if (i2 == -1 && a == 0) {
            m3135c("Successful resultcode from purchase activity.");
            m3135c("Purchase data: " + stringExtra);
            m3135c("Data signature: " + stringExtra2);
            m3135c("Extras: " + intent.getExtras());
            m3135c("Expected item type: " + this.f1776n);
            if (stringExtra == null || stringExtra2 == null) {
                m3136d("BUG: either purchaseData or dataSignature is null.");
                m3135c("Extras: " + intent.getExtras().toString());
                c0904c = new C0904c(-1008, "IAB returned null purchaseData or dataSignature");
                if (this.f1778p != null) {
                    this.f1778p.m2813a(c0904c, null);
                }
                return true;
            }
            try {
                C0906e c0906e = new C0906e(this.f1776n, stringExtra, stringExtra2);
                String b = c0906e.m3146b();
                if (C0907f.m3150a(this.f1777o, stringExtra, stringExtra2)) {
                    m3135c("Purchase signature successfully verified.");
                    if (this.f1778p != null) {
                        this.f1778p.m2813a(new C0904c(0, "Success"), c0906e);
                    }
                } else {
                    m3136d("Purchase signature verification FAILED for sku " + b);
                    c0904c = new C0904c(-1003, "Signature verification failed for sku " + b);
                    if (this.f1778p != null) {
                        this.f1778p.m2813a(c0904c, c0906e);
                    }
                    return true;
                }
            } catch (JSONException e) {
                m3136d("Failed to parse purchase data.");
                e.printStackTrace();
                c0904c = new C0904c(-1002, "Failed to parse purchase data.");
                if (this.f1778p != null) {
                    this.f1778p.m2813a(c0904c, null);
                }
                return true;
            }
        } else if (i2 == -1) {
            m3135c("Result code was OK but in-app billing response was not OK: " + C0903b.m3116a(a));
            if (this.f1778p != null) {
                this.f1778p.m2813a(new C0904c(a, "Problem purchashing item."), null);
            }
        } else if (i2 == 0) {
            m3135c("Purchase canceled - Response: " + C0903b.m3116a(a));
            c0904c = new C0904c(-1005, "User canceled.");
            if (this.f1778p != null) {
                this.f1778p.m2813a(c0904c, null);
            }
        } else {
            m3136d("Purchase failed. Result code: " + Integer.toString(i2) + ". Response: " + C0903b.m3116a(a));
            c0904c = new C0904c(-1006, "Unknown purchase response.");
            if (this.f1778p != null) {
                this.f1778p.m2813a(c0904c, null);
            }
        }
        return true;
    }

    public void m3132b() {
        synchronized (this.f1779q) {
            if (this.f1770h) {
                m3135c("Will dispose after async operation finishes.");
                this.f1767e = true;
            } else {
                try {
                    m3123a();
                } catch (C0902a e) {
                }
            }
        }
    }

    void m3133b(String str) {
        synchronized (this.f1779q) {
            if (this.f1770h) {
                throw new C0902a("Can't start async operation (" + str + ") because another async operation (" + this.f1771i + ") is in progress.");
            }
            this.f1771i = str;
            this.f1770h = true;
            m3135c("Starting async operation: " + str);
        }
    }

    void m3134c() {
        synchronized (this.f1779q) {
            m3135c("Ending async operation: " + this.f1771i);
            this.f1771i = BuildConfig.VERSION_NAME;
            this.f1770h = false;
            if (this.f1767e) {
                try {
                    m3123a();
                } catch (C0902a e) {
                }
            }
        }
    }

    void m3135c(String str) {
        if (this.f1763a) {
            Log.d(this.f1764b, str);
        }
    }

    void m3136d(String str) {
        Log.e(this.f1764b, "In-app billing error: " + str);
    }

    void m3137e(String str) {
        Log.w(this.f1764b, "In-app billing warning: " + str);
    }
}
