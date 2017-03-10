package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest.Gender;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Deprecated
public class MediationAdRequest {
    private final Date f2268a;
    private final Gender f2269b;
    private final Set<String> f2270c;
    private final boolean f2271d;
    private final Location f2272e;

    public MediationAdRequest(Date date, Gender gender, Set<String> set, boolean z, Location location) {
        this.f2268a = date;
        this.f2269b = gender;
        this.f2270c = set;
        this.f2271d = z;
        this.f2272e = location;
    }

    public Integer getAgeInYears() {
        if (this.f2268a == null) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance.setTime(this.f2268a);
        Integer valueOf = Integer.valueOf(instance2.get(1) - instance.get(1));
        return (instance2.get(2) < instance.get(2) || (instance2.get(2) == instance.get(2) && instance2.get(5) < instance.get(5))) ? Integer.valueOf(valueOf.intValue() - 1) : valueOf;
    }

    public Date getBirthday() {
        return this.f2268a;
    }

    public Gender getGender() {
        return this.f2269b;
    }

    public Set<String> getKeywords() {
        return this.f2270c;
    }

    public Location getLocation() {
        return this.f2272e;
    }

    public boolean isTesting() {
        return this.f2271d;
    }
}
