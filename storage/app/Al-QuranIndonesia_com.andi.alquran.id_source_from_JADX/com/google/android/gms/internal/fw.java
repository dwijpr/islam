package com.google.android.gms.internal;

import android.support.v7.recyclerview.BuildConfig;
import com.google.android.gms.internal.fr.C1580a;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

@op
public class fw {
    private final fq f4117a;
    private final int f4118b;
    private String f4119c;
    private String f4120d;
    private final boolean f4121e;
    private final int f4122f;
    private final int f4123g;

    /* renamed from: com.google.android.gms.internal.fw.a */
    public class C1582a implements Comparator<fp> {
        public C1582a(fw fwVar) {
        }

        public int m6248a(fp fpVar, fp fpVar2) {
            if (fpVar.m6219b() < fpVar2.m6219b()) {
                return -1;
            }
            if (fpVar.m6219b() > fpVar2.m6219b()) {
                return 1;
            }
            if (fpVar.m6218a() < fpVar2.m6218a()) {
                return -1;
            }
            if (fpVar.m6218a() > fpVar2.m6218a()) {
                return 1;
            }
            float d = (fpVar.m6221d() - fpVar.m6219b()) * (fpVar.m6220c() - fpVar.m6218a());
            float d2 = (fpVar2.m6221d() - fpVar2.m6219b()) * (fpVar2.m6220c() - fpVar2.m6218a());
            return d <= d2 ? d < d2 ? 1 : 0 : -1;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m6248a((fp) obj, (fp) obj2);
        }
    }

    public fw(int i, int i2, int i3) {
        this.f4118b = i;
        this.f4121e = false;
        if (i2 > 64 || i2 < 0) {
            this.f4122f = 64;
        } else {
            this.f4122f = i2;
        }
        if (i3 < 1) {
            this.f4123g = 1;
        } else {
            this.f4123g = i3;
        }
        this.f4117a = new fv(this.f4122f);
    }

    String m6249a(String str, char c) {
        StringBuilder stringBuilder = new StringBuilder(str);
        Object obj = null;
        int i = 1;
        while (i + 2 <= stringBuilder.length()) {
            if (stringBuilder.charAt(i) == '\'') {
                if (stringBuilder.charAt(i - 1) == c || !((stringBuilder.charAt(i + 1) == 's' || stringBuilder.charAt(i + 1) == 'S') && (i + 2 == stringBuilder.length() || stringBuilder.charAt(i + 2) == c))) {
                    stringBuilder.setCharAt(i, c);
                } else {
                    stringBuilder.insert(i, c);
                    i += 2;
                }
                obj = 1;
            }
            i++;
        }
        return obj != null ? stringBuilder.toString() : null;
    }

    public String m6250a(ArrayList<String> arrayList, ArrayList<fp> arrayList2) {
        Collections.sort(arrayList2, new C1582a(this));
        HashSet hashSet = new HashSet();
        int i = 0;
        while (i < arrayList2.size() && m6251a(Normalizer.normalize((CharSequence) arrayList.get(((fp) arrayList2.get(i)).m6222e()), Form.NFKC).toLowerCase(Locale.US), hashSet)) {
            i++;
        }
        C1580a c1580a = new C1580a();
        this.f4119c = BuildConfig.VERSION_NAME;
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            try {
                c1580a.m6226a(this.f4117a.m6224a((String) it.next()));
            } catch (Throwable e) {
                sg.m8445b("Error while writing hash to byteStream", e);
            }
        }
        return c1580a.toString();
    }

    boolean m6251a(String str, HashSet<String> hashSet) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return true;
        }
        for (String str2 : split) {
            String str22;
            String a;
            String[] a2;
            int i;
            Object obj;
            int i2;
            boolean z;
            if (str22.indexOf("'") != -1) {
                a = m6249a(str22, ' ');
                if (a != null) {
                    this.f4120d = a;
                    a2 = fs.m6233a(a, true);
                    if (a2.length < this.f4123g) {
                        for (i = 0; i < a2.length; i++) {
                            obj = BuildConfig.VERSION_NAME;
                            for (i2 = 0; i2 < this.f4123g; i2++) {
                                if (i + i2 < a2.length) {
                                    z = false;
                                    break;
                                }
                                if (i2 > 0) {
                                    obj = String.valueOf(obj).concat(" ");
                                }
                                String valueOf = String.valueOf(obj);
                                str22 = String.valueOf(a2[i + i2]);
                                obj = str22.length() == 0 ? valueOf.concat(str22) : new String(valueOf);
                            }
                            z = true;
                            if (z) {
                                break;
                            }
                            hashSet.add(obj);
                            if (hashSet.size() < this.f4118b) {
                                return false;
                            }
                        }
                        if (hashSet.size() < this.f4118b) {
                            return false;
                        }
                    }
                }
            }
            a = str22;
            a2 = fs.m6233a(a, true);
            if (a2.length < this.f4123g) {
                while (i < a2.length) {
                    obj = BuildConfig.VERSION_NAME;
                    while (i2 < this.f4123g) {
                        if (i + i2 < a2.length) {
                            if (i2 > 0) {
                                obj = String.valueOf(obj).concat(" ");
                            }
                            String valueOf2 = String.valueOf(obj);
                            str22 = String.valueOf(a2[i + i2]);
                            if (str22.length() == 0) {
                            }
                        } else {
                            z = false;
                            break;
                            if (z) {
                                break;
                                if (hashSet.size() < this.f4118b) {
                                    return false;
                                }
                            } else {
                                hashSet.add(obj);
                                if (hashSet.size() < this.f4118b) {
                                    return false;
                                }
                            }
                        }
                    }
                    z = true;
                    if (z) {
                        break;
                        if (hashSet.size() < this.f4118b) {
                            return false;
                        }
                    } else {
                        hashSet.add(obj);
                        if (hashSet.size() < this.f4118b) {
                            return false;
                        }
                    }
                }
                if (hashSet.size() < this.f4118b) {
                    return false;
                }
            }
        }
        return true;
    }
}
