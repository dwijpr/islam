package com.google.android.gms.internal;

import com.google.android.gms.ads.reward.RewardItem;

@op
public class qd implements RewardItem {
    private final pz f5538a;

    public qd(pz pzVar) {
        this.f5538a = pzVar;
    }

    public int getAmount() {
        int i = 0;
        if (this.f5538a != null) {
            try {
                i = this.f5538a.m8205b();
            } catch (Throwable e) {
                sg.m8447c("Could not forward getAmount to RewardItem", e);
            }
        }
        return i;
    }

    public String getType() {
        String str = null;
        if (this.f5538a != null) {
            try {
                str = this.f5538a.m8204a();
            } catch (Throwable e) {
                sg.m8447c("Could not forward getType to RewardItem", e);
            }
        }
        return str;
    }
}
