package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p007e.C0265c;
import android.support.v4.view.as.C0453a;
import android.view.Display;
import android.view.View;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

public class aj {
    static final C0441l f880a;

    /* renamed from: android.support.v4.view.aj.l */
    interface C0441l {
        ColorStateList m1650A(View view);

        Mode m1651B(View view);

        void m1652C(View view);

        boolean m1653D(View view);

        float m1654E(View view);

        boolean m1655F(View view);

        boolean m1656G(View view);

        Display m1657H(View view);

        int m1658a(int i, int i2);

        int m1659a(int i, int i2, int i3);

        bf m1660a(View view, bf bfVar);

        void m1661a(View view, float f);

        void m1662a(View view, int i, int i2);

        void m1663a(View view, int i, int i2, int i3, int i4);

        void m1664a(View view, int i, Paint paint);

        void m1665a(View view, ColorStateList colorStateList);

        void m1666a(View view, Mode mode);

        void m1667a(View view, Drawable drawable);

        void m1668a(View view, C0036a c0036a);

        void m1669a(View view, ad adVar);

        void m1670a(View view, C0058z c0058z);

        void m1671a(View view, Runnable runnable);

        void m1672a(View view, Runnable runnable, long j);

        void m1673a(View view, boolean z);

        boolean m1674a(View view);

        boolean m1675a(View view, int i);

        bf m1676b(View view, bf bfVar);

        void m1677b(View view, float f);

        void m1678b(View view, boolean z);

        boolean m1679b(View view);

        boolean m1680b(View view, int i);

        void m1681c(View view);

        void m1682c(View view, float f);

        void m1683c(View view, int i);

        void m1684c(View view, boolean z);

        int m1685d(View view);

        void m1686d(View view, float f);

        void m1687d(View view, int i);

        float m1688e(View view);

        void m1689e(View view, int i);

        int m1690f(View view);

        int m1691g(View view);

        int m1692h(View view);

        int m1693i(View view);

        int m1694j(View view);

        int m1695k(View view);

        boolean m1696l(View view);

        float m1697m(View view);

        float m1698n(View view);

        Matrix m1699o(View view);

        int m1700p(View view);

        int m1701q(View view);

        ay m1702r(View view);

        String m1703s(View view);

        int m1704t(View view);

        void m1705u(View view);

        float m1706v(View view);

        boolean m1707x(View view);

        void m1708y(View view);

        boolean m1709z(View view);
    }

    /* renamed from: android.support.v4.view.aj.b */
    static class C0442b implements C0441l {
        WeakHashMap<View, ay> f875a;

        C0442b() {
            this.f875a = null;
        }

        private boolean m1710a(af afVar, int i) {
            int computeHorizontalScrollOffset = afVar.computeHorizontalScrollOffset();
            int computeHorizontalScrollRange = afVar.computeHorizontalScrollRange() - afVar.computeHorizontalScrollExtent();
            return computeHorizontalScrollRange == 0 ? false : i < 0 ? computeHorizontalScrollOffset > 0 : computeHorizontalScrollOffset < computeHorizontalScrollRange + -1;
        }

        private boolean m1711b(af afVar, int i) {
            int computeVerticalScrollOffset = afVar.computeVerticalScrollOffset();
            int computeVerticalScrollRange = afVar.computeVerticalScrollRange() - afVar.computeVerticalScrollExtent();
            return computeVerticalScrollRange == 0 ? false : i < 0 ? computeVerticalScrollOffset > 0 : computeVerticalScrollOffset < computeVerticalScrollRange + -1;
        }

        public ColorStateList m1712A(View view) {
            return al.m1905a(view);
        }

        public Mode m1713B(View view) {
            return al.m1909b(view);
        }

        public void m1714C(View view) {
            if (view instanceof C0039v) {
                ((C0039v) view).stopNestedScroll();
            }
        }

        public boolean m1715D(View view) {
            return al.m1911c(view);
        }

        public float m1716E(View view) {
            return m1770w(view) + m1769v(view);
        }

        public boolean m1717F(View view) {
            return al.m1914f(view);
        }

        public boolean m1718G(View view) {
            return false;
        }

        public Display m1719H(View view) {
            return al.m1915g(view);
        }

        public int m1720a(int i, int i2) {
            return i | i2;
        }

        public int m1721a(int i, int i2, int i3) {
            return View.resolveSize(i, i2);
        }

        long m1722a() {
            return 10;
        }

        public bf m1723a(View view, bf bfVar) {
            return bfVar;
        }

        public void m1724a(View view, float f) {
        }

        public void m1725a(View view, int i, int i2) {
        }

        public void m1726a(View view, int i, int i2, int i3, int i4) {
            view.setPadding(i, i2, i3, i4);
        }

        public void m1727a(View view, int i, Paint paint) {
        }

        public void m1728a(View view, ColorStateList colorStateList) {
            al.m1907a(view, colorStateList);
        }

        public void m1729a(View view, Mode mode) {
            al.m1908a(view, mode);
        }

        public void m1730a(View view, Drawable drawable) {
            view.setBackgroundDrawable(drawable);
        }

        public void m1731a(View view, C0036a c0036a) {
        }

        public void m1732a(View view, ad adVar) {
        }

        public void m1733a(View view, C0058z c0058z) {
        }

        public void m1734a(View view, Runnable runnable) {
            view.postDelayed(runnable, m1722a());
        }

        public void m1735a(View view, Runnable runnable, long j) {
            view.postDelayed(runnable, m1722a() + j);
        }

        public void m1736a(View view, boolean z) {
        }

        public boolean m1737a(View view) {
            return false;
        }

        public boolean m1738a(View view, int i) {
            return (view instanceof af) && m1710a((af) view, i);
        }

        public bf m1739b(View view, bf bfVar) {
            return bfVar;
        }

        public void m1740b(View view, float f) {
        }

        public void m1741b(View view, boolean z) {
        }

        public boolean m1742b(View view) {
            return false;
        }

        public boolean m1743b(View view, int i) {
            return (view instanceof af) && m1711b((af) view, i);
        }

        public void m1744c(View view) {
            view.invalidate();
        }

        public void m1745c(View view, float f) {
        }

        public void m1746c(View view, int i) {
        }

        public void m1747c(View view, boolean z) {
        }

        public int m1748d(View view) {
            return 0;
        }

        public void m1749d(View view, float f) {
        }

        public void m1750d(View view, int i) {
            al.m1910b(view, i);
        }

        public float m1751e(View view) {
            return 1.0f;
        }

        public void m1752e(View view, int i) {
            al.m1906a(view, i);
        }

        public int m1753f(View view) {
            return 0;
        }

        public int m1754g(View view) {
            return 0;
        }

        public int m1755h(View view) {
            return view.getMeasuredWidth();
        }

        public int m1756i(View view) {
            return 0;
        }

        public int m1757j(View view) {
            return view.getPaddingLeft();
        }

        public int m1758k(View view) {
            return view.getPaddingRight();
        }

        public boolean m1759l(View view) {
            return true;
        }

        public float m1760m(View view) {
            return 0.0f;
        }

        public float m1761n(View view) {
            return 0.0f;
        }

        public Matrix m1762o(View view) {
            return null;
        }

        public int m1763p(View view) {
            return al.m1912d(view);
        }

        public int m1764q(View view) {
            return al.m1913e(view);
        }

        public ay m1765r(View view) {
            return new ay(view);
        }

        public String m1766s(View view) {
            return null;
        }

        public int m1767t(View view) {
            return 0;
        }

        public void m1768u(View view) {
        }

        public float m1769v(View view) {
            return 0.0f;
        }

        public float m1770w(View view) {
            return 0.0f;
        }

        public boolean m1771x(View view) {
            return false;
        }

        public void m1772y(View view) {
        }

        public boolean m1773z(View view) {
            return false;
        }
    }

    /* renamed from: android.support.v4.view.aj.c */
    static class C0443c extends C0442b {
        C0443c() {
        }

        public int m1774a(int i, int i2) {
            return am.m1917a(i, i2);
        }

        public int m1775a(int i, int i2, int i3) {
            return am.m1918a(i, i2, i3);
        }

        long m1776a() {
            return am.m1919a();
        }

        public void m1777a(View view, float f) {
            am.m1920a(view, f);
        }

        public void m1778a(View view, int i, Paint paint) {
            am.m1922a(view, i, paint);
        }

        public void m1779b(View view, float f) {
            am.m1925b(view, f);
        }

        public void m1780b(View view, boolean z) {
            am.m1923a(view, z);
        }

        public void m1781c(View view, float f) {
            am.m1929c(view, f);
        }

        public void m1782c(View view, boolean z) {
            am.m1927b(view, z);
        }

        public void m1783d(View view, int i) {
            am.m1926b(view, i);
        }

        public float m1784e(View view) {
            return am.m1916a(view);
        }

        public void m1785e(View view, int i) {
            am.m1921a(view, i);
        }

        public int m1786f(View view) {
            return am.m1924b(view);
        }

        public int m1787h(View view) {
            return am.m1928c(view);
        }

        public int m1788i(View view) {
            return am.m1930d(view);
        }

        public float m1789m(View view) {
            return am.m1931e(view);
        }

        public float m1790n(View view) {
            return am.m1932f(view);
        }

        public Matrix m1791o(View view) {
            return am.m1933g(view);
        }

        public void m1792y(View view) {
            am.m1934h(view);
        }
    }

    /* renamed from: android.support.v4.view.aj.e */
    static class C0444e extends C0443c {
        static Field f876b;
        static boolean f877c;

        static {
            f877c = false;
        }

        C0444e() {
        }

        public void m1793a(View view, C0036a c0036a) {
            an.m1936a(view, c0036a == null ? null : c0036a.getBridge());
        }

        public void m1794a(View view, boolean z) {
            an.m1937a(view, z);
        }

        public boolean m1795a(View view) {
            boolean z = true;
            if (f877c) {
                return false;
            }
            if (f876b == null) {
                try {
                    f876b = View.class.getDeclaredField("mAccessibilityDelegate");
                    f876b.setAccessible(true);
                } catch (Throwable th) {
                    f877c = true;
                    return false;
                }
            }
            try {
                if (f876b.get(view) == null) {
                    z = false;
                }
                return z;
            } catch (Throwable th2) {
                f877c = true;
                return false;
            }
        }

        public boolean m1796a(View view, int i) {
            return an.m1938a(view, i);
        }

        public boolean m1797b(View view, int i) {
            return an.m1939b(view, i);
        }

        public ay m1798r(View view) {
            if (this.a == null) {
                this.a = new WeakHashMap();
            }
            ay ayVar = (ay) this.a.get(view);
            if (ayVar != null) {
                return ayVar;
            }
            ayVar = new ay(view);
            this.a.put(view, ayVar);
            return ayVar;
        }
    }

    /* renamed from: android.support.v4.view.aj.d */
    static class C0445d extends C0444e {
        C0445d() {
        }

        public boolean m1799G(View view) {
            return ao.m1940a(view);
        }
    }

    /* renamed from: android.support.v4.view.aj.f */
    static class C0446f extends C0445d {
        C0446f() {
        }

        public void m1800a(View view, Drawable drawable) {
            ap.m1942a(view, drawable);
        }

        public void m1801a(View view, Runnable runnable) {
            ap.m1943a(view, runnable);
        }

        public void m1802a(View view, Runnable runnable, long j) {
            ap.m1944a(view, runnable, j);
        }

        public boolean m1803b(View view) {
            return ap.m1945a(view);
        }

        public void m1804c(View view) {
            ap.m1946b(view);
        }

        public void m1805c(View view, int i) {
            if (i == 4) {
                i = 2;
            }
            ap.m1941a(view, i);
        }

        public int m1806d(View view) {
            return ap.m1947c(view);
        }

        public boolean m1807l(View view) {
            return ap.m1952h(view);
        }

        public int m1808p(View view) {
            return ap.m1948d(view);
        }

        public int m1809q(View view) {
            return ap.m1949e(view);
        }

        public void m1810u(View view) {
            ap.m1950f(view);
        }

        public boolean m1811x(View view) {
            return ap.m1951g(view);
        }
    }

    /* renamed from: android.support.v4.view.aj.g */
    static class C0447g extends C0446f {
        C0447g() {
        }

        public Display m1812H(View view) {
            return aq.m1959f(view);
        }

        public void m1813a(View view, int i, int i2, int i3, int i4) {
            aq.m1954a(view, i, i2, i3, i4);
        }

        public int m1814g(View view) {
            return aq.m1953a(view);
        }

        public int m1815j(View view) {
            return aq.m1955b(view);
        }

        public int m1816k(View view) {
            return aq.m1956c(view);
        }

        public int m1817t(View view) {
            return aq.m1957d(view);
        }

        public boolean m1818z(View view) {
            return aq.m1958e(view);
        }
    }

    /* renamed from: android.support.v4.view.aj.h */
    static class C0448h extends C0447g {
        C0448h() {
        }
    }

    /* renamed from: android.support.v4.view.aj.i */
    static class C0449i extends C0448h {
        C0449i() {
        }

        public boolean m1819D(View view) {
            return ar.m1960a(view);
        }

        public boolean m1820F(View view) {
            return ar.m1961b(view);
        }

        public void m1821c(View view, int i) {
            ap.m1941a(view, i);
        }
    }

    /* renamed from: android.support.v4.view.aj.j */
    static class C0450j extends C0449i {

        /* renamed from: android.support.v4.view.aj.j.1 */
        class C04541 implements C0453a {
            final /* synthetic */ C0058z f878a;
            final /* synthetic */ C0450j f879b;

            C04541(C0450j c0450j, C0058z c0058z) {
                this.f879b = c0450j;
                this.f878a = c0058z;
            }

            public Object m1843a(View view, Object obj) {
                return bf.m2111a(this.f878a.onApplyWindowInsets(view, bf.m2110a(obj)));
            }
        }

        C0450j() {
        }

        public ColorStateList m1822A(View view) {
            return as.m1975e(view);
        }

        public Mode m1823B(View view) {
            return as.m1976f(view);
        }

        public void m1824C(View view) {
            as.m1977g(view);
        }

        public float m1825E(View view) {
            return as.m1978h(view);
        }

        public bf m1826a(View view, bf bfVar) {
            return bf.m2110a(as.m1963a(view, bf.m2111a(bfVar)));
        }

        public void m1827a(View view, ColorStateList colorStateList) {
            as.m1967a(view, colorStateList);
        }

        public void m1828a(View view, Mode mode) {
            as.m1968a(view, mode);
        }

        public void m1829a(View view, C0058z c0058z) {
            if (c0058z == null) {
                as.m1969a(view, null);
            } else {
                as.m1969a(view, new C04541(this, c0058z));
            }
        }

        public bf m1830b(View view, bf bfVar) {
            return bf.m2110a(as.m1970b(view, bf.m2111a(bfVar)));
        }

        public void m1831d(View view, float f) {
            as.m1965a(view, f);
        }

        public void m1832d(View view, int i) {
            as.m1972b(view, i);
        }

        public void m1833e(View view, int i) {
            as.m1966a(view, i);
        }

        public String m1834s(View view) {
            return as.m1964a(view);
        }

        public void m1835u(View view) {
            as.m1971b(view);
        }

        public float m1836v(View view) {
            return as.m1973c(view);
        }

        public float m1837w(View view) {
            return as.m1974d(view);
        }
    }

    /* renamed from: android.support.v4.view.aj.k */
    static class C0451k extends C0450j {
        C0451k() {
        }

        public void m1838a(View view, int i, int i2) {
            at.m1980a(view, i, i2);
        }

        public void m1839d(View view, int i) {
            at.m1981b(view, i);
        }

        public void m1840e(View view, int i) {
            at.m1979a(view, i);
        }
    }

    /* renamed from: android.support.v4.view.aj.a */
    static class C0452a extends C0451k {
        C0452a() {
        }

        public void m1841a(View view, ad adVar) {
            ak.m1904a(view, adVar != null ? adVar.m1638a() : null);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (C0265c.m909a()) {
            f880a = new C0452a();
        } else if (i >= 23) {
            f880a = new C0451k();
        } else if (i >= 21) {
            f880a = new C0450j();
        } else if (i >= 19) {
            f880a = new C0449i();
        } else if (i >= 18) {
            f880a = new C0448h();
        } else if (i >= 17) {
            f880a = new C0447g();
        } else if (i >= 16) {
            f880a = new C0446f();
        } else if (i >= 15) {
            f880a = new C0445d();
        } else if (i >= 14) {
            f880a = new C0444e();
        } else if (i >= 11) {
            f880a = new C0443c();
        } else {
            f880a = new C0442b();
        }
    }

    public static Mode m1844A(View view) {
        return f880a.m1651B(view);
    }

    public static void m1845B(View view) {
        f880a.m1652C(view);
    }

    public static boolean m1846C(View view) {
        return f880a.m1653D(view);
    }

    public static float m1847D(View view) {
        return f880a.m1654E(view);
    }

    public static boolean m1848E(View view) {
        return f880a.m1655F(view);
    }

    public static boolean m1849F(View view) {
        return f880a.m1656G(view);
    }

    public static Display m1850G(View view) {
        return f880a.m1657H(view);
    }

    public static int m1851a(int i, int i2) {
        return f880a.m1658a(i, i2);
    }

    public static int m1852a(int i, int i2, int i3) {
        return f880a.m1659a(i, i2, i3);
    }

    public static bf m1853a(View view, bf bfVar) {
        return f880a.m1660a(view, bfVar);
    }

    public static void m1854a(View view, float f) {
        f880a.m1661a(view, f);
    }

    public static void m1855a(View view, int i, int i2) {
        f880a.m1662a(view, i, i2);
    }

    public static void m1856a(View view, int i, int i2, int i3, int i4) {
        f880a.m1663a(view, i, i2, i3, i4);
    }

    public static void m1857a(View view, int i, Paint paint) {
        f880a.m1664a(view, i, paint);
    }

    public static void m1858a(View view, ColorStateList colorStateList) {
        f880a.m1665a(view, colorStateList);
    }

    public static void m1859a(View view, Mode mode) {
        f880a.m1666a(view, mode);
    }

    public static void m1860a(View view, Drawable drawable) {
        f880a.m1667a(view, drawable);
    }

    public static void m1861a(View view, C0036a c0036a) {
        f880a.m1668a(view, c0036a);
    }

    public static void m1862a(View view, ad adVar) {
        f880a.m1669a(view, adVar);
    }

    public static void m1863a(View view, C0058z c0058z) {
        f880a.m1670a(view, c0058z);
    }

    public static void m1864a(View view, Runnable runnable) {
        f880a.m1671a(view, runnable);
    }

    public static void m1865a(View view, Runnable runnable, long j) {
        f880a.m1672a(view, runnable, j);
    }

    public static void m1866a(View view, boolean z) {
        f880a.m1673a(view, z);
    }

    public static boolean m1867a(View view) {
        return f880a.m1674a(view);
    }

    public static boolean m1868a(View view, int i) {
        return f880a.m1675a(view, i);
    }

    public static bf m1869b(View view, bf bfVar) {
        return f880a.m1676b(view, bfVar);
    }

    public static void m1870b(View view, float f) {
        f880a.m1677b(view, f);
    }

    public static void m1871b(View view, boolean z) {
        f880a.m1678b(view, z);
    }

    public static boolean m1872b(View view) {
        return f880a.m1679b(view);
    }

    public static boolean m1873b(View view, int i) {
        return f880a.m1680b(view, i);
    }

    public static void m1874c(View view) {
        f880a.m1681c(view);
    }

    public static void m1875c(View view, float f) {
        f880a.m1682c(view, f);
    }

    public static void m1876c(View view, int i) {
        f880a.m1683c(view, i);
    }

    public static void m1877c(View view, boolean z) {
        f880a.m1684c(view, z);
    }

    public static int m1878d(View view) {
        return f880a.m1685d(view);
    }

    public static void m1879d(View view, float f) {
        f880a.m1686d(view, f);
    }

    public static void m1880d(View view, int i) {
        f880a.m1689e(view, i);
    }

    public static float m1881e(View view) {
        return f880a.m1688e(view);
    }

    public static void m1882e(View view, int i) {
        f880a.m1687d(view, i);
    }

    public static int m1883f(View view) {
        return f880a.m1690f(view);
    }

    public static int m1884g(View view) {
        return f880a.m1691g(view);
    }

    public static int m1885h(View view) {
        return f880a.m1692h(view);
    }

    public static int m1886i(View view) {
        return f880a.m1693i(view);
    }

    public static int m1887j(View view) {
        return f880a.m1694j(view);
    }

    public static int m1888k(View view) {
        return f880a.m1695k(view);
    }

    public static float m1889l(View view) {
        return f880a.m1697m(view);
    }

    public static float m1890m(View view) {
        return f880a.m1698n(view);
    }

    public static Matrix m1891n(View view) {
        return f880a.m1699o(view);
    }

    public static int m1892o(View view) {
        return f880a.m1700p(view);
    }

    public static int m1893p(View view) {
        return f880a.m1701q(view);
    }

    public static ay m1894q(View view) {
        return f880a.m1702r(view);
    }

    public static float m1895r(View view) {
        return f880a.m1706v(view);
    }

    public static String m1896s(View view) {
        return f880a.m1703s(view);
    }

    public static int m1897t(View view) {
        return f880a.m1704t(view);
    }

    public static void m1898u(View view) {
        f880a.m1705u(view);
    }

    public static boolean m1899v(View view) {
        return f880a.m1707x(view);
    }

    public static void m1900w(View view) {
        f880a.m1708y(view);
    }

    public static boolean m1901x(View view) {
        return f880a.m1696l(view);
    }

    public static boolean m1902y(View view) {
        return f880a.m1709z(view);
    }

    public static ColorStateList m1903z(View view) {
        return f880a.m1650A(view);
    }
}
