package com.andi.alquran.p032j;

import android.location.Location;

/* renamed from: com.andi.alquran.j.e */
public class C0943e {
    public static double m3279a(double d, double d2) {
        Location location = new Location("Nows");
        Location location2 = new Location("Kabah");
        location.setLatitude(d);
        location.setLongitude(d2);
        location2.setLatitude(21.42242d);
        location2.setLongitude(39.8261239d);
        return ((double) Math.round((((double) location.distanceTo(location2)) * 0.001d) * 100.0d)) / 100.0d;
    }
}
