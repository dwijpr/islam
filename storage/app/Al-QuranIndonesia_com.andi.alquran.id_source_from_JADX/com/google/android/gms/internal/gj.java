package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

@op
public final class gj {
    private long f4145a;
    private Bundle f4146b;
    private int f4147c;
    private List<String> f4148d;
    private boolean f4149e;
    private int f4150f;
    private boolean f4151g;
    private String f4152h;
    private zzfj f4153i;
    private Location f4154j;
    private String f4155k;
    private Bundle f4156l;
    private Bundle f4157m;
    private List<String> f4158n;
    private String f4159o;
    private String f4160p;
    private boolean f4161q;

    public gj() {
        this.f4145a = -1;
        this.f4146b = new Bundle();
        this.f4147c = -1;
        this.f4148d = new ArrayList();
        this.f4149e = false;
        this.f4150f = -1;
        this.f4151g = false;
        this.f4152h = null;
        this.f4153i = null;
        this.f4154j = null;
        this.f4155k = null;
        this.f4156l = new Bundle();
        this.f4157m = new Bundle();
        this.f4158n = new ArrayList();
        this.f4159o = null;
        this.f4160p = null;
        this.f4161q = false;
    }

    public gj(zzdy com_google_android_gms_internal_zzdy) {
        this.f4145a = com_google_android_gms_internal_zzdy.f6434b;
        this.f4146b = com_google_android_gms_internal_zzdy.f6435c;
        this.f4147c = com_google_android_gms_internal_zzdy.f6436d;
        this.f4148d = com_google_android_gms_internal_zzdy.f6437e;
        this.f4149e = com_google_android_gms_internal_zzdy.f6438f;
        this.f4150f = com_google_android_gms_internal_zzdy.f6439g;
        this.f4151g = com_google_android_gms_internal_zzdy.f6440h;
        this.f4152h = com_google_android_gms_internal_zzdy.f6441i;
        this.f4153i = com_google_android_gms_internal_zzdy.f6442j;
        this.f4154j = com_google_android_gms_internal_zzdy.f6443k;
        this.f4155k = com_google_android_gms_internal_zzdy.f6444l;
        this.f4156l = com_google_android_gms_internal_zzdy.f6445m;
        this.f4157m = com_google_android_gms_internal_zzdy.f6446n;
        this.f4158n = com_google_android_gms_internal_zzdy.f6447o;
        this.f4159o = com_google_android_gms_internal_zzdy.f6448p;
        this.f4160p = com_google_android_gms_internal_zzdy.f6449q;
    }

    public gj m6330a(Location location) {
        this.f4154j = location;
        return this;
    }

    public zzdy m6331a() {
        return new zzdy(7, this.f4145a, this.f4146b, this.f4147c, this.f4148d, this.f4149e, this.f4150f, this.f4151g, this.f4152h, this.f4153i, this.f4154j, this.f4155k, this.f4156l, this.f4157m, this.f4158n, this.f4159o, this.f4160p, false);
    }
}
