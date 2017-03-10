package com.google.android.gms.internal;

import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

abstract class ur<T extends uq> extends uc {
    C2035a<T> f6129a;

    /* renamed from: com.google.android.gms.internal.ur.a */
    public interface C2035a<U extends uq> {
        U m9321a();

        void m9322a(String str, int i);

        void m9323a(String str, String str2);

        void m9324a(String str, boolean z);

        void m9325b(String str, String str2);
    }

    public ur(uf ufVar, C2035a<T> c2035a) {
        super(ufVar);
        this.f6129a = c2035a;
    }

    private T m9326a(XmlResourceParser xmlResourceParser) {
        try {
            xmlResourceParser.next();
            int eventType = xmlResourceParser.getEventType();
            while (eventType != 1) {
                if (xmlResourceParser.getEventType() == 2) {
                    String toLowerCase = xmlResourceParser.getName().toLowerCase();
                    String trim;
                    if (toLowerCase.equals("screenname")) {
                        toLowerCase = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(toLowerCase) || TextUtils.isEmpty(trim))) {
                            this.f6129a.m9323a(toLowerCase, trim);
                        }
                    } else if (toLowerCase.equals("string")) {
                        Object attributeValue = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(attributeValue) || trim == null)) {
                            this.f6129a.m9325b(attributeValue, trim);
                        }
                    } else if (toLowerCase.equals("bool")) {
                        toLowerCase = xmlResourceParser.getAttributeValue(null, "name");
                        r1 = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(toLowerCase) || TextUtils.isEmpty(r1))) {
                            try {
                                this.f6129a.m9324a(toLowerCase, Boolean.parseBoolean(r1));
                            } catch (NumberFormatException e) {
                                m4256c("Error parsing bool configuration value", r1, e);
                            }
                        }
                    } else if (toLowerCase.equals("integer")) {
                        toLowerCase = xmlResourceParser.getAttributeValue(null, "name");
                        r1 = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(toLowerCase) || TextUtils.isEmpty(r1))) {
                            try {
                                this.f6129a.m9322a(toLowerCase, Integer.parseInt(r1));
                            } catch (NumberFormatException e2) {
                                m4256c("Error parsing int configuration value", r1, e2);
                            }
                        }
                    } else {
                        continue;
                    }
                }
                eventType = xmlResourceParser.next();
            }
        } catch (XmlPullParserException e3) {
            m4261e("Error parsing tracker configuration file", e3);
        } catch (IOException e4) {
            m4261e("Error parsing tracker configuration file", e4);
        }
        return this.f6129a.m9321a();
    }

    public T m9327a(int i) {
        try {
            return m9326a(m4263i().m9155c().getResources().getXml(i));
        } catch (NotFoundException e) {
            m4258d("inflate() called with unknown resourceId", e);
            return null;
        }
    }
}
