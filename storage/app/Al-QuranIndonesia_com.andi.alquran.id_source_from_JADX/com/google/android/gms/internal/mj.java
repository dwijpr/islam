package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

@op
public final class mj implements MediationAdRequest {
    private final Date f4937a;
    private final int f4938b;
    private final Set<String> f4939c;
    private final boolean f4940d;
    private final Location f4941e;
    private final int f4942f;
    private final boolean f4943g;

    public mj(Date date, int i, Set<String> set, Location location, boolean z, int i2, boolean z2) {
        this.f4937a = date;
        this.f4938b = i;
        this.f4939c = set;
        this.f4941e = location;
        this.f4940d = z;
        this.f4942f = i2;
        this.f4943g = z2;
    }

    public Date getBirthday() {
        return this.f4937a;
    }

    public int getGender() {
        return this.f4938b;
    }

    public Set<String> getKeywords() {
        return this.f4939c;
    }

    public Location getLocation() {
        return this.f4941e;
    }

    public boolean isDesignedForFamilies() {
        return this.f4943g;
    }

    public boolean isTesting() {
        return this.f4940d;
    }

    public int taggedForChildDirectedTreatment() {
        return this.f4942f;
    }
}
