package android.support.v4.view.p015a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.view.View;
import com.andi.alquran.C0861R;
import com.google.ads.AdSize;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.maps.GoogleMap;

/* renamed from: android.support.v4.view.a.c */
public class C0404c {
    static final C0391f f856a;
    public int f857b;
    private final Object f858c;

    /* renamed from: android.support.v4.view.a.c.f */
    interface C0391f {
        int m1410a(Object obj);

        Object m1411a(int i, int i2, int i3, int i4, boolean z, boolean z2);

        Object m1412a(int i, int i2, boolean z, int i3);

        void m1413a(Object obj, int i);

        void m1414a(Object obj, Rect rect);

        void m1415a(Object obj, View view);

        void m1416a(Object obj, CharSequence charSequence);

        void m1417a(Object obj, Object obj2);

        void m1418a(Object obj, boolean z);

        CharSequence m1419b(Object obj);

        void m1420b(Object obj, Rect rect);

        void m1421b(Object obj, Object obj2);

        void m1422b(Object obj, boolean z);

        CharSequence m1423c(Object obj);

        void m1424c(Object obj, boolean z);

        CharSequence m1425d(Object obj);

        void m1426d(Object obj, boolean z);

        CharSequence m1427e(Object obj);

        boolean m1428f(Object obj);

        boolean m1429g(Object obj);

        boolean m1430h(Object obj);

        boolean m1431i(Object obj);

        boolean m1432j(Object obj);

        boolean m1433k(Object obj);

        boolean m1434l(Object obj);

        boolean m1435m(Object obj);

        boolean m1436n(Object obj);

        boolean m1437o(Object obj);

        String m1438p(Object obj);
    }

    /* renamed from: android.support.v4.view.a.c.k */
    static class C0392k implements C0391f {
        C0392k() {
        }

        public int m1439a(Object obj) {
            return 0;
        }

        public Object m1440a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return null;
        }

        public Object m1441a(int i, int i2, boolean z, int i3) {
            return null;
        }

        public void m1442a(Object obj, int i) {
        }

        public void m1443a(Object obj, Rect rect) {
        }

        public void m1444a(Object obj, View view) {
        }

        public void m1445a(Object obj, CharSequence charSequence) {
        }

        public void m1446a(Object obj, Object obj2) {
        }

        public void m1447a(Object obj, boolean z) {
        }

        public CharSequence m1448b(Object obj) {
            return null;
        }

        public void m1449b(Object obj, Rect rect) {
        }

        public void m1450b(Object obj, Object obj2) {
        }

        public void m1451b(Object obj, boolean z) {
        }

        public CharSequence m1452c(Object obj) {
            return null;
        }

        public void m1453c(Object obj, boolean z) {
        }

        public CharSequence m1454d(Object obj) {
            return null;
        }

        public void m1455d(Object obj, boolean z) {
        }

        public CharSequence m1456e(Object obj) {
            return null;
        }

        public boolean m1457f(Object obj) {
            return false;
        }

        public boolean m1458g(Object obj) {
            return false;
        }

        public boolean m1459h(Object obj) {
            return false;
        }

        public boolean m1460i(Object obj) {
            return false;
        }

        public boolean m1461j(Object obj) {
            return false;
        }

        public boolean m1462k(Object obj) {
            return false;
        }

        public boolean m1463l(Object obj) {
            return false;
        }

        public boolean m1464m(Object obj) {
            return false;
        }

        public boolean m1465n(Object obj) {
            return false;
        }

        public boolean m1466o(Object obj) {
            return false;
        }

        public String m1467p(Object obj) {
            return null;
        }
    }

    /* renamed from: android.support.v4.view.a.c.e */
    static class C0393e extends C0392k {
        C0393e() {
        }

        public int m1468a(Object obj) {
            return C0406e.m1532a(obj);
        }

        public void m1469a(Object obj, int i) {
            C0406e.m1533a(obj, i);
        }

        public void m1470a(Object obj, Rect rect) {
            C0406e.m1534a(obj, rect);
        }

        public void m1471a(Object obj, View view) {
            C0406e.m1535a(obj, view);
        }

        public void m1472a(Object obj, CharSequence charSequence) {
            C0406e.m1536a(obj, charSequence);
        }

        public void m1473a(Object obj, boolean z) {
            C0406e.m1537a(obj, z);
        }

        public CharSequence m1474b(Object obj) {
            return C0406e.m1538b(obj);
        }

        public void m1475b(Object obj, Rect rect) {
            C0406e.m1539b(obj, rect);
        }

        public void m1476b(Object obj, boolean z) {
            C0406e.m1540b(obj, z);
        }

        public CharSequence m1477c(Object obj) {
            return C0406e.m1541c(obj);
        }

        public void m1478c(Object obj, boolean z) {
            C0406e.m1542c(obj, z);
        }

        public CharSequence m1479d(Object obj) {
            return C0406e.m1543d(obj);
        }

        public CharSequence m1480e(Object obj) {
            return C0406e.m1544e(obj);
        }

        public boolean m1481f(Object obj) {
            return C0406e.m1545f(obj);
        }

        public boolean m1482g(Object obj) {
            return C0406e.m1546g(obj);
        }

        public boolean m1483h(Object obj) {
            return C0406e.m1547h(obj);
        }

        public boolean m1484i(Object obj) {
            return C0406e.m1548i(obj);
        }

        public boolean m1485j(Object obj) {
            return C0406e.m1549j(obj);
        }

        public boolean m1486k(Object obj) {
            return C0406e.m1550k(obj);
        }

        public boolean m1487l(Object obj) {
            return C0406e.m1551l(obj);
        }

        public boolean m1488m(Object obj) {
            return C0406e.m1552m(obj);
        }

        public boolean m1489n(Object obj) {
            return C0406e.m1553n(obj);
        }

        public boolean m1490o(Object obj) {
            return C0406e.m1554o(obj);
        }
    }

    /* renamed from: android.support.v4.view.a.c.g */
    static class C0394g extends C0393e {
        C0394g() {
        }
    }

    /* renamed from: android.support.v4.view.a.c.h */
    static class C0395h extends C0394g {
        C0395h() {
        }
    }

    /* renamed from: android.support.v4.view.a.c.i */
    static class C0396i extends C0395h {
        C0396i() {
        }

        public String m1491p(Object obj) {
            return C0407f.m1555a(obj);
        }
    }

    /* renamed from: android.support.v4.view.a.c.j */
    static class C0397j extends C0396i {
        C0397j() {
        }

        public Object m1492a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return C0408g.m1556a(i, i2, i3, i4, z);
        }

        public Object m1493a(int i, int i2, boolean z, int i3) {
            return C0408g.m1557a(i, i2, z, i3);
        }

        public void m1494a(Object obj, Object obj2) {
            C0408g.m1558a(obj, obj2);
        }

        public void m1495b(Object obj, Object obj2) {
            C0408g.m1560b(obj, obj2);
        }

        public void m1496d(Object obj, boolean z) {
            C0408g.m1559a(obj, z);
        }
    }

    /* renamed from: android.support.v4.view.a.c.a */
    static class C0398a extends C0397j {
        C0398a() {
        }

        public Object m1497a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return C0405d.m1530a(i, i2, i3, i4, z, z2);
        }

        public Object m1498a(int i, int i2, boolean z, int i3) {
            return C0405d.m1531a(i, i2, z, i3);
        }
    }

    /* renamed from: android.support.v4.view.a.c.b */
    static class C0399b extends C0398a {
        C0399b() {
        }
    }

    /* renamed from: android.support.v4.view.a.c.c */
    static class C0400c extends C0399b {
        C0400c() {
        }
    }

    /* renamed from: android.support.v4.view.a.c.d */
    static class C0401d extends C0400c {
        C0401d() {
        }
    }

    /* renamed from: android.support.v4.view.a.c.l */
    public static class C0402l {
        final Object f854a;

        C0402l(Object obj) {
            this.f854a = obj;
        }

        public static C0402l m1499a(int i, int i2, boolean z, int i3) {
            return new C0402l(C0404c.f856a.m1412a(i, i2, z, i3));
        }
    }

    /* renamed from: android.support.v4.view.a.c.m */
    public static class C0403m {
        final Object f855a;

        C0403m(Object obj) {
            this.f855a = obj;
        }

        public static C0403m m1500a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return new C0403m(C0404c.f856a.m1411a(i, i2, i3, i4, z, z2));
        }
    }

    static {
        if (VERSION.SDK_INT >= 24) {
            f856a = new C0401d();
        } else if (VERSION.SDK_INT >= 23) {
            f856a = new C0400c();
        } else if (VERSION.SDK_INT >= 22) {
            f856a = new C0399b();
        } else if (VERSION.SDK_INT >= 21) {
            f856a = new C0398a();
        } else if (VERSION.SDK_INT >= 19) {
            f856a = new C0397j();
        } else if (VERSION.SDK_INT >= 18) {
            f856a = new C0396i();
        } else if (VERSION.SDK_INT >= 17) {
            f856a = new C0395h();
        } else if (VERSION.SDK_INT >= 16) {
            f856a = new C0394g();
        } else if (VERSION.SDK_INT >= 14) {
            f856a = new C0393e();
        } else {
            f856a = new C0392k();
        }
    }

    public C0404c(Object obj) {
        this.f857b = -1;
        this.f858c = obj;
    }

    private static String m1501b(int i) {
        switch (i) {
            case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                return "ACTION_FOCUS";
            case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                return "ACTION_CLEAR_FOCUS";
            case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                return "ACTION_SELECT";
            case C1096c.MapAttrs_uiRotateGestures /*8*/:
                return "ACTION_CLEAR_SELECTION";
            case C1096c.MapAttrs_ambientEnabled /*16*/:
                return "ACTION_CLICK";
            case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                return "ACTION_LONG_CLICK";
            case C0861R.styleable.AppCompatTheme_editTextBackground /*64*/:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case NotificationCompat.FLAG_HIGH_PRIORITY /*128*/:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case NotificationCompat.FLAG_LOCAL_ONLY /*256*/:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case AdRequest.MAX_CONTENT_URL_LENGTH /*512*/:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case ItemAnimator.FLAG_MOVED /*2048*/:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT /*4096*/:
                return "ACTION_SCROLL_FORWARD";
            case FragmentTransaction.TRANSIT_EXIT_MASK /*8192*/:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }

    public Object m1502a() {
        return this.f858c;
    }

    public void m1503a(int i) {
        f856a.m1413a(this.f858c, i);
    }

    public void m1504a(Rect rect) {
        f856a.m1414a(this.f858c, rect);
    }

    public void m1505a(View view) {
        f856a.m1415a(this.f858c, view);
    }

    public void m1506a(CharSequence charSequence) {
        f856a.m1416a(this.f858c, charSequence);
    }

    public void m1507a(Object obj) {
        f856a.m1417a(this.f858c, ((C0402l) obj).f854a);
    }

    public void m1508a(boolean z) {
        f856a.m1418a(this.f858c, z);
    }

    public int m1509b() {
        return f856a.m1410a(this.f858c);
    }

    public void m1510b(Rect rect) {
        f856a.m1420b(this.f858c, rect);
    }

    public void m1511b(Object obj) {
        f856a.m1421b(this.f858c, ((C0403m) obj).f855a);
    }

    public void m1512b(boolean z) {
        f856a.m1422b(this.f858c, z);
    }

    public void m1513c(boolean z) {
        f856a.m1424c(this.f858c, z);
    }

    public boolean m1514c() {
        return f856a.m1428f(this.f858c);
    }

    public void m1515d(boolean z) {
        f856a.m1426d(this.f858c, z);
    }

    public boolean m1516d() {
        return f856a.m1429g(this.f858c);
    }

    public boolean m1517e() {
        return f856a.m1432j(this.f858c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        C0404c c0404c = (C0404c) obj;
        return this.f858c == null ? c0404c.f858c == null : this.f858c.equals(c0404c.f858c);
    }

    public boolean m1518f() {
        return f856a.m1433k(this.f858c);
    }

    public boolean m1519g() {
        return f856a.m1437o(this.f858c);
    }

    public boolean m1520h() {
        return f856a.m1430h(this.f858c);
    }

    public int hashCode() {
        return this.f858c == null ? 0 : this.f858c.hashCode();
    }

    public boolean m1521i() {
        return f856a.m1434l(this.f858c);
    }

    public boolean m1522j() {
        return f856a.m1431i(this.f858c);
    }

    public boolean m1523k() {
        return f856a.m1435m(this.f858c);
    }

    public boolean m1524l() {
        return f856a.m1436n(this.f858c);
    }

    public CharSequence m1525m() {
        return f856a.m1425d(this.f858c);
    }

    public CharSequence m1526n() {
        return f856a.m1419b(this.f858c);
    }

    public CharSequence m1527o() {
        return f856a.m1427e(this.f858c);
    }

    public CharSequence m1528p() {
        return f856a.m1423c(this.f858c);
    }

    public String m1529q() {
        return f856a.m1438p(this.f858c);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        Rect rect = new Rect();
        m1504a(rect);
        stringBuilder.append("; boundsInParent: " + rect);
        m1510b(rect);
        stringBuilder.append("; boundsInScreen: " + rect);
        stringBuilder.append("; packageName: ").append(m1525m());
        stringBuilder.append("; className: ").append(m1526n());
        stringBuilder.append("; text: ").append(m1527o());
        stringBuilder.append("; contentDescription: ").append(m1528p());
        stringBuilder.append("; viewId: ").append(m1529q());
        stringBuilder.append("; checkable: ").append(m1514c());
        stringBuilder.append("; checked: ").append(m1516d());
        stringBuilder.append("; focusable: ").append(m1517e());
        stringBuilder.append("; focused: ").append(m1518f());
        stringBuilder.append("; selected: ").append(m1519g());
        stringBuilder.append("; clickable: ").append(m1520h());
        stringBuilder.append("; longClickable: ").append(m1521i());
        stringBuilder.append("; enabled: ").append(m1522j());
        stringBuilder.append("; password: ").append(m1523k());
        stringBuilder.append("; scrollable: " + m1524l());
        stringBuilder.append("; [");
        int b = m1509b();
        while (b != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(b);
            b &= numberOfTrailingZeros ^ -1;
            stringBuilder.append(C0404c.m1501b(numberOfTrailingZeros));
            if (b != 0) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
